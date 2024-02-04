package studentR;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		student newStud = new student();
		newStud.setUserName(request.getParameter("username"));
		newStud.setFirstName(request.getParameter("firstname"));
		newStud.setLastName(request.getParameter("lastname"));
		newStud.setEmail(request.getParameter("email"));
		newStud.setSex(request.getParameter("sex"));
		newStud.setDepartment(request.getParameter("department"));
		newStud.setHobbies(request.getParameter("hobbies"));
		newStud.setPassword(request.getParameter("password"));
		backend.save(newStud);
		PrintWriter out = response.getWriter();
		out.print("<h1> here we go</h1>");
		out.print("<a href=\"index.html\">home</a><br>");
		out.print("<a href=\"List\">list all</a>");
		
	}

}