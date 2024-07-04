package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {
	
	public static void main(String args[]) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Shape> listOfShapes = new ArrayList<>();
	
		System.out.print("Enter the number of shapes: ");
		int NumberOfShapes = sc.nextInt();
		
		for (int i = 0; i < NumberOfShapes; i++) {
			System.out.printf("Shape #%d data:%n", i + 1);
			
			System.out.print("Rectangle or Circle (r/c): ");
			char choose = sc.next().toUpperCase().charAt(0);
			System.out.print("Color (BLACK/BLUE/RED): ");
			sc.nextLine(); // Limpa Buffer
			String color = sc.nextLine().toUpperCase();
			
			if (choose == 'R') {
				System.out.print("Width: ");
				double width = sc.nextDouble();
				System.out.print("Height: ");
				double height = sc.nextDouble();
				
				listOfShapes.add(new Rectangle(Color.valueOf(color), width, height));
			}
			else if (choose == 'C') {
				System.out.print("Radius: ");
				double radius = sc.nextDouble();
				
				listOfShapes.add(new Circle(Color.valueOf(color), radius));
			}
		}
		
		System.out.println("\nSHAPE AREAS:");
		
		for (Shape shapes : listOfShapes) {
			System.out.println(String.format("%.2f", shapes.area()));
		}
		
		sc.close();
	}
}
