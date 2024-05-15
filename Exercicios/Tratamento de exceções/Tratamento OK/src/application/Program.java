package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	
	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			System.out.print("Número de quarto: ");
			int numero = sc.nextInt();
			System.out.print("CheckIn date (dd/MM/yyyy): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), formato);
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), formato);
			
			Reservation reservation = new Reservation(numero, checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());
			
			System.out.println();
			System.out.println("Insira os dados para atualizar o cadastro: ");
			System.out.print("CheckIn date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(sc.next(), formato);
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(sc.next(), formato);
			
			reservation.updateDates(checkIn, checkOut);
			
			System.out.println("Reservation: " + reservation.toString());
		}
		catch(DateTimeParseException e) {
			System.out.println("Formato de data inválido.");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado.");
		}
				
		sc.close();
	}
}
