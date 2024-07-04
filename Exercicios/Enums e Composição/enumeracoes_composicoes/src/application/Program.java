package application;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Program {
	
	public static void main(String args[]) throws ParseException {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Insira o departamento do colaborador: ");
		String nomeDoDepartamento = sc.nextLine();
		System.out.println("[Insira os dados do trabalhador]");
		System.out.print("Nome: ");
		String nomeDoColaborador = sc.nextLine();
		System.out.print("Nível hierárquico: ");
		String nivelDoColaborador = sc.nextLine();
		System.out.print("Sálario base: ");
		double salarioBase = sc.nextDouble();
		
		Worker worker = new Worker(nomeDoColaborador, WorkerLevel.valueOf(nivelDoColaborador),
				salarioBase, new Department(nomeDoDepartamento));
		
		System.out.print("Quantos contratos deseja atribuir ao trabalhador: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.printf("[Insira dados do contrato #0%d]:%n", i);
			System.out.print("Data (DD/MM/YYYY): ");
			Date DataDeContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração (Horas): ");
			int horas = sc.nextInt();
			HourContract contrato = new HourContract(DataDeContrato, valorPorHora, horas);
			worker.addContract(contrato);
		}
		
		System.out.println();
		System.out.print("Insira um mês e um ano para calcular o salário (MM/YYYY): ");
		sc.nextLine();
		String mesEAno = sc.nextLine();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println("Nome: " + worker.getNome());
		System.out.println("Departamento: " + worker.getDepartment().getNome());
		System.out.println("Valor a receber a partir de " + mesEAno + ": " + 
		String.format("%.2f", worker.incomeValue(ano, mes)));

		
		
		sc.close();
	}
}
