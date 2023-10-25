package br.com.fiap.seriesapi.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.seriesapi.model.Serie;

public class SerieDao {
	
	private Connection conexao;

	List<Serie> series = new ArrayList<>();

	public SerieDao()throws SQLException{
		
		try {
            conexao = ConnectionFactory.createConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public List<Serie> findAll() throws SQLException{
		
		var comando = conexao.prepareStatement("SELECT * FROM serie");
		var resultado = comando.executeQuery();

	    while(resultado.next()){
	         series.add(new Serie(
	            resultado.getInt("id"),
	            resultado.getString("titulo"),
	            resultado.getString("sinopse"),
	            resultado.getString("poster"),
	            resultado.getDouble("nota")
	         ));
	      }
	        
		return series;
	}
	public Serie findById(Long id) {
		//SELECT * FROM SERIES WHERE ID=?

		return series
			.stream()
			.filter(serie -> serie.id() == id)
			.findFirst()
			.orElse(null);
	}

	public void delete(Serie serie) {
		//DELETE FROM SERIES WHERE ID=?
		series.remove(serie);
		System.out.println(series);
	}

}
