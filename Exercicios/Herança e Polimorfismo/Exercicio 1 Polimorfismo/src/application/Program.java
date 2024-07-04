package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {
	
	public static void main(String args[]) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> EmployeesList = new ArrayList<>();
		
		System.out.print("Você deseja cadastrar quantos funcionários: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.printf("[Cadastro #%d]:", i + 1);
			
			System.out.print("Tercerizado (Y/N): ");
			sc.nextLine();
			char outsourcedEmployee = sc.nextLine().charAt(0);
			
			System.out.print("Nome: ");
			String nameEmployee = sc.nextLine();
			
			System.out.print("Horas: ");
			int hoursEmployee = sc.nextInt();
			
			System.out.print("Valor por hora: ");
			double valuePerHourEmployee = sc.nextDouble();
			
			if (String.valueOf(outsourcedEmployee).toUpperCase().equals("N")) {
				EmployeesList.add(new Employee(
						nameEmployee, hoursEmployee, valuePerHourEmployee));
			} 
			else {
				System.out.print("Bônus adicional: ");
				double additionalCharge = sc.nextDouble();
				EmployeesList.add(new OutsourcedEmployee(
						nameEmployee, hoursEmployee, valuePerHourEmployee, additionalCharge));
			}
		}
		System.out.println("PAGAMENTOS:");
		for (Employee c : EmployeesList) {
			System.out.println(c);
		}
		
		sc.close();
	}
}
