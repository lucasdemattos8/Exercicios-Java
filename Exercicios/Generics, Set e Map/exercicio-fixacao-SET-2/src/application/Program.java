package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Character> coursesList = new ArrayList<>(Arrays.asList('A', 'B', 'C'));
		
		Set<Integer> courseA = new HashSet<Integer>();
		Set<Integer> courseB = new HashSet<Integer>();
		Set<Integer> courseC = new HashSet<Integer>();
		
		Set<Integer> totalStudents = new HashSet<Integer>();

		for(Character course : coursesList) {
			System.out.print("How many students for course " + course + "? ");
			int students = sc.nextInt();
			for (int i = 0; i < students; i++) {
				int student = sc.nextInt();
				switch (course) {
					case 'A':{
						courseA.add(student);
						break;
					}
					case 'B':{
						courseB.add(student);
						break;
					}
					case 'C':{
						courseC.add(student);
						break;
					}	
				}
			}	
		}
		
		totalStudents.addAll(courseA);
		totalStudents.addAll(courseB);
		totalStudents.addAll(courseC);
		
		System.out.println("Total students: " + totalStudents.size());
		
		sc.close();
	}

}
