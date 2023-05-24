package com.vitos.pizza.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitos.pizza.user.entity.Customer;
import com.vitos.pizza.user.service.CustomerService;
import com.vitos.pizza.user.util.AppConstants;
import com.vitos.pizza.user.util.MockDTOUtil;

/**
 * The Class CustomerControllerTest.
 */
@WebMvcTest(CustomerController.class)
@TestPropertySource(locations = "classpath:test-application.properties")
public class CustomerControllerTest extends MockDTOUtil {

	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;

	/** The customer service. */
	@MockBean
	private CustomerService customerService;

	/** The customer controller. */
	@InjectMocks
	private CustomerController customerController;

	/** The object mapper. */
	@Mock
	ObjectMapper objectMapper;
	
	/**
	 * Post customer request.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void postCustomerRequest() throws Exception {

		final Customer response = objectMapper.readValue(
                "/UserService/src/test/resources/postCustomerResponse.json",
                Customer.class);
		Mockito.when(customerService.saveCustomer(ArgumentMatchers.isA(Customer.class))).thenReturn(response);

		MvcResult mvcResult = this.mockMvc.perform(post(AppConstants.BASE_URL + AppConstants.CUSTOMER_URL)
				.contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(postCustomer()))).andExpect(status().isOk())
				.andReturn();

		assertEquals(mvcResult, response);

	}

	/**
	 * Retrieve customers.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void retrieveCustomers() throws Exception {

		final Customer response = objectMapper.readValue(
                "/UserService/src/test/resources/getAllCustomerss.json",
                Customer.class);
		Mockito.when(customerService.getAllCustomers()).thenReturn((List<Customer>) response);

		final MvcResult mvcResult = this.mockMvc.perform(get(AppConstants.BASE_URL + AppConstants.CUSTOMERS_URL))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

		assertEquals(mvcResult, response);

	}
	
}
