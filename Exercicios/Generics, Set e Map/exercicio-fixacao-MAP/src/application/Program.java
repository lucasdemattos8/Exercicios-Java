package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {
	
	public static void main(String[] args) {
		
		Map<String, Integer> Electoralvotes = new TreeMap<String, Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path : ");
		String file = sc.nextLine();
	
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			
			while(line != null) {
				
				String[] values = line.strip().split(",");
				
				if(Electoralvotes.containsKey(values[0])) {
					int pastVotes = Electoralvotes.get(values[0]);
					int currentVotes = pastVotes + Integer.parseInt(values[1]);
					
					Electoralvotes.put(values[0], currentVotes);
				}
				else {
					Electoralvotes.put(values[0], Integer.parseInt(values[1]));
				}
				
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
		
		for (String elector : Electoralvotes.keySet()) {
			System.out.println(elector + " : " + Electoralvotes.get(elector));
		}
		
		sc.close();
	}
}
