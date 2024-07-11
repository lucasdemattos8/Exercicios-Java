package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;

import java.util.HashSet;
import java.util.Set;

import entities.LogClients;

import java.util.Scanner;

public class Program {
	public static void main (String[] args) {
	
		Set<LogClients> set = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			
			while(line != null) {
				String[] values = line.split(" ");
				
				String username = values[0];
				Instant date = Instant.parse(values[1]);
				
				LogClients log = new LogClients(username, date);
				
				set.add(log);
				line = br.readLine();
			}
			System.out.println(set.toString());
			System.out.println("Total Users : " + set.size());
		}
		catch(IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
		finally {
			sc.close();
		}		
	}
}
