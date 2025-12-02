package com.wings.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "cart_id", "product_id" }))
@Entity
public class CartProduct {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int cpId;

	@Column(name = "cart_id", insertable = false, updatable = false)
	private int cartId;

	@Column(name = "product_id", insertable = false, updatable = false)
	private int productId;
	@ManyToOne()
	@JoinColumn(name = "cart_id", referencedColumnName = "cartId")
	@JsonIgnore
	private Cart cart;
	@ManyToOne()
	@JoinColumn(name = "product_id", referencedColumnName = "productId")
	private Product product;
	private Integer quantity = 1;

	public CartProduct() {
		super();
	}

	public CartProduct(Cart cart, Product product, Integer quantity) {
		super();
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}

	public CartProduct(int cartId, int productId, int quantity)
	{
		this.cartId=cartId;
		this.productId=productId;
		this.quantity=quantity;
	}

	public Integer getCpId() {
		return cpId;
	}

	public void setCpId(Integer cpId) {
		this.cpId = cpId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartProduct [cpId=" + cpId + ", cart=" + cart.getCartId() + ", product=" + product.getProductId()
				+ ", quantity=" + quantity + "]";
	}

}