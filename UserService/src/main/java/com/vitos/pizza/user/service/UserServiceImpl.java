package com.vitos.pizza.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitos.pizza.user.entity.User;
import com.vitos.pizza.user.exception.ResourceAlreadyFoundException;
import com.vitos.pizza.user.exception.ResourceNotFoundException;
import com.vitos.pizza.user.repo.UserRepo;

/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService {
	
	/** The user repo. */
	@Autowired
	private UserRepo userRepo;
	
	/**
	 * Instantiates a new user service impl.
	 *
	 * @param userRepo the user repo
	 */
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public List<User> getAllUsers() throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside User Service @Get All User Method Running");
		return userRepo.findAll();
	}

	/**
	 * Gets the user by id.
	 *
	 * @param id the id
	 * @return the user by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public User getUserById(Long id) throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside User Service @Find By ID User Method Started");
		if (userRepo.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("User not found with id :" + id);
		} else {
			logger.info("Logging Stated!!! Inside User Service @Get User Method Started");
			User userRequest = userRepo.findById(id).get();
			return userRequest;
		}
	}

	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return the string
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public String deleteUser(Long id) throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside User Service @Find By ID User Method Started");
		if (userRepo.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("User not found with id :" + id);
		} else {
			logger.info("Logging Stated!!! Inside User Service @Delete User Method Started");
			userRepo.deleteById(id);
		}
		return "User Deleted Successfully with id : "+id;
	}

	/**
	 * Save user.
	 *
	 * @param user the user
	 * @return the user
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	@Override
	public User saveUser(User user) throws ResourceAlreadyFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
