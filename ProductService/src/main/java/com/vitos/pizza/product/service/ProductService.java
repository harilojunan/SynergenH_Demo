package com.vitos.pizza.product.service;

import java.util.List;

import com.vitos.pizza.product.entity.Product;
import com.vitos.pizza.product.exception.ResourceAlreadyFoundException;
import com.vitos.pizza.product.exception.ResourceNotFoundException;

/**
 * The Interface ProductService.
 */
public interface ProductService {
	
	/**
	 * Save product.
	 *
	 * @param product the product
	 * @return the product
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	public Product saveProduct(Product product) throws ResourceAlreadyFoundException;
	
	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public List<Product> getAllProducts() throws ResourceNotFoundException;
	
	/**
	 * Gets the product by id.
	 *
	 * @param id the id
	 * @return the product by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public Product getProductById(Long id) throws ResourceNotFoundException;
	
	/**
	 * Delete product.
	 *
	 * @param id the id
	 * @return the string
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public String deleteProduct(Long id) throws ResourceNotFoundException;

}
