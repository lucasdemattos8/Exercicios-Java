package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

public class Program {
	
	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> productsList = new ArrayList<>();
		
		System.out.print("Enter with the file path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			
			while(line != null) {
				String[] values = line.split(",");
				
				String productName = values[0];
				Double productValue = Double.parseDouble(values[1]);
				
				Product product = new Product(productName, productValue);
				
				productsList.add(product);
				line = br.readLine(); // Próxima linha
			}
		}
		catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
		
		double averagePrice = productsList.stream()
				.map(p -> p.getPrice())
				.reduce(0.0, (x, y) -> x + y) / productsList.size();
		
		System.out.println("Average price : " + String.format("%.2f", averagePrice));

		Comparator<String> comparator = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
		
		List<String> names = productsList.stream().filter(p -> p.getPrice() < averagePrice)
				.map(p -> p.getName())
				.sorted(comparator.reversed())
				.collect(Collectors.toList());
		
		names.forEach(System.out::println);
		
		sc.close();
	}
}
