package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Promocao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromocaoDAO extends GenericDAO {

    public List<Promocao> getBySite(long idSite) {
        List<Promocao> lista = new ArrayList<>();

        String sql = "SELECT * from promocao WHERE id_site = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setLong(1, idSite);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lista.add(parseResult(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public List<Promocao> getByTeatro(long idTeatro) {
        List<Promocao> lista = new ArrayList<>();

        String sql = "SELECT * from promocao WHERE id_teatro = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, idTeatro);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lista.add(parseResult(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void insert(Promocao promocao) {
        String sql = "INSERT INTO promocao (id_site, id_teatro, nome_peca, preco, data_peca) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = this.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setLong(1, promocao.getIdSite());
            statement.setLong(2, promocao.getIdTeatro());
            statement.setString(3, promocao.getNome());
            statement.setFloat(4, promocao.getPreco());
            statement.setString(5, promocao.getData());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean checkIfExists(Promocao promocao) {

        String sql = "SELECT * from promocao WHERE (id_teatro = ? OR id_site = ?) AND data_peca = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, promocao.getIdTeatro());
            statement.setLong(2, promocao.getIdSite());
            statement.setString(3, promocao.getData());
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Promocao parseResult(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        long idSite = rs.getLong("id_site");
        long idTeatro = rs.getLong("id_teatro");
        String nome = rs.getString("nome_peca");
        float preco = rs.getFloat("preco");
        String data = rs.getString("data_peca");

        return new Promocao(id, idSite, idTeatro, nome, preco, data);
    }
}
