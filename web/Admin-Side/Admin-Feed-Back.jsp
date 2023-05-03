<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - Feed Back</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body>
        <%@include file="/Common-File/admin-header.jsp" %>
        <%@include file="/Common-File/message.jsp" %>
        <!--Image section-->
        <div class="container text-center">
            <img src="../Pre-Use_Image/admin-feed-back.png" alt="" class="mt-2" width="250">
            <h1>Total count is <%= theFeedbacks.size()%></h1>
        </div>        
        <%if (theFeedbacks.size() == 0) {  %>
        <div class="container text-center my-2">
            <h1>User cannot place any order now !!</h1>
        </div>
        <%} else {%>
        <!--Information section-->
        <div class="table-responsive mt-4">
            <form action="../FeedBackServlet" method="post" onsubmit="if (!(confirm('Are you sure to delete this feed back form database!!')))
                        return false">
                <table class="table table-striped table-hover">
                    <thead class="table-dark fs-5">
                        <tr>
                            <th style="min-width: 80px">S No.</th>
                            <th style="min-width: 180px" >U_Name</th>
                            <th>U_Age</th>
                            <th>U_Email</th>
                            <th>U_Contact</th>
                            <th style="min-width: 120px">F_Comment</th>
                            <th style="min-width: 120px">Action</th>
                        </tr>
                    </thead>
                    <tbody class="table-success fs-5">
                        <% int i = 1;
                            for (FeedBack fb : theFeedbacks) {
                        %>
                        <tr>
                    <input hidden name="Commond" value="DELETE">
                    <input hidden name="Id" value="<%= fb.getId()%>">
                    <td><%= i++%></td>
                    <td><%= fb.getName()%></td>
                    <td><%= fb.getAge()%></td>
                    <td><%= fb.getEmail()%></td>
                    <td><%= fb.getContact()%></td>
                    <td><%= fb.getComment()%></td>
                    <!--<td><a href="../FeedBackServlet" class="link">Delete</a></td>-->
                    <td><input class="btn btn-warning" type="submit" value="Delete"></td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </form>
        </div>
        <%}%>
    </body>
</html>