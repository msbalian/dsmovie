package br.com.digitalemp.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.digitalemp.dsmovie.dto.MovieDto;
import br.com.digitalemp.dsmovie.dto.ScoreDto;
import br.com.digitalemp.dsmovie.entities.Movie;
import br.com.digitalemp.dsmovie.entities.Score;
import br.com.digitalemp.dsmovie.entities.User;
import br.com.digitalemp.dsmovie.repository.MovieRepository;
import br.com.digitalemp.dsmovie.repository.ScoreRepository;
import br.com.digitalemp.dsmovie.repository.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDto saveScore(ScoreDto scoreDto) {
		
		User user = userRepository.findByEmail(scoreDto.getEmail());
		
		if (user == null) {
			user = new User();
			user.setEmail(scoreDto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(scoreDto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDto.getScore());
		
		score = scoreRepository.saveAndFlush(score);

		// setting score average and count to movie
		
		Double scoreAverage = movie.getScores().stream()
			.mapToDouble(s -> s.getValue())
			.average().getAsDouble();
		
		Integer scoreCount = (int) movie.getScores().stream().count();
		
		movie.setCount(scoreCount);
		movie.setScore(scoreAverage);
		movie = movieRepository.save(movie);
		
		return new MovieDto(movie);
	}
	
}
