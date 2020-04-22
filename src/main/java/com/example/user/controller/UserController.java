package com.example.user.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.user.bean.User;
import com.example.user.exception.UserNotFoundException;
import com.example.user.service.UserDaoService;

@RestController
public class UserController {
	@Autowired
	UserDaoService service;
	
	@GetMapping("/users")
	public List<User> findAll() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public User findById(@PathVariable final int id) {
		User user = service.findById(id);
		if (user == null) {
			throw new UserNotFoundException(id);
		}
		return user;
	}

	@DeleteMapping("/users/{id}")
	public User deleteById(@PathVariable final int id) {
		User user = service.deleteById(id);
		if (user == null) {
			throw new UserNotFoundException(id);
		}
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> save(@Valid @RequestBody final User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
