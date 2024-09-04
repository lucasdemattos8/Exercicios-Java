package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Order order;
	
	public Payment() {
	}

	private Payment(PaymentBuilder paymentBuilder) {
		this.id = paymentBuilder.id;
		this.moment = paymentBuilder.moment;
		this.order = paymentBuilder.order;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}

	// Class Builder
	public static class PaymentBuilder{
		private Long id;
		private Instant moment;	
		private Order order;
		
		public PaymentBuilder setId(Long id) {
			this.id = id;
			return this;
		}
		
		public PaymentBuilder setMoment(Instant moment) {
			this.moment = moment;
			return this;
		}
		
		public PaymentBuilder setOrder(Order order) {
			this.order = order;
			return this;
		}
		
		public Payment build() {
			return new Payment(this);
		}
	}
}
