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

import com.vitos.pizza.product.entity.OrderDetails;
import com.vitos.pizza.product.service.OrderDetailsService;
import com.vitos.pizza.product.util.AppConstants;
import com.vitos.pizza.user.exception.ResourceAlreadyFoundException;
import com.vitos.pizza.user.exception.ResourceNotFoundException;

/**
 * The Class OrderController.
 */
@RestController
@RequestMapping(AppConstants.BASE_URL)
@CrossOrigin(origins = AppConstants.CROSS_ORIGIN_URL)
public class OrderDetailsController {
	
	/** The order service. */
	@Autowired
	private OrderDetailsService orderService;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(OrderDetailsController.class);
	
	/**
	 * Save product.
	 *
	 * @param order the order
	 * @return the response entity
	 * @throws ResourceAlreadyFoundException 
	 */
	@PostMapping(AppConstants.ORDER_URL)
	public ResponseEntity<?> saveProduct(@RequestBody OrderDetails order) throws ResourceAlreadyFoundException  {
		logger.info("Logging Stated!!! Inside Order Controller @Save Order Method Initiated");
		OrderDetails savedOrder = orderService.saveOrderDetails(order);

		if (null != savedOrder) {
			return new ResponseEntity<OrderDetails>(savedOrder, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	/**
	 * Gets the all orders.
	 *
	 * @return the all orders
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping(AppConstants.ORDERS_URL)
	public ResponseEntity<List<OrderDetails>> getAllOrders() throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Order Controller @Get All Order Method Initiated");
		return new ResponseEntity<>(orderService.getAllOrderDetails().stream().collect(Collectors.toList()),
				HttpStatus.OK);
	}
	
	/**
	 * Gets the order by id.
	 *
	 * @param id the id
	 * @return the order by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping(AppConstants.ORDER_BY_ID_URL)
	public ResponseEntity<OrderDetails> getOrderById(@PathVariable Long id) throws ResourceNotFoundException {
		logger.info("Loggig Stated!!! Inside Order Controller logger.info @Get Order By ID Method Initiated");
		OrderDetails orderRetrieved = orderService.getOrderDetailsById(id);
		return new ResponseEntity<OrderDetails>(orderRetrieved, HttpStatus.OK);
	}
	
	/**
	 * Delete order by id.
	 *
	 * @param id the id
	 * @return the http status
	 * @throws ResourceNotFoundException 
	 */
	@DeleteMapping(AppConstants.ORDER_BY_ID_URL)
	public HttpStatus deleteOrderById(@PathVariable("id") Long id) throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Order Controller @Delete Order Method Initiated");
		orderService.deleteOrderDetails(id);
		return HttpStatus.OK;
	}

}
