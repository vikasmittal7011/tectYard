<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - Profile</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body class="custome-bg-light">
        <%@include file="/Common-File/admin-header.jsp" %>
        <!--Image section-->
        <div class="container text-center d-lg-flex d-sm-block justify-content-evenly my-4">
            <img src="../Pre-Use_Image/admin-profile.png" alt="" height="200">
            <h1 class="text-center my-5 py-3 ">Update Details</h1>
        </div>
        <%@include file="/Common-File/message.jsp" %>
        <!--Form for updation-->
        <form action="../AdminServlet" onsubmit="" method="post">
            <input value="UPDATE-DETAILS" name="Commond" hidden>
            <input value="<%= theAdminDetails.getA_Email()%>" hidden name="A_Email">
            <input value="<%= theAdminDetails.getA_Passeword()%>" hidden name="A_Password">
            <div>
                <div class="container fs-3">
                    <div class="row">
                        <div class="mb-3 col-md-6 col-sm-12">
                            <label class="mt-1">Your name: </label>
                            <input type="text" class="form-control mt-2 fs-5" name="A_Name" id="A_Name" placeholder="Name..." value="<%= theAdminDetails.getA_Name()%>" required>

                            <label class="mt-1">Your contact: </label>
                            <input type="text" class="form-control mt-2 fs-5" name="A_Contact" id="A_Contact" placeholder="Contact..." value="<%= theAdminDetails.getA_Contact()%>" required>

                        </div>
                        <div class="mb-3 col-md-6 col-sm-12">
                            <label class="mt-1">Your email: </label>
                            <input type="text" class="form-control mt-2 fs-5" name="A_Email" id="A_Email" value="<%= theAdminDetails.getA_Email()%>" required disabled>

                            <div class="container text-center m-3 mt-5">
                                <input type="submit"
                                       class="btn btn-lg btn-success rounded-pill mx-5 my-2 py-2 px-4 fs-3"
                                       value="Update">
                                <input type="reset"
                                       class="btn btn-lg btn-outline-warning rounded-pill mx-5 my-2 py-2 px-4 fs-3"
                                       value="Reset">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!--Information section-->
        <div class="container text-center"><h1>Other admin details</h1></div>
        <div class="table-responsive mt-4">
            <table class="table table-striped table-hover">
                <thead class="table-dark fs-5">
                    <tr>
                        <th style="min-width: 80px">S No.</th>
                        <th style="min-width: 180px" >A_Name</th>
                        <th>A_Email</th>
                        <th>A_Contact</th>
                    </tr>
                </thead>
                <tbody class="table-success fs-6">
                    <%
                        int i = 1;
                        for (Admin a : adminsDetails) {
                    %>
                    <tr>
                        <td><%= i++%></td>
                        <td><%= a.getA_Name()%></td>
                        <td><%= a.getA_Email()%></td>
                        <td><%= a.getA_Contact()%></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>