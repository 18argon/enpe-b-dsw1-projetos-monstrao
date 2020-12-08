package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Teatro;

public class TeatroDAO extends GenericDAO {   
		
	public void insert(Teatro teatro) {

        String sql = "INSERT INTO tb_teatro (id_usuario, cnpj, nome, cidade) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            //statement.setString(1, teatro.getId());
            statement.setString(2, teatro.getCnpj());
            statement.setString(3, teatro.getNome());
            statement.setString(4, teatro.getCidade());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	    
	public List<Teatro> getAll() {

        List<Teatro> listaTeatros = new ArrayList<>();

        String sql = "SELECT * from tb_teatro ORDER BY nome";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {            	
                long id = resultSet.getLong("id");
                long id_usuario = resultSet.getLong("id_usuario");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                Teatro teatro = new Teatro(id, id_usuario, cnpj, nome, cidade);
                listaTeatros.add(teatro);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTeatros;
    }
	
	public void delete(Teatro teatro) {
        String sql = "DELETE FROM tb_teatro where id = ?";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, teatro.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public Teatro get(Long id_usuario) {
		Teatro teatro = null;

        String sql = "SELECT * from tb_teatro t where t.id_usuario = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id_usuario);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	Long id = Long.parseLong(resultSet.getString("id"));            	
            	
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");                                     

                teatro = new Teatro(id, id_usuario, cnpj, nome, cidade);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teatro;
    }
}