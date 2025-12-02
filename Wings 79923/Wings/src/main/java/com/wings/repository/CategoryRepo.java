package com.wings.repository;

//import com.fresco.ecommerce.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wings.models.Category;

import java.util.Optional;

// Import required annotations to make use of the Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
	Optional<Category> findByCategoryName(String category);
}