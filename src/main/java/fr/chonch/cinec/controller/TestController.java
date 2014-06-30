package fr.chonch.cinec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.chonch.cinec.domain.Film;
import fr.chonch.cinec.service.ConnectionService;
import fr.chonch.cinec.service.IFilmService;

@Controller
public class TestController {

	@Autowired
	IFilmService filmService;

	@Autowired ConnectionService connectionService;

	@RequestMapping(value="/hello" ,method = RequestMethod.GET)
	public @ResponseBody List<Film> hello() {

		System.out.println("dans controller");
		final Film f = new Film();
		f.setTitre("latouché");
		final ArrayList<Film> films = new ArrayList<Film>();
		films.add(f);
		films.addAll(filmService.getAllFilm());
		return films;
	}


	@RequestMapping (value="/post",method=RequestMethod.POST)
	public @ResponseBody String post(final String file){
		System.out.println("dans controler post");
		System.out.println("file : "+file);
		return "ok";
	}


	@RequestMapping(value="/getfiles" ,method = RequestMethod.GET)
	public @ResponseBody String getFiles() {
		connectionService.getListFiles();
		return "ok";
	}

}

