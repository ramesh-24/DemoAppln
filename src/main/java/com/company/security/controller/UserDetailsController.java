package com.company.security.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.company.security.other.User;
import com.company.security.other.UserService;

@RestController
@RequestMapping("/api")
public class UserDetailsController {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserDetailsController.class);

	@RequestMapping(value = "/getValue", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getValue() {
		return new ResponseEntity<>("Hello_Ramesh", HttpStatus.OK);
	}

	@Autowired
	UserService userService;

	

	@GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable("name") String name) {
		logger.info("Fetching User with id " + name);
		User user = userService.findById(name);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping(value = "/create", consumes = { "application/json" })
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
	    logger.info("Creating User " + user.getName());
		System.out.println(user.getCountry());
		System.out.println(user.getId());
		userService.createUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@GetMapping(value = "/get",headers = "Accept=application/xml")
	public List<User> getAllUser() {
		List<User> tasks = userService.getUser();
		return tasks;

	}

	@PutMapping(value = "/update/{id}", headers = "Accept=application/json")
	public ResponseEntity<String> updateUser(@RequestBody User currentUser, @PathVariable long id) {
		logger.info("id" + id);
		Optional<User> user = userService.findById(currentUser.getId());
		if (user == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		userService.update(currentUser, currentUser.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
		Optional<User> user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

}
