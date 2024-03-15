<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--begin of menu-->
<!--Navbar-->

<nav class="navbar navbar-light bg-light justify-content-between">
    <div class="container">
        <a class="navbar-brand" href="home"><img
                src="https://www.vhv.rs/dpng/d/587-5875449_my-flower-shop-famous-flower-shop-logo-hd.png" style="height: 70px;"></a>
        
                
                <form action="search" method="post" class="form-inline my-2 my-lg-0">
            <div class="input-group input-group-sm">
                <input value="${txt}" name="txt" type="text" class="form-control" aria-label="Small"
                       aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                <div class="input-group-append">
                    <button type="submit" class="btn btn-secondary btn-number">
                        <i class="fa fa-search"></i>
                    </button>
                </div>
            </div>

                    
              
                       <div>           
            <a class="btn btn-sm ml-3" style="background-color: rgb(149, 167, 154)" href="carts">
                <i class="fa fa-shopping-cart" style="color: black"></i> Cart
                <span class="badge badge-light">${sessionScope.carts.size()}</span>
            </a>
          
        </form>
    </div>
</nav>
<!--end nav-->

<!--Home-->

<nav class="navbar navbar-expand-md navbar-dark " style="background-color: rgb(149, 167, 154);">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">

                <li class="nav-item d-flex">
                    <i class="fa-solid fa-house pt-2" style="line-height: 1.5;"></i>
                    <a class="nav-link text-black" href="home">Home |</a>
                </li>
                <c:if test="${sessionScope.acc.isAdmin == 1}">
                <li class="nav-item d-flex ">
                    <i class="fa-brands fa-product-hunt pt-2" style="line-height:1.5;"></i>
                    <a class="nav-link text-black" href="manageraccount">Manager Account |</a>
                      <li class="nav-item d-flex">
                    <i class="fa-solid fa-user pt-2" style="line-height:1.5;"></i>
                    <a class="nav-link text-black" href="managerCategory">Manager Category  |</a>
                </li>
                </li>
                </c:if>
                <c:if test="${sessionScope.acc.isSell == 1}">
                <li class="nav-item d-flex">
                    <i class="fa-solid fa-user pt-2" style="line-height:1.5;"></i>
                    <a class="nav-link text-black" href="manager">Manager Product  |</a>
                </li>
               
                </c:if>
                <c:if test="${sessionScope.acc != null}">
                     <li class="nav-item d-flex">
                         <a class="nav-link text-black" href="#">Hello ${sessionScope.acc.user} |</a>
                    </li>
                    <li class="nav-item d-flex">
                        <a class="nav-link text-black" href="logout">Logout |</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    <li class="nav-item d-flex ">
                        <i class="fa-solid fa-right-to-bracket pt-2" style="line-height: 1.5;"></i>
                        <a class="nav-link text-black" href="login.jsp">Login</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

<!--end home-->
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Hoa tươi cho những khoảnh khắc đặc biệt</h1>
        <p class="lead text-muted mb-0">Hòa quyện màu sắc và tình yêu trong từng bông hoa</p>
    </div>
</section>
<!--end of menu-->