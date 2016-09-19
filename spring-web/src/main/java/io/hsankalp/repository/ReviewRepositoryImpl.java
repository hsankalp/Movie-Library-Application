package io.hsankalp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.hsankalp.entity.Movie;
import io.hsankalp.entity.Review;


@Repository
public class ReviewRepositoryImpl implements ReviewRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Review create(Review review) {
		em.persist(review);
		return review;
	}

	@Override
	public List<Review> findAll(String movieId) {
		TypedQuery<Review> query = em.createNamedQuery("Review.findAllById", Review.class);
		query.setParameter("pId", movieId);
		return query.getResultList();
	}

	@Override
	public Review findOne(String reviewId) {
		return em.find(Review.class, reviewId);
	}

	@Override
	public void delete(Review review) {
		em.remove(review);
		
	}

	

}
