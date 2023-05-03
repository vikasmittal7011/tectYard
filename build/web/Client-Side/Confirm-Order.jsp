<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client - Confirm Order</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body style="background-color: #f3f3f3;">
        <%@include file="/Common-File/client-header.jsp" %>
        <%@include file="/Common-File/message.jsp" %>
        <%Product singleProducts = (Product) session.getAttribute("single-product");%>
        <%if (theUserDetails.getU_HouseNo() == -1 || theUserDetails.getU_City() == ""
                    || theUserDetails.getU_Pincode() == "" || theUserDetails.getU_State() == "" || theUserDetails.getU_Street() == "") {%>
        <div class="container text-center my-2">
            <h1>Your profile is not complete!!</h1>
            <h1>First <a class="link" href="Client-Profile.jsp">complete profile</a> first to purchase product!!</h1>
        </div>
        <%} else {%>
        <!--Confirm Order-->
        <form action="../OrderAndCartServlet" method="post" onsubmit="if (!(confirm('Are you sure with this address!!')))
                    return false">
            <input hidden name="U_Email" value="<%=theUserDetails.getU_Email()%>">
            <input hidden name="P_Id" value="<%= singleProducts.getP_Id()%>">
            <input hidden name="Commond" value="ORDER">
            <div class="container my-2 px-5">
                <div class="row">
                    <div class="col-md-6 col-sm-12">
                        <h1>Product Information</h1>
                        <h2><%= singleProducts.getP_Name()%></h2>
                        <p><%= singleProducts.getP_Info()%></p>
                        <h3>₹ <%= singleProducts.getP_Price()%></h3>
                    </div>
                    <div class="col-md-6 col-sm-12 text-end">
                        <h1>Product Information</h1>
                        <p>
                            <%= theUserDetails.getU_Name() + "<br>"
                                    + theUserDetails.getU_Email() + "<br>"
                                    + theUserDetails.getU_Contact()%>
                        </p>
                        <h4>Address</h4>
                        <p>
                            <%= theUserDetails.getU_HouseNo() + ", "
                                    + theUserDetails.getU_Street() + "<br>"
                                    + theUserDetails.getU_City() + ","
                                    + theUserDetails.getU_State() + "<br> "
                                    + theUserDetails.getU_Pincode()%>
                        </p>
                    </div>
                    <div class="d-flex justify-content-evenly">
                        <input type="submit"
                               class="btn btn-lg btn-outline-success rounded-pill py-2 px-4 fs-4"
                               value="Order">
                    </div>
                    <div class="d-flex justify-content-evenly align-items-center">
                        <img src="../Pre-Use_Image/order.png" alt="" height="250">
                        <h1 class="text-uppercase">cash on delviery</h1>
                    </div>                        
                </div>
            </div>
        </form>
        <%}%>
        <%@include file="../Common-File/footer.jsp" %>
    </body>
</html>