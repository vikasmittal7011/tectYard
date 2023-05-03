<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TechYard - Registeration</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body>
        <%@include file="/Common-File/home-header.jsp" %>
        <div class="form-container">
            <%@include file="/Common-File/message.jsp" %>
            <div class="container text-center d-flex justify-content-evenly">
                <img src="../Pre-Use_Image/registration.png" alt="" height="100">
                <h1 class="mt-3">Register your self</h1>
            </div>

            <!--new form-->
            <form action="../UserServlet" onsubmit="return validateRegisterationForm()" method="post">
                <input value="REGISTER" name="Commond" hidden>
                <div>
                    <div class="container fs-3">
                        <div class="row">
                            <div class="mb-3 col-md-6 col-sm-12">
                                <label class="mt-1">Enter name: </label>
                                <input class="mt-2 fs-5 form-control" type="text" name="U_Name" id="U_Name" placeholder="Fist Name..." required autofocus />

                                <label class="mt-1">Enter sur name: </label>
                                <input class="mt-2 fs-5 form-control" type="text" name="U_Name_Sur" id="U_Name_Sur" placeholder="Last Name..." required />

                                <label class="mt-1">Enter age: </label>
                                <input class="mt-2 fs-5 form-control" type="text" name="U_Age" id="U_Age" placeholder="Age..." required />

                                <label class="mt-1">Enter email: </label>
                                <input class="mt-2 fs-5 form-control" type="text" name="U_Email" id="U_Email" placeholder="Email Address..." required />

                            </div>
                        </div>
                    </div>
                </div>
                <div>
                    <div class="container fs-3 mt-0">
                        <div class="row">
                            <div class="mb-3 col-md-6 col-sm-12">
                                <label class="mt-1">Enter contact number: </label>
                                <input class="mt-2 fs-5 form-control" type="text" name="U_Contact" id="U_Contact" placeholder="Phone Number..." required />

                                <label class="mt-1">Enter password: </label>
                                <input class="mt-2 fs-5 form-control" type="password" name="U_Password" id="U_Password" placeholder="Password..." required />

                                <label class="mt-1">Confirm password: </label>
                                <input class="mt-2 fs-5 form-control" type="password" name="U_Password_Confirm" id="U_Password_Confirm" placeholder="Retype Password..." required />

                                <div class="container text-center m-3 mt-5">
                                    <input type="reset" class="btn btn-lg btn-warning rounded-pill mx-5 mx-5 py-2 px-4 fs-3" value="Reset">
                                    <input type="submit" class="btn btn-lg btn-success rounded-pill mx-5 mx-5 py-2 px-4 fs-3" value="Register">    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>

            <p class="text-center fs-3">Already have a account <a class="link" href="login.jsp">Loing here</a> !!!</p>
        </div>
        <%@include file="/Common-File/footer.jsp" %>
    </body>
</html>