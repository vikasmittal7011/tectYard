<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TeckYard - Forget Password</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body style="overflow: hidden;">
        <%@include file="/Common-File/home-header.jsp" %>
        <div class="login-form">
            <%@include file="/Common-File/message.jsp" %>
            <form action="../UserServlet" onsubmit="return validateChangePasswordForm()" method="post">
                <input type="hidden" value="UPDATE-PASSWORD" name="Commond">
                <div class="container text-center my-2">
                    <h1>Forget Password</h1>
                </div>
                <div class="container fs-3">
                    <div class="row">
                        <div class="col-md-4 col-sm-12">
                            <img class="px-4" src="../Pre-Use_Image/reset-password.png" alt="" height="300">
                        </div>
                        <div class="col-md-7 col-sm-12">
                            <label class="mt-3">Enter email: </label>
                            <input type="text" class="fs-5 form-control mt-2" name="U_Email" id="U_Email"
                                   placeholder="User Id..." required autofocus />

                            <label class="mt-1">Enter password: </label>
                            <input class="mt-2 fs-5 form-control" type="password" name="U_Password"
                                   id="U_Password" placeholder="Password..." required />

                            <label class="mt-1">Confirm password: </label>
                            <input class="mt-2 fs-5 form-control" type="password" name="U_Password_Confirm"
                                   id="U_Password_Confirm" placeholder="Retype Password..." required />
                        </div>
                    </div>
                    <div class="container text-center my-3 ">
                        <input type="submit" class="btn btn-lg btn-outline-success rounded-pill mx-5 py-2 px-4"
                               value="Restore">
                        <input type="reset" class="btn btn-lg btn-warning rounded-pill mx-5 py-2 px-4"
                               value="Reset">
                    </div>
                </div>
            </form>
            <p class="fs-3 p-2 text-center">Don't have a account <a class="link" href="register.jsp">Register
                    here</a> !!!</p>
        </div>

        <footer class="bg-dark text-white">
            <p class="py-3">All &#169; coypright reserved by TechYard.</p>
        </footer>
    </body>
</html>