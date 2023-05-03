package com.techyard.orderAndcart;

import com.techyard.product.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "OrderAndCartServlet", urlPatterns = {"/OrderAndCartServlet"})
public class OrderAndCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the action 
        String action = request.getParameter("Commond");
        // Check the action status
        switch (action) {
            case "ORDER":
                confirmOrder(request, response);
                break;
            case "Add Cart":
                addToCart(request, response);
                break;
            case "Remove":
                removeItemFromCart(request, response);
                break;
            case "Purchase":
                orderItem(request, response);
                break;
            case "Cancel":
                loadCancelPage(request, response);
                break;
            case "CANCEL-ORDER":
                cancelOrder(request, response);
                break;
            case "Delete":
                deleteOrderDetails(request, response);
                break;
            case "DELETE-CANCEL-DETAILS":
                deleteCancelOrderDetails(request, response);
                break;
            case "UPDATE-PAYMENT-DETAILS":
                updatePaymetDetails(request, response);
                break;
            case "UPDATE-DELIVERY-DETAILS":
                updateDeliveryDetails(request, response);
                break;
        }
    }

    // Add product in cart method
    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get data from form
        String P_Id = request.getParameter("P_Id");
        String U_Email = request.getParameter("U_Email");
        // Create cart class object
        Cart cart = new Cart();
        // Set data in cart variable
        cart.setP_Id(P_Id);
        cart.setU_Email(U_Email);
        // Create cart utility object
        CartDBUtil cartDBUtil = new CartDBUtil();
        // Run a method that add product from utility class and store result
        int result = cartDBUtil.addProductToCart(cart);
        // Create session object
        HttpSession httpSession = request.getSession();
        if (result > 0) {
            // Run if data was insert
            httpSession.setAttribute("message", "Item is add successfully !! ");
            response.sendRedirect("Client-Side/Client-Product.jsp");
        } else {
            // Run if data was not insert            
            httpSession.setAttribute("message", "This item is already in your cart !!");
            response.sendRedirect("Client-Side/Client-Product.jsp");
        }
    }

    // Load confirm order method
    private void orderItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get id of product that you want
        String id = request.getParameter("P_Id");
        // Create product utility class object
        ProductDBUtil productDBUtil = new ProductDBUtil();
        // Create product class object and loat product method
        Product products = productDBUtil.loadProduct(id);
        // Create session object
        HttpSession httpSession = request.getSession();
        // Set attribute of product details
        httpSession.setAttribute("single-product", products);
        // Send the data in confirm order page
        response.sendRedirect("Client-Side/Confirm-Order.jsp");
    }

    // Delete item from cart method
    private void removeItemFromCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get data from form
        String id = request.getParameter("C_Id");
        int C_Id = Integer.parseInt(id);
        // Create cart utility object
        CartDBUtil cartDBUtil = new CartDBUtil();
        // Run a method that remove product from utility class and store result
        int result = cartDBUtil.removeItem(C_Id);
        // Create session object
        HttpSession hs = request.getSession();
        if (result > 0) {
            // Run if data was delete
            hs.setAttribute("message", "Product is remove successfully form cart details!!");
            response.sendRedirect("Client-Side/Client-Cart-Details.jsp");
        } else {
            // Run if data was not delete    
            hs.setAttribute("message", "Product remove Fails, somthing is worng!!");
            response.sendRedirect("Client-Side/Client-Cart-Details.jsp");
        }
    }

    // Book order method
    private void confirmOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Create date object and get current date
        LocalDateTime currentDateTIme = LocalDateTime.now();
        // Formate date and time that we want
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy hh:mm:ss");
        // Formate date that we want
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // Create another object and get after three days date
        LocalDateTime afterThreeDays = currentDateTIme.plus(3, ChronoUnit.DAYS);
        // Getting data form confirm page
        String DOB = currentDateTIme.format(dateTimeFormatter);
        String DOD = afterThreeDays.format(dateFormatter);
        String P_Id = request.getParameter("P_Id");
        String U_Email = request.getParameter("U_Email");
        // Create order class object and set some data
        Order order = new Order();
        order.setDOB(DOB);
        order.setDOD(DOD);
        order.setU_Email(U_Email);
        order.setP_Id(P_Id);
        // Create order utility class object
        OrderDBUtil orderDBUtil = new OrderDBUtil();
        // Run method that insert data into order list table
        int O_Id = orderDBUtil.orderProduct(order);
        // Create session object
        HttpSession httpSession = request.getSession();
        if (O_Id > 0) {
            // Run method that insert data into payment details table
            int resultOfPayment = orderDBUtil.addPaymentDetails(order, O_Id);
            if (resultOfPayment > 0) {
                // Run method that insert data into delivery details table
                int resultOfDelivery = orderDBUtil.addDeliveryDetails(order, O_Id);
                if (resultOfDelivery > 0) {
                    // Run if all method work fine
                    httpSession.setAttribute("message", "Product is booked successfully, go and check it on order scetion !!");
                    response.sendRedirect("Client-Side/Client-Product.jsp");
                } else {
                    // Run all else call if any if condition is fails
                    httpSession.setAttribute("message", "Product booking fails !!");
                    response.sendRedirect("Client-Side/Client-Product.jsp");
                }
            } else {
                httpSession.setAttribute("message", "Product booking fails !!");
                response.sendRedirect("Client-Side/Client-Product.jsp");
            }
        } else {
            httpSession.setAttribute("message", "Product booking fails !!");
            response.sendRedirect("Client-Side/Client-Product.jsp");
        }
    }

    // Load page of cancal order method
    private void loadCancelPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get some data that was needed
        String O_Id = request.getParameter("O_Id");
        String P_Id = request.getParameter("P_Id");
        // Session object
        HttpSession httpSession = request.getSession();
        // Set some attribute 
        httpSession.setAttribute("O_Id", O_Id);
        httpSession.setAttribute("P_Id", P_Id);
        // Send user to cancel page
        response.sendRedirect("Client-Side/Confirm-Cancel.jsp");
    }

    // Cancel order method
    private void cancelOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Create date object and get current date
        LocalDateTime currentDateTIme = LocalDateTime.now();
        // Formate date that we want
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // Getting data form confirm page
        String DOC = currentDateTIme.format(dateFormatter);
        String O_Id = request.getParameter("O_Id");
        String P_Id = request.getParameter("P_Id");
        String U_Email = request.getParameter("U_Email");
        String C_Reason = request.getParameter("C_Reason");
        // Create cancelorder class object and set data on it
        CancelOrder cancelOrder = new CancelOrder(U_Email, P_Id, C_Reason, DOC);
        // Create cancelorderutility class object
        CancelOrderDBUtil cancelOrderDBUtil = new CancelOrderDBUtil();
        // Run method that delete order from order_list
        int resultOfDelete = cancelOrderDBUtil.deleteOrder(O_Id);
        // Session object
        HttpSession httpSession = request.getSession();
        // If deletion was success
        if (resultOfDelete > 0) {
            // Run method that insert data data in cancel order details
            int result = cancelOrderDBUtil.insertCancelDetails(cancelOrder);
            if (result > 0) {
                // Run if data was insert success
                httpSession.setAttribute("message", "Order was successfully cancel, check the result in cancel order section !!");
                response.sendRedirect("Client-Side/Client-Order-Details.jsp");
            } else {
                // Fails
                httpSession.setAttribute("message", "Something is wrong !!");
                response.sendRedirect("Client-Side/Client-Order-Details.jsp");
            }
        } else {
            // Fails
            httpSession.setAttribute("message", "Something is wrong !!");
            response.sendRedirect("Client-Side/Client-Order-Details.jsp");
        }
    }

    // Delete order details method
    private void deleteOrderDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get data from form
        String O_Id = request.getParameter("O_Id");
        // Create order utility class object
        OrderDBUtil orderDBUtil = new OrderDBUtil();
        // Run delete order method and store data
        int result = orderDBUtil.deteleOrder(O_Id);
        // Create session object
        HttpSession httpSession = request.getSession();
        if (result > 0) {
            // Run if success
            httpSession.setAttribute("message", "Order details was successfully detele !!");
            response.sendRedirect("Client-Side/Client-Order-Details.jsp");
        } else {
            // If fails
            httpSession.setAttribute("message", "Order details deletion was fails !!");
            response.sendRedirect("Client-Side/Client-Order-Details.jsp");
        }
    }

    // Delete cancel order method
    private void deleteCancelOrderDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get data from form
        String C_Id = request.getParameter("C_Id");
        // Create cancel order utility class object
        CancelOrderDBUtil bUtil = new CancelOrderDBUtil();
        // Run delete cancel order method and store data
        int result = bUtil.deleteCancelDetails(C_Id);
        // Create session object
        HttpSession httpSession = request.getSession();
        if (result > 0) {
            // Run if success
            httpSession.setAttribute("message", "Details was successfully delete");
            response.sendRedirect("Client-Side/Client-Cancel-Details.jsp");
        } else {
            // If fails
            httpSession.setAttribute("message", "Details delete fails");
            response.sendRedirect("Client-Side/Client-Cancel-Details.jsp");
        }
    }

    // Update payment details method
    private void updatePaymetDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get data from form
        String Pay_Id = request.getParameter("Pay_Id");
        // Create order utility class object
        OrderDBUtil orderDBUtil = new OrderDBUtil();
        // Run update payment status method and store data
        int result = orderDBUtil.updatePaymentStatus(Pay_Id);
        // Create session object
        HttpSession httpSession = request.getSession();
        if (result > 0) {
            // Run if success
            httpSession.setAttribute("message", "Payment status was successfully updated !!");
            response.sendRedirect("Admin-Side/Admin-Payment.jsp");
        } else {
            // If fails
            httpSession.setAttribute("message", "Payment status was successfully updated !!");
            response.sendRedirect("Admin-Side/Admin-Payment.jsp");
        }
    }

    // Update delivery status method
    private void updateDeliveryDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get data from form
        String D_Id = request.getParameter("D_Id");
        // Create order utility class object
        OrderDBUtil orderDBUtil = new OrderDBUtil();
        // Run update delivery status method and store data
        int result = orderDBUtil.updateDeliveryStatus(D_Id);
        // Create session object
        HttpSession httpSession = request.getSession();
        if(result > 0){
            // Run if success
            httpSession.setAttribute("message", "Delivery status was update successfully !!");
            response.sendRedirect("Admin-Side/Product-Delivery.jsp");
        }else{
            // If fails
            httpSession.setAttribute("message", "Delivery status update fails !!");
            response.sendRedirect("Admin-Side/Product-Delivery.jsp");
        }
        
    }
}