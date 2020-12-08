package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Site;
import br.ufscar.dc.dsw.domain.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SiteDao extends GenericDAO {

    public void insert(Site site, String senha) {

        String sqlUsuario = "INSERT INTO usuario (email, senha, papel) VALUES (?, ?, ?)";
        String sqlGetUsuarioId = "SELECT id FROM usuario WHERE email = ?";
        String sqlSite = "INSERT INTO site (id, email, nome, endereco, telefone) VALUES (?, ?, ?, ?, ?)";

        try {
            // TODO: Fazer uma transação https://docs.oracle.com/javase/tutorial/jdbc/basics/transactions.html
            Connection conn = this.getConnection();
            PreparedStatement statementUsuario = conn.prepareStatement(sqlUsuario);
            PreparedStatement statementGetUsuarioId = conn.prepareStatement(sqlGetUsuarioId);
            PreparedStatement statementSite = conn.prepareStatement(sqlSite);

            statementUsuario.setString(1, site.getEmail());
            statementUsuario.setString(2, senha);
            statementUsuario.setString(3, "SITE");
            statementUsuario.executeUpdate();

            statementGetUsuarioId.setString(1, site.getEmail());
            ResultSet rs = statementGetUsuarioId.executeQuery();
            rs.next();
            long id = rs.getLong("id");

            statementSite.setLong(1, id);
            statementSite.setString(2, site.getEmail());
            statementSite.setString(3, site.getNome());
            statementSite.setString(4, site.getEndereco());
            statementSite.setString(5, site.getTelefone());
            statementSite.executeUpdate();

            statementUsuario.close();
            statementGetUsuarioId.close();
            statementSite.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Site> getAll() {
        List<Site> lista = new ArrayList<>();

        String sql = "SELECT * from site";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String endereco = resultSet.getString("endereco");
                String telefone = resultSet.getString("telefone");
                Site site = new Site(id, email, nome, endereco, telefone);
                lista.add(site);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void delete(long id) {
        String sql = "DELETE FROM usuario where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Site getById(Long id) {
        Site site = null;

        String sql = "SELECT * from site WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String endereco = resultSet.getString("endereco");
                String telefone = resultSet.getString("telefone");

                site = new Site(id, email, nome, endereco, telefone);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }

    public Site getByEmail(String email) {
        Site site = null;

        String sql = "SELECT * from site WHERE email = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String endereco = resultSet.getString("endereco");
                String telefone = resultSet.getString("telefone");

                site = new Site(id, email, nome, endereco, telefone);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }

    public void update(Site site) {
        String sql = "UPDATE site SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, site.getNome());
            statement.setString(2, site.getEndereco());
            statement.setString(3, site.getTelefone());
            statement.setLong(4, site.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
