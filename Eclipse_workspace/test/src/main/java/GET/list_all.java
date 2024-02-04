package GET;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class list_all
 */
@WebServlet("/list_all")
public class list_all extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public list_all() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("naol");
		String url = "jdbc:mysql://localhost:3306/hana";
        String un = "naol";
        String pass = "1122";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, un, pass);
            
        } catch(Exception e){
        	System.out.println(e);
        }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("naol");
		PrintWriter out = response.getWriter();
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from students");
			while (rs.next()) {
				String username, fname,lname,email,sex,department, hobbies, pass;
				username = rs.getString("userName");
				fname = rs.getString("FName");
				lname = rs.getString("LName");
				email = rs.getString("email");
				pass = rs.getString("password");
				department = rs.getString("department");
				hobbies = rs.getString("hobbies");
				sex = rs.getString("sex");
				
				out.println(username +"  "+fname+" "+lname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		response.sendRedirect("testJsp.jsp");		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
