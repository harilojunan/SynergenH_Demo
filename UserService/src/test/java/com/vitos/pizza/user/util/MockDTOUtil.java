package com.vitos.pizza.user.util;

import com.vitos.pizza.user.entity.Customer;

/**
 * The Class MockDTOUtil.
 */
public class MockDTOUtil {
	
	/**
	 * Post customer.
	 *
	 * @return the customer
	 */
	protected Customer postCustomer() {
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setFname("Test01");
		customer.setLname("Check");
		customer.setEmail("0778123456");
		customer.setPhone("test01@gmail.com");
		return customer;
	}
	
}
