package br.com.digitalemp.dsmovie.controllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalemp.dsmovie.dto.ScoreDto;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	@PutMapping
	public ScoreDto saveScore(@RequestBody ScoreDto scoreDto) {
		return null;
	}
	
}
