package com.example.user.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
import com.example.user.repository.UserRepository;
import com.example.user.service.UserDaoService;

@RestController
public class UserJpaController {
	@Autowired
	UserDaoService service;
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/jpa/users")
	public List<User> findAll() {
		return repository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> findById(@PathVariable final int id) {
		Optional<User> optionalUser = repository.findById(id);
		
		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException(id);
		}
		
		EntityModel<User> model = new EntityModel<>(optionalUser.get());
		model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn((this.getClass())).findAll()).withRel("users"));
		return model;
	}

	@DeleteMapping("/jpa/users/{id}")
	public EntityModel<User> deleteById(@PathVariable final int id) {
		User user = service.deleteById(id);
		if (user == null) {
			throw new UserNotFoundException(id);
		}
		EntityModel<User> model = new EntityModel<>(user);
		model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn((this.getClass())).findAll()).withRel("users"));
		return model;
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<Object> save(@Valid @RequestBody final User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
