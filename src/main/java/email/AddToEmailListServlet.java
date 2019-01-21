package email;

import business.User;
import data.UserIO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "AddToEmailListServlet")
public class AddToEmailListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("emailAddress"));
       String path = getServletContext().getRealPath("/WEB-INF") + File.separator + "EmailList.json";
        UserIO.addRecord(user, path);

        // store user object in request object
        request.setAttribute("user", user);
        String url = "/display_email_entry.jsp";

        // forward request and response objects to JSP page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
