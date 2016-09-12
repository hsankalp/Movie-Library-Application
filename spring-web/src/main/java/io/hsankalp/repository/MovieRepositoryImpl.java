package io.hsankalp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.hsankalp.entity.Movie;

@Repository
public class MovieRepositoryImpl implements MovieRepository{

	@PersistenceContext
	private EntityManager em;
		
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createQuery("SELECT m from Movie m ORDER BY m.title ASC", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String id) {
		return em.find(Movie.class, id);
	}
	
	@Override
	public Movie findByMovieTitle(String movieName) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByMovieTitle", Movie.class);
		query.setParameter("pTitle", movieName);
		List<Movie> movies = query.getResultList();
		System.out.println(movies);
		if(movies!=null && movies.size() == 1){
			return movies.get(0);
			
		}else{
			return null;
		}
		
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);
	}

	
}
