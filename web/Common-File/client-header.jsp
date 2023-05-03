<%@page import="com.techyard.orderAndcart.*"%>
<%@page import="com.techyard.orderAndcart.*"%>
<%@page import="java.util.List"%>
<%@page import="com.techyard.product.*"%>
<%@page import="com.techyard.user.*"%>
<%
    // Get login user details
    User theUserDetails = (User) session.getAttribute("user-details");
    // Making product utility class object
    ProductDBUtil productDBUtil = new ProductDBUtil();
    // Fetching products details
    List<Product> products = productDBUtil.getProducts();
    // Making Order utility class object
    OrderDBUtil theOrderDBUtil = new OrderDBUtil();
    // Fetching order details
    List<Order> ordersDetails = theOrderDBUtil.getOrdersDetailsForClientFirst(theUserDetails.getU_Email());
    List<Order> ordersDeliveryDetails = theOrderDBUtil.getOrdersDetailsForClientSecond(theUserDetails.getU_Email());
    // Making cancel order utility class object
    CancelOrderDBUtil  cancelOrderDBUtil = new CancelOrderDBUtil();
    // Fetching cancel order details
    List<CancelOrder> cancelOrders = cancelOrderDBUtil.getCancelOrderDetailsForUser(theUserDetails.getU_Email());
    // Making cart utility class object
    CartDBUtil cdbu = new CartDBUtil();
    //Fetching cart details
     List<Cart> cs = cdbu.getCartProducts(theUserDetails.getU_Email());
    if (theUserDetails == null) {
        session.setAttribute("message", "You are not loged in, please login first !! ");
        response.sendRedirect("../Home/login.jsp");
        return;
    }
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fs-4">
    <div class="container-fluid">
        <a class="navbar-brand fs-2 px-4" href="../Client-Side/Client-Home.jsp">TechYard</a>
        <button class="navbar-toggler border border-light" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="fa fa-bars"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item px-4">
                    <a class="nav-link" href="../Client-Side/Client-Home.jsp">Home</a>
                </li>
                <li class="nav-item px-4">
                    <a class="nav-link" href="../Client-Side/Client-Product.jsp">Products</a>
                </li>
                <li class="nav-item px-4">
                    <a class="nav-link" href="../Client-Side/Client-Feed-Back.jsp">Feed Back</a>
                </li>
                <li class="nav-item px-4">
                    <a class="nav-link" href="../Client-Side/Client-Cart-Details.jsp">My Cart (<%= cs.size() %>)</a>
                </li>
                <li class="nav-item dropdown px-4">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Hello <%= theUserDetails.getU_Name()%>
                    </a>
                    <ul class="dropdown-menu fs-5">
                        <li><a class="dropdown-item" href="../Client-Side/Client-Profile.jsp">Profile</a></li>
                        <li><a class="dropdown-item" href="../Client-Side/Client-Order-Details.jsp">Orders</a></li>
                        <li><a class="dropdown-item" href="../Client-Side/Client-Cancel-Details.jsp">Cancel Orders</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item px-4">
                    <a class="nav-link" href="../UserServlet">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>