package com.vitos.pizza.product.controller;

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

import com.vitos.pizza.product.entity.Product;
import com.vitos.pizza.product.exception.ResourceAlreadyFoundException;
import com.vitos.pizza.product.exception.ResourceNotFoundException;
import com.vitos.pizza.product.service.ProductService;
import com.vitos.pizza.product.util.AppConstants;

/**
 * The Class ProductController.
 */
@RestController
@RequestMapping(AppConstants.BASE_URL)
@CrossOrigin(origins = AppConstants.CROSS_ORIGIN_URL)
public class ProductController {
	
	/** The product service. */
	@Autowired
	private ProductService productService;
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	/**
	 * Save product.
	 *
	 * @param product the product
	 * @return the response entity
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	@PostMapping(AppConstants.PRODUCT_URL)
	public ResponseEntity<?> saveProduct(@RequestBody Product product) throws ResourceAlreadyFoundException {
		logger.info("Logging Stated!!! Inside Product Controller @Save Product Method Initiated");
		Product savedProduct = productService.saveProduct(product);

		if (null != savedProduct) {
			return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping(AppConstants.PRODUCTS_URL)
	public ResponseEntity<List<Product>> getAllProducts() throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Product Controller @Get All Product Method Initiated");
		return new ResponseEntity<>(productService.getAllProducts().stream().collect(Collectors.toList()),
				HttpStatus.OK);
	}
	
	/**
	 * Gets the product by id.
	 *
	 * @param id the id
	 * @return the product by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping(AppConstants.PRODUCT_BY_ID_URL)
	public ResponseEntity<Product> getProductById(@PathVariable Long id) throws ResourceNotFoundException {
		logger.info("Loggig Stated!!! Inside Product Controller logger.info @Get Product By ID Method Initiated");
		Product productRetrieved = productService.getProductById(id);
		return new ResponseEntity<Product>(productRetrieved, HttpStatus.OK);
	}
	
	/**
	 * Delete product by id.
	 *
	 * @param id the id
	 * @return the http status
	 */
	@DeleteMapping(AppConstants.PRODUCT_BY_ID_URL)
	public HttpStatus deleteProductById(@PathVariable("id") Long id) {
		logger.info("Logging Stated!!! Inside Product Controller @Delete Product Method Initiated");
		try {
			productService.deleteProduct(id);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return HttpStatus.OK;
	}

}
