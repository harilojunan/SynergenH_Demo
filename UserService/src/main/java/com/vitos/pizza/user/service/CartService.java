//package com.vitos.pizza.user.service;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.vitos.pizza.user.util.AppConstants;
//
//@Service
//public class CartService {
//	
//	/** The rest template. */
//	RestTemplate restTemplate = new RestTemplate();
//
//	/**
//	 * All products.
//	 *
//	 * @return the response entity
//	 */
//	public ResponseEntity<List<Cart>> allCarts() {
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//
//		ResponseEntity<List<Cart>> response = restTemplate.exchange(AppConstants.PRODUCTS_URL, HttpMethod.GET, entity,
//				String.class);
//		List<Cart> cart = response.get
//		return response;
//	}
//
//}
