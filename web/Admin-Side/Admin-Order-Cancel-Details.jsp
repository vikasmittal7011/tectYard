<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - Cancel Details</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body>
        <%@include file="/Common-File/admin-header.jsp" %>

        <%if (cancelOrders.size() == 0) {  %>
        <div class="container text-center my-2">
            <h1>User cannot cancel any product now!!</h1>
        </div>
        <%} else {%>

        <div class="table-responsive">
            <form action="../OrderAndCartServlet" method="post">
                <table class="table table-striped table-hover">
                    <thead class="table-dark fs-5">
                        <tr>
                            <th style="min-width: 80px">S No.</th>
                            <th>Product Name</th>
                            <th>Cancel Date</th>
                            <th>Cancel Details</th>
                        </tr>
                    </thead>
                    <tbody class="table-success fs-6">

                        <%int sno = 1;
                            for (CancelOrder can : cancelOrders) {
                        %>  
                        <tr>
                            <td><%= sno++%></td>
                            <td><%= can.getP_Name()%></td>
                            <td><%= can.getC_Date_Of_Cancel()%></td>
                            <td><%= can.getC_Reason()%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </form>
        </div>
        <%}%>
    </body>
</html>