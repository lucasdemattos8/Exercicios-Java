package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	Integer roomNumber;
	LocalDate checkin;
	LocalDate checkout;
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	// Construtores
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout){
		if (checkout.isBefore(checkin)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	// Getters e Setters

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}

	// Métodos
	
	public Integer duration() {
		return (int) ChronoUnit.DAYS.between(checkin, checkout);
	}
	
	public void updateDates(LocalDate checkin, LocalDate checkout){
		
		LocalDate dateTimeNow = LocalDate.now();
		
		// Condiciona de tratamento de exceções/erros
		if(checkin.isBefore(dateTimeNow) || checkout.isBefore(dateTimeNow)) {
			throw new DomainException("Reservation dates for update must be future dates") ;
		}
		if (checkout.isBefore(checkin)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		// Adiciona número de quarto
		sb.append("Room ").append(roomNumber);
		
	    // Adiciona a data de check-in formatada
		sb.append(", check-in: ").append(checkin.format(formatter));
		
		// Adiciona a data de check-out formatada
		sb.append(", check-out: ").append(checkin.format(formatter));
		
	    // Adiciona a duração da estadia em noites
		sb.append(", ").append(duration()).append(" nights.");
		
		return sb.toString();
	}
	
}
