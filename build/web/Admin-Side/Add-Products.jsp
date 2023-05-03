<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - Add Product</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body style="background-color: #f3f3f3;">
        <%@include file="/Common-File/admin-header.jsp" %>
        <%@include file="/Common-File/message.jsp" %>
        <!--Image section-->
        <div class="container text-center d-flex justify-content-evenly">
            <img src="../Pre-Use_Image/add-product.png" alt="" class="mt-2" height="120">
            <h1 class="my-4">Add Prodcut Here !!</h1>
        </div>
        <!--Form of add product-->
        <form action="../ProductServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="Commond" value="UPLOAD">

            <div class="container fs-3">
                <div class="row">
                    <div class="col-md-6 col-sm-12">
                        <label class="mt-3">Product Name: </label>
                        <input type="text" class="mt-2 fs-5 form-control border border-primary" name="P_Name" id="P_Name" placeholder="Name..." required autofocus>

                        <label class="mt-3">Product Price: </label>
                        <input type="text" class="mt-2 fs-5 form-control border border-primary" name="P_Price" id="P_Price" placeholder="Price..." required>

                    </div>
                    <div class="col-md-6 col-sm-12">
                        <label class="mt-3">Product Id: </label>
                        <div class="row">
                            <div class="col-6">
                                <select name="P_IdF" class="form-select mt-2 fs-5 border border-primary">
                                    <option value="LT">Laptop</option>
                                    <option value="DT">Desktop</option>
                                    <option value="MAC">MAC</option>
                                    <option value="MT">Monitor</option>
                                    <option value="MB">MotherBorad</option>
                                    <option value="RAM">RAM</option>
                                    <option value="MS">Mouse</option>
                                    <option value="KB">KeyBorad</option>
                                </select>
                            </div>
                            <div class="col-6">
                                <input type="text" name="P_IdL" id="F_IdL" class="mt-2 fs-5 form-control border border-primary" placeholder="Id..." required>
                            </div>
                        </div>

                        <label class="mt-3">Select a image</label>
                        <input type="file" class="mt-2 fs-5 form-control border border-primary" name="P_Img" id="P_Img" required>
                    </div>
                    <div class="col-12">
                        <label class="mt-3">Product Info: </label>
                        <textarea onkeydown="countNumberOfWords()" name="P_Info" id="P_Info" rows="5" class="mt-2 fs-5 form-control border border-primary" placeholder="Description..." required></textarea>
                    </div>
                    <div class="col-12">
                        <div class="container text-center mt-3">
                            <input type="reset"
                                   class="btn btn-lg btn-warning rounded-pill mx-5 mx-5 py-2 px-4 fs-3"
                                   value="Reset">
                            <input type="submit"
                                   class="btn btn-lg btn-outline-success rounded-pill mx-5 mx-5 py-2 px-4 fs-3"
                                   value="Upload">
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
    <script>
        // Use to add <br> in text 
        var abc = document.getElementById("P_Info"); 
        var newLine = "<br>";
        abc.addEventListener('keyup', function(e){
            if(e.keyCode === 13){
                var getString = document.getElementById("P_Info").value;
                var postString = getString + newLine; 
                document.getElementById("P_Info").value = postString;
            }
        })
    </script>
</html>