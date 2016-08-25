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

    <title>ICTC - <decorator:title default="Login" /></title>

    <!-- Bootstrap -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="https://colorlib.com/polygon/gentelella/css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/css/custom.min.css" rel="stylesheet">

    <!-- PNotify -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">
</head>

<body class="login">
    <decorator:body />
</div>

<!-- jQuery -->
<script src="<%= request.getContextPath()%>/theme/gentelella/vendors/jquery/dist/jquery.min.js"></script>

<!-- Custom Theme Scripts -->
<script src="<%= request.getContextPath()%>/theme/gentelella/js/custom.min.js"></script>

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

</body>
</html>