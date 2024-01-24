package bd;

import java.sql.*;
import java.util.Scanner;

public class hanas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Registration Form");

        // Collect user input
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter firstname: ");
        String firstname = scanner.nextLine();

        System.out.print("Enter lastname: ");
        String lastname = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        String sex = "none";
        while (true){
            System.out.print("Enter sex: M or F: ");
            sex = scanner.nextLine();
            System.out.println(sex);
            if(sex.equals("F") || sex.equals("M") || sex.equals("f") || sex.equals("m")){
                break;
            }
        }


        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        String[] hbs = {"reading" , "football", "swimming"};
        int i = 0;
        for(String hb : hbs){
            System.out.println("enter " + i++ + " for " + hb);
        }
        System.out.print("Enter hobbies: ");
        String hobbies = scanner.nextLine();
        String hobb = "";
        String[] temp = hobbies.split(" ");
        for(i = 0; i < hobbies.length(); i++){
            try {
                hobb += hbs[Integer.parseInt(temp[i])] + ",";
            } catch (Exception e) {
                // TODO: handle exception
            }
        }



        String url = "jdbc:mysql://localhost:3306/hana";
        String un = "naol";
        String pass = "1122";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, un, pass);
            String sql = "INSERT into students (username, Fname, Lname, email, password, sex, department, hobbies) values(?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setString(4, email);
            ps.setString(5, password);
            ps.setString(6, sex);
            ps.setString(7, department);
            ps.setString(8, hobb);
            int row = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
