<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client - Profile</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body class="custome-bg-light">
        <%@include file="/Common-File/client-header.jsp" %>
        <!--Image section-->
        <div class="container text-center d-lg-flex d-sm-block justify-content-evenly my-4">
            <img src="../Pre-Use_Image/user.png" alt="" height="200">
            <h1 class="text-center my-5 py-3 ">Change Details & Update</h1>
        </div>
        <%@include file="/Common-File/message.jsp" %>
        <!--Form of client profile-->
        <form action="../UserServlet" onsubmit="return validateUpdationUserDetailsForm()" method="post">
            <input value="UPDATE-DETAILS" name="Commond" hidden>
            <div>
                <div class="container fs-3">
                    <div class="row">
                        <div class="mb-3 col-md-6 col-sm-12">
                            <label class="mt-1">Your name: </label>
                            <input class="mt-2 fs-5 form-control" type="text" name="U_Name" id="U_Name"
                                   placeholder="Full Name..." value="<%= theUserDetails.getU_Name()%>" required />

                            <label class="mt-1">Your age: </label>
                            <input class="mt-2 fs-5 form-control" type="text" name="U_Age" id="U_Age"
                                   placeholder="Age..." value="<%= theUserDetails.getU_Age()%>" required />

                            <% if (theUserDetails.getU_HouseNo() == -1) { %>
                            <label class="mt-1">Your House no: </label>
                            <input class="mt-2 fs-5 form-control" type="text" name="U_HouseNo"
                                   id="U_HouseNo" placeholder="House No..." required />
                            <% } else {%>
                            <label class="mt-1">Your house no: </label>
                            <input class="mt-2 fs-5 form-control" type="text" name="U_HouseNo"
                                   id="U_HouseNo" placeholder="House No..."
                                   value="<%= theUserDetails.getU_HouseNo()%>" required />
                            <% }%>

                            <label class="mt-1">Your state: </label>
                            <input class="mt-2 fs-5 form-control" type="text" name="U_City"
                                   id="U_City" placeholder="City..."
                                   value="<%= theUserDetails.getU_City()%>" required />


                            <label class="mt-1">Your pincode: </label>
                            <input class="mt-2 fs-5 form-control" type="text" name="U_Pincode"
                                   id="U_Pincode" placeholder="Pincode..."
                                   value="<%= theUserDetails.getU_Pincode()%>" required />

                        </div>
                        <div class="mb-3 col-md-6 col-sm-12">
                            <label class="mt-1">Your email: </label>
                            <input class="mt-2 fs-5 form-control" type="text" placeholder="Email Address..."
                                   value="<%= theUserDetails.getU_Email()%>" disabled />
                            <input name="U_Email" value="<%= theUserDetails.getU_Email()%>" hidden />
                            <input name="U_Password" value="<%= theUserDetails.getU_Password()%>" hidden />

                            <label class="mt-1">Your contact number: </label>
                            <input class="mt-2 fs-5 form-control" type="text" name="U_Contact" id="U_Contact"
                                   placeholder="Phone Number..." value="<%= theUserDetails.getU_Contact()%>"
                                   required />

                            <label class="mt-1">Your street: </label>
                            <input class="mt-2 fs-5 form-control" type="text" name="U_Street" id="U_Street"
                                   placeholder="Street..." value="<%= theUserDetails.getU_Street()%>" required />

                            <label class="mt-1">Your country : </label>
                            <input class="mt-2 fs-5 form-control" type="text" name="U_State" id="U_State"
                                   placeholder="Country..." value="<%= theUserDetails.getU_State()%>" required />


                            <div class="container text-center m-3 mt-5">
                                <input type="submit"
                                       class="btn btn-lg btn-success rounded-pill mx-5 my-2 py-2 px-4 fs-3"
                                       value="Update">
                                <input type="reset"
                                       class="btn btn-lg btn-outline-warning rounded-pill mx-5 my-2 py-2 px-4 fs-3"
                                       value="Reset">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!--Form for reset password-->
        <form action="../UserServlet" onsubmit="return validateChangePasswordForm()" method="post">
            <h1 class="text-center my-2">Update Paasword</h1>
            <input hidden name="U_Email" value="<%= theUserDetails.getU_Email()%>" />
            <input value="UPDATE-PASSWORD" name="Commond" hidden>
            <div>
                <div class="container fs-3">
                    <div class="row">
                        <div class="mb-3 col-md-6 col-sm-12">
                            <label class="mt-1">Reenter password: </label>
                            <input class="mt-2 fs-5 form-control" type="password" name="U_Password"
                                   id="U_Password" placeholder="Reenter Password..." required />

                        </div>
                        <div class="mb-3 col-md-6 col-sm-12">
                            <label class="mt-1">Confirm password: </label>
                            <input class="mt-2 fs-5 form-control" type="password" name="U_Password_Confirm"
                                   id="U_Password_Confirm" placeholder="Retype Password..." required />
                        </div>
                    </div>
                    <div class="container text-center">
                        <div class="container text-center m-3 mt-5">
                            <input type="submit"
                                   class="btn btn-lg btn-outline-success rounded-pill mx-5 mx-5 py-2 px-4 fs-3"
                                   value="Change Password">
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <%@include file="/Common-File/footer.jsp" %>
    </body>
</html>