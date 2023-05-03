package com.techyard.orderAndcart;

import java.sql.*;
import java.util.*;

public class OrderDBUtil {
    // SQL parameter
    private final String URL = "jdbc:mysql://localhost:3306/tech_yard";
    private final String userName = "root";
    private final String passWord = "Sonu@9876";
    private final String driver = "com.mysql.jdbc.Driver";
    // Create sql object
    Connection con = null;
    PreparedStatement ppestmt = null;
    ResultSet rs = null;

    // Order item method
    int orderProduct(Order order) {
        // Create query that insert data
        String query = "insert into order_list (u_email, p_id, date_of_booking, date_of_delivery) values (?,?,?,?)";
        try {
            // Assign values to sql objects
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            ppestmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            // Set query values
            ppestmt.setString(1, order.getU_Email());
            ppestmt.setString(2, order.getP_Id());
            ppestmt.setString(3, order.getDOB());
            ppestmt.setString(4, order.getDOD());
            // Execute query
            ppestmt.executeUpdate();
            // Get the id of oder that was auto generated
            rs = ppestmt.getGeneratedKeys();
            // Create a local variable and assign is -1
            int generatedId = -1;
            // Run while to check data was insert or not
            if (rs.next()) {
                // Store id in local veriable
                generatedId = rs.getInt(1);
            }
            // Return id
            return generatedId;
        } catch (Exception e) {
        }
        // Return if fails
        return 0;
    }

    // Payment data insert method
    int addPaymentDetails(Order order, int O_Id) {
        // Create query that insert data
        String query = ("insert into payment_details (u_email, p_id, pay_status, o_id) values(?,?,?,?)");
        try {
            // Assign values to sql objects
            con = DriverManager.getConnection(URL, userName, passWord);
            ppestmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            // Set query values
            ppestmt.setString(1, order.getU_Email());
            ppestmt.setString(2, order.getP_Id());
            ppestmt.setBoolean(3, false);
            ppestmt.setInt(4, O_Id);
            // Execute query
            ppestmt.executeUpdate();
            // Get the id of oder that was auto generated
            rs = ppestmt.getGeneratedKeys();
            // Create a local variable and assign is -1
            int generatedId = -1;
            // Run while to check data was insert or not
            if (rs.next()) {
                // Store id in local veriable
                generatedId = rs.getInt(1);
            }
            // Return id
            return generatedId;
        } catch (Exception e) {
        }
        // Return if fails
        return 0;
    }

    // Delivery data insert method
    int addDeliveryDetails(Order order, int O_Id) {
        // Create query that insert data
        String query = "insert into delivery_details (u_email, p_id, date_of_delivery, d_status, o_id)  values(?,?,?,?,?)";
        try {
            // Assign values to sql objects
            con = DriverManager.getConnection(URL, userName, passWord);
            ppestmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            // Set query values
            ppestmt.setString(1, order.getU_Email());
            ppestmt.setString(2, order.getP_Id());
            ppestmt.setString(3, order.getDOD());
            ppestmt.setBoolean(4, false);
            ppestmt.setInt(5, O_Id);
            // Execute query
            ppestmt.executeUpdate();
            // Get the id of oder that was auto generated
            rs = ppestmt.getGeneratedKeys();
            // Create a local variable and assign is -1
            int generatedId = -1;
            // Run while to check data was insert or not
            if (rs.next()) {
                // Store id in local veriable
                generatedId = rs.getInt(1);
            }
            // Return i
            return generatedId;
        } catch (Exception e) {
        }
        // Return if fails
        return 0;
    }

