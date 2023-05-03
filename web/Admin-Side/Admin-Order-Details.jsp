<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - Order</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body>
        <%@include file="/Common-File/admin-header.jsp" %>
        <% if (ordersDetails.size() == 0) { %>
        <div class="container text-center my-2">
            <h1>User cannot place any order now!!</h1>
        </div>
        <% } else { %>
        <!--Information section-->
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead class="table-dark fs-5">
                    <tr>
                        <th style="min-width: 80px">S No.</th>
                        <th>Product Name</th>
                        <th>User Info</th>
                        <th>Address</th>
                        <th>Booking Date</th>
                        <th>Delivery Date</th>
                        <th>Payment Status</th>
                        <th>Delivery Status</th>
                    </tr>
                </thead>
                <tbody class="table-success fs-6">

                    <%int sno = 1;
                        for (int i = 0; i < ordersDetails.size() && i < ordersDeliveryDetails.size(); i++) {
                            Order order = ordersDetails.get(i);
                            Order orderDelivery = ordersDeliveryDetails.get(i);
                    %>  
                    <tr>
                        <td><%= sno++%></td>
                        <td><%= order.getP_Name()%> </td>
                        <td><%= order.getU_Name()%> <br> <%= order.getU_Email()%> <br> <%= order.getU_Contact()%> </td>
                        <td><%= order.getU_Address()%></td>
                        <td><%= order.getDOB()%></td>
                        <td><%= order.getDOD()%></td>
                        <td><%= order.isPay_Status()%></td>
                        <td><%= orderDelivery.isD_Status()%></td>
                        <%}%>
                </tbody>
            </table>
        </div>
        <% }%>
    </body>
</html>