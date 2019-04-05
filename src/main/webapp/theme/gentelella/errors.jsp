<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>ICTC - <decorator:title default="Welcome" /></title>

    <!-- Bootstrap -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <!-- page content -->
        <div class="col-md-12">
            <decorator:body/>
        </div>
        <!-- /page content -->
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
<!-- Custom Theme Scripts -->
<script src="<%= request.getContextPath()%>/theme/gentelella/js/custom.min.js"></script>


<decorator:getProperty property="page.scripts"/>

</body>
</html>
