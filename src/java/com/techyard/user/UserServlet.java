package com.techyard.user;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    // Method for logout user
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("user-details");
        response.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get what to we do
        String theCommond = request.getParameter("Commond");
        // Check the work
        switch (theCommond) {
            case "REGISTER":
                userRegister(request, response);
                break;
            case "LOGIN":
                userLogin(request, response);
                break;
            case "UPDATE-DETAILS":
                updateUserDetails(request, response);
                break;
            case "UPDATE-PASSWORD":
                changePassword(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // User registration method
    private void userRegister(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Getting data from form
        String firstName = request.getParameter("U_Name");
        String lastName = request.getParameter("U_Name_Sur");
        String stringAge = request.getParameter("U_Age");
        String fullName = firstName + " " + lastName;
        int age = Integer.parseInt(stringAge);
        String email = request.getParameter("U_Email");
        String contact = request.getParameter("U_Contact");
        String password = request.getParameter("U_Password");
        // Set data into user class
        User theUser = new User(fullName, email, contact, password, age);
        // Send data to utility class
        UserDBUtil theuserDBUtil = new UserDBUtil();
        // Get what return by register customer method
        String message = theuserDBUtil.registerCustomer(theUser);
        // Do action on behalf of customer method return
        if (message.equals("DONE")) {
            // Run when registration was success
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("message",
                    "Your registration was success, now you are able to login with your email and Password");
            response.sendRedirect("Home/login.jsp");
        } else if (message.equals("FAIL")) {
            // Run when registration was not success
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("message", "Your email was already exist, please try another email to register");
            response.sendRedirect("Home/register.jsp");
        }
    }

    // User login method
    private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get data from form for login
        String loginEmail = request.getParameter("U_Email");
        String loginPassword = request.getParameter("U_Password");
        // Create utility class object
        UserDBUtil theUserDBUtil = new UserDBUtil();
        // Create user class object and check user are registered or not 
        User theUser = theUserDBUtil.loginUser(loginEmail, loginPassword);
        // Take action after checking user details;
        if (theUser != null) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user-details", theUser);
            response.sendRedirect("Client-Side/Client-Home.jsp");
        } else {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("message", "You details are wrong, plase check it and try again");
            response.sendRedirect("Home/login.jsp");
        }
    }

    // User details update method
    private void updateUserDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Getting data from user parofile
        int age = Integer.parseInt(request.getParameter("U_Age"));
        int houseNo = Integer.parseInt(request.getParameter("U_HouseNo"));
        String name = request.getParameter("U_Name");
        String contact = request.getParameter("U_Contact");
        String street = request.getParameter("U_Street");
        String state = request.getParameter("U_State");
        String city = request.getParameter("U_City");
        String pincode = request.getParameter("U_Pincode");
        String email = request.getParameter("U_Email");
        String password = request.getParameter("U_Password");
        // Create user class object and set the value of variables
        User theUser = new User();
        theUser.setU_Age(age);
        theUser.setU_City(city);
        theUser.setU_Contact(contact);
        theUser.setU_Email(email);
        theUser.setU_Password(password);
        theUser.setU_HouseNo(houseNo);
        theUser.setU_Name(name);
        theUser.setU_Pincode(pincode);
        theUser.setU_State(state);
        theUser.setU_Street(street);
        // Create utility class object and call the method and set the result in variable(INT)
        UserDBUtil theUserDBUtil = new UserDBUtil();
        int result = theUserDBUtil.updateUserDetails(theUser);
        // Create http session object
        HttpSession httpSession = request.getSession();
        // Run if data updation was success
        if (result > 0) {
            // Create a new User class object for update tha data of user
            User updatedData = theUserDBUtil.loginUser(email, password);
            // Send object after data update
            httpSession.setAttribute("message", "Your data was succfully updated");
            httpSession.setAttribute("user-details", updatedData);
            response.sendRedirect("Client-Side/Client-Profile.jsp");
        } else { 
            // Run if fails
            httpSession.setAttribute("message", "Data is not update, Somthing is wrong!!!");
            response.sendRedirect("Client-Side/Client-Profile.jsp");
        }

    }

    // User password chaneg method
    private void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Getting data from form
        String email = request.getParameter("U_Email");
        String password = request.getParameter("U_Password");
        // Create and Set data into user class constructor
        User theUser = new User(email, password);
        // Create utility class object
        UserDBUtil theUserDBUtil = new UserDBUtil();
        // Send data to change password method and getting result
        String result = theUserDBUtil.changePassword(theUser);
        // Create session object
        HttpSession httpSession = request.getSession();
        // Check condition based on result object
        if ("SUCCESS".equals(result)) {
            // Run if data chnaged
            httpSession.setAttribute("message", "Your Password has successfully changed, please LOGIN again !!!");
            httpSession.removeAttribute("user-details");
            response.sendRedirect("Home/login.jsp");
        } else if ("FAIL".equals(result)) {
            // Run if data is not changed
            httpSession.setAttribute("message", "Please check your mail, maye it's wrong ");
            response.sendRedirect("Home/forget-password.jsp");
        }
    }
}