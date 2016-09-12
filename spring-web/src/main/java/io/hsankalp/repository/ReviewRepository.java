package io.hsankalp.repository;

import java.util.List;

import io.hsankalp.entity.Review;

public interface ReviewRepository {

	public Review create(Review review);

	public List<Review> findAll(String id);

}
