package io.hsankalp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.hsankalp.entity.User;
import io.hsankalp.exception.EntityExistsException;
import io.hsankalp.exception.EntityNotFoundException;
import io.hsankalp.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll () {
		return service.findAll();
	}
	
	@RequestMapping(value="/id/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findOne(@PathVariable("id") String userId) throws EntityNotFoundException {
		return service.findOne(userId);
	}
	
	@RequestMapping(value="/uname/{username}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findByUsername(@PathVariable("username") String username) throws EntityNotFoundException {
		return service.findByUsername(username);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public boolean create (@RequestBody User user) throws EntityExistsException {
		return service.create(user);
	}
	
	@RequestMapping(value="/auth", method=RequestMethod.POST, produces=MediaType.TEXT_PLAIN_VALUE)
	public String login (@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password) throws EntityNotFoundException {
		return service.login(username, password);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update (@RequestBody User user) throws EntityNotFoundException {
		return service.update(user);
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User delete (@PathVariable("username") String username) throws EntityNotFoundException {
		return service.delete(username);
	}
}
