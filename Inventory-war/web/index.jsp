<%-- 
    Document   : index.jsp
    Created on : Feb 11, 2016, 8:50:03 PM
    Author     : nuzly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
        
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
     <jsp:include page="header.jsp" />
   
      <jsp:include page="side_bar.jsp" />
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
      		<div class="row mt">
      			<div class="col-lg-6 col-md-6 col-sm-12">
      				<! -- BASIC PROGRESS BARS -->
      				<div class="showback">
      					<h4><i class="fa fa-angle-right"></i> Basic Progress Bars</h4>
	      				<div class="progress">
						  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
						    <span class="sr-only">40% Complete (success)</span>
						  </div>
						</div>
						<div class="progress">
						  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="95" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
						    <span class="sr-only">20% Complete</span>
						  </div>
						</div>
						<div class="progress">
						  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
						    <span class="sr-only">60% Complete (warning)</span>
						  </div>
						</div>
						<div class="progress">
						  <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
						    <span class="sr-only">80% Complete</span>
						  </div>
						</div>
      				</div><!--/showback -->
      				
      				
					
      				
      				
      				
      				
      				<! -- GRITTER NOTICES -->
      				<div class="showback">
      					<h4><i class="fa fa-angle-right"></i> Gritter Examples</h4>
							<p>Click on below buttons to check it out.</p>
							<a id="add-regular" class="btn btn-default btn-sm" href="javascript:;">Regular</a>
							<a id="add-sticky" class="btn btn-success  btn-sm" href="javascript:;">Sticky</a>
							<a id="add-without-image" class="btn btn-info  btn-sm" href="javascript:;">Imageless</a>
							<a id="add-gritter-light" class="btn btn-warning  btn-sm" href="javascript:;">Light</a>
							<a id="remove-all" class="btn btn-danger  btn-sm" href="general.html#">Remove all</a>
      				</div><!-- /showback -->
      				
      			</div><! --/col-lg-6 -->
      			
      			
      			<div class="col-lg-6 col-md-6 col-sm-12">
      				
      				<div class="showback">
      					<h4><i class="fa fa-angle-right"></i> Inventory Alerts</h4>
                                         <c:forEach var="item" items="${sessionScope.alertItems}">
							<div class="alert alert-danger"><b>${item.itemName}</b> Is almost out of stock.</div>
                                         </c:forEach>
                              </div><!-- /showback -->
      				
      				<! -- DISMISSABLE ALERT -->
      				<div class="showback">
      					<h4><i class="fa fa-angle-right"></i> Dismissable Alert</h4>
						<div class="alert alert-warning alert-dismissable">
						  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						  <strong>Warning!</strong> Better check yourself, you're not looking too good.
						</div>      				
      				</div><!-- /showback -->
      				
      				<! -- BADGES -->
      				<div class="showback">
      					<h4><i class="fa fa-angle-right"></i> Badges</h4>
						<span class="badge">5</span>
						<span class="badge bg-primary">10</span>
						<span class="badge bg-success">15</span>
						<span class="badge bg-info">20</span>
						<span class="badge bg-inverse">25</span>
						<span class="badge bg-warning">30</span>
						<span class="badge bg-important">35</span>
      				</div><!-- /showback -->
      				
      				<! -- LABELS -->
      				<div class="showback">
      					<h4><i class="fa fa-angle-right"></i> Labels</h4>
							<span class="label label-default">label</span>
							<span class="label label-primary">Primary</span>
							<span class="label label-success">Success</span>
							<span class="label label-info">Info</span>
							<span class="label label-warning">Warning</span>
							<span class="label label-danger">Danger</span>
                    </div><!-- /showback -->
      			
      			</div><!-- /col-lg-6 -->
      			
      		</div><!--/ row -->
          </section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
      <jsp:include page="footer.jsp"/>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/jjquery-1.8.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>

    <!--script for this page-->
    <script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="assets/js/gritter-conf.js"></script>
    
  <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>

  </body>
</html>

