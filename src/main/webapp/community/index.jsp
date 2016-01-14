<%-- 
    Document   : index
    Created on : Aug 26, 2015, 11:56:36 AM
    Author     : skwakwa
--%>

<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%@page import="com.grameenfoundation.ictc.wrapper.CommunityCounterWrapper"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.models.UserModel"%>
<%@page import="com.grameenfoundation.ictc.wrapper.UserWrapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
List<CommunityCounterWrapper> users =  new BiodataModel().getCommunityWrapper();
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
            
                <th>Community</th>
                <th>No of Farmers</th>
              
              <th>Actions</th>
            </tr>


            <% for (CommunityCounterWrapper bio : users) {%>

            <tr>
                <td><%= bio.getCommunity() %></td>
                 <td><%= bio.getNoOfFarmers()%></td>
               
                <td>
                   
                    <a href="<%=request.getContextPath() %>/farmer/search.jsp?type=community&q=<%=bio.getCommunity()%>" class="label label-info">Farmers</a>
                  
                </td>
            </tr>
            <% }%>
 </table>
    </body>
</html>
