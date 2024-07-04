package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	
	public static void main (String args[]) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> listaDeProdutos = new ArrayList<>();

		System.out.print("Insira quantos produtos deseja cadastrar: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.printf("[Cadastro de produto #0%d]: %n", i);
			System.out.print("Comum, usado ou importado (C/U/I): ");
			char tipo = Character.toUpperCase(sc.next().charAt(0));
			System.out.print("Nome: ");
			sc.nextLine(); // Clean buffer de quebra de linha
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			if (tipo == 'I') {
				System.out.print("Taxa de importação: ");
				double taxa = sc.nextDouble();
				listaDeProdutos.add(new ImportedProduct(nome, preco, taxa));
			} 
			else if (tipo == 'U') {
				System.out.print("Data de manufatura: ");
				sc.nextLine(); // Clean buffer de quebra de linha
				String data = sc.nextLine();
				listaDeProdutos.add(new UsedProduct(nome, preco, sdf.parse(data)));
			}
			else {
				listaDeProdutos.add(new Product(nome, preco));
			}		
		}
		
		System.out.println("\nETIQUETAS DE PREÇO: ");
		for (Product c : listaDeProdutos) {
			System.out.println(c.priceTag());
		}
		
		sc.close();
	}
}
