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

import io.hsankalp.entity.Review;
import io.hsankalp.exception.EntityNotFoundException;
import io.hsankalp.service.ReviewService;

@CrossOrigin
@RestController
@RequestMapping(value="/reviews")
public class ReviewController {
	
	@Autowired
	ReviewService service;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review create(@RequestBody Review review) {
		return service.create(review);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Review> findAll(@PathVariable("id") String movieId){
		return service.findAll(movieId);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@PathVariable("id") String reviewId) throws EntityNotFoundException{
		service.delete(reviewId);
	}
	
}
