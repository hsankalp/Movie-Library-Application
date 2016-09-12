package io.hsankalp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
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
	public List<Review> findAll(String id) {
		TypedQuery<Review> query = em.createNamedQuery("Review.findAllById", Review.class);
		query.setParameter("pId", id);
		return query.getResultList();
	}

	

}
