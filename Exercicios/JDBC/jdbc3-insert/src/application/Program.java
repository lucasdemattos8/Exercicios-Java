package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {
	
	public static void main(String[] args) {
	
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DB.getConnection();
			
			/*
			ps = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, Birthdate, BaseSalary ,DepartmentId)"
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, "Carl Purple");
			ps.setString(2, "carl.purple@gmail.com");
			ps.setDate(3, new java.sql.Date(sdf.parse("12/05/2005").getTime()));
			ps.setDouble(4, 3000.0);
			ps.setInt(5, 4);
			
			
			
			*/
			
			ps = conn.prepareStatement(
					"INSERT INTO department (Name) values ('D1'), ('D2')",
					Statement.RETURN_GENERATED_KEYS);
			
			int rowsAffected = ps.executeUpdate();
			
			
			if (rowsAffected > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done, ID = " + id);
				}
			}
			else {
				System.out.println("No rown affected!");
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
