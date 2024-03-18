
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.ArrayList;
@WebServlet("/ListItems")
public class ListItems extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<String> itemList = (ArrayList<String>) session.getAttribute("itemList");

        if (itemList == null) {
            itemList = new ArrayList<>();
            session.setAttribute("itemList", itemList);
        }

        String newItem = request.getParameter("newItem");
        if (newItem != null && !newItem.trim().isEmpty()) {
            itemList.add(newItem);
        }

        // Send back HTML response directly
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>List Items</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>List Items</h1>");
        out.println("<ul>");
        for (String item : itemList) {
            out.println("<li>" + item + "</li>");
        }
        out.println("</ul>");
        out.println("<br>");
        out.println("<form action=\"ListItems\" method=\"post\">");
        out.println("<label for=\"newItem\">New Item:</label>");
        out.println("<input type=\"text\" id=\"newItem\" name=\"newItem\">");
        out.println("<button type=\"submit\">Add</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Redirect to doPost method to handle form submission
        doPost(request, response);
    }
}
