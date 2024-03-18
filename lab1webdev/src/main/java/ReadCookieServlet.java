import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadCookie")
public class ReadCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();

        out.println("<html><body>");
        out.println("<h2>Cookie values:</h2>");
        if (cookies != null) {
            out.println("<ul>");
            for (Cookie cookie : cookies) {
                out.println("<li>" + cookie.getName() + ": " + cookie.getValue() + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>No cookies found.</p>");
        }
        out.println("</body></html>");
    }
}