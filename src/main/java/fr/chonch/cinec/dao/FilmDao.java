package fr.chonch.cinec.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.chonch.cinec.domain.Film;


@Repository
public class FilmDao implements IDaoFilm{

	@Autowired
	private SessionFactory cinecSessionFactory;

	public void setSessionFactory(final SessionFactory sessionFactory) {
		if(sessionFactory==null)    {
			throw new IllegalStateException();
		}
		cinecSessionFactory = sessionFactory;
	}

	@Override
	public List<Film> getAllFilms(){
		final List<Film> list = cinecSessionFactory.getCurrentSession()
				.createCriteria(Film.class).list();
		return list;
	}

}
