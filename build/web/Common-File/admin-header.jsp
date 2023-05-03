<%@page import="com.techyard.orderAndcart.*"%>
<%@page import="com.techyard.product.*"%>
<%@page import="com.techyard.feedback.*"%>
<%@page import="com.techyard.admin.*"%>
<%@page import="com.techyard.user.*"%>
<%@page import="java.util.List"%>
<%
    // Admin details for login
    Admin theAdminDetails = (Admin) session.getAttribute("admin-details");
    // Making user utility class object
    UserDBUtil theUserDBUtil = new UserDBUtil();
    // Fetching user details
    List<User> theUserDetails = theUserDBUtil.getUserDetails();
    // Making admin utility class object
    AdminDBUtil theAdminDBUtil = new AdminDBUtil();
    // Fetching admin details
    List<Admin> adminsDetails = theAdminDBUtil.getAdminsData();
    // Making feedback utility class object
    FBDBUtil theFBDBUtil = new FBDBUtil();
    // Fetching feedbacks details
    List<FeedBack> theFeedbacks = theFBDBUtil.getFeedBacks();
    // Making product utility class object
    ProductDBUtil productDBUtil = new ProductDBUtil();
    // Fetching products details
    List<Product> products = productDBUtil.getProducts();
    // Making Order utility class object
    OrderDBUtil theOrderDBUtil = new OrderDBUtil();
    // Fetching order details
    List<Order> ordersDetails = theOrderDBUtil.getOrdersDetailsForAdminFirst();
    List<Order> ordersDeliveryDetails = theOrderDBUtil.getOrdersDetailsForAdminSecond();
    // Making cancel order utility class object
    CancelOrderDBUtil cancelOrderDBUtil = new CancelOrderDBUtil();
    // Fetching cancel order details
    List<CancelOrder> cancelOrders = cancelOrderDBUtil.getCancelOrderDetailsForAdmin();
    // Checking is user are login or not
    if (theAdminDetails == null) {
        session.setAttribute("message", "You are not loged in, please login first !! ");
        response.sendRedirect("../Home/admin-login.jsp");
        return;
    }
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fs-4">
    <div class="container-fluid">
        <a class="navbar-brand fs-2 px-2" href="../Admin-Side/Admin-Order-Details.jsp">TechYard</a>
        <button class="navbar-toggler border border-light" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="fa fa-bars"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item px-2">
                    <a class="nav-link" href="../Admin-Side/Admin-Order-Details.jsp">Orders</a>
                </li>
                <li class="nav-item px-2">
                    <a class="nav-link" href="../Admin-Side/Admin-Order-Cancel-Details.jsp">Canceled Orders</a>
                </li>
                <li class="nav-item px-2">
                    <a class="nav-link" href="../Admin-Side/Admin-Products.jsp">Products</a>
                </li>
                <li class="nav-item px-2">
                    <a class="nav-link" href="../Admin-Side/Admin-Payment.jsp">Payments</a>
                </li>
                <li class="nav-item px-2">
                    <a class="nav-link" href="../Admin-Side/Product-Delivery.jsp">Deliverys</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Hello <%= theAdminDetails.getA_Name()%>
                    </a>
                    <ul class="dropdown-menu fs-5">
                        <li><a class="dropdown-item" href="../Admin-Side/Admin-Profile.jsp">Profile</a></li>
                        <li><a class="dropdown-item" href="../Admin-Side/Add-Products.jsp">Add Products</a></li>
                        <li><a class="dropdown-item" href="../Admin-Side/Admin-Feed-Back.jsp">Feed Back</a></li>
                        <li><a class="dropdown-item" href="../Admin-Side/Admin-User-Details.jsp">User Details</a></li>
                    </ul>
                </li>
                <li class="nav-item px-2">
                    <a class="nav-link" href="../AdminServlet">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>