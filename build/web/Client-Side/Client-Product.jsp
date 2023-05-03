<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client - Product</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body style="background-color: #f3f3f3;">
        <%@include file="/Common-File/client-header.jsp" %>
        <%@include file="/Common-File/message.jsp" %>
        <div class="alert alert-dismissible fade show mt-3 mx-4 fs-4 bg-success text-light" role="alert">
            <strong>Currently, we do not offer the option of bulk purchases or simultaneous purchases of multiple items. 
                However, we plan to introduce these features in the future. 
                If you are interested in purchasing multiple items or making a bulk purchase, 
                please feel free to contact us or visit our store.</strong>
            <button type="button" class="btn-close text-light" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <!--Information section-->
        <div class="row row-cols-1 row-cols-md-3 g-4 mx-2 my-1">
            <%for (Product p : products) {%>
            <form action="../OrderAndCartServlet" method="post" >
                <input hidden name="P_Id" value="<%= p.getP_Id()%>">
                <input hidden name="U_Email" value="<%= theUserDetails.getU_Email()%>">
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
                                   class="btn btn-lg btn-outline-secondary rounded-pill mx-1  py-1 px-2 fs-4"
                                   name="Commond" value="Add Cart">
                            <input type="submit"
                                   class="btn btn-lg btn-outline-success rounded-pill mx-1  py-1 px-2 fs-4"
                                   name="Commond"  value="Purchase">
                        </div>
                    </div>
                </div>
            </form>
            <%}%>
        </div>
        <%@include file="../Common-File/footer.jsp" %>
    </body>
</html>