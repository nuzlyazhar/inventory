<%-- 
    Document   : side_bar
    Created on : Feb 27, 2016, 4:30:54 PM
    Author     : nuzly
--%>

 <%@page import="entity.User"%>
<aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="profile.html"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered"><%= session.getAttribute("logFname") %> </h5>
              	  	
                

                  <li class="sub-menu">
                      <a class="active" href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>Admin Function</span>
                      </a>
                      <ul class="sub">
                          <c:if test="<%= ((User)session.getAttribute("user")).getRole().equals("ADMIN") %>">
                          <li> <a href="${pageContext.request.contextPath}/admin">Approval Requests</a></li>
                          </c:if>
                           
                          <li><a href="${pageContext.request.contextPath}/AddCategoryServlet">Categories</a></li>
                          
                           <li><a href="${pageContext.request.contextPath}/CreateSupplierServlet">Suppliers</a></li>
                          
                           
                         
                      </ul>
                  </li>
                  
                   <li class="sub-menu">
                      <a class="active" href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>Items</span>
                      </a>
                      <ul class="sub">
                          
                           <li><a href="${pageContext.request.contextPath}/listitem">View Items</a></li>
                           <li><a href="${pageContext.request.contextPath}/AddStockServlet">Add Stock</a></li>
                         
                      </ul>
                  </li>
                  
                   <li class="sub-menu">
                      <a class="active" href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>Customers</span>
                      </a>
                      <ul class="sub">
                          
                           <li><a href="create_customer.jsp">Create Customers</a></li>
                         
                      </ul>
                  </li>
                     <li class="sub-menu">
                      <a class="active" href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>Orders</span>
                      </a>
                      <ul class="sub">
                          
                           <li><a href="${pageContext.request.contextPath}/CreateOrderServlet">Create Orders</a></li>
                           <li><a href="${pageContext.request.contextPath}/OrderProcessorServlet">Order History</a></li>
                         
                      </ul>
                  </li>

          
               
            

              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
