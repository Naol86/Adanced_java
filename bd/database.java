package bd;
import java.sql.*;

public class database {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/Software_Company";
		String user = "naol";
		String pass = "1122";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,pass);
			Statement st = con.createStatement();
			int rs = st.executeUpdate("create table new_name(firstName varchar(100), id INT)");
			System.out.println(rs);
			// while(rs.next()){
			// 	int id = rs.getInt("id");
			// 	String title = rs.getString("title");
			// 	System.out.println(id + " " + title);
			// }

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
