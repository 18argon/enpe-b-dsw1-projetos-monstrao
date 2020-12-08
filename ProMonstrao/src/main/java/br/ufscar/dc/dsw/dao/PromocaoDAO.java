package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Promocao;

public class PromocaoDAO extends GenericDAO {   
		
	public void insert(Promocao promocao) {

        String sql = "INSERT INTO tb_promocao (id_site, id_teatro, nome_peca, preco, data_peca) VALUES (?, ?, ?, ?, ?)";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setLong(1, promocao.getIdSite());
            statement.setLong(2, promocao.getIdTeatro());
            statement.setString(3, promocao.getNomePeca());
            statement.setFloat(4, promocao.getPrecoPeca());
            statement.setString(5, promocao.getDataPeca());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	 public List<Promocao> getAllIdTeatro(Long id_teatro) {
		 
	        List<Promocao> listaPromocoes = new ArrayList<>();

	        String sql = "SELECT * FROM tb_promocao WHERE id_teatro = ?";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

	            statement.setLong(1, id_teatro);
	            ResultSet resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	            	Long id = resultSet.getLong("id");
	                Long id_site = resultSet.getLong("id_site");
	                String nome_peca = resultSet.getString("nome_peca");
	                Float preco = Float.parseFloat(resultSet.getString("preco"));
	                String data_peca = resultSet.getString("data_peca");
	                Promocao promocao = new Promocao(id, id_teatro, id_site, nome_peca, preco, data_peca);	                
	                listaPromocoes.add(promocao);
	            }

	            resultSet.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return listaPromocoes;
	 }
	 
	 public List<Promocao> getAllIdSite(Long id_site) {
		 
	        List<Promocao> listaPromocoes = new ArrayList<>();

	        String sql = "SELECT * FROM tb_promocao WHERE id_site = ?";

	        try {
	            Connection conn = this.getConnection();
	            PreparedStatement statement = conn.prepareStatement(sql);

	            statement.setLong(1, id_site);
	            ResultSet resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	            	Long id = resultSet.getLong("id");
	                Long id_teatro = resultSet.getLong("id_teatro");
	                String nome_peca = resultSet.getString("nome_peca");
	                Float preco = Float.parseFloat(resultSet.getString("preco"));
	                String data_peca = resultSet.getString("data_peca");
	                Promocao promocao = new Promocao(id, id_teatro, id_site, nome_peca, preco, data_peca);	                
	                listaPromocoes.add(promocao);
	            }

	            resultSet.close();
	            statement.close();
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return listaPromocoes;
	 }
	 
}