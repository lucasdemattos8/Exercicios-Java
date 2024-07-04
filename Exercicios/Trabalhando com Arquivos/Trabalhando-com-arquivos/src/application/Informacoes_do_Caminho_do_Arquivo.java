package application;

import java.io.File;
import java.util.Scanner;

public class Informacoes_do_Caminho_do_Arquivo {
	
	public static void main (String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira um diretório de arquivo: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		System.out.println("getname: " + path.getName());
		System.out.println("getParent: " + path.getParent());
		System.out.println("getPath: " + path.getPath());
		
		sc.close();
	}
}
