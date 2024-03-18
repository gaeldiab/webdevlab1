import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FormServlet")
public class Form_Servlet1 extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        // TODO Auto-generated method stub
        // Retrieve elements from the request parameters
        String firstName = request.getParameter("FName");
        String lastName = request.getParameter("LName");
        String birthDay = request.getParameter("BDay");
        String sex = request.getParameter("sex");


        //get cookies 
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);
        Cookie birthDayCookie = new Cookie("birthDay", birthDay);
        Cookie sexCookie = new Cookie("sex", sex);
// Set the max age of the cookies to 24 hours (86400 seconds)
        firstNameCookie.setMaxAge(86400);
        lastNameCookie.setMaxAge(86400);
        birthDayCookie.setMaxAge(86400);
        sexCookie.setMaxAge(86400);

        //add to response
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

