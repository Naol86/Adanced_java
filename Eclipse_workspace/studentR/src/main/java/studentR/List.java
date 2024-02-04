package studentR;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class List
 */
@WebServlet("/List")
public class List extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		ArrayList<student> lis = backend.getAll();
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>first name</th><th>last name</th><th>department</th></tr>");
		for (student stud : lis) {
			String page ="<tr>" + 
								"<td>" +
									stud.getFirstName() +
								"</td>" +
								"<td>" +
									stud.getLastName() + 
								"</td>" +
								"<td>" +
									stud.getDepartment() + 
								"</td>" +
								"<td>" +
								"<a href=Delete?name=" + stud.getUserName() + "> delete</a>" +
								"</td>" +
								
							"</tr>" ;
			out.print(page);
		}
		out.print("</table>");
		out.print("<a href=\"index.html\"> home </a>"); 
	}

}
