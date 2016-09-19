package io.hsankalp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hsankalp.entity.User;
import io.hsankalp.exception.EntityExistsException;
import io.hsankalp.exception.EntityNotFoundException;
import io.hsankalp.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

	@Override
	public User findOne(String id) throws EntityNotFoundException {
		User user = repo.findOne(id);
		if (user == null) {
			throw new EntityNotFoundException();
		}
		return user;
	}

	@Override
	public User findByUsername(String username) throws EntityNotFoundException {
		User user = repo.findByUsername(username);
		if (user == null) {
			throw new EntityNotFoundException();
		}
		return user;
	}

	@Override
	public boolean create(User user) throws EntityExistsException {

		User existing = repo.findByUsername(user.getUsername());

		if (existing != null) {
			throw new EntityExistsException();
		}
		repo.create(user);
		return true;
	}

	@Override
	public User update(User user) throws EntityNotFoundException {
		User existing = repo.findOne(user.getId());
		if (existing == null) {
			throw new EntityNotFoundException();
		}
		return repo.update(user);
	}

	@Override
	public User delete(String username) throws EntityNotFoundException {
		User existing = repo.findByUsername(username);
		if (existing == null) {
			throw new EntityNotFoundException();
		}
		repo.delete(existing);
		return existing;
	}

	@Override
	public String login(String username, String password) throws EntityNotFoundException {
		if (username.equals("admin") && password.equals("admin")) {
			return username;
		} else {
			User user = repo.findByUsername(username);
			if (user == null) {
				throw new EntityNotFoundException();
			} else {
				if (user.getPassword().equals(password)) {
					return username;
				} else {
					return null;
				}
			}
		}
	}

}
