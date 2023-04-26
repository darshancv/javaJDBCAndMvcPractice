package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	private static final String url = "jdbc:mysql://localhost:3306/library";
	private static final String userName = "root";
	private static final String password = "Welcome123";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeDB(Connection connection) throws SQLException {
		connection.close();
	}
}
