package com.techyard.product;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.http.Part;

public class ProductDBUtil {

    // SQL parameter
    private final String URL = "jdbc:mysql://localhost:3306/tech_yard";
    private final String userName = "root";
    private final String passWord = "Sonu@9876";
    private final String driver = "com.mysql.jdbc.Driver";

    // Add a new product method
    int insertProduct(Product theProduct, String path, Part image) {
        // Query
        String query = "insert into product_list values(?,?,?,?,?)";
        // Sql objects
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            // Assign sql object values
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Set values to query
            stmt.setString(1, theProduct.getP_Name());
            stmt.setString(2, theProduct.getP_Id());
            stmt.setInt(3, theProduct.getP_Price());
            stmt.setString(4, theProduct.getP_Image());
            stmt.setString(5, theProduct.getP_Info());
            // Execute update to store data
            int i = stmt.executeUpdate();
            // Out file object and pass it the object of path of folder
            FileOutputStream fos = new FileOutputStream(path);
            // Input file object and give tha image to it
            InputStream is = image.getInputStream();
            // Convert image into byts 
            byte[] data = new byte[is.available()];
            // Read data
            is.read(data);
            // Store data in folder
            fos.write(data);
            // Return if data was successfully insert
            return i;
        } catch (Exception ex) {
        }
        // Return if not insert data
        return 0;
    }

    // Get tha all product details
    public List<Product> getProducts() {
        // List type object of product class
        List<Product> therProducts = new ArrayList<>();
        // Query for fetch data
        String query = "select * from product_list";
        // Sql objects
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Assign values of sql objects
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            // Run while loop for getting data form db
            while (rs.next()) {
                // Getting data
                String name = rs.getString("P_Name");
                String id = rs.getString("P_Id");
                int price = rs.getInt("P_Price");
                String image = rs.getString("P_Image");
                String info = rs.getString("P_Info");
                // Create a set value of prodoct class object
                Product product = new Product(name, id, image, info, price);
                // Add data into list object
                therProducts.add(product);
            }
        } catch (Exception e) {
        }
        // Return list object with data
        return therProducts;
    }

    // Load a single product method
    public Product loadProduct(String id) {
        // Product class object and set it to null
        Product product = null;
        // Query
        String query = "select * from product_list where p_id = ?";
        // Sql object and set it to null
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Set sql object values
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            // Run while loop if data was exist in db
            while (rs.next()) {
                // Store data in local veriable 
                String name = rs.getString("P_Name");
                String info = rs.getString("P_Info");
                String imageName = rs.getString("P_Image");
                String Id = rs.getString("P_Id");
                int price = rs.getInt("P_Price");
                // Set local data in product object
                product = new Product(name, Id, imageName, info, price);
                // Return if all think working fine
                return product;
            }
        } catch (Exception e) {
        }
        // Run if somthings is wrong
        return product;
    }

    // Update product information method
    int updateProduct(Product product) {
        // Query
        String query = "update product_list set p_name = ?, p_price = ?, p_info = ? where p_id = ?";
        // Sql objects
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            // Assign sql object values
            Class.forName(driver);
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Set values to query
            stmt.setString(1, product.getP_Name());
            stmt.setInt(2, product.getP_Price());
            stmt.setString(3, product.getP_Info());
            stmt.setString(4, product.getP_Id());
            // Execute update to store data
            int i = stmt.executeUpdate();
            // Return if data was successfully insert
            return i;
        } catch (Exception e) {
        }
        // Return if not insert data
        return 0;
    }

    // Delete product method
    int deleteProduct(String id) {
        // Query 
        String query = "delete from product_list where p_id = ?";
        // Sql objects
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            // Assign values 
            con = DriverManager.getConnection(URL, userName, passWord);
            stmt = con.prepareStatement(query);
            // Set value to query data
            stmt.setString(1, id);
            // Execute command
            int i = stmt.executeUpdate();
            // Return if success;
            return i;
        } catch (Exception e) {
        }
        // Return if not success
        return 0;
    }
}