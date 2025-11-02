package com.wings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wings.models.Product;
import com.wings.repository.ProductRepo;
import com.wings.repository.UserInfoRepository;

@RestController
@RequestMapping("/api/public")
public class PublicController {
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	UserInfoRepository userRepo;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/product/search")
	public List<Product> getProducts(@RequestParam String keyword){
//		return null;
		
		return productRepo.findByProductNameContainingIgnoreCaseOrCategoryCategoryNameContainingIgnoreCase(keyword, keyword);
	}
}
