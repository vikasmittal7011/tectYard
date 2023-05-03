package com.techyard.feedback;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "FeedBackServlet", urlPatterns = {"/FeedBackServlet"})
public class FeedBackServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Getting commond
        String commond = request.getParameter("Commond");
        // Check tha commond
        switch (commond) {
            case "FEEDBACK":
                addFeedback(request, response);
                break;
            case "DELETE":
                deleteFeedback(request, response);
                break;
        }
    }

    // Add data method
    private void addFeedback(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Getting data form from
        String email = request.getParameter("U_Email");
        String comment = request.getParameter("F_Comment");
        // Making objects of classes
        FeedBack theFeedBack = new FeedBack(comment, email);
        FBDBUtil theFBDBUtil = new FBDBUtil();
        // Getting result of action
        int i = theFBDBUtil.inserData(theFeedBack);
        // Create session object
        HttpSession httpSession = request.getSession();
        if (i > 0) {
            // Run if data was save 
            httpSession.setAttribute("message", "Thank you for giving your feed back to us !!");
            response.sendRedirect("Client-Side/Client-Feed-Back.jsp");
        } else {
            // Run if fails
            httpSession.setAttribute("message", "Something is worng to giving feed back !!");
            response.sendRedirect("Client-Side/Client-Feed-Back.jsp");
        }
    }

    private void deleteFeedback(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Getting id
        String id = request.getParameter("Id");
        // Create object of utility class object
        FBDBUtil theBDBUtil = new FBDBUtil();
        // Run detele method
        int result = theBDBUtil.deletFeedBackDetails(id);
        // Session object
        HttpSession httpSession = request.getSession();
        if (result > 0) {
            httpSession.setAttribute("message", "The details was successfully deleted, the id is: " + id);
            response.sendRedirect("Admin-Side/Admin-Feed-Back.jsp");
        } else {
            httpSession.setAttribute("message", "Somthing is wrong to delete data.");
            response.sendRedirect("Admin-Side/Admin-Feed-Back.jsp");
        }
    }
}