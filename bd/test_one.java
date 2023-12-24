package bd;

import java.sql.*;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class test_one {
	public static void main(String[] args) {
		System.out.println("test one ");
		String url = "jdbc:mysql://localhost:3306/astu"; // Replace 'your_database_name' with your database name
        String username = "naol"; // Replace 'your_username' with your MySQL username
        String password = "1122"; // Replace 'your_password' with your MySQL password

		try {
			JdbcRowSet rw = RowSetProvider.newFactory().createJdbcRowSet();
			rw.setUrl(url);
			rw.setUsername(username);
			rw.setPassword(password);

			rw.setCommand("select * from tv_shows");
			rw.execute();
			while(rw.next()){
				int id = rw.getInt("Id");
				String title = rw.getString("title");
				System.out.println(id +"   "+title);
			}
			System.out.println("done");
			// Connection connection = DriverManager.getConnection(url, username, password);
			// System.out.println("database is connected");
			// Class.forName("com.mysql.cj.jdbc.Driver");
			// Statement st = connection.createStatement();
			// ResultSet rs = st.executeQuery("select * from tv_genres");
			// int count = rs.getMetaData().getColumnCount();
			// System.out.println(count);
			// while(rs.next()){
			// 	int id = rs.getInt("id");
			// 	String title = rs.getString("name");
			// 	System.out.println(id + "  " + title);
			// }

			// DatabaseMetaData md = connection.getMetaData();
			// System.out.println(md.getURL());
			// ResultSet table = md.getTables(null, null, null, new String[]{"TABLE"});
			// while(table.next()){
			// 	String name = table.getString("TABLE_NAME");
			// 	System.out.println(name);
			// }

			// rs.close();
			// st.close();
			// connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
	}
}
