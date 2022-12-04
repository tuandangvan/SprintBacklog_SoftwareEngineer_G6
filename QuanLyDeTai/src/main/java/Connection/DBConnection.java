package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBConnection {
	private final String serverName = "VANTUAN";
	private final String dbName = "DKDT_CNPM";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "12345";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	public static void main(String[] args) {
		try {
			System.out.println(new DBConnection().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
