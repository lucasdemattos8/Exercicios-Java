package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Try_With_Resources {

	public static void main(String[] args) {
		
		String path = "c:\\temp\\miau.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String linha = br.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
