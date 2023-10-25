package br.com.fiap.seriesapi.service;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.seriesapi.data.SerieDao;
import br.com.fiap.seriesapi.model.Serie;

public class SerieService {

	public List<Serie> findAll() throws SQLException {
		SerieDao dao = new SerieDao();
		return dao.findAll();
	}

	public Serie findById(Long id) throws SQLException {
		SerieDao dao = new SerieDao();
		return dao.findById(id);
	}

	public void delete(Serie serie) throws SQLException {
		SerieDao dao = new SerieDao();
		dao.delete(serie);
	}

}
