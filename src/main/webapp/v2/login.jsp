<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login - ICTC</title>
      <!-- Bootstrap -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <!-- PNotify -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">
    
    
    <!-- Custom Theme Style -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/css/custom.min.css" rel="stylesheet">
    
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form action="<%=request.getContextPath()%>/users/login" method="post">
                    <h1>Login</h1>
                    <div>
                        <input type="text" class="form-control" placeholder="Username" id="username" name="username" required />
                    </div>
                    <div>
                        <input type="password" class="form-control" placeholder="Password" id="password" name="password" required />
                    </div>
                    <div>
                        <button class="btn btn-default submit" type="submit"  >Log in </button>
                        <a class="reset_pass" href="#">Lost your password?</a>
                    </div>
                    <input type="hidden" id="login" name="action" value="login" />
			
                    <div class="clearfix"></div>

                    <div class="separator">
                            <div>
                                <h1><i class="fa fa-umbrella"></i> ICTC</h1>
                                <p>© 2016 ICTC</p>
                            </div>
                        </div>
                </form>
            </section>
        </div>
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
</body>
</html>