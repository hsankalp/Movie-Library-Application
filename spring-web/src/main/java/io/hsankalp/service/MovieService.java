package io.hsankalp.service;

import java.util.List;

import io.hsankalp.entity.Movie;
import io.hsankalp.exception.EntityExistsException;
import io.hsankalp.exception.EntityNotFoundException;

public interface MovieService {
	
	public List<Movie> findAll();
	public Movie findOne(String id) throws EntityNotFoundException;
	public Movie findByMovieTitle(String title) throws EntityNotFoundException;
	public Movie create(Movie movie) throws EntityExistsException;
	public Movie update(Movie movie) throws EntityNotFoundException;
	public void delete(String id) throws EntityNotFoundException;
	
}
