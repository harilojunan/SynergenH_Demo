package com.vitos.pizza.product.service;

import java.util.List;

import com.vitos.pizza.product.entity.OrderDetails;
import com.vitos.pizza.user.exception.ResourceAlreadyFoundException;
import com.vitos.pizza.user.exception.ResourceNotFoundException;

/**
 * The Interface OrderService.
 */
public interface OrderDetailsService {
	
	
	/**
	 * Save order details.
	 *
	 * @param orderDetails the order details
	 * @return the order details
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	public OrderDetails saveOrderDetails(OrderDetails orderDetails) throws ResourceAlreadyFoundException;
	
	/**
	 * Gets the all order detailss.
	 *
	 * @return the all order detailss
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public List<OrderDetails> getAllOrderDetails() throws ResourceNotFoundException;
	
	
	/**
	 * Gets the order details by id.
	 *
	 * @param id the id
	 * @return the order details by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public OrderDetails getOrderDetailsById(Long id) throws ResourceNotFoundException;
	
	
	/**
	 * Delete order details.
	 *
	 * @param id the id
	 * @return the string
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public String deleteOrderDetails(Long id) throws ResourceNotFoundException;

}
