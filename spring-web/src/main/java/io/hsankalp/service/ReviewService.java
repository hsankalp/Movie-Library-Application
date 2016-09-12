package io.hsankalp.service;

import java.util.List;

import io.hsankalp.entity.Review;

public interface ReviewService {

	public Review create(Review review);
	public List<Review> findAll(String id);

}
