package io.hsankalp.repository;


import java.util.List;

import io.hsankalp.entity.User;

public interface UserRepository {
	public List<User> findAll ();
	public User findOne (String id);
	public User findByUsername (String username);
	public User create (User user);
	public User update (User user);
	public void delete (User user);
}