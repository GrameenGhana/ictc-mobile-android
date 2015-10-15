<%-- 
    Document   : index
    Created on : Aug 13, 2015, 2:03:20 PM
    Author     : skwakwa
--%>

<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%@page import="com.grameenfoundation.ictc.wrapper.BiodataWrapper"%>
<%@page import="com.grameenfoundation.ictc.domains.Biodata"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  BiodataModel biodataModel = new BiodataModel();
    List<BiodataWrapper> bioWrapper = biodataModel.getBioData("", "");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>user Page</title>
      
    </head>
    <body>
       

        <table class="table table-striped table-bordered">
            <tr>
                <th>ID</th>
                <th>Surname</th>
                <th>Othernames</th>
                <th>Community</th>
                <th>Main Crop</th>
                <th>Cluster</th>
                <th>Village</th>
                <th>Actions</th>
            </tr>


            <% for (BiodataWrapper bio : bioWrapper) {%>

            <tr>
                <td><%= bio.getFarmID()%></td>
                <td><%= bio.getLastName()%></td>
                <td><%= bio.getFirstName() %></td>
                <td><%= bio.getCommunity() %></td>
                <td><%= bio.getMajorCrop() %></td>
                <td><%= bio.getCluster() %></td>
                <td><%= bio.getVillage() %></td>
                <td>
                   
                        <a href="detail.jsp?id=<%=bio.getFarmID()  %>" class="btn btn-info">View</a>
                   
                </td>
            </tr>
            <% }%>

        </table>
    </body>
</html>
