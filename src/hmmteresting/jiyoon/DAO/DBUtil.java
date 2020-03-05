package hmmteresting.jiyoon.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
public static Connection getConnection() {
		
		try {
			String dbURL = "jdbc:mysql://localhost/hmmteresting";
			String dbID = "root";
			String dbPW = "1234";
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			return DriverManager.getConnection(dbURL,dbID,dbPW);
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


}
