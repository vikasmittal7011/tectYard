package com.techyard.feedback;

import java.sql.*;
import java.util.*;

public class FBDBUtil {

    // SQL parameter
    private final String URL = "jdbc:mysql://localhost:3306/tech_yard";
    private final String userName = "root";
    private final String passWord = "Sonu@9876";
    private final String driver = "com.mysql.jdbc.Driver";

    public FBDBUtil() {}

    // Insert data in db
    int inserData(FeedBack theFeedBack) {
        // Query for insert data
        String query = "insert into feed_back_list (u_email, f_comment) values(?,?)";
        // Mysql Object
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            // Assign values of sql objects
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Setting data into query
            stmt.setString(1, theFeedBack.getEmail());
            stmt.setString(2, theFeedBack.getComment());
            // Execute query
            int i = stmt.executeUpdate();
            // return if data enter successfully
            return i;
        } catch (Exception e) {
        }
        // return if not success
        return 0;
    }

    // Fetching all data form feed back table
    public List<FeedBack> getFeedBacks() {
        // Making list object
        List<FeedBack> theFeedBacks = new ArrayList<>();
        // Query
        String query = "select "
                + "f_id, f_comment, u_name, u_age, u_contact, feed_back_list.U_Email "
                + "from feed_back_list "
                + "inner join user_details on feed_back_list.U_Email = user_details.U_Email "
                + "order by f_id desc";
        // sql object
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
       try{
           // Assign data to sql objects
           Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            // Running loop 
            while(rs.next()){
                // Store data
                String name = rs.getString("U_Name");
                String email = rs.getString("U_Email");
                String contact = rs.getString("U_Contact");
                String comment = rs.getString("F_Comment");
                int id = rs.getInt("F_Id");
                int age = rs.getInt("U_Age");
                // Set data into feedback object
                FeedBack theFeedBack = new FeedBack(id, age, comment, name, email, contact);
                // Add data into list object
                theFeedBacks.add(theFeedBack);
            }
       }catch(Exception e){  
       }
        // return data 
        return theFeedBacks;
    }

    // Delete data
    int deletFeedBackDetails(String id) {
        // Convert string value in int
        int F_Id = Integer.parseInt(id);
        // Query 
        String query = "delete from feed_back_list where f_id = ?";
        // Sql objects
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            // Assign values 
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Set value to query data
            stmt.setInt(1, F_Id);
            // Execute command
            int i = stmt.executeUpdate();
            // Return if success;
            return i;
        }catch(Exception e){
            System.out.println(e);
        }
        // Return if not success
        return 0;
    }
}