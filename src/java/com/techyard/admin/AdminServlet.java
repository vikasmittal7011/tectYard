package com.techyard.admin;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {
    // Using method for logout admin
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("admin-details");
        response.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the command for action
        String theCommond = request.getParameter("Commond");
        // Check command
        switch (theCommond) {
            case "ADMIN-LOGIN":
                adminLoing(request, response);
                break;
            case "UPDATE-DETAILS":
                updateAdminDetails(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // Admin login method
    private void adminLoing(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Geting data 
        String aEmail = request.getParameter("A_Email");
        String ePassword = request.getParameter("A_Password");
        // Create admin utility class object
        AdminDBUtil theAdminDBUtil = new AdminDBUtil();
        // Create admin class object and run method for login admin
        Admin theAdmin = theAdminDBUtil.loginAdmin(aEmail, ePassword);
        // Create session object
        HttpSession httpSession = request.getSession();
        if (theAdmin == null) {
            // Run if success
            httpSession.setAttribute("message", "You details are wrong, plase check it and try again");
            response.sendRedirect("Home/admin-login.jsp");
        } else {
            // Run if fails
            httpSession.setAttribute("admin-details", theAdmin);
            response.sendRedirect("Admin-Side/Admin-Order-Details.jsp");
        }
    }
    
    // Update admin details method
    private void updateAdminDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get data from form
        String name = request.getParameter("A_Name");
        String email = request.getParameter("A_Email");
        String password = request.getParameter("A_Password");
        String contact = request.getParameter("A_Contact");
        // Create admin class object 
        Admin theAdmin = new Admin(name, email, contact, password);
        // Create admin utility class object
        AdminDBUtil theAdminDBUtil = new AdminDBUtil();
        // Run update details and store result
        int result = theAdminDBUtil.updatedetails(theAdmin);
        // Create session object
        HttpSession httpSession = request.getSession();
        if(result > 0){
            // Run if success
            // Update admin details
            theAdmin = theAdminDBUtil.loginAdmin(email, password);
            httpSession.setAttribute("message", "Data was successfully changed!!");
            httpSession.setAttribute("admin-details", theAdmin);
            response.sendRedirect("Admin-Side/Admin-Profile.jsp");
        }else{
            // Run if fails
            httpSession.setAttribute("message", "Something is wrong, updation is failed1!");
            response.sendRedirect("Admin-Side/Admin-Profile.jsp");
        }
    }
}