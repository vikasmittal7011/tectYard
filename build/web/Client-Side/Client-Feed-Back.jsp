<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client - Feed Back</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body class="custome-bg-light">
        <%@include file="/Common-File/client-header.jsp" %>
        <%@include file="/Common-File/message.jsp" %>
        <div class="container">
            <div class="container text-center my-2">
                <h1>Send us your experience</h1>
            </div>
            <div class="row">
                <div class="col-md-5 col-sm-12 px-4">
                    <img src="../Pre-Use_Image/feedback.png" alt="feedback" height="400">
                </div>
                <div class="col-md-7 col-sm-12 fs-3">
                    <form onsubmit="return validateFeedBackForm()" action="../FeedBackServlet" method="post">

                        <input value="FEEDBACK" name="Commond" hidden>
                        <input value="<%= theUserDetails.getU_Email()%>" name="U_Email" hidden>

                        <label class="mt-1">Email</label>
                        <input class="form-control mt-2 fs-5" value="<%= theUserDetails.getU_Email()%>" disabled>

                        <label class="mt-1">Comment</label>
                        <textarea name="F_Comment" id="F_Comment" class="form-control mt-2 fs-5" rows="4" required
                                  autofocus></textarea>
                        <div class="container text-center m-3 mt-5">
                            <input type="submit"
                                   class="btn btn-lg btn-success rounded-pill mx-5 mx-5 py-2 px-4 fs-3" value="Submit">
                            <input type="reset" class="btn btn-lg btn-warning rounded-pill mx-5 mx-5 py-2 px-4 fs-3"
                                   value="Reset">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="../Common-File/footer.jsp" %>
    </body>
</html>