package io.hsankalp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hsankalp.entity.Review;
import io.hsankalp.repository.ReviewRepository;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewRepository repo;

	@Override
	public Review create(Review review){

		return repo.create(review);
	
	}

	@Override
	public List<Review> findAll(String id) {
		return repo.findAll(id);
	}

}
