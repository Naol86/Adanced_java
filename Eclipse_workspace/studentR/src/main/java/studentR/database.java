package studentR;

import java.sql.*;

public class database {
//	Connection con;
	public static Connection getConnetion() {
		String url = "jdbc:mysql://localhost:3306/hana";
		String user = "naol";
		String pass = "1122";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return con;
	}

}
