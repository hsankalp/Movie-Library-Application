package io.hsankalp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hsankalp.entity.Movie;
import io.hsankalp.exception.EntityExistsException;
import io.hsankalp.exception.EntityNotFoundException;
import io.hsankalp.repository.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repo;

	@Override
	public List<Movie> findAll() {
		return repo.findAll();
	}

	@Override
	public Movie findOne(String id) throws EntityNotFoundException {
		Movie movie = repo.findOne(id);
		if (movie == null) {
			throw new EntityNotFoundException();
		}
		return movie;
	}
	
	@Override
	public Movie findByMovieTitle(String title) throws EntityNotFoundException {
		Movie movie = repo.findByMovieTitle(title);
		if (movie == null) {
			throw new EntityNotFoundException();
		}
		return movie;
	}

	@Override
	public Movie create(Movie movie) throws EntityExistsException {
		Movie existing = repo.findByMovieTitle(movie.getTitle());
		if (existing != null) {
			throw new EntityExistsException();
		}
		return repo.create(movie);
	}

	@Override
	public Movie update(Movie movie) throws EntityNotFoundException {
		Movie existing = repo.findOne(movie.getId());
		if (existing == null) {
			throw new EntityNotFoundException();
		}
		return repo.update(movie);
	}

	@Override
	public void delete(String id) throws EntityNotFoundException {
		Movie existing = repo.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException();
		}
		repo.delete(existing);
	}

}
