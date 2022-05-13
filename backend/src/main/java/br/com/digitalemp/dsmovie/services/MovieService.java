package br.com.digitalemp.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.digitalemp.dsmovie.dto.MovieDto;
import br.com.digitalemp.dsmovie.entities.Movie;
import br.com.digitalemp.dsmovie.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	
	@Transactional(readOnly = true)
	public Page<MovieDto> findAll(Pageable pageable) {
		
		Page<Movie> result = movieRepository.findAll(pageable);
		
		return result.map(p -> new MovieDto(p));
				
	}

	@Transactional(readOnly = true)
	public MovieDto findById(Long id) {
		
		return new MovieDto(movieRepository.findById(id).get());
				
	}
	

}
