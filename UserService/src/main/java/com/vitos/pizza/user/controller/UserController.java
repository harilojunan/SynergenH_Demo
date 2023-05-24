package com.vitos.pizza.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitos.pizza.user.entity.User;
import com.vitos.pizza.user.exception.ResourceAlreadyFoundException;
import com.vitos.pizza.user.exception.ResourceNotFoundException;
import com.vitos.pizza.user.service.UserService;
import com.vitos.pizza.user.util.AppConstants;

/**
 * The Class UserController.
 */
@RestController
@RequestMapping(AppConstants.BASE_URL)
@CrossOrigin(origins = AppConstants.CROSS_ORIGIN_URL)
public class UserController {
	
	/** The user service. */
	@Autowired
	private UserService userService;
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * Save user.
	 *
	 * @param user the user
	 * @return the response entity
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	@PostMapping(AppConstants.USER_URL)
	public ResponseEntity<User> saveUser(@RequestBody User user) throws ResourceAlreadyFoundException {
		logger.info("Logging Stated!!! Inside User Controller @Save User Method Initiated");
		User savedUser = userService.saveUser(user);

		if (null != savedUser) {
			return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping(AppConstants.USERS_URL)
	public ResponseEntity<List<User>> getAllUsers() throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside User Controller @Get All User Method Initiated");
		return new ResponseEntity<>(userService.getAllUsers().stream().collect(Collectors.toList()),
				HttpStatus.OK);
	}
	
	/**
	 * Gets the user by id.
	 *
	 * @param id the id
	 * @return the user by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping(AppConstants.USER_BY_ID_URL)
	public ResponseEntity<User> getUserById(@PathVariable Long id) throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside User Controller logger.info @Get User By ID Method Initiated");
		User userRetrieved = userService.getUserById(id);
		return new ResponseEntity<User>(userRetrieved, HttpStatus.OK);
	}
	
	/**
	 * Delete user by id.
	 *
	 * @param id the id
	 * @return the http status
	 */
	@DeleteMapping(AppConstants.USER_BY_ID_URL)
	public HttpStatus deleteUserById(@PathVariable("id") Long id) {
		logger.info("Logging Stated!!! Inside User Controller @Delete User Method Initiated");
		try {
			userService.deleteUser(id);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return HttpStatus.OK;
	}
	
	
	

}
