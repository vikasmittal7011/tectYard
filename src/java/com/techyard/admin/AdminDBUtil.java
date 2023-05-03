package com.techyard.admin;

import java.sql.*;
import java.util.*;

public class AdminDBUtil {

    // SQL parameter
    private final String URL = "jdbc:mysql://localhost:3306/tech_yard";
    private final String userName = "root";
    private final String passWord = "Sonu@9876";

    public AdminDBUtil(){}
    
    // Fetching admin data
    Admin loginAdmin(String aEmail, String ePassword) {
        // Create admin class object set it to null
        Admin theAdmin = null;
        try {
            // Create and assign the parameter of SQL classes
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, userName, passWord);
            PreparedStatement stmt = con.prepareStatement("select * from admin_details where a_email = ?  and a_password = ?");
            // Set values
            stmt.setString(1, aEmail);
            stmt.setString(2, ePassword);
            // Execute the query;
            ResultSet rs = stmt.executeQuery();
            // Check can data has in data base
            if (rs.next()) {
                String name = rs.getString("a_name");
                String email = rs.getString("a_email");
                String contact = rs.getString("a_contact");
                String password = rs.getString("a_password");
                // Store data in user class 
                theAdmin = new Admin(name, email, contact, password);
                // Return if data find
                return theAdmin;
            }
        } catch (Exception e) {
        }
        // Return  null if data is not find 
        return theAdmin;
    }

    // Uodate admin details
    int updatedetails(Admin theAdmin) {
        // Query 
        String query = "update admin_details set a_name = ?, a_contact = ? where a_email = ?";
        // Mysql object
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            // Set oject values
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Setting data to query
            stmt.setString(1, theAdmin.A_Name);
            stmt.setString(2, theAdmin.A_Contact);
            stmt.setString(3, theAdmin.getA_Email());
            // Execute query and get respons of success
            int i = stmt.executeUpdate();
            // Return result
            return i;
        } catch (Exception w) {
        }
        // Retrun if any error ocure
        return 0;
    }

    // Selet all admin details
    public List<Admin> getAdminsData() {
        // List type object
        List<Admin> adminList = new ArrayList<>();
        // Query
        String query = "select * from admin_details";
        // Mysql objects 
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Assign values to objects
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            // Run while loop for getting data
            while (rs.next()) {
                // Store data into local variable
                String name = rs.getString("a_name");
                String email = rs.getString("a_email");
                String contact = rs.getString("a_contact");
                String password = rs.getString("a_password");
                // Create admin object and store data on it
                Admin theAdmin = new Admin(name, email, contact, password);
                // Add details in list 
                adminList.add(theAdmin);
            }
        } catch (Exception e) {
        }
        // Return all data of admin
        return adminList;
    }
}