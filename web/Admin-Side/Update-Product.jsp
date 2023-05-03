<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
    Product singleProduct = (Product) session.getAttribute("single-product");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - Update Product</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body style="background-color: #f3f3f3;">
        <%@include file="/Common-File/admin-header.jsp" %>
        <div class="text-center">
            <h1 class="my-2">Update Prodcut Here !!</h1>
        </div>
        <!--Form for update product-->
        <form action="../ProductServlet" method="post">
            <input type="hidden" name="Commond" value="UPDATE">
            <input name="P_Id" value="<%= singleProduct.getP_Id()%>" hidden>
            <div class="container fs-3">
                <div class="row">
                    <div class="col-12">
                        <label class="mt-2">Product Name: </label>
                        <input type="text" class="mt-2 fs-5 form-control border border-primary" name="P_Name" id="P_Name"  value="<%= singleProduct.getP_Name()%>" required>

                        <label class="mt-2">Product Price: </label>
                        <input type="text" class="mt-2 fs-5 form-control border border-primary" name="P_Price" id="P_Price" value="<%= singleProduct.getP_Price()%>" required>

                        <label class="mt-2">Product Id: </label>
                        <input type="text"  class="mt-2 fs-5 form-control border border-primary" value="<%= singleProduct.getP_Id()%>" required disabled>

                        <label class="mt-2">Product Info: </label>
                        <textarea name="P_Info" id="P_Info" rows="5" class="mt-2 fs-5 form-control border border-primary" placeholder="Description..." required><%= singleProduct.getP_Info()%>
                        </textarea>
                    </div>
                    <div class="col-12">
                        <div class="container text-center mt-2">
                            <input type="reset"
                                   class="btn btn-lg btn-warning rounded-pill mx-5 mx-5 py-2 px-4 fs-3"
                                   value="Reset">
                            <input type="submit"
                                   class="btn btn-lg btn-outline-success rounded-pill mx-5 mx-5 py-2 px-4 fs-3"
                                   value="Update">
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>