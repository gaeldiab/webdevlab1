import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Form_Servlet2
 */
@WebServlet("/Form_Servlet2")
public class Form_Servlet2 extends HttpServlet 
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
        // Retrieve elements from the request parameters
        String firstName = request.getParameter("fName");
        String lastName = request.getParameter("LName");
		String birthDay = request.getParameter("bDay");
		String sex = request.getParameter("sex");
		
		response.setContentType("text/html");
		//get cookies 
			Cookie firstNameCookie = new Cookie("firstName", firstName);
			Cookie lastNameCookie = new Cookie("lastName", lastName);
			Cookie birthDayCookie = new Cookie("birthDay", birthDay);
			Cookie sexCookie = new Cookie("sex", sex);
		
		firstNameCookie.setMaxAge(60*60*24);
		lastNameCookie.setMaxAge(60*60*24);
		birthDayCookie.setMaxAge(60*60*24);
		sexCookie.setMaxAge(60*60*24);
		
		response.addCookie(firstNameCookie);
		response.addCookie(lastNameCookie);
		response.addCookie(birthDayCookie);
		response.addCookie(sexCookie);
		
		response.setContentType("text/html");
		PrintWriter out1 = response.getWriter();
		
		out1.println("<HTML>");
		out1.println("<HEAD><TITLE>Lab1 Form Display</TITLE></HEAD>");
		out1.println("<BODY>");
		out1.println("<H1>Your parameters:</H1>");
		
		out1.println("<table border=1>");
		out1.println("  <tr>");
		out1.println("    <td>First Name</td>");
		out1.println("    <td>Last Name</td>      ");
		out1.println("<td>Birthday</td>");
		out1.println("<td>Sex</td>");
		out1.println("</tr>");
		out1.println("<tr>");
		out1.println("<td>"+firstName+"</td>");
		out1.println("<td>"+lastName+"</td>");
		out1.println("<td>"+birthDay+"</td>");
		out1.println("<td>"+sex+"</td>");
		out1.println("</tr>");
		out1.println("</table>");
		out1.println("</BODY></HTML>");
		out1.close();	
		doGet(request, response);
	}
}