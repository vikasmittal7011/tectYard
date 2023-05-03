package com.techyard.product;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@MultipartConfig
@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get command
        String comond = request.getParameter("Commond");
        // Check what is command
        switch (comond) {
            case "UPLOAD":
                addProduct(request, response);
                break;
            case "UPDATE":
                updateProductDetails(request, response);
                break;
            case "Update":
                loadProduct(request, response);
                break;
            case "Remove":
                removeProduct(request, response);
                break;
        }
    }

    // Add product method
    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Getting data from form
        String name = request.getParameter("P_Name");
        String id = request.getParameter("P_IdF") + request.getParameter("P_IdL");
        String price = request.getParameter("P_Price");
        String info = request.getParameter("P_Info");
        int prices = Integer.parseInt(price);
        // Get image from form
        Part image = request.getPart("P_Img");
        String imageName = image.getSubmittedFileName();
        // Get the path of folder
        String path = request.getRealPath("Product-Image") + File.separator + imageName;
        // Making object of product class and set data on it
        Product theProduct = new Product(name, id, imageName, info, prices);
        // Making utility class object
        ProductDBUtil theProductDBUtil = new ProductDBUtil();
        // Run the method for insert data
        int result = theProductDBUtil.insertProduct(theProduct, path, image);
        // Session object
        HttpSession httpSession = request.getSession();
        if (result > 0) {
            // Run if data was insert
            httpSession.setAttribute("message", "Product was successfully added !!!");
            response.sendRedirect("Admin-Side/Add-Products.jsp");
        } else {
            // Run if data was not insert
            httpSession.setAttribute("message", "Product was not added !!!");
            response.sendRedirect("Admin-Side/Add-Products.jsp");
        }
    }

    // Load a single product method
    private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get tha id of product
        String id = request.getParameter("P_Id");
        // Create a product utility class object
        ProductDBUtil productDBUtil = new ProductDBUtil();
        // Create product class object and run a method of utility class method
        Product product = productDBUtil.loadProduct(id);
        // Create session object
        HttpSession httpSession = request.getSession();
        if (product != null) {
            // Run if data was update successfully 
            httpSession.setAttribute("single-product", product);
            response.sendRedirect("Admin-Side/Update-Product.jsp");
        } else {
            // Run if fails
            httpSession.setAttribute("message", "Something is wrong to load product details!!");
            response.sendRedirect("Admin-Side/Admin-Products.jsp");
        }
    }

    // Delete product method
    private void removeProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get data
        String imageName = request.getParameter("P_ImageName");
        String id = request.getParameter("P_Id");
        // Get the path of image
        String path = request.getRealPath("Product-Image") + File.separator + imageName;
        // Make a file type object
        File file = new File(path);
        // Create session object
        HttpSession httpSession = request.getSession();
        // Run if imgae was exsist
        if (file.exists()) {
            // Delete file from folder
            file.delete();
            // Utility class object
            ProductDBUtil productDBUtil = new ProductDBUtil();
            // Run delete product method from utilty class and store result
            int result = productDBUtil.deleteProduct(id);
            // Run if delete
            if (result > 0) {
                httpSession.setAttribute("message", "Product is deleted!!");
                response.sendRedirect("Admin-Side/Admin-Products.jsp");
            }
            // Run if any problem is ocurre
        } else {
            httpSession.setAttribute("message", "Product is fail to delete!!");
            response.sendRedirect("Admin-Side/Admin-Products.jsp");
        }
    }

    // Update product information method
    private void updateProductDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get data from form 
        String name = request.getParameter("P_Name");
        String id = request.getParameter("P_Id");
        String info = request.getParameter("P_Info");
        int price = Integer.parseInt(request.getParameter("P_Price"));
        // Create product class object and set usefull feilds
        Product product = new Product();
        product.setP_Name(name);
        product.setP_Info(info);
        product.setP_Price(price);
        product.setP_Id(id);
        // Create product utility class object
        ProductDBUtil productDBUtil = new ProductDBUtil();
        // Run method of update deatils in utility class and store there result 0
        int result = productDBUtil.updateProduct(product);
        // Create session object
        HttpSession httpSession = request.getSession();
        if (result > 0) {
            // Run if data was update successfully 
            httpSession.setAttribute("message", "Product details update successfully");
            response.sendRedirect("Admin-Side/Admin-Products.jsp");
        } else {
            // Run if fails
            httpSession.setAttribute("message", "Product details update Fail");
            response.sendRedirect("Admin-Side/Admin-Products.jsp");
        }
    }
}