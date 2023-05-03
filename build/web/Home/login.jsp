<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TeckYard - Login</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body>
        <%@include file="/Common-File/home-header.jsp" %>
        <div class="login-form">
            <%@include file="/Common-File/message.jsp" %>
            <h1 class="p-3 text-center ">Login Here</h1>
            <form action="../UserServlet" onsubmit="return validateLoginForm()" method="post">
                <input value="LOGIN" name="Commond" hidden>
                <div class="container fs-3">
                    <div class="row">
                        <div class="mb-3 col-md-5 px-5">
                            <img src="../Pre-Use_Image/login.png" alt="login" height="300">
                        </div>
                        <div class="mb-3 col-md-7">
                            <label class="mt-3">Enter email: </label>
                            <input type="text" class="fs-5 form-control mt-2" name="U_Email" id="U_Email_" placeholder="User Id..." required autofocus />

                            <label class="mt-3">Enter password: </label>
                            <input type="password" class="fs-5 form-control mt-2" name="U_Password" id="U_Password_" placeholder="Password..."
                                   required />

                            <div class="container text-center m-3 mt-4">
                                <input type="submit" class="btn btn-lg btn-outline-success rounded-pill mx-5 py-2 px-4"
                                       value="Login">
                                <input type="reset" class="btn btn-lg btn-warning rounded-pill mx-5 py-2 px-4"
                                       value="Reset">
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <div class="container text-center">

                <div class="row">
                    <div class="col-md-6 col-sm-12">
                        <p class="fs-3 p-2 text-center">Not remember password <a class="link" href="forget-password.jsp">Forget Here</a> !!!</p>
                    </div>
                    <div class="col-md-6 col-sm-12">
                        <p class="fs-3 p-2 text-center">Don't have a account <a class="link" href="register.jsp">Register
                                here</a> !!!</p>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/Common-File/footer.jsp" %>
    </body>
</html>