    // Get the details of order for user method
    public List<Order> getOrdersDetailsForClientFirst(String U_Email) {
        // Create list type order object
        List<Order> orders = new ArrayList<>();
        // Create query that fetch the data
        String firstQuery = "select "
                + "payment_details.U_Email, U_Name, U_Contact, U_HouseNo, U_Street, U_State, U_City, U_Pincode, "
                + "payment_details.P_Id, P_Name, P_Info, P_Price, "
                + "payment_details.O_Id, Date_Of_Booking, Date_Of_Delivery, "
                + "payment_details.Pay_Id, Pay_Status "
                + "from payment_details "
                + "inner join product_list on product_list.P_Id = payment_details.P_Id "
                + "inner join user_details on user_details.U_Email = payment_details.U_Email "
                + "inner join order_list on order_list.O_Id = payment_details.O_Id "
                + "where payment_details.U_Email = ? "
                + "order by payment_details.pay_id desc ";
        try {
            // Assign values to sql objects
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            ppestmt = con.prepareStatement(firstQuery);
            // Set query values
            ppestmt.setString(1, U_Email);
            // Execute query and store data in rs
            rs = ppestmt.executeQuery();
            // Run while loop for check the data was exsist or not
            while (rs.next()) {
                // Store table data in local veriable
                boolean Pay_Status = rs.getBoolean("Pay_Status");
                int O_Id = rs.getInt("O_Id");
                int Pay_Id = rs.getInt("Pay_Id");
                int P_Price = rs.getInt("P_Price");
                String u_Email = rs.getString("U_Email");
                String U_Name = rs.getString("U_Name");
                String U_Contact = rs.getString("U_Contact");
                int House = rs.getInt("U_HouseNo");
                String U_Address = Integer.toString(House) + " "
                        + rs.getString("U_Street") + " <br>"
                        + rs.getString("U_City") + " "
                        + rs.getString("U_State") + " "
                        + rs.getString("U_Pincode");
                String P_Id = rs.getString("P_Id");
                String P_Info = rs.getString("P_Info");
                String P_Name = rs.getString("P_Name");
                String DOB = rs.getString("Date_Of_Booking");
                String DOD = rs.getString("Date_Of_Delivery");
                // Create Order class object and store local data on it
                Order o = new Order(O_Id, Pay_Id, P_Price, u_Email, P_Id, DOB, DOD, U_Address, U_Name, U_Contact, P_Name, P_Info, Pay_Status);
                // Add on list type object
                orders.add(o);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        // Return all data
        return orders;
    }

    // Get the details of order for admin method
    public List<Order> getOrdersDetailsForAdminFirst() {
        // Create list type order object
        List<Order> orders = new ArrayList<>();
        // Create query that fetch the data
        String firstQuery = "select "
                + "payment_details.U_Email, U_Name, U_Contact, U_HouseNo, U_Street, U_State, U_City, U_Pincode, "
                + "payment_details.P_Id, P_Name, P_Info, P_Price, "
                + "payment_details.O_Id, Date_Of_Booking, Date_Of_Delivery, "
                + "payment_details.Pay_Id, Pay_Status "
                + "from payment_details "
                + "inner join product_list on product_list.P_Id = payment_details.P_Id "
                + "inner join user_details on user_details.U_Email = payment_details.U_Email "
                + "inner join order_list on order_list.O_Id = payment_details.O_Id "
                + "order by payment_details.pay_id desc ";
        try {
            // Assign values to sql objects
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            ppestmt = con.prepareStatement(firstQuery);
            // Execute query and store data in rs
            rs = ppestmt.executeQuery();
            // Run while loop for check the data was exsist or not
            while (rs.next()) {
                // Store table data in local veriable
                boolean Pay_Status = rs.getBoolean("Pay_Status");
                int O_Id = rs.getInt("O_Id");
                int Pay_Id = rs.getInt("Pay_Id");
                int P_Price = rs.getInt("P_Price");
                String u_Email = rs.getString("U_Email");
                String U_Name = rs.getString("U_Name");
                String U_Contact = rs.getString("U_Contact");
                int House = rs.getInt("U_HouseNo");
                String U_Address = Integer.toString(House) + " "
                        + rs.getString("U_Street") + " <br>"
                        + rs.getString("U_City") + " "
                        + rs.getString("U_State") + " "
                        + rs.getString("U_Pincode");
                String P_Id = rs.getString("P_Id");
                String P_Info = rs.getString("P_Info");
                String P_Name = rs.getString("P_Name");
                String DOB = rs.getString("Date_Of_Booking");
                String DOD = rs.getString("Date_Of_Delivery");
                // Create Order class object and store local data on it
                Order o = new Order(O_Id, Pay_Id, P_Price, u_Email, P_Id, DOB, DOD, U_Address, U_Name, U_Contact, P_Name, P_Info, Pay_Status);
                // Add on list type object
                orders.add(o);
            }
        } catch (Exception e) {
        }
        // Return all data
        return orders;
    }

    // Get the details of delivery for user method
    public List<Order> getOrdersDetailsForClientSecond(String U_Email) {
        // Create list type order object
        List<Order> orders = new ArrayList<>();
        // Create query that fetch the data
        String secondQuery = "select "
                + "D_Id, D_Status "
                + "from delivery_details "
                + "inner join order_list on order_list.O_Id = delivery_details.O_Id "
                + "where delivery_details.U_Email = ? "
                + "order by d_id desc";
        try {
            // Assign values to sql objects
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            ppestmt = con.prepareStatement(secondQuery);
            // Set query values
            ppestmt.setString(1, U_Email);
            // Execute query and store data in rs
            rs = ppestmt.executeQuery();
            // Run while loop for check the data was exsist or not
            while (rs.next()) {
                // Store table data in local veriable
                int D_Id = rs.getInt("D_Id");
                boolean D_Status = rs.getBoolean("D_Status");
                // Create Order class object and store local data on it
                Order order = new Order();
                order.setD_Id(D_Id);
                order.setD_Status(D_Status);
                // Add on list type object
                orders.add(order);
                System.out.println(D_Id + "\n" + D_Status);
            }
        } catch (Exception e) {
        }
        // Return all data
        return orders;
    }

    // Get the details of delivery for admin method
    public List<Order> getOrdersDetailsForAdminSecond() {
        // Create list type order object
        List<Order> orders = new ArrayList<>();
        // Create query that fetch the data
        String secondQuery = "select "
                + "D_Id, D_Status "
                + "from delivery_details "
                + "inner join order_list on order_list.O_Id = delivery_details.O_Id "
                + "order by d_id desc";
        try {
            // Assign values to sql objects
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            ppestmt = con.prepareStatement(secondQuery);
            // Execute query and store data in rs
            rs = ppestmt.executeQuery();
            // Run while loop for check the data was exsist or not
            while (rs.next()) {
                // Store table data in local veriable
                int D_Id = rs.getInt("D_Id");
                boolean D_Status = rs.getBoolean("D_Status");
                // Create Order class object and store local data on it
                Order order = new Order();
                order.setD_Id(D_Id);
                order.setD_Status(D_Status);
                // Add on list type object
                orders.add(order);
            }
        } catch (Exception e) {
        }
        // Return all data
        return orders;
    }

    // Delete order method
    int deteleOrder(String O_Id) {
        // Covert id into int
        int id = Integer.parseInt(O_Id);
        // Query for detele order
        String query = "delete from order_list where o_id = ?";
        try {
            // Assign sql objects values
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            ppestmt = con.prepareStatement(query);
            // Set query values
            ppestmt.setInt(1, id);
            // Execute update and store data
            int i = ppestmt.executeUpdate();
            // Return if success
            return i;
        } catch (Exception e) {
        }
        // Return if fails
        return 0;
    }

    // Update payment method
    int updatePaymentStatus(String Pay_Id) {
        // Covert id into int
        int pay_id = Integer.parseInt(Pay_Id);
        // Query for update payment status
        String query = "update payment_details set Pay_Status = true where pay_id = ? ";
        try {
            // Assign sql objects values
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            ppestmt = con.prepareStatement(query);
            // Set query values
            ppestmt.setInt(1, pay_id);
            // Execute update and store data
            int i = ppestmt.executeUpdate();
            // Return if success
            return i;
        } catch (Exception e) {
        }
        // Return if fails
        return 0;
    }

    // Update delivery status method
    int updateDeliveryStatus(String D_Id) {
        // Covert id into int
        int d_id = Integer.parseInt(D_Id);
        // Query for update delivery status
        String query = "update delivery_details set D_Status = true where d_id = ?";
        try {
            // Assign sql objects values
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            ppestmt = con.prepareStatement(query);
            // Set query values
            ppestmt.setInt(1, d_id);
            // Execute update and store data
            int i = ppestmt.executeUpdate();
            // Return if success
            return i;
        } catch (Exception e) {
        }
        // Return if fails
        return 0;
    }
}