package com.techyard.orderAndcart;

import java.sql.*;
import java.util.*;

public class CancelOrderDBUtil {
    // SQL parameter
    private final String URL = "jdbc:mysql://localhost:3306/tech_yard";
    private final String userName = "root";
    private final String passWord = "Sonu@9876";
    private final String driver = "com.mysql.jdbc.Driver";
    // Create sql object
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    // Delete order details data method
    int deleteOrder(String O_Id) {
        // Convert id into int
        int id = Integer.parseInt(O_Id);
        // Query for delete
        String query = "delete from order_list where o_id = ?";
        try {
            // Assign sl object values
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Set query value
            stmt.setInt(1, id);
            // Execute query and store data
            int i = stmt.executeUpdate();
            // Return store data
            return i;
        } catch (Exception e) {
        }
        // Return if any issue ocure
        return 0;
    }

    // Insert data into cancel details method
    int insertCancelDetails(CancelOrder cancelOrder) {
        // Quert for insert data
        String query = "insert into cancel_details (u_email, p_id, c_reason, c_date_of_cancel) values(?,?,?,?)";
        try {
            // Assign sql values
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Set query values 
            stmt.setString(1, cancelOrder.getU_Email());
            stmt.setString(2, cancelOrder.getP_Id());
            stmt.setString(3, cancelOrder.getC_Reason());
            stmt.setString(4, cancelOrder.getC_Date_Of_Cancel());
            // Execute query and store data 
            int i = stmt.executeUpdate();
            // Return result of query
            return i;
        } catch (Exception e) {
            System.out.println(e);
        }
        // Return if fails
        return 0;
    }

    // Get cancel order details for user method
    public List<CancelOrder> getCancelOrderDetailsForUser(String U_Email) {
        // Create list type cancel order class object
        List<CancelOrder> cancelOrders = new ArrayList<>();
        // Query for geting data
        String query = "select u_email, c_id, c_reason, c_date_of_cancel, "
                + "product_list.P_Name, product_list.P_Id "
                + "from cancel_details "
                + "inner join product_list on product_list.P_Id = cancel_details.P_Id "
                + "where u_email = ? "
                + "order by c_id desc";
        try {
            // Assign sql object values
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Set query value
            stmt.setString(1, U_Email);
            // Execute query and store the result in rs 
            rs = stmt.executeQuery();
            // Run while 
            while (rs.next()) {
                // Store data in local variable
                String U_email = rs.getString("U_Email");
                String P_Name = rs.getString("P_Name");
                String DOC = rs.getString("C_Date_Of_Cancel");
                String C_Reason = rs.getString("C_Reason");
                int C_Id = rs.getInt("C_Id");
                // Create nomarl cancel class object and store data on it
                CancelOrder cancelOrder = new CancelOrder(C_Id, U_email, P_Name, C_Reason, DOC);
                // Add normal class data into list obect
                cancelOrders.add(cancelOrder);
            }
        } catch (Exception e) {
        }
        // Return the list object with data
        return cancelOrders;
    }

    // Get cancel order details for admin method
    public List<CancelOrder> getCancelOrderDetailsForAdmin() {
        // Create list type cancel order class object
        List<CancelOrder> cancelOrders = new ArrayList<>();
        // Query for geting data
        String query = "select u_email, c_id, c_reason, c_date_of_cancel, "
                + "product_list.p_Name, product_list.p_Id "
                + "from cancel_details  "
                + "inner join product_list on product_list.p_Id = cancel_details.p_Id "
                + "order by c_id desc";
        try {
            // Assign sql object values
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Execute query and store the result in rs 
            rs = stmt.executeQuery();
            // Run while 
            while (rs.next()) {
                // Store data in local variable
                String U_email = rs.getString("U_Email");
                String P_Name = rs.getString("P_Name");
                String DOC = rs.getString("C_Date_Of_Cancel");
                String C_Reason = rs.getString("C_Reason");
                int C_Id = rs.getInt("C_Id");
                // Create nomarl cancel class object and store data on it
                CancelOrder cancelOrder = new CancelOrder(C_Id, U_email, P_Name, C_Reason, DOC);
                // Add normal class data into list obect
                cancelOrders.add(cancelOrder);
            }
        } catch (Exception e) {
        }
        // Return the list object with data
        return cancelOrders;
    }
    
    // Delete data from cancel details
    int deleteCancelDetails(String C_Id){
        // Convert id into int
        int id = Integer.parseInt(C_Id);
        // Query for delete data
        String query = "delete from cancel_details where c_id = ?";
        try{
            // Assign sql object values
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Set query value
            stmt.setInt(1, id);
            // Execute query and store data
            int i = stmt.executeUpdate();
            // Return if success
            return i;
        }catch(Exception e){
        }
        // Return if Fails
        return 0;
    }
}