<%-- 
    Document   : viewobtoag
    Created on : Oct 3, 2016, 4:45:00 PM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.ictc.wrapper.UserWrapper"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.models.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View User</title>
        <%
            UserModel userModel = new UserModel();
            List<UserWrapper> users = userModel.findAll();
        
        %>
    </head>
    <body>
         <table class="table table-striped table-bordered">
            <tr>
                <th>OutGrower Bussiness Owner</th>
                <th>Agent</th>
               
                
                
               
            </tr>


            <% for (UserWrapper ag : users) {%>

            <tr>
                <td><%= ag.getFirstName()  %></td>
                <td><%= ag.getLastName() %></td>
                <td><%= ag.getUsername() %></td>
                <td><%= ag.getAgentType() %></td>
                <td><%= ag.getOrganisation()  %></td>
            </tr>
            <% }%>
         </table>
    </body>
</html>
