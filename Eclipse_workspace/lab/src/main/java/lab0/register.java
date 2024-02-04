package lab0;

import java.io.IOException;
import java.sql.*;
import java.util.Map;
import java.util.Map.Entry;

// import servlet

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private String insert = "INSERT into students (username, Fname, Lname, email, password, sex, department, hobbies) values(?, ?, ?, ?, ?, ?, ?, ?)";
	private PreparedStatement ps;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
            ps = con.prepareStatement(insert);
            
        } catch(Exception e){
        	System.out.println(e);
        }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request);
//		System.out.println(request.getKey());
		Map<String, String[]> parameterMap = request.getParameterMap();

        // Iterate through the parameter map and print each parameter
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String paramName = entry.getKey();
            String[] paramValues = entry.getValue();
            

//             If the parameter has multiple values, you might want to iterate through them
            for (String paramValue : paramValues) {
                // Print parameter name and value
                System.out.println("Parameter Name: " + paramName + ", Value: " + paramValue);
            }
        }
//		doGet(request, response);
        try {
			ps.setString(1, request.getParameter("username"));
			ps.setString(2, request.getParameter("firstname"));
			ps.setString(3, request.getParameter("lastname"));
			ps.setString(4, request.getParameter("email"));
			ps.setString(5, request.getParameter("password"));
			ps.setString(6, request.getParameter("sex"));
			ps.setString(7, request.getParameter("department"));
			ps.setString(8, request.getParameterValues("hobbies").toString());
			int row = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.sendRedirect("done.html");
	}

}
