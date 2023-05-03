<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TeckYard- About Us</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body>
        <%@include file="/Common-File/home-header.jsp" %>
        <!--Base info section-->
            <div class="container my-5">
                <div class="row my-3">
                    <div class="col-md-6 col-sm-12">
                        <img class="rounded-5" src="../Pre-Use_Image/about.jpg" alt="" width="100%">
                    </div>
                    <div class="col-md-6 p-4 col-sm-12">
                        <h1 class="fw-bolder p-2">Who we are?</h1>
                        <p class="p-3 fs-5 lh-base ">As a small startup, we are dedicated to delivering the best components to
                            our users. Our aim is to provide an unparalleled experience for those who are in the market
                            for a new system, PC, laptop, or other components. We are committed to providing excellent
                            after-purchase service.</p>
                    </div>
                </div>
            </div>
        <!--Founder details section-->
            <div class="container-fluid my-5 text-white bg-dark">
                <div class="container text-center">
                    <h1 class="ls-5 pt-3  mb-1">Our thougts</h1>
                    <div class="p-3 mt-4 about-owner">
                        <!-- Fisrt -->
                        <div>
                            <p class="d-block pt-3 fs-3">Empowering technology.</p>
                            <p class="fst-italic fs-5"> -Vikas</p>
                        </div>
                        <div>
                            <img class="rounded-circle" src="../Pre-Use_Image/vikas.jpg" alt="" width="250"
                                height="200">
                        </div>
                    </div>
                    <!-- Second -->
                    <div class="p-3 mt-4 about-owner">
                        <div>
                            <img class="rounded-circle" src="../Pre-Use_Image/dev.jpeg" alt="" width="250"
                                height="200">
                        </div>
                        <div>
                            <p class="d-block pt-3 fs-3">Enabling progress, together.</p>
                            <p class="fst-italic fs-5"> -Dev</p>
                        </div>
                    </div>
                    <!-- Third -->
                    <div class="p-3 mt-4 pb-4 about-owner">
                        <div>
                            <p class="d-block pt-3 fs-3">Partnering for technological excellence.</p>
                            <p class="fst-italic fs-5"> -Aman</p>
                        </div>
                        <div>
                            <img class="rounded-circle" src="../Pre-Use_Image/aman.jpeg" alt="" width="250"
                                height="200">
                        </div>
                    </div>
                </div>
            </div>
            <footer class="m-5">
                <p class="py-1 mt-3">All &#169; coypright reserved by TechYard.</p>
            </footer>
    </body>
    </html>