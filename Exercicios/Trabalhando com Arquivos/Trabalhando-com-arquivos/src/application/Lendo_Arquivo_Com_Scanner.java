package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lendo_Arquivo_Com_Scanner {
	
	public static void main(String[] args) {
	
		File arquivo = new File("c:\\temp\\miau.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(arquivo);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}
		catch(IOException e) {
			System.out.println("Erro em: " + e);
		}
		finally {
			if(sc != null) {
				sc.close();
			}
		}
		
	}
}
