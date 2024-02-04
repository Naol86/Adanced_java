package studentR;

import java.sql.*;
import java.util.ArrayList;

public class backend {
	public static void save(student stud) {
		try {
			Connection con = database.getConnetion();
			PreparedStatement ps = con.prepareStatement("INSERT into students (username, Fname, Lname, email, password, sex, department, hobbies) values(?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, stud.getUserName());
			ps.setString(2, stud.getFirstName());
			ps.setString(3, stud.getLastName());
			ps.setString(4, stud.getEmail());
			ps.setString(5, stud.getPassword());
			ps.setString(6, stud.getSex());
			ps.setString(7, stud.getDepartment());
			ps.setString(8, stud.getHobbies());
			int row = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<student> getAll() {
		ArrayList<student> lis = new ArrayList<student>();
		try {
			Connection con = database.getConnetion();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from students;");
			while (rs.next()) {
				student newStud = new student();
				newStud.setUserName(rs.getString(1));
				newStud.setFirstName(rs.getString(2));
				newStud.setLastName(rs.getString(3));
				newStud.setEmail(rs.getString(4));
				newStud.setPassword(rs.getString(5));
				newStud.setSex(rs.getString(6));
				newStud.setDepartment(rs.getString(7));
				newStud.setHobbies(rs.getString(8));
				lis.add(newStud);
			}
		} catch(Exception e){
			System.out.println(e);
		}
		
		return lis;
	}
	public static void delete(String username) throws SQLException {
		Connection con = database.getConnetion();
		PreparedStatement st = con.prepareStatement("delete from students where username = ?");
		st.setString(1, username);
		st.executeUpdate();
	}
}
