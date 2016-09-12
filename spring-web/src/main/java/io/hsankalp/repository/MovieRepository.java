package io.hsankalp.repository;

import java.util.List;

import io.hsankalp.entity.Movie;

public interface MovieRepository {
	
	public List<Movie> findAll();
	public Movie findOne(String id);
	public Movie findByMovieTitle(String movieName);
	public Movie create(Movie movie);
	public Movie update(Movie movie);
	public void delete(Movie movie);
	

}
