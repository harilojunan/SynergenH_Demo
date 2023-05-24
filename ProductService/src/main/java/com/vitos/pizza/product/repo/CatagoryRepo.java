package com.vitos.pizza.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitos.pizza.product.entity.Catagory;

@Repository
public interface CatagoryRepo extends JpaRepository<Catagory, Long> {

}
