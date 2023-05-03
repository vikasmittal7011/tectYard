<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TeckYard - Admin Login</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body>
        <%@include file="/Common-File/home-header.jsp" %>
        <!--Form-->
        <div class="login-form">
            <%@include file="/Common-File/message.jsp" %>
            <h1 class="pt-4 pb-2 text-center">Admin Login</h1>
            <form class="my-3" action="../AdminServlet" onsubmit="return validateLoginForm()" method="post">
                <input value="ADMIN-LOGIN" name="Commond" hidden>
                <div class="container fs-3">
                    <div class="row">
                        <div class="mb-3 col-md-6 ps-5">
                            <img src="../Pre-Use_Image/admin.png" alt="login" height="450" width="470">
                        </div>
                        <div class="mb-3 col-md-6">
                            <label class="mt-3">Enter email: </label>
                            <input class="form-control fs-5 mt-2" type="text" name="A_Email" id="U_Email_" placeholder="Admin Id..." autofocus
                                   required />

                            <label class="mt-3">Enter password: </label>
                            <input class="form-control fs-5 mt-2" type="password" name="A_Password" id="U_Password_" placeholder="Password..."
                                   required />

                            <div class="container text-center m-3 mt-4">
                                <input type="submit"
                                       class="btn btn-lg btn-outline-success rounded-pill mx-5 py-2 px-4 fs-4"
                                       value="Login">
                                <input type="reset" class="btn btn-lg btn-warning rounded-pill mx-5 py-2 px-4 fs-4"
                                       value="Reset">
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
            <%@include file="/Common-File/footer.jsp" %>
    </body>
</html>