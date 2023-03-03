package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//Connect to database
			conn = DB.getConnection();
			
			st = conn.createStatement();
			//Enter with string corresponding to a sql command
			//rs receives the consult result
			
			rs = st.executeQuery("select * from department");
			
			//rs has a table structure
			//next() returns false when its the last element
			while(rs.next()) {
				System.out.println(rs.getInt("Id")+", "+ rs.getString("Name"));
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
			}
		//Adding this clausule is usefull since the sql resources imported arent controlled by the JVM, avoiding memory leaking
		finally {
		
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}
		
		
	}

}
