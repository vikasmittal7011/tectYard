<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - User Details</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body class="custome-bg-light">
        <%@include file="/Common-File/admin-header.jsp" %>
        <!--Information section-->
        <div class="container text-center">
            <img src="../Pre-Use_Image/profile.png" alt="" class="mt-2" width="250">
            <h1>Total count of user is <%= theUserDetails.size()%></h1>
        </div>        
        <%if (theUserDetails.size() == 0) {  %>
        <div class="container text-center my-2">
            <h1>User cannot place any order now !!</h1>
        </div>
        <%} else {%>
        <div class="table-responsive mt-4">
            <table class="table table-striped table-hover">
                <thead class="table-dark fs-5">
                    <tr>
                        <th style="min-width: 80px">S No.</th>
                        <th style="min-width: 180px" >U_Name</th>
                        <th>U_Age</th>
                        <th>U_Email</th>
                        <th>U_Contact</th>
                        <th style="min-width: 120px">U_City</th>
                        <th style="min-width: 120px">U_State</th>
                    </tr>
                </thead>
                <tbody class="table-success fs-6">
                    <%
                        int i = 1;
                        for (User u : theUserDetails) {
                    %>
                    <tr style="font-size: 1.1rem;" >
                        <td><%=i++%></td>
                        <td><%= u.getU_Name()%></td>
                        <td><%= u.getU_Age()%></td>
                        <td><%= u.getU_Email()%></td>
                        <td><%= u.getU_Contact()%></td>
                        <% if (u.getU_City().equals("")) { %>
                        <td>--</td>
                        <%} else {%>
                        <td><%= u.getU_City()%></td>
                        <%}%>
                        <% if (u.getU_State().equals("")) { %>
                        <td>--</td>
                        <%} else {%>
                        <td><%= u.getU_State()%></td>
                        <%}%>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <%}%>

    </body>
</html>