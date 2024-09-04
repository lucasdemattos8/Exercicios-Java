package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.Objects;

import com.educandoweb.course.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK id;

	private Integer quantity;
	private Double price;

	// Construtores

	public OrderItem() {
	}

	private OrderItem(OrderItemBuilder orderItemBuilder) {
		this.id = orderItemBuilder.id;
		this.quantity = orderItemBuilder.quantity;
		this.price = orderItemBuilder.price;
	}

	// Getters e Setters
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getSubTotal() {
		return price * quantity;
	}

	// HashCode e Equals

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}

	// Builder

	public static class OrderItemBuilder {
		private OrderItemPK id = new OrderItemPK();

		private Integer quantity;
		private Double price;

		public OrderItemBuilder setOrder(Order order) {
			this.id.setOrder(order);
			return this;
		}

		public OrderItemBuilder setProduct(Product product) {
			this.id.setProduct(product);
			return this;
		}

		public OrderItemBuilder setQuantity(Integer quantity) {
			this.quantity = quantity;
			return this;
		}

		public OrderItemBuilder setPrice(Double price) {
			this.price = price;
			return this;
		}

		public OrderItem build() {
			return new OrderItem(this);
		}

	}

}
