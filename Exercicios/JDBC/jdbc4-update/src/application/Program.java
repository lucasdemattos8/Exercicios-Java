package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {
	
	public static void main(String[] args) {
	
		Connection conn = null;
		PreparedStatement st = null;
		
		conn = DB.getConnection();
		try {
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ?"
					+ "WHERE "
					+ "(DepartmentId = ?)");
			
			st.setDouble(1, 200.00);
			st.setInt(2, 2);
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				System.out.println("Done!");
				System.out.println("Rows Affected : " + rowsAffected);
			}
			else {
				System.out.println("Any row was affected.");
				System.out.println("Rows Affected : " + rowsAffected);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
