package com.techyard.orderAndcart;

import java.sql.*;
import java.util.*;

public class CartDBUtil {
    // SQL parameter
    private final String URL = "jdbc:mysql://localhost:3306/tech_yard";
    private final String userName = "root";
    private final String passWord = "Sonu@9876";
    private final String driver = "com.mysql.jdbc.Driver";
    
    public CartDBUtil() { }

    // Add Product in cart
    int addProductToCart(Cart cart) {
        // Query for insert data
        String query = "insert into cart_list (u_email, p_id) values(?,?)";
        // Sql objects
        Connection con = null;
        PreparedStatement stmt = null;
        // Check already prodcut has exist or not
        int checkValue = checkCartProductAvailable(cart);
        // Check value return value run if they return 0
        if(checkValue == 0){
            // Return if already exists
            return 0;
        }
        try{
            // Assign values of sql objects
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Set query values
            stmt.setString(1, cart.getU_Email());
            stmt.setString(2, cart.getP_Id());
            // Execute query
            int i = stmt.executeUpdate();
            // Return if success
            return i;
        }catch(Exception e){
            System.out.println(e);
        }
        // Return if fails
        return 0;
    }

    // Check product existance
    private int checkCartProductAvailable(Cart cart) {
        // Query for fetch data
        String query = "select * from cart_list";
        // Sql objects
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            // Assign values of sql objects
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            // Run while loop 
            while(rs.next()){
                // Store data in local variable
                String email = rs.getString("U_Email");
                String id = rs.getString("P_Id");
                // Check user that want to add product in cart they are exist or not
                if(email.equals(cart.getU_Email()) && id.equals(cart.getP_Id())){
                    // Return if they are exist
                    return 0;
                }
            }
        }catch(Exception e){
        }
        // Return if they are not exists
        return 505;
    }
    
    // Get all cart product list
     public List<Cart> getCartProducts(String U_Email){
         // Create list type cart class object
        List<Cart> carts = new ArrayList<>();
        // Query for fetch data
        String query = "select c_id, u_email, cart_list.p_id, p_name, p_image, p_info, p_price from " + 
                " cart_list inner join product_list on product_list.p_id = cart_list.p_id " + 
                " where u_email = ? ";
        // Sql objects
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            // Assign values of sql objects
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Set query value
            stmt.setString(1, U_Email);
            // Execute query
            rs = stmt.executeQuery();
            // Run while loop
            while(rs.next()){
                // Store data in local variable
                int C_Id = rs.getInt("C_Id");
                int P_Price = rs.getInt("P_Price");
                String P_Id = rs.getString("P_Id");
                String P_Name = rs.getString("P_Name");
                String P_Image = rs.getString("P_Image");
                String P_Info = rs.getString("P_Info");
                // Store data in cart class object
               Cart cart = new Cart(C_Id, P_Price, P_Id, P_Name, P_Image, P_Info);
               // Add cart object in list type cart object
               carts.add(cart);
            }
        }catch(Exception e){}
        // Return 
        return carts;
    }

     // Remove item from cart
    int removeItem(int C_Id) {
        // Query for remove item
        String query = "delete from cart_list where c_id = ?";
        // Sql objects
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            // Assign values of sql objects
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Set query value
            stmt.setInt(1, C_Id);
            // Execute query and store resslt
            int i = stmt.executeUpdate();
            // Return if done
            return i;
        }catch(Exception e){}
        // Return if error 
        return 0;
    }
}