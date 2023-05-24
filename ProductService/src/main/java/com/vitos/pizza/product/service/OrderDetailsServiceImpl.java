/*
 * 
 */
package com.vitos.pizza.product.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitos.pizza.product.entity.OrderDetails;
import com.vitos.pizza.product.repo.OrderRepo;
import com.vitos.pizza.user.exception.ResourceAlreadyFoundException;
import com.vitos.pizza.user.exception.ResourceNotFoundException;

/**
 * The Class OrderServiceImpl.
 */
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	/** The order repo. */
	@Autowired
	private OrderRepo orderRepo;
	
	
	/**
	 * Instantiates a new order service impl.
	 *
	 * @param orderRepo the order repo
	 */
	public OrderDetailsServiceImpl(OrderRepo orderRepo) {
		this.orderRepo = orderRepo;
	}
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(OrderDetailsServiceImpl.class);

	
	/**
	 * Save order details.
	 *
	 * @param orderDetails the order details
	 * @return the order details
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	@Override
	public OrderDetails saveOrderDetails(OrderDetails orderDetails) throws ResourceAlreadyFoundException {
		logger.info("Logging Stated!!! Inside Order Service @Save Order Method Running");
		if (orderRepo.existsById(orderDetails.getId())) {
			throw new ResourceAlreadyFoundException("Order already found");
		}
		orderDetails.setQuantity_price(orderDetails.getQuantity()*orderDetails.getProduct().getPrice());
		orderDetails.setTotal_price(orderDetails.getQuantity_price());
		orderDetails.setBalance(orderDetails.getReceived_cash()-orderDetails.getTotal_price());
		OrderDetails savedOrder = orderRepo.save(orderDetails);
		return savedOrder;
	}


	/**
	 * Gets the all order details.
	 *
	 * @return the all order details
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public List<OrderDetails> getAllOrderDetails() throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Order Service @Get All Orders Method Running");
		return orderRepo.findAll();
	}

	
	/**
	 * Gets the order details by id.
	 *
	 * @param id the id
	 * @return the order details by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public OrderDetails getOrderDetailsById(Long id) throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Order Service @Find By ID Order Method Started");
		OrderDetails order;
		if (orderRepo.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Order not found with id :" + id);
		} else {
			logger.info("Logging Stated!!! Inside Order Service @Get Order Method Started");
			Optional<OrderDetails> orderRequest = orderRepo.findById(id);
			order = orderRequest.get();
		}
		return order;
	}

	
	/**
	 * Delete order details.
	 *
	 * @param id the id
	 * @return the string
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	public String deleteOrderDetails(Long id) throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Order Service @Find By ID Order Method Started");
		if (orderRepo.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Order not found with id :" + id);
		} else {
			logger.info("Logging Stated!!! Inside Order Service @Delete Order Method Started");
			orderRepo.deleteById(id);
		}
		return "Order Deleted Successfully with id : "+id;
	}

}
