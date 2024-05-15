package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Reservation;

public class Program {
	
	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Número de quarto: ");
		int numero = sc.nextInt();
		System.out.print("CheckIn date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), formato);
		System.out.print("CheckOut date (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), formato);
		
		if (checkOut.isBefore(checkIn)) {
			System.out.println(
					"Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(numero, checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());
			
			System.out.println();
			System.out.println("Insira os dados para atualizar o cadastro: ");
			System.out.print("CheckIn date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(sc.next(), formato);
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(sc.next(), formato);
			
			String error = reservation.updateDates(checkIn, checkOut);
			
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} 
			else {
				System.out.println("Reservation: " + reservation.toString());
			}
		}
		
		sc.close();
	}
}
