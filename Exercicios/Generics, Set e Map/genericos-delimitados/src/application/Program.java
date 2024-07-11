package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Products;
import services.CalculationService;

public class Program {
	
	public static void main(String[] args){
		
		Locale.setDefault(Locale.US);
		List<Products> list = new ArrayList<>();
		
		String path = "C://temp//products.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String linha = br.readLine();
			while(linha != null) {
				String[] values = linha.split(",");
 				
				list.add(new Products(values[0], Double.parseDouble(values[1])));
				linha = br.readLine();
			}
			
			Products x = CalculationService.max(list);
			System.out.println("Most Expensive : " + x);
			
		}
		catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
		
	}
}
