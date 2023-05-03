<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client - Home</title>
        <%@include file="/Common-File/including-files.jsp" %>
    </head>
    <body>
        <%@include file="/Common-File/client-header.jsp" %>
        <!-- Welcome -->
        <div class="home-bg-image">
            <img src="../Pre-Use_Image/back.jpg" alt="">
            <h1 class="text-uppercase"><%= theUserDetails.getU_Name()%></h1>
        </div>
        <!-- Brands -->
        <h1 class="m-5 text-center ls-5">We are deal in several brand's</h1>
        <section id="testimonials" class="bg-dark my-5 text-light">
            <div id="carouselExampleControlsNoTouching" class="carousel slide" data-bs-touch="false">
                <div class="carousel-inner">
                    <div class="testimonials-box carousel-item home-brands-info  active">
                        <div>
                            <h2 class="mt-3 py-1">Think Different</h2>
                            <img src="../Pre-Use_Image/mac.png" alt="">
                        </div>
                        <div>
                            <h2 class="mt-3 py-1">Life's Good</h2>
                            <img src="../Pre-Use_Image/lg.png" alt="">
                        </div>
                        <div>
                            <h2 class="mt-3 py-1">Together for tomorrow</h2>
                            <img src="../Pre-Use_Image/samsung.png" alt="">
                        </div>
                        <div>
                            <h2 class="mt-3 py-1">Explore beyond limits</h2>
                            <img src="../Pre-Use_Image/acre.png" alt="">
                        </div>
                    </div>
                    <div class="testimonials-box carousel-item home-brands-info">
                        <div>
                            <h2 class="mt-3 py-1">We create technologies that drive human progress.</h2>
                            <img src="../Pre-Use_Image/dell.png" alt="">
                        </div>
                        <div>
                            <h2 class="mt-3 py-1">Inspiring Innovation • Persistent Perfection</h2>
                            <img src="../Pre-Use_Image/asus.jpg" alt="">
                        </div>
                        <div>
                            <h2 class="mt-3 py-1">Smarter takes you beyond the everyday.</h2>
                            <img src="../Pre-Use_Image/lenovo.png" alt="">
                        </div>
                        <div>
                            <h2 class="mt-3 py-1">Expand your creative imagination</h2>
                            <img src="../Pre-Use_Image/msi.png" alt="">
                        </div>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button"
                        data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon carousel-icon product-info-slide-btn"></span>
                </button>
                <button class="carousel-control-next" type="button"
                        data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="next">
                    <span class="carousel-control-next-icon carousel-icon"></span>
            </div>
        </section>
        <!-- Product -->
        <div class="home-product-info my-5">
            <h1 class="m-4 text-center">We are deal's with different product</h1>
            <div class="product-display m-3">
                <div>
                    <img src="../Pre-Use_Image/pc.jpg" alt="" />
                    <h4>DeskTop's</h4>
                </div>
                <div>
                    <img src="../Pre-Use_Image/laptop.jpg" alt="" />
                    <h4>LapTop's</h4>
                </div>
                <div>
                    <img src="../Pre-Use_Image/mac.jpg" alt="" />
                    <h4>MAC's</h4>
                </div>
                <div>
                    <img src="../Pre-Use_Image/monitor.jpg" alt="" />
                    <h4>Monitor's</h4>
                </div>
                <div>
                    <img src="../Pre-Use_Image/motherborad.jpg" alt="" />
                    <h4>MotherBorad's</h4>
                </div>
                <div>
                    <img src="../Pre-Use_Image/ram.jpg" alt="" />
                    <h4>Ram's</h4>
                </div>
                <div>
                    <img src="../Pre-Use_Image/keyborad.jpg" alt="" />
                    <h4>KeyBorad's</h4>
                </div>
                <div>
                    <img src="../Pre-Use_Image/mouse.avif" alt="" />
                    <h4>Mouse's</h4>
                </div>
            </div>
        </div>
        <!-- Application -->
        <div class="home-app p-3 my-5 bg-dark text-light">
            <h1 class="m-5">Here is the download link of our application</h1>
            <button type="button" class="btn btn-info donwload cta-downloa mx-5 my-3"
                    onclick="errorInDownload()"><span class="fa-brands fa-apple mx-1"></span> Download</button>
            <button type="button" class="btn btn-primary donwload cta-downloa mx-5 my-3"
                    onclick="errorInDownload()"><span class="fa-brands fa-google-play mx-1"></span> Download</button>
            <p class="fs-3 m-2 p-1 hide">We are lunch application as soon as posible</p>
        </div>
        <!-- Footer -->
        <footer class="m-5">
            <p class="py-1 mt-3">All &#169; coypright reserved by TechYard.</p>
        </footer>
    </body>
</html>