package com.techyard.user;

import java.sql.*;
import java.util.*;

public class UserDBUtil {
    // SQL parameter
    private final String URL = "jdbc:mysql://localhost:3306/tech_yard";
    private final String userName = "root";
    private final String passWord = "Sonu@9876";

    // Insert data into data base method
    String registerCustomer(User theUser) {
        // SQL query for insert user into data base
        String query = "insert into user_details "
                + "(u_name, u_age, u_email, u_contact, u_password, u_houseno, u_street, u_city, u_state, u_pincode) "
                + " values(?,?,?,?,?,?,?,?,?,?)";
        try {
            // Create SQL objects
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection(URL, userName, passWord);
            PreparedStatement stmt = con.prepareStatement(query);
            // Set values for insert commod
            stmt.setString(1, theUser.getU_Name());
            stmt.setInt(2, theUser.getU_Age());
            stmt.setString(3, theUser.getU_Email());
            stmt.setString(4, theUser.getU_Contact());
            stmt.setString(5, theUser.getU_Password());
            stmt.setInt(6, -1);
            stmt.setString(7, "");
            stmt.setString(8, "");
            stmt.setString(9, "");
            stmt.setString(10, "");
            // Execute insert commond
            int success = stmt.executeUpdate();
            close(con, stmt, null);
            // Return when insert data success
            if (success == 1) {
                return "DONE";
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        // Return when data not able to insert in data base 
        return "FAIL";
    }

    // Fetching user data
    User loginUser(String getEmail, String getPassword) {
        // Create user class object set it to null
        User newUser = null;
        try {
            // Create and assign the parameter of SQL classes
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, userName, passWord);
            PreparedStatement stmt = con.prepareStatement("select * from user_details where u_email = ? and u_password = ?");
            // Set values
            stmt.setString(1, getEmail);
            stmt.setString(2, getPassword);
            // Execute the query;
            ResultSet rs = stmt.executeQuery();
            // Check can data has in data base
            if (rs.next()) {
                String name = rs.getString("u_name");
                int age = rs.getInt("u_age");
                String email = rs.getString("u_email");
                String contact = rs.getString("u_contact");
                String password = rs.getString("u_password");
                int houseNo = rs.getInt("u_houseno");
                String street = rs.getString("u_street");
                String state = rs.getString("u_state");
                String city = rs.getString("u_city");
                String pincode = rs.getString("u_pincode");
                // Store data in user class 
                newUser = new User(name, email, contact, password, street, city, state, pincode, age, houseNo);
                // Close sql oject
                close(con, stmt, null);
                // Return if data find
                return newUser;
            }
        } catch (Exception e) {
        }
        // Return  null if data is not find 
        return newUser;
    }

    // Change user password
    String changePassword(User theUser) {
        // Create SQL objects
        Connection con = null;
        PreparedStatement stmt = null;
        // SQL query for update password user into data base
        String query = "update user_details "
                + "set u_password = ? "
                + "where u_email = ?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Set values for insert commod
            stmt.setString(1, theUser.getU_Password());
            stmt.setString(2, theUser.getU_Email());
            // Execute insert commond
            int value = stmt.executeUpdate();
            // Close sql oject
            close(con, stmt, null);
            // Return when insert data success
            if (value > 0) {
                return "SUCCESS";
            }
        } catch (Exception e) {
        }
        // Return when data not able to insert in data base
        return "FAIL";
    }

    // Close SQL ojects
    private void close(Connection con, Statement stmt, ResultSet rs) {
        try {
            if (con != null && stmt != null && rs != null) {
                con.close();
                stmt.close();
                rs.close();
            }
        } catch (SQLException e) {
        }
    }

    // Update user basic details
    int updateUserDetails(User theUser) {
        // Update data query 
        String query = "update user_details set u_name = ?, u_age = ?, u_contact = ?, u_houseno = ?, "
                + " u_street = ?,  u_city = ?, u_state = ?, u_pincode = ? where u_email = ?";
        // Create SQL object set null
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            // Assign values to
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Setting query values 
            stmt.setString(1, theUser.getU_Name());
            stmt.setInt(2, theUser.getU_Age());
            stmt.setString(3, theUser.getU_Contact());
            stmt.setInt(4, theUser.getU_HouseNo());
            stmt.setString(5, theUser.getU_Street());
            stmt.setString(6, theUser.getU_City());
            stmt.setString(7, theUser.getU_State());
            stmt.setString(8, theUser.getU_Pincode());
            stmt.setString(9, theUser.getU_Email());
            // Excute query
            int i = stmt.executeUpdate();
            // Return if data was suucessfully update
            return i;
        } catch (Exception e) {
        }
        // Return if data was not update
        return 0;
    }

    // Get all user detials
    public List<User> getUserDetails() {
        // Create list type user class object
         List<User> userTable = new ArrayList<>();
         // Create sql Objects
         Connection con = null;
         Statement stmt = null;
         ResultSet rs = null;
         // Query for get data
         String query = "select * from user_details";
         try{
             // Assign sql object values
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection(URL, userName, passWord);
             stmt = con.createStatement();
             // Execute query
             rs = stmt.executeQuery(query);
             // While loop
             while(rs.next()){
                 // Store data in local veriable
                 String name = rs.getString(1);
                 int age = rs.getInt(2);
                 String email = rs.getString(3);
                 String contact = rs.getString(4);
                 String password = rs.getString(5);
                 int houseno = rs.getInt(6);
                 String street = rs.getString(7);
                 String city = rs.getString(8);
                 String state = rs.getString(9);
                 String pincode = rs.getString(10);
                 // Create user class object and store local data on it
                 User theUser = new User(name,email,contact,password, street, city, state, pincode,age, houseno);
                 // Add noraml user to list object
                 userTable.add(theUser);
             }
         }catch(Exception ex){
         }
         // Return list object
         return userTable;
    }
}