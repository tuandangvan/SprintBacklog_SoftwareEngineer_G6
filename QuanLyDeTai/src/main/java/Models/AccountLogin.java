package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountLogin{

	private static String serverName = "VANTUAN";
	private static String dbName = "DKDT_CNPM";
	private static String portNumber = "1433";
	private static String instance = "";// MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
	private static String userID = "sa";
	private static String password = "12345";

	public static boolean checkLogin(String userName, String passworduser) throws Exception {
		boolean success=false;
		
		//connect
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
		Connection con = DriverManager.getConnection(url,userID,password);
		//query
		try {
			String sql = "Select * from Account where userName=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passworduser);

			ResultSet rs = ps.executeQuery();

			if (rs.next())
			{
				success = true;
			}
			else
				success = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
}
