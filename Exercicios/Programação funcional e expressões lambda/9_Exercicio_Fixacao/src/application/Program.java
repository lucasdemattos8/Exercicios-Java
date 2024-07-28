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

import entities.Employee;

public class Program {
	
	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		List<Employee> employeeList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the full file path: ");
		String path = sc.nextLine();
		
		System.out.print("Enter the salary to search: ");
		Double salarySearch = sc.nextDouble();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while(line != null) {
			
				String[] values = line.strip().split(",");
				
				String name = values[0];
				String email = values[1];
				Double salary = Double.parseDouble(values[2]);
				
				Employee employee = new Employee(name, email, salary);
				
				employeeList.add(employee);
				
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
		
		System.out.println("Email of people whose salary is more than " + String.format("%.2f", salarySearch) + ":");
		
		Comparator<String> emailComparator = (email1, email2) -> email1.toUpperCase().compareTo(email2.toUpperCase());
		
		List<String> emails = employeeList.stream()
				.filter(x -> x.getSalary() > salarySearch)
				.map(x -> x.getEmail())
				.sorted(emailComparator)
				.collect(Collectors.toList());
		
		emails.forEach(System.out::println);
		
		Double salaryFindByChar = employeeList.stream()
				.filter(x -> x.getName().charAt(0) == 'M')
				.map(x -> x.getSalary())
				.reduce(0.0, (x, y) -> x + y);
		
		System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", salaryFindByChar));
				
		sc.close();
		
	}
}
