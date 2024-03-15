
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
        <title>Shop Homepage</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
         <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="shopping-cart">
                <div class="px-4 px-lg-0">

                    <div class="pb-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">#</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Name</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Image</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Price</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Quantity</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Total Price</div>
                                                    </th>
                                                    
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${carts}" var="C">
                                            <form action="update-quantity">
                                                <tr>
                                                <input type="hidden" name="productId" value="${C.value.product.id}"/>
                                                <th scope="row">${C.value.product.id}</th>
                                                <td>${C.value.product.name}</td>
                                                <td><img src="${C.value.product.image}" width="50"/></td>
                                                <td>${C.value.product.price}</td>
                                                <td><input onchange="this.form.submit()" type="number" name="quantity" value="${C.value.quantity}"/></td>
                                                <td>${C.value.product.price*C.value.quantity+0.5}$</td>
                                                
                                                </tr>
                                            </form>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <h5 class="font-weight-bold">Total ${totalMoney+0.5}$</h5>
                                </div>
                                <!-- End -->
                                <div class="col-md-4" style="border: 1px solid #ccc; border-radius: 5px; padding: 1rem">
                                    <h3>Information of customer</h3>
                                    <form action="checkout" method="POST">
                                        <div class="mb-3">
                                            <label for="name" class="form-label">Name<span style="color: red"> *</span></label>
                                            <input type="text" class="form-control" required id="name" name="name" aria-describedby="emailHelp">
                                        </div>
                                        <div class="mb-3">
                                            <label for="phone" class="form-label">Phone<span style="color: red"> *</span></label>
                                            <input type="text" class="form-control" id="phone" required name="phone" aria-describedby="emailHelp">
                                        </div>
                                        <div class="mb-3">
                                            <label for="address" class="form-label">Address<span style="color: red"> *</span></label>
                                            <input type="text" class="form-control" id="address" required name="address" aria-describedby="emailHelp">
                                        </div>
                                        <div class="mb-3">
                                            <label for="note" class="form-label">Note<span style="color: red"> *</span></label>
                                            <textarea class="form-control" id="note" required name="note" rows="3"></textarea>
                                        </div>
                                        <button type="submit" class="btn btn-primary w-100">Submit</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div class="row py-5 p-4 bg-white rounded shadow-sm">




                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>

