package com.vitos.pizza.product.controller;

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
import com.vitos.pizza.product.entity.Catagory;
import com.vitos.pizza.product.service.CatagoryService;
import com.vitos.pizza.product.util.AppConstants;
import com.vitos.pizza.product.util.MockDTOUtil;

/**
 * The Class CatagoryControllerTest.
 */
@WebMvcTest(CatagoryController.class)
@TestPropertySource(locations = "classpath:test-application.properties")
public class CatagoryControllerTest extends MockDTOUtil {
	
	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;

	/** The catagory service. */
	@MockBean
	private CatagoryService catagoryService;

	/** The catagory controller. */
	@InjectMocks
	private CatagoryController catagoryController;

	/** The object mapper. */
	@Mock
	ObjectMapper objectMapper;
	
	/**
	 * Post catagory request.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void postCatagoryRequest() throws Exception {

		final Catagory response = objectMapper.readValue(
                "/ProductService/src/test/resources/postCatagoryResponse.json",
                Catagory.class);
		Mockito.when(catagoryService.saveCatagory(ArgumentMatchers.isA(Catagory.class))).thenReturn(response);

		MvcResult mvcResult = this.mockMvc.perform(post(AppConstants.BASE_URL + AppConstants.CATAGORY_URL)
				.contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(postCatagory()))).andExpect(status().isOk())
				.andReturn();

		assertEquals(mvcResult, response);

	}

	/**
	 * Retrieve products.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void retrieveProducts() throws Exception {

		final Catagory response = objectMapper.readValue(
                "/ProductService/src/test/resources/getAllCatagorys.json",
                Catagory.class);
		Mockito.when(catagoryService.getAllCatagorys()).thenReturn((List<Catagory>) response);

		final MvcResult mvcResult = this.mockMvc.perform(get(AppConstants.BASE_URL + AppConstants.CATAGORYS_URL))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

		assertEquals(mvcResult, response);

	}

}
