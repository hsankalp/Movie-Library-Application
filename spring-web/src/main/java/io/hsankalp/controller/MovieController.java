package io.hsankalp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.hsankalp.entity.Movie;
import io.hsankalp.exception.EntityExistsException;
import io.hsankalp.exception.EntityNotFoundException;
import io.hsankalp.service.MovieService;

@CrossOrigin
@RestController
@RequestMapping(value="/movies")
public class MovieController {
	
	@Autowired
	MovieService service;

	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value="/movie/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findOne(@PathVariable("id") String movieId) throws EntityNotFoundException {
		return service.findOne(movieId);
	}
	
	@RequestMapping(value="/{title}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findByMovieTitle(@PathVariable("title") String title) throws EntityNotFoundException {
		return service.findByMovieTitle(title);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie) throws EntityExistsException {
		return service.create(movie);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@RequestBody Movie movie) throws EntityNotFoundException {
		return service.update(movie);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@PathVariable("id") String id) throws EntityNotFoundException {
		service.delete(id);
	}
	
	
}
