package br.com.digitalemp.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digitalemp.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
