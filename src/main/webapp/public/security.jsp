
<%@page import="com.grameenfoundation.ictc.utils.security.UserActionAuthenticator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>


<%
    /*
    Authorizer is a file to authorize the specific user viewing a page
    Admin Authorizer authorizes the administrator to only see admin pages
     */
    
    //Get
    boolean hasLogin = UserActionAuthenticator.hasLogin(request.getSession());
    System.out.println("Has User login"+hasLogin);

    if (hasLogin) {
        String userType = UserActionAuthenticator.loginUser(request.getSession()).getUserType();



        
    } else {
        //Logs the user out and kill the session     	
        System.out.println("Login Item  : "+hasLogin);
        UserActionAuthenticator.logoutClient(request, response, "/login.jsp");
    }

%>
