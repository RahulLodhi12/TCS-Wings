package com.wings.repository;

//import com.fresco.ecommerce.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wings.models.Cart;

import java.util.Optional;

// Import required annotations to make use of the Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
	Optional<Cart> findByUserUsername(String username);


}