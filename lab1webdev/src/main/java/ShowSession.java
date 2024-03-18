import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  // Add this import for HttpSession


@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        // Check if this is a new session
        if (session.isNew()) {
            // If new, display the welcome message and form for name and birth date
            out.println("<p>Welcome to my site!</p>");
            out.println("<form action='ShowSession' method='POST'>");
            out.println("Full Name: <input type='text' name='fullName'><br>");
            out.println("Date of Birth (mm/dd/yyyy): <input type='text' name='birthDate'><br>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        } else {
            // If returning, display the welcome back message
            out.println("<p>Welcome back!</p>");
            
            // Check if we already have the user's name and birth date
            String fullName = (String) session.getAttribute("fullName");
            String birthDate = (String) session.getAttribute("birthDate");
            if (fullName != null && birthDate != null) {
                // Compute the number of days to the user's next birthday
                int daysToBirthday = calculateDaysToBirthday(birthDate);
                out.println("<p>Hi, " + fullName + ". There are " + daysToBirthday + " days to your birthday.</p>");
            } else {
                out.println("<p>We do not have your details. Please submit your name and birth date.</p>");
            }
        }
        // Count the number of visits
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if (visitCount == null) {
            visitCount = 0; // start counting
        }
        visitCount++;
        session.setAttribute("visitCount", visitCount);
        
        out.println("<p>Visit count: " + visitCount + "</p>");
        out.println("</body></html>");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Store the submitted name and birth date in the session
        String fullName = request.getParameter("fullName");
        String birthDate = request.getParameter("birthDate");
        
        HttpSession session = request.getSession();
        session.setAttribute("fullName", fullName);
        session.setAttribute("birthDate", birthDate);
        
        // Redirect back to doGet to display the message
        doGet(request, response);
    }
    
    private int calculateDaysToBirthday(String birthDateString) {
        // Implement your date calculation logic here
        // ...
        return 0; // replace with the calculated days
    }
}