<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client - Orders</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body>
        <%@include file="/Common-File/client-header.jsp" %>
        <%@include file="/Common-File/message.jsp" %>
        <!--Information section-->
        <% if (ordersDetails.size() == 0) { %>
        <div class="container">
            <div class="container text-center my-2">
                <h1>You don't have any order</h1>
                <h2>Do you want to <a href="Client-Product.jsp">Order products !!!</a></h2>
            </div>
            <% } else {%>

            <div class="table-responsive">
                <form action="../OrderAndCartServlet" method="post" onsubmit="if (!(confirm('Are you sure to do that action!!')))
                    return false">
                    <table class="table table-striped table-hover">
                        <thead class="table-dark fs-5">
                            <tr>
                                <th style="min-width: 80px">S No.</th>
                                <th>Product Info</th>
                                <th>Address</th>
                                <th>Booking Date</th>
                                <th>Delivery Date</th>
                                <th>Payment Status</th>
                                <th>Delivery Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody class="table-success fs-6">

                            <%int sno = 1;
                                for (int i = 0; i < ordersDetails.size() && i < ordersDeliveryDetails.size(); i++) {
                                    Order order = ordersDetails.get(i);
                                    Order orderDelivery = ordersDeliveryDetails.get(i);
                              %>  
                        <input hidden name="O_Id" value="<%= order.getO_Id()%>">
                        <input hidden name="P_Id" value="<%= order.getP_Id()%>">
                        <tr>
                            <td><%= sno++%></td>
                            <td><%= order.getP_Name()%> <br>
                                <%= order.getP_Info().substring(0, 60)%> <br>
                                <strong>₹ <%= order.getP_Price()%></strong> </td>
                            <td><%= order.getU_Address()%></td>
                            <td><%= order.getDOB()%></td>
                            <td><%= order.getDOD()%></td>
                            <td><%= order.isPay_Status()%></td>
                            <td><%= orderDelivery.isD_Status()%></td>
                            <%if (orderDelivery.isD_Status() == false || order.isPay_Status() == false) {%>
                            <td><input class="btn btn-transparent text-primary text-decoration-underline"  type="submit" name="Commond" value="Cancel"></td>
                                <%} else {%>
                            <td><input class="btn btn-transparent text-primary text-decoration-underline" type="submit" name="Commond" value="Delete" ></td>
                                <%}%>
                        </tr>
                        <%}%>
                        </tbody>
                    </table>
                </form>
            </div>
            <%@include file="../Common-File/footer.jsp" %>
            <% }%>
    </body>
</html>