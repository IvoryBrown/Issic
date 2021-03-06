package hu.working;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkingDB {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/issic";
	static final String USER = "root";
	static final String PASS = "12345";

	public WorkingDB() {

	}

	protected static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			return con;
		} catch (SQLException ex) {
			Logger.getLogger(Working.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
