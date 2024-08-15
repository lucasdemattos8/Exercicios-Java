package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Program {
	
	public static void main(String[] args) {
	
		Connection conn = null;
		PreparedStatement st = null;
		
		conn = DB.getConnection();
		try {
			st = conn.prepareStatement(
					"DELETE FROM department " +
					"WHERE " +
					"ID = ?");
			
			st.setInt(1, 2);
			
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
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
