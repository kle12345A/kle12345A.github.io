

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop </title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
            rel="stylesheet"
            />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="container" style="min-height: 1000px">
                <div class="alert alert-success text-center mt-5" role="alert" >
                    <h3>List Products</h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Image</th>
                                <th scope="col">Name</th>
                                <th scope="col">Price</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Total Price</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${cartss}" var="C">
                            <tr>
                        <input type="hidden" name="productId" value="${C.value.product.id}"/>
                        <th scope="row">${C.value.product.id}</th>
                        <td>${C.value.product.name}</td>
                        <td><img src="${C.value.product.image}" width="50"/></td>
                        <td>${C.value.product.price}</td>
                        <td>${C.value.quantity}</td>
                        <td>${C.value.product.price*C.value.quantity}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <h3>Total Amount: $${totalPrice}</h3>
                Order successfully, Thank you very much...
                <div class="text-center mt-2">
                    <a class="btn btn-outline-primary" href="home">Continue Shopping</a>
                </div>
            </div>
        </div>

    </body>
</html>

