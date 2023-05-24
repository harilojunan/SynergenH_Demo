package com.vitos.pizza.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitos.pizza.user.entity.Customer;

/**
 * The Interface CustomerRepo.
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
