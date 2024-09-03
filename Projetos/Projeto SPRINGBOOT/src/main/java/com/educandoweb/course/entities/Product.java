package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();

	public Product() {
	}

	private Product(ProductBuilder productBuilder) {
		this.id = productBuilder.id;
		this.name = productBuilder.name;
		this.description = productBuilder.description;
		this.price = productBuilder.price;
		this.imgUrl = productBuilder.imgUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
	}

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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

	public static class ProductBuilder {
		private Long id;
		private String name;
		private String description;
		private Double price;
		private String imgUrl;

		public ProductBuilder setId(Long id) {
			this.id = id;
			return this;
		}

		public ProductBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public ProductBuilder setDescription(String description) {
			this.description = description;
			return this;
		}

		public ProductBuilder setPrice(Double price) {
			this.price = price;
			return this;
		}

		public ProductBuilder setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
			return this;
		}

		public Product build() {
			return new Product(this);
		}
	}
}