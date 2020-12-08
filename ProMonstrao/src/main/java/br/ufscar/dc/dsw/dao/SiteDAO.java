package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Site;

public class SiteDAO extends GenericDAO {   
	    
	public List<Site> getAll() {

        List<Site> listaSites = new ArrayList<>();

        String sql = "SELECT * from tb_site";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {            	
                long id = resultSet.getLong("id");
                long id_usuario = resultSet.getLong("id_usuario");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");                
                Site site = new Site(id, id_usuario, nome, telefone);
                listaSites.add(site);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaSites;
    }	
	
	public Site get(Long id_usuario) {
        Site site = null;
        
        String sql = "SELECT * from tb_site where id_usuario = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setLong(1, id_usuario);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                
                site = new Site(id, id_usuario, nome, telefone);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }

}