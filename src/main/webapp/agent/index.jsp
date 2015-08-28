<%-- 
    Document   : index
    Created on : Aug 26, 2015, 11:56:36 AM
    Author     : skwakwa
--%>

<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.models.UserModel"%>
<%@page import="com.grameenfoundation.ictc.wrapper.UserWrapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
List<UserWrapper> users = new UserModel().findAll();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agents</title>
    </head>
    <body>
 <table class="table table-striped table-bordered">
            <tr>
                <th>ID</th>
                <th>Lastname</th>
                <th>Fistname</th>
                <th>Code</th>
                <th>User Type</th>
                <th>Organisation</th>
              <th>Actions</th>
            </tr>


            <% for (UserWrapper bio : users) {%>

            <tr>
                <td><%= bio.getID()%></td>
                <td><%= bio.getLastName()%></td>
                <td><%= bio.getFirstName() %></td>
                <td><%= bio.getAgentCode()%></td>
                <td><%= bio.getAgentType()%></td>
                <td><%= bio.getOrganisation()%></td>
               
                <td>
                   
                    <a href="farmers.jsp?id=<%=bio.getID()%>" class="btn btn-success">Farmers <span class="badge badge-info"><%=bio.getMyFarmers().size() %></span></a>
                   <a href="details.jsp?id=<%=bio.getID()%>" class="btn btn-info">Details</a>
                </td>
            </tr>
            <% }%>
 </table>
    </body>
</html>
