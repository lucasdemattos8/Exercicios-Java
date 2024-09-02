package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	public Category() {
	}
	
	private Category(CategoryBuilder categoryBuilder) {
		this.id = categoryBuilder.id;
		this.name = categoryBuilder.name;
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
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

	public static class CategoryBuilder{
		private Long id;
		private String name;
		
		public CategoryBuilder setId(Long id) {
			this.id = id;
			return this;
		}
		
		public CategoryBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Category build() {
			return new Category(this);
		}
	}

}
