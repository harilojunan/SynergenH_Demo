package com.vitos.pizza.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitos.pizza.user.entity.User;

/**
 * The Interface UserRepo.
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
