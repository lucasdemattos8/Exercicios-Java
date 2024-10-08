package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		List<Department> departmentList = new ArrayList<Department>();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("-= TEST 1: Department findById =-");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n-= TEST 2: Department findAll =-");
		departmentList = departmentDao.findAll();
		departmentList.forEach(System.out::println);
		
		System.out.println("\n-= TEST 4: Department Insert =-");
		Department department2 = new Department(null, "Tables");
		departmentDao.insert(department2);
		System.out.println("Done! Seller inserted, new ID = " + department2.getId());
		
		System.out.println("\n-= TEST 5: Department Update =-");
		department = departmentDao.findById(2);
		department.setName("Juices");
		departmentDao.update(department);
		System.out.println("Updated.");
		
		System.out.println("\n-= TEST 6: Department Delete =-");
		System.out.print("Enter the ID for delete in Database: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted.");
	
		sc.close();
	}
}
