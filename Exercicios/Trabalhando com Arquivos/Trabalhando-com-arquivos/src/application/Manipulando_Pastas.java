package application;

import java.io.File;
import java.util.Scanner;

public class Manipulando_Pastas {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira um diretorio: ");
		String strPath = sc.nextLine();

		File path = new File(strPath);
		
		File[] pastas = path.listFiles(File::isDirectory);
		
		System.out.println("Pastas :");
		for (File pasta : pastas) {
			if (pasta != null) {
				System.out.println(pasta);
			}
		}
		
		File[] arquivos = path.listFiles(File::isFile);
		
		System.out.println("\n-x-");
		System.out.println("Arquivos :");
		for (File arquivo : arquivos) {
			if (arquivo != null) {
				System.out.println(arquivo);
			}
		}
		
		boolean statusFile = new File(strPath + "\\miau").mkdir();
		System.out.println("Status do diretório criado: " + statusFile);
		
		sc.close();
	}

}
