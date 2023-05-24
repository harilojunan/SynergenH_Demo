package com.vitos.pizza.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitos.pizza.user.entity.Customer;
import com.vitos.pizza.user.entity.User;
import com.vitos.pizza.user.exception.ResourceAlreadyFoundException;
import com.vitos.pizza.user.exception.ResourceNotFoundException;
import com.vitos.pizza.user.repo.CustomerRepo;
import com.vitos.pizza.user.repo.UserRepo;
import com.vitos.pizza.user.util.RandomPassword;

/**
 * The Class CustomerServiceImpl.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	/** The customer repo. */
	@Autowired
	private CustomerRepo customerRepo;

	/** The user repo. */
	@Autowired
	private UserRepo userRepo;

	/**
	 * Instantiates a new customer service impl.
	 *
	 * @param customerRepo the customer repo
	 */
	public CustomerServiceImpl(CustomerRepo customerRepo) {
		this.customerRepo = customerRepo;
	}

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	/**
	 * Save customer.
	 *
	 * @param customer the customer
	 * @return the customer
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	@Override
	public Customer saveCustomer(Customer customer) throws ResourceAlreadyFoundException {
		logger.info("Logging Stated!!! Inside Customer Service @Save Customer Method Running");
		if (customerRepo.existsById(customer.getId())) {
			throw new ResourceAlreadyFoundException("Customer already found");
		}
		// saving user object
		User user = new User();
		boolean isExist = user != null;
		if (isExist) {
			logger.info("Logging Stated!!! Inside User Service @Save User Method Running");
			user.setId(customer.getId());
			user.setUsername(customer.getEmail());
			RandomPassword randomPassword = new RandomPassword();
			user.setPassword(randomPassword.generateRandomPassword());
			user.setCustomer(customer);
			userRepo.save(user);
			System.out.println(user);
		} else {
			throw new ResourceAlreadyFoundException("User already found");
		}

		Customer savedCustomer = customerRepo.save(customer);
		return savedCustomer;
	}

	/**
	 * Gets the all customers.
	 *
	 * @return the all customers
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public List<Customer> getAllCustomers() throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Customer Service @Get All Customers Method Running");
		return customerRepo.findAll();
	}

	/**
	 * Gets the customer by id.
	 *
	 * @param id the id
	 * @return the customer by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public Customer getCustomerById(Long id) throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Customer Service @Find By ID Customer Method Started");
		if (customerRepo.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Customer not found with id :" + id);
		} else {
			logger.info("Logging Stated!!! Inside Customer Service @Get Customer Method Started");
			Customer customerRequest = customerRepo.findById(id).get();
			return customerRequest;
		}
	}

	/**
	 * Delete customer.
	 *
	 * @param id the id
	 * @return the string
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public String deleteCustomer(Long id) throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Customer Service @Find By ID Customer Method Started");
		if (customerRepo.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Customer not found with id :" + id);
		} else {
			logger.info("Logging Stated!!! Inside Customer Service @Delete Customer Method Started");
			userRepo.deleteById(id);
			customerRepo.deleteById(id);
		}
		return "Customer Deleted Successfully with id : " + id;
	}

}
