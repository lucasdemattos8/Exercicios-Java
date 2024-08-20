package application;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("-= TEST 1: Seller findById =-");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n-= TEST 2: Seller findByDepartment =-");
		Department department = new Department(2, null);
		List<Seller> listSeller = sellerDao.findByDepartment(department);
		listSeller.forEach(System.out::println);
		
		System.out.println("\n-= TEST 3: Seller findAll =-");
		listSeller = sellerDao.findAll();
		listSeller.forEach(System.out::println);
		
		System.out.println("\n-= TEST 4: Seller Insert =-");
		Seller newSeller = new Seller(null, "Grego", "greg@gmail.com", LocalDate.of(1967, 10, 30), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Done! Seller inserted, new ID = " + newSeller.getId());
		
		System.out.println("\n-= TEST 5: Seller Update =-");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Updated.");
		
		System.out.println("\n-= TEST 6: Seller Delete =-");
		System.out.print("Enter the ID for delete in Database: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deleted.");
		
		sc.close();
	}
}
