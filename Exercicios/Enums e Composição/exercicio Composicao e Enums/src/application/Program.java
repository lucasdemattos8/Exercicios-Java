package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String emailClient = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String birthDate = sc.nextLine();
		
		Client client = new Client(nameClient, emailClient, sdf.parse(birthDate));
		
		Date CurrentDate = new Date();
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String orderStatus = sc.nextLine();
		System.out.print("How many items to this order? ");
		int orderQuantity = sc.nextInt();
		
		Order order = new Order(CurrentDate, OrderStatus.valueOf(orderStatus), client);
		
		Product[] product = new Product[orderQuantity];
		OrderItem[] orderItem = new OrderItem[orderQuantity];
		
		for(int i = 0; i < orderQuantity; i++) {
			System.out.printf("Enter #%d item data:%n", i + 1);
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productValue = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			product[i] = new Product(productName, productValue);
			orderItem[i] = new OrderItem(productQuantity, productValue, product[i]);
			order.addItem(orderItem[i]);
		}
		
		System.out.println("\nORDER SUMMARY:");
		System.out.println(order.toString());
		
		sc.close();
	}
}
