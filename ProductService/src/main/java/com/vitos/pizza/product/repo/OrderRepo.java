package com.vitos.pizza.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitos.pizza.product.entity.OrderDetails;

/**
 * The Interface OrderRepo.
 */
@Repository
public interface OrderRepo extends JpaRepository<OrderDetails, Long>{

}
