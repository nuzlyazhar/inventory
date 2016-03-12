<%-- 
    Document   : adminHome
    Created on : Feb 10, 2016, 11:39:56 PM
    Author     : nuzly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

        <title>Inventory Control System</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/style-responsive.css" rel="stylesheet">


    </head>

    <body>

        <section id="container" >
            <!-- **********************************************************************************************************************************************************
            TOP BAR CONTENT & NOTIFICATIONS
            *********************************************************************************************************************************************************** -->
            <jsp:include page="header.jsp" />

            <jsp:include page="side_bar.jsp" />

            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <h3><i class="fa fa-angle-right"></i>Order Overview</h3>
                    <div class="row">





                        <div class="row mt">
                            <div class="col-md-12">
                                <div class="content-panel">
                                    <ul class="sub">
                                        <li><a href="${pageContext.request.contextPath}/CreateItemServlet">Add more</a></li>

                                    </ul>
                                    <form action="OrderProcessorServlet" method="post" > 
                                         <div class="form-group">
                                            <label class="sr-only" for="category">Supplier</label>
                                            <input width="20%" required="true" type="text" class="form-control" list="customerList" id="cusId" name="customerList" placeholder="Enter Customer" autocomplete="off">

                                            <datalist  name="customerList" id="customerList" >
                                                <c:forEach items="${sessionScope.customers}" var="cus" >
                                                    <option value="${cus.id} - ${cus.firstName}">${cus.id} - ${cus.firstName}</option>

                                                </c:forEach>
                                            </datalist>
                                        </div>
                                        <table class="table table-striped table-advance table-hover">

                                            <hr>
                                            <thead>
                                                <tr>
                                                    <th><i class="fa fa-bullhorn"></i>Item Name</th>
                                                    <th><i class="fa fa-bookmark"></i> Item Description</th>
                                                    <th><i class="fa fa-bookmark"></i> Unit Price</th>
                                                    <th><i class="fa fa-bookmark"></i> Units Ordered</th>
                                                    <th><i class="fa fa-bookmark"></i> Sub total</th>

                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            <input type="hidden" value="EDIT" name="fromList">
                                            <c:forEach var="od" items="${sessionScope.sessionOrder.orderDetailCollection}">
                                                <tr>
                                                    <td><a href="basic_table.html#"><c:out value="${od.itemId.itemName}" /></a></td>
                                                    <td class="hidden-phone"><c:out value="${od.itemId.itemDescription}" /></td>
                                                    <td class="hidden-phone"><c:out value="${od.itemId.unitPrice}" /></td>
                                                    <td class="hidden-phone"><c:out value="${od.orderQantity}" /></td>
                                                    <td class="hidden-phone"><c:out value="${od.total}" /></td>


                                                    <td>

                                                        <button name="removeItem"  id="removeItem" class="btn btn-danger btn-xs" value="${od.itemId.id}"><i class="fa  fa-trash-o" ></i></button>

                                                    </td>
                                                </tr>
                                            </c:forEach>
                                                <tr>
                                                     <td>  </td>
                                                    <td>  </td>
                                                     <td>  </td>
                                                    <td> Total </td>
                                                    <td>${sessionScope.sessionOrder.total} </td>
                                                </tr>
                                    </form>

                                    </tbody>
                                    </table>
                                    <button type="submit" id="confirm_order" name="confirm_order"   value="confirm_order" class="btn btn-success btn-sm" name="addToOrder">Confirm</button>

                                </div><!-- /content-panel -->
                            </div><!-- /col-md-12 -->
                        </div><!-- /row -->

                </section><! --/wrapper -->
            </section><!-- /MAIN CONTENT -->

            <!--main content end-->
            <!--footer start-->
            <jsp:include page="footer.jsp" />


            <!--footer end-->
        </section>

        <!-- js placed at the end of the document so the pages load faster -->
        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="assets/js/jquery.scrollTo.min.js"></script>
        <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


        <!--common script for all pages-->
        <script src="assets/js/common-scripts.js"></script>

        <!--script for this page-->

        <script>
            //custom select box

            $(function () {
                $('select.styled').customSelect();
            });

        </script>

    </body>
</html>

