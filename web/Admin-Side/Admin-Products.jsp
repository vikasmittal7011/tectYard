<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - Products</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body style="background-color: #f3f3f3;">
        <%@include file="/Common-File/admin-header.jsp" %>
        <%@include file="/Common-File/message.jsp" %>
        <!--Information section-->
        <div class="row row-cols-1 row-cols-md-3 g-4 mx-2 my-1">
            <%for (Product p : products) {%>
            <form action="../ProductServlet" method="post" onsubmit="if (!(confirm('Are you sure to do this action!!')))
                        return false">
                <input hidden name="P_Id" value="<%= p.getP_Id()%>">
                <input hidden name="P_ImageName" value="<%= p.getP_Image()%>">
                <div class="col">
                    <div class="card h-100">
                        <img src="../Product-Image/<%= p.getP_Image()%>" class="card-img-top p-4" alt="<%= p.getP_Image()%>" style="max-height: 320px">
                        <div class="card-body">
                            <h5 class="card-title"><%= p.getP_Name()%></h5>
                            <p class="card-text"><%= p.getP_Info()%></p>
                            <h4 class="card-title"> ₹ <%= p.getP_Price()%></h4>
                        </div>
                        <div class="card-footer d-flex justify-content-evenly">
                            <input type="submit"
                                   class="btn btn-lg btn-outline-danger rounded-pill mx-1  py-1 px-2 fs-4"
                                   name="Commond" value="Remove">
                            <input type="submit"
                                   class="btn btn-lg btn-outline-primary rounded-pill mx-1  py-1 px-2 fs-4"
                                   name="Commond"  value="Update">
                        </div>
                    </div>
                </div>
            </form>
            <%}%>
        </div>
    </body>
</html>