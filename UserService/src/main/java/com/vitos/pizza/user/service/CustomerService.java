package com.vitos.pizza.user.service;

import java.util.List;

import com.vitos.pizza.user.entity.Customer;
import com.vitos.pizza.user.exception.ResourceAlreadyFoundException;
import com.vitos.pizza.user.exception.ResourceNotFoundException;

/**
 * The Interface CustomerService.
 */
public interface CustomerService {
	
	/**
	 * Save customer.
	 *
	 * @param customer the customer
	 * @return the customer
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	public Customer saveCustomer(Customer customer) throws ResourceAlreadyFoundException;
	
	/**
	 * Gets the all customers.
	 *
	 * @return the all customers
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public List<Customer> getAllCustomers() throws ResourceNotFoundException;
	
	/**
	 * Gets the customer by id.
	 *
	 * @param id the id
	 * @return the customer by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public Customer getCustomerById(Long id) throws ResourceNotFoundException;
	
	/**
	 * Delete customer.
	 *
	 * @param id the id
	 * @return the string
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public String deleteCustomer(Long id) throws ResourceNotFoundException;

}
