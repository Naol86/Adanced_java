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
			System.out.println("connected");
			Statement st = con.createStatement();
			int x = st.executeUpdate("create table if not exists student(firstName varchar(100),lastName Varchar(100), id INT, age INT, section INT, department Varchar(100))");
			String sql = "INSERT INTO student (firstName, lastName, id, age, section, department) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pS = con.prepareStatement(sql);
			pS.setString(1, "naol");
			pS.setString(2, "kasinet");
			pS.setString(3, "25520");
			pS.setString(4, "21");
			pS.setString(5, "4");
			pS.setString(6, "sf");
			pS.addBatch();

			int[] result = pS.executeBatch();

			for (int i : result) {
                System.out.println("Rows affected: " + i);
            }

			ResultSet rs = st.executeQuery("select * from student");
			while(rs.next()){
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				int age = rs.getInt("age");
				int id = rs.getInt("id");
				int section = rs.getInt("section");
				String dep = rs.getString("department");
				System.out.printf("%s %s %d %d %d %s",firstName, lastName, age, id, section, dep);
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
