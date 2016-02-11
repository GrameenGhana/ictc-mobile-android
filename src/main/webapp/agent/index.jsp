<%-- 
    Document   : index
    Created on : Aug 26, 2015, 11:56:36 AM
    Author     : skwakwa
--%>

<%@page import="com.grameenfoundation.ictc.models.AgentModel"%>
<%@page import="com.grameenfoundation.ictc.wrapper.AgentWrapper"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.models.UserModel"%>
<%@page import="com.grameenfoundation.ictc.wrapper.UserWrapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
List<AgentWrapper> users = new AgentModel().findAllAgents();
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


            <% for (AgentWrapper bio : users) {%>

            <tr>
                <td><%= bio.getAgentId()%></td>
                <td><%= bio.getLastname()%></td>
                <td><%= bio.getFirstname()%></td>
                <td><%= bio.getAgentcode()%></td>
                <td><%= bio.getAgenttype()%></td>
                <td><%= bio.getAgenttype()%></td>
               
                <td>
                   
                    <a href="farmers.jsp?id=<%=bio.get() %>" class="btn btn-success">Farmers</a>
                   <a href="details.jsp?id=<%=bio.getID()%>" class="btn btn-info">Details</a>
                </td>
            </tr>
            <% }%>
 </table>
    </body>
</html>
