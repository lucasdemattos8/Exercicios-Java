package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Account;
import entities.BussinesAccount;
import entities.SavingsAccount;

public class Program {
	
	public static void main (String args[]) {
		
		Locale.setDefault(Locale.US);
		List<Account> list = new ArrayList<>();
		
		list.add(new SavingsAccount(1001, "Alex", 500.00, 0.01));
		list.add(new BussinesAccount(1002, "Maria", 1000.00, 400.00));
		list.add(new SavingsAccount(1003, "Bob", 300.00, 0.01));
		list.add(new BussinesAccount(1004, "Anna", 500.00, 500.00));

		double soma = 0.0;
		
		for(Account c : list) {
			soma += c.getBalance();
		}
		
		System.out.println("Soma TOTAL: " + soma);
		
		for(Account c : list) {
			c.deposit(13.00);
		}
		for(Account c : list) {
			System.out.println("Valor atualizado: " + c.getBalance());
		}		
	}
}
