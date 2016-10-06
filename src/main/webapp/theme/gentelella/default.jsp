<%@page import="com.grameenfoundation.ictc.utils.ICTCKonstants"%>
<%@page import="com.grameenfoundation.ictc.utils.security.Authenticator"%>
<%@page import="com.grameenfoundation.ictc.wrapper.LoginUser"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ include file="/public/security.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% 
    LoginUser user =  Authenticator.loginUser(session);
    System.out.println("user " + user.getUserScreenName());
    System.out.println("usertype  " + user.getUserType());
    
    
    if(null==user)
    {
        System.out.println("user not found");
        response.sendRedirect(request.getContextPath()+"/v2/login.jsp");
    }
     
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>ICTC - <decorator:title default="Welcome" /></title>

    <!-- Bootstrap -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <!-- PNotify -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">

    <decorator:getProperty property="page.stylesheets"/>

    <!-- Custom Theme Style -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/css/custom.min.css" rel="stylesheet">

</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="<%=request.getContextPath()%>/v2" class="site_title"><i class="fa fa-umbrella"></i> <span>ICTC</span></a>
                </div>

                <div class="clearfix"></div>

                <br />

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>General</h3>
                        <ul class="nav side-menu">
                            <% if(user.getUserType().equalsIgnoreCase(ICTCKonstants.GRAMEEN_ADMIN)|| user.getUserType().equals(ICTCKonstants.GRAMEEN_USER) ) {%>      
                            <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%=request.getContextPath()%>/v2/index.jsp">General Dashboard</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/dashboards/gf.jsp">GF Dashboard</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/dashboards/acdivoca.jsp">ACDIVOCA Dashboard </a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/dashboards/mofa.jsp">MOFA Dashboard</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/dashboards/obo.jsp">OBO Dashboard</a></li>
                                </ul>
                            </li>
                            <%}%>
                            <% if(user.getUserType().equalsIgnoreCase(ICTCKonstants.ACDIVOCA_USER)) {%>
                             <li><a><i class="fa fa-user"></i>ACDIVOCA <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath()%>/v2/dashboards/acdivoca.jsp">ACDIVOCA Dashboard </a></li>
                                </ul>
                            </li>
                            <% } %>
                            <% if(user.getUserType().equalsIgnoreCase(ICTCKonstants.ACDIVOCA_OB)) { %>
                             <li><a><i class="fa fa-user"></i>OutGrower Owner <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath()%>/v2/dashboards/obo.jsp">OB Dashboard </a></li>
                                </ul>
                            </li>
                            <% } %>
                            
                            <% if(user.getUserType().equalsIgnoreCase(ICTCKonstants.GRAMEEN_ADMIN)|| user.getUserType().equals(ICTCKonstants.GRAMEEN_USER) ) {%>
                            <li><a><i class="fa fa-bar-chart-o"></i> Reports <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath()%>/v2/reports/adoptation.jsp">Adoptation Report</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/reports/agent.jsp">Agent Report</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/reports/farmer.jsp">Farmer Report</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/reports/kpi.jsp">KPI Report</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/reports/submissioncount.jsp">Submission Count Report</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/reports/training.jsp">Training Report</a></li>
                                </ul>
                            </li>
                            <%}%>
                            
                              <% if(user.getUserType().equalsIgnoreCase(ICTCKonstants.GRAMEEN_ADMIN)|| user.getUserType().equals(ICTCKonstants.GRAMEEN_USER) ) {%>
                            <li><a><i class="fa fa-users"></i> People <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath()%>/v2/agents/index.jsp">Agents</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/farmers/index.jsp">Farmers</a></li>
                                </ul>
                            </li>
                             <%}%>
                             
                             <% if(user.getUserType().equalsIgnoreCase(ICTCKonstants.ACDIVOCA_USER)) {%>
                             <li><a><i class="fa fa-users"></i> People <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath()%>/v2/agent/acdivoca_agent.jsp">Agents</a></li>
                                   <!-- <li><a href="<%= request.getContextPath()%>/v2/farmers/index.jsp">Farmers</a></li>-->
                                </ul>
                            </li>
                            <%}%>
                        </ul>
                    </div>

                                
              <% if(user.getUserType().equalsIgnoreCase(ICTCKonstants.GRAMEEN_ADMIN) ) {%>              
                    <div class="menu_section">
                        <h3>System Management</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-group"></i> Users <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath()%>/v2/admin/users/index.jsp">Manage Users</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-globe"></i> Locations <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath()%>/v2/admin/locations/districts.jsp">Manage Districts</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/admin/locations/regions.jsp">Manage Regions</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-cogs"></i> Other <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath()%>/v2/admin/categories">Manage Categories</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/admin/logs/index.jsp">Logs</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <%}%>
                </div>
                <!-- /sidebar menu -->
               
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <nav class="" role="navigation">
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <img src="" alt=""><%= user.getUserScreenName() %>
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right">
                                <li><a href="<%= request.getContextPath()%>/v2/profile.jsp"><i class="fa fa-user pull-right"></i> Profile</a></li>
                                <li><a href="<%= request.getContextPath()%>/v2/help.jsp"><i class="fa fa-question-circle pull-right"></i> Help</a></li>
                                <li><a href="<%= request.getContextPath()%>/users/login?action=logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <decorator:body />
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
            <div class="pull-right">
                &copy; 2015 ICTC. Powered By <a href="http://www.grameenfoundation.org">Grameen Foundation.</a> Design by <a href="https://colorlib.com">Colorlib</a>
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
</div>

<!-- jQuery -->
<script src="<%= request.getContextPath()%>/theme/gentelella/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="<%= request.getContextPath()%>/theme/gentelella/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="<%= request.getContextPath()%>/theme/gentelella/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="<%= request.getContextPath()%>/theme/gentelella/vendors/nprogress/nprogress.js"></script>

<!-- PNotify -->
<script>
    $(document).ready(function() {
        var errorMsg = "${generalResponse.error}";
        var successMsg = "${generalResponse.success}";
        if (errorMsg.length > 0) {
            new PNotify({
                nonblock: { nonblock: true },
                title: 'Oh No!',
                text: errorMsg,
                type: 'error',
                styling: 'bootstrap3'});
        }
        if (successMsg.length > 1) {
            new PNotify({
                nonblock: { nonblock: true },
                title: 'Success',
                text: successMsg,
                type: 'success',
                styling: 'bootstrap3'
            });
        }
    });
</script>
<!-- /PNotify -->

<decorator:getProperty property="page.scripts"/>

<!-- Custom Theme Scripts -->
<script src="<%= request.getContextPath()%>/theme/gentelella/js/custom.min.js"></script>

</body>
</html>