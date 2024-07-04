package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_E_BufferedWriter {
	
	public static void main (String[] args) {
		
		String[] linhas = new String[] {"Hehe5", "hehe6", "hehe7"};
		
		String path = "c:\\temp\\mia1u.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
			for (String linha : linhas) {
				bw.write(linha);
				bw.newLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
