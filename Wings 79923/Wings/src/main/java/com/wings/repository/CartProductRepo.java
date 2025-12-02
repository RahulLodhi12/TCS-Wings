package com.wings.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wings.models.CartProduct;
import jakarta.transaction.Transactional;

// Import required annotations to make use of the Repository
public interface CartProductRepo extends JpaRepository<CartProduct, Integer> {
	Optional<CartProduct> findByCartUserUserIdAndProductProductId(Integer userId, Integer productId);

	@Transactional
	void deleteByCartUserUserIdAndProductProductId(Integer userId, Integer productId);
}