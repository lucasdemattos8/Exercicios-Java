package application;

import entities.Clients;

public class Program {

	public static void main(String[] args) {

		Clients c1 = new Clients("Lucas", "lucas@gmail.com");
		Clients c2 = new Clients("Lucas", "lucas@gmail.com");
		
		String s1 = "Teste";
		String s2 = "Teste";
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c1.equals(c2));
		
		System.out.println(c1 == c2);
		System.out.println(s1 == s2);
	}

}
