package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	public User() {
	}
	
	private User(UserBuilder userBuilder) {
		this.id = userBuilder.id;
		this.name = userBuilder.name;
		this.email = userBuilder.email;
		this.phone = userBuilder.phone;
		this.password = userBuilder.password;
	}
	
	// Getters e Setters
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// hashCode e Equals

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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}	
	
	// Builder
	
	public static class UserBuilder{
		private Long id;
		private String name;
		private String email;
		private String phone;
		private String password;
		
		public UserBuilder setId(Long id) {
			this.id = id;
			return this;
		}
		
		public UserBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public UserBuilder setEmail(String email) {
			this.email = email;
			return this;
		}
		
		public UserBuilder setPhone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public UserBuilder setPassword(String password) {
			this.password = password;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
}
