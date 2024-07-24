package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {
	
	public static void main(String[] args) {
	
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 350.00));
		list.add(new Product("HD Case", 80.00));
		
		double minValue = 100.0;
		
		/*
			Foram desenvolvidas 5 abordagens para esta demonstração:
			
			• Implementação da interface;
				- Criação da classe util.ProductPredicate implementando a interface
				'Predicate';
				
			• Reference method com método estático;
				- Criação de um método estático dentro da nossa classe Product, ou seja,
				o método recebe um objeto Product do seu parametro e acessa o seu valor a ser testado;
				
			• Reference method com método não estático;
				- Criação de um método não estático dentro da nossa classe Product, ou seja,
				o método acessa o atributo encapsulado dentro do próprio objeto a ser testado;
				
			• Expressão lambda declarada;
				- Expressão lambda declarada em uma variavel, e em sua utilização apenas referenciada para reuso;
				
			• Expressão lambda inline;
				- Expressão lambda declarada diretamente no predicado, sem a necessidade de atribuir
				para uma variavel;
			
		*/
		
		list.removeIf(x -> x.getPrice() >= minValue); // Lambda Inline
		
		for (Product p : list) {
			System.out.println(p);
		}
		
	}
}
