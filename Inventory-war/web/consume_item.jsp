<%-- 
    Document   : register
    Created on : Feb 10, 2016, 10:42:38 PM
    Author     : nuzly
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="assets/js/bootstrap-datepicker/css/datepicker.css" />
        <link rel="stylesheet" type="text/css" href="assets/js/bootstrap-daterangepicker/daterangepicker.css" />

        <!-- Custom styles for this template -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/style-responsive.css" rel="stylesheet">

       
    </head>

    <body>

        <section id="container" >
            <!-- **********************************************************************************************************************************************************
            TOP BAR CONTENT & NOTIFICATIONS
            *********************************************************************************************************************************************************** -->
            <!--header start-->
            <jsp:include page="header.jsp" />

            <jsp:include page="side_bar.jsp" />
            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <h3><i class="fa fa-angle-right"></i> Consume Item</h3>

                    <!-- BASIC FORM ELELEMNTS -->


                    <div class="row mt" >
                        <div class="col-lg-12">
                            <div class="form-panel">
                                <h4 class="mb"><i class="fa fa-angle-right"></i> Item Detail</h4>
                                <form class="form-horizontal style-form" method="post" action="ConsumeOrderServlet">



                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Item Name</label>
                                        <div class="col-sm-10">
                                            <label type="text" class="control-label" name="sinamel">${orderItem.itemName}</label>
                                            <input type="hidden" value="${orderItem.itemName}" name="siname">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Item Description</label>
                                        <div class="col-sm-10">
                                            <label type="text" class="control-label" name="sidesc">${orderItem.itemDescription}</label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Unit Price</label>
                                        <div class="col-sm-10">
                                            <label type="text" class="control-label" name="siup">${orderItem.unitPrice}</label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Available Stock</label>
                                        <div class="col-sm-10">
                                            <label type="text" class="control-label" name="sias">${orderItem.unitsInStock}</label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Threshold</label>
                                        <div class="col-sm-10">
                                            <label type="text" class="control-label" name="sit">${orderItem.reorderThreshold}</label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Supplier</label>
                                        <div class="col-sm-10">
                                            <label type="text" class="control-label" name="sisup">${orderItem.supId.compName}</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Category</label>
                                        <div class="col-sm-10">
                                            <label type="text" class="control-label" name="sic">${orderItem.catId.catName}</label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Number of Units</label>
                                        <div class="col-sm-10">
                                            <input type="number" class="control-label" id ="noOfUnits" name="noOfUnits" min="1">
                                        </div>
                                    </div>
                                    <button type="submit" value="${orderItem.id}" class="btn btn-success btn-sm" name="addToOrder">Add to order</button>
                                </form>
                            </div>
                        </div><!-- col-lg-12-->      	
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
        <script src="assets/js/jquery-ui-1.9.2.custom.min.js"></script>

        <!--custom switch-->
        <script src="assets/js/bootstrap-switch.js"></script>

        <!--custom tagsinput-->
        <script src="assets/js/jquery.tagsinput.js"></script>

        <!--custom checkbox & radio-->

        <script type="text/javascript" src="assets/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap-daterangepicker/date.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap-daterangepicker/daterangepicker.js"></script>

        <script type="text/javascript" src="assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>


        <script src="assets/js/form-component.js"></script>    


        <script>
            //custom select box

            $(function () {
                $('select.styled').customSelect();
            });

        </script>

    </body>
</html>

