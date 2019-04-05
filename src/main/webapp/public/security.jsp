<%@page import="com.grameenfoundation.ictc.utils.security.UserActionAuthenticator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%
    boolean hasLogin = UserActionAuthenticator.hasLogin(request.getSession());
    System.out.println("Has User login"+hasLogin);

    String username = "Test User";

    if (hasLogin) {
        String userType = UserActionAuthenticator.loginUser(request.getSession()).getUserType();
    } else {
        //Logs the user out and kill the session     	
        System.out.println("Login Item  : "+hasLogin);
        UserActionAuthenticator.logoutClient(request, response, "/login.jsp");
    }
%>
