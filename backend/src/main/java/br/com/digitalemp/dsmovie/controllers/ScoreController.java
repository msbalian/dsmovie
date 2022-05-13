package br.com.digitalemp.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalemp.dsmovie.dto.MovieDto;
import br.com.digitalemp.dsmovie.dto.ScoreDto;
import br.com.digitalemp.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService service;
	
	@PutMapping
	public MovieDto saveScore(@RequestBody ScoreDto scoreDto) {
		return service.saveScore(scoreDto);
	}
	
}
