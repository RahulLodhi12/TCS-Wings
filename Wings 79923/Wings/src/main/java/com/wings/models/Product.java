package com.wings.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Product {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int productId;
	private String productName;
	private double price;

	@ManyToOne
	@JoinColumn(name = "seller_id", referencedColumnName = "userId", updatable = false)
	@JsonIgnore
	private UserInfo seller;

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "categoryId")
	private Category category;

	// Default constructor
	public Product() {
		super();
	}

	// Updated constructor to accept a Category and UserInfo object
	public Product(String productName, double price, UserInfo seller, Category category) {
		this.productName = productName;
		this.price = price;
		this.seller = seller;
		this.category = category;
	}

	// Getters and setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public UserInfo getSeller() {
		return seller;
	}

	public void setSeller(UserInfo seller) {
		this.seller = seller;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price +
				", seller=" + (seller != null ? seller.getUserId() : "null") + ", category=" + category + "]";
	}
}