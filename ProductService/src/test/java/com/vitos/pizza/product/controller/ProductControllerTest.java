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
import com.vitos.pizza.product.entity.Product;
import com.vitos.pizza.product.service.ProductService;
import com.vitos.pizza.product.util.AppConstants;
import com.vitos.pizza.product.util.MockDTOUtil;

/**
 * The Class ProductControllerTest.
 */
@WebMvcTest(ProductController.class)
@TestPropertySource(locations = "classpath:test-application.properties")
public class ProductControllerTest extends MockDTOUtil {

	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;

	/** The product service. */
	@MockBean
	private ProductService productService;

	/** The product controller. */
	@InjectMocks
	private ProductController productController;

	/** The object mapper. */
	@Mock
	ObjectMapper objectMapper;
	
	/**
	 * Post product request.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void postProductRequest() throws Exception {

		final Product response = objectMapper.readValue(
                "/ProductService/src/test/resources/postProductResponse.json",
                Product.class);
		Mockito.when(productService.saveProduct(ArgumentMatchers.isA(Product.class))).thenReturn(response);

		MvcResult mvcResult = this.mockMvc.perform(post(AppConstants.BASE_URL + AppConstants.PRODUCT_URL)
				.contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(postProduct()))).andExpect(status().isOk())
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

		final Product response = objectMapper.readValue(
                "/ProductService/src/test/resources/getAllProducts.json",
                Product.class);
		Mockito.when(productService.getAllProducts()).thenReturn((List<Product>) response);

		final MvcResult mvcResult = this.mockMvc.perform(get(AppConstants.BASE_URL + AppConstants.PRODUCTS_URL))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

		assertEquals(mvcResult, response);

	}

	
}
