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

import com.vitos.pizza.user.entity.Customer;
import com.vitos.pizza.user.exception.ResourceAlreadyFoundException;
import com.vitos.pizza.user.exception.ResourceNotFoundException;
import com.vitos.pizza.user.service.CustomerService;
import com.vitos.pizza.user.util.AppConstants;

@RestController
@RequestMapping(AppConstants.BASE_URL)
@CrossOrigin(origins = AppConstants.CROSS_ORIGIN_URL)
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@PostMapping(AppConstants.CUSTOMER_URL)
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) throws ResourceAlreadyFoundException {
		logger.info("Logging Stated!!! Inside Customer Controller @Save Customer Method Initiated");
		Customer savedCustomer = customerService.saveCustomer(customer);

		if (null != savedCustomer) {
			return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(AppConstants.CUSTOMERS_URL)
	public ResponseEntity<List<Customer>> getAllCustomers() throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Customer Controller @Get All Customer Method Initiated");
		return new ResponseEntity<>(customerService.getAllCustomers().stream().collect(Collectors.toList()),
				HttpStatus.OK);
	}

	@GetMapping(AppConstants.CUSTOMER_BY_ID_URL)
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Customer Controller logger.info @Get Customer By ID Method Initiated");
		Customer customerRetrieved = customerService.getCustomerById(id);
		return new ResponseEntity<Customer>(customerRetrieved, HttpStatus.OK);
	}

	@DeleteMapping(AppConstants.CUSTOMER_BY_ID_URL)
	public HttpStatus deleteCustomerById(@PathVariable("id") Long id) {
		logger.info("Logging Stated!!! Inside Customer Controller @Delete Customer Method Initiated");
		try {
			customerService.deleteCustomer(id);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return HttpStatus.OK;
	}

}
