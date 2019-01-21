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

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");
        String message;
        String url;
        User user = new User(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("emailAddress"));
        if(firstName.length() == 0 ||
            lastName.length() == 0 ||
            emailAddress.length() == 0) {
            message = "Please fill out all three text boxes.";
            url = "/join_email_list.jsp";
        } else {
            message = "";
            String path = getServletContext().getRealPath("/WEB-INF") + File.separator + "EmailList.json";
            UserIO.addRecord(user, path);
            url = "/display_email_entry.jsp";
        }

        // store user object in request object
        request.setAttribute("user", user);
        request.setAttribute("message", message);

        // forward request and response objects to JSP page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
