package com.vitos.pizza.user.service;

import java.util.List;
import com.vitos.pizza.user.entity.User;
import com.vitos.pizza.user.exception.ResourceAlreadyFoundException;
import com.vitos.pizza.user.exception.ResourceNotFoundException;

/**
 * The Interface UserService.
 */
public interface UserService {
	
	/**
	 * Save user.
	 *
	 * @param user the user
	 * @return the user
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	public User saveUser(User user) throws ResourceAlreadyFoundException;
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public List<User> getAllUsers() throws ResourceNotFoundException;
	
	/**
	 * Gets the user by id.
	 *
	 * @param id the id
	 * @return the user by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public User getUserById(Long id) throws ResourceNotFoundException;
	
	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return the string
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public String deleteUser(Long id) throws ResourceNotFoundException;

}
