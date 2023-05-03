<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client - Cart</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body>
        <%@include file="/Common-File/client-header.jsp" %>
        <%@include file="/Common-File/message.jsp" %>
        <% CartDBUtil cartDBUtil = new CartDBUtil();
            List<Cart> carts
                    = cartDBUtil.getCartProducts(theUserDetails.getU_Email());
        %>
        <!--Information section-->
        <%if (carts.size() == 0) {%>
        <div class="container text-center my-2">
            <h1>Your cart was empty</h1>
            <h2>Do you want to <a href="Client-Product.jsp">add products !!!</a></h2>
        </div>
        <%} else {%>
        <div class="row row-cols-1 row-cols-md-4 g-4 mx-1 my-1">
            <%for (Cart c : carts) {%>
            <form action="../OrderAndCartServlet" method="post">
                <input hidden name="C_Id" value="<%= c.getC_Id()%>">
                <input hidden name="P_Id" value="<%= c.getP_Id()%>">
                <input hidden name="U_Email" value="<%= theUserDetails.getU_Email()%>">
                <div class="col">
                    <div class="card h-100">
                        <img src="../Product-Image/<%= c.getP_Image()%>"
                             class="card-img-top p-2" alt="<%= c.getP_Image()%>"
                             style="max-height: 250px">
                        <div class="card-body">
                            <h5 class="card-title">
                                <%= c.getP_Name()%>
                            </h5>
                            <p class="card-text">
                                <%= c.getP_Info()%>
                            </p>
                            <h4 class="card-title"> ₹ <%= c.getP_Price()%>
                            </h4>
                        </div>
                        <div class="card-footer d-flex justify-content-evenly">
                            <input type="submit"
                                   class="btn btn-lg btn-outline-secondary rounded-pill mx-1  py-1 px-2 fs-4"
                                   name="Commond" value="Remove">
                            <input type="submit"
                                   class="btn btn-lg btn-outline-success rounded-pill mx-1  py-1 px-2 fs-4"
                                   name="Commond" value="Purchase">
                        </div>
                    </div>
                </div>
            </form>
            <%}%>
        </div>
        <%}%>
        <%@include file="../Common-File/footer.jsp" %>
    </body>
</html>