<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cancel Order</title>
        <%@include file="/Common-File/including-files.jsp"%>
    </head>
    <body>
        <%
            String id = (String) session.getAttribute("O_Id");
            String p_id = (String) session.getAttribute("P_Id");
            System.out.println(p_id);
        %>
        <%@include file="/Common-File/client-header.jsp" %>        
        <!--form for cancel prodcut-->
        <div class="mt-4">
            <form action="../OrderAndCartServlet" method="post">
                <div class="container fs-3">
                    <input  name="O_Id" value="<%= id%>" hidden>
                    <input  name="P_Id" value="<%= p_id%>" hidden>
                    <input  name="U_Email" value="<%= theUserDetails.getU_Email()%>" hidden>
                    <input  name="Commond" value="CANCEL-ORDER" hidden>
                    <div class="row">
                        <div class="mb-3 col-md-5 px-5">
                            <img src="../Pre-Use_Image/cancelled.png" alt="login" height="300">
                        </div>
                        <div class="mb-3 col-md-7">
                            <label class="mt-3">Write Reason: </label>
                            <textarea name="C_Reason" id="C_Reason" rows="6" class="mt-2 fs-5 form-control border border-primary" placeholder="Please write a reason for cancel order......" required></textarea>
                            <div class="container text-center m-3 mt-4">
                                <input type="submit" class="btn btn-lg btn-outline-success rounded-pill mx-5 py-2 px-4"
                                       value="Cancel">
                            </div>
                        </div>
                    </div>
                </div>
            </form>            
        </div>
        <%@include file="/Common-File/footer.jsp" %>
    </body>
</html>