package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {
	
	public static void main (String args[]) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pessoa> listaContribuintes = new ArrayList<>();
		
		System.out.print("Insira o número de contribuintes: ");
		int quantidade = sc.nextInt();
		
		for (int i = 1; i <= quantidade; i++) {
			System.out.printf("[Dados do contribuinte #%d]:%n", i);
			System.out.print("Individuo ou empresa (i/e): ");
			char tipo = sc.next().toUpperCase().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine(); // Limpeza de Buffer
			String nome = sc.nextLine();
			System.out.print("Renda anual: ");
			double rendaAnual = sc.nextDouble();
			
			if (tipo == 'I') {
				System.out.print("Gastos com saúde: ");
				double gastosComSaude = sc.nextDouble();
				
				listaContribuintes.add(new PessoaFisica(
						nome, rendaAnual, gastosComSaude));
			}
			else if (tipo == 'C') {
				System.out.print("Número de colaboradores: ");
				int numeroDeColaboradores = sc.nextInt();
			
				listaContribuintes.add(new PessoaJuridica(
						nome, rendaAnual, numeroDeColaboradores));
			}
		}

		System.out.println("\nImposto a pagar: ");
		double totalDeImposto = 0.0;
		
		for (Pessoa pessoa : listaContribuintes) {
			System.out.println(pessoa.getNome() + ": R$ "+ String.format(
					"%.2f", pessoa.impostoAPagar()));
			totalDeImposto += pessoa.impostoAPagar();
		}
		
		System.out.println("\nTotal de imposto: R$ " + totalDeImposto);
		
		sc.close();
	}
}
