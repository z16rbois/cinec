package fr.chonch.cinec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.chonch.cinec.dao.IDaoFilm;
import fr.chonch.cinec.domain.Film;

@Service
public class FilmService implements IFilmService {

	@Autowired
	IDaoFilm dao;

	@Override
	@Transactional
	public List<Film> getAllFilm() {
		return dao.getAllFilms();
	}

}
