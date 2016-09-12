package io.hsankalp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Review.findAllById", query = "SELECT r FROM Review r WHERE r.id= :pId") })
public class Review {

	@Id
	@GenericGenerator(strategy = "uuid2", name = "myuuid")
	@GeneratedValue(generator = "myuuid")
	private String reviewId;

	private String id;
	private String username;
	private String comments;
	private String userRatings;

	public Review() {

	}

	public Review(String reviewId, String id, String username, String comments, String userRatings) {
		
		this.reviewId = reviewId;
		this.id = id;
		this.username = username;
		this.comments = comments;
		this.userRatings = userRatings;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(String userRatings) {
		this.userRatings = userRatings;
	}

}
