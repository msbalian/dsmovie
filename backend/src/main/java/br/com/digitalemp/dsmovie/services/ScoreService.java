package br.com.digitalemp.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public void saveScore(ScoreDto scoreDto) {
		
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

		// falta armazenar o score médio e o count do movie. Devemos acessar todos os scores de um dado movie
		
	}
	
}
