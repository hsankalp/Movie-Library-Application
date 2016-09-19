package io.hsankalp.service;

import java.util.List;

import io.hsankalp.entity.Review;
import io.hsankalp.exception.EntityNotFoundException;

public interface ReviewService {

	public Review create(Review review);
	public List<Review> findAll(String movieId);
	public void delete(String reviewId) throws EntityNotFoundException;

}
