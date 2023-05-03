<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - Payment</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body>
        <%@include file="/Common-File/admin-header.jsp" %>
        <%@include file="/Common-File/message.jsp" %>
        <%if (ordersDetails.size() == 0) {  %>
        <div class="container text-center my-2">
            <h1>User cannot place any order now !!</h1>
        </div>
        <%} else {%>
        <!--Information section-->
        <div class="table-responsive">
            <form action="../OrderAndCartServlet" method="post">
                <table class="table table-striped table-hover">
                    <thead class="table-dark fs-5">
                        <tr>
                            <th style="min-width: 80px">S No.</th>
                            <th>Product Name</th>
                            <th>User Info</th>
                            <th>Address</th>
                            <th>Delivery Date</th>
                            <th>Payment Status</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody class="table-success fs-6">

                        <%int sno = 1;
                            for (int i = 0; i < ordersDetails.size() && i < ordersDeliveryDetails.size(); i++) {
                                Order order = ordersDetails.get(i);
                        %>  
                    <input hidden name="Commond" value="UPDATE-PAYMENT-DETAILS">
                    <input hidden name="Pay_Id" value="<%= order.getPay_Id()%>">
                    <tr>
                        <td><%= sno++%></td>
                        <td><%= order.getP_Name()%> </td>
                        <td><%= order.getU_Name()%> <br> <%= order.getU_Email()%> </td>
                        <td><%= order.getU_Address()%></td>
                        <td><%= order.getDOD()%></td>
                        <td><%= order.isPay_Status()%></td>
                        <% if (order.isPay_Status() == false) { %>
                        <td><input class="btn btn-transparent text-primary text-decoration-underline" type="submit" value="Update" ></td>
                            <% } else { %>
                        <td>DONE</td>
                        <% } %>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </form>
        </div>
        <%}%>
    </body>
</html>