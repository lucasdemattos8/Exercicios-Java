package application;

import java.time.LocalDate;

import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	public static void main(String[] args) {
		
		Department d1 = new Department(1, "Books");
		
		Seller seller = new Seller(1, "Carl", "carl@gmail.com", LocalDate.now(), 2800.59, d1);
		
		System.out.println(seller);
		
		
	}
}
