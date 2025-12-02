package com.wings.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cart {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int cartId;

	private double totalAmount;

	// Use UserInfo object to reference the user associated with the cart.
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_id", referencedColumnName = "userId") // Ensure correct FK relationship
	@JsonIgnore
	private UserInfo user;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cart")
	private List<CartProduct> cartProducts;

	// Default constructor
	public Cart() {
		super();
	}

	// Constructor with user and cart products
	public Cart(Integer cartId, Double totalAmount, UserInfo user, List<CartProduct> cartProducts) {
		this.cartId = cartId;
		this.totalAmount = totalAmount;
		this.user = user;
		this.cartProducts = cartProducts;
	}

	// Constructor with totalAmount and userId (directly passing userId)
	public Cart(Double totalAmount, UserInfo user) {
		this.totalAmount = totalAmount;
		this.user = user;
	}

	// Getters and setters
	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalAmount=" + totalAmount + ", user=" + user.getUserId()
				+ ", cartProducts=" + cartProducts + "]";
	}

	public void updateTotalAmount(Double price) {
		this.totalAmount += price;
	}
}