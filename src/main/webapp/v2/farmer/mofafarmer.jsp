<%-- 
    Document   : mofafarmer
    Created on : Mar 30, 2016, 4:00:04 PM
    Author     : Joseph George Davis
--%>

<%@page import="org.neo4j.graphdb.Transaction"%>
<%@page import="com.grameenfoundation.ictc.utils.ICTCDBUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%@page import="com.grameenfoundation.ictc.wrapper.BiodataWrapper"%>
<%@page import="com.grameenfoundation.ictc.domains.Biodata"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
   BiodataModel biodataModel = new BiodataModel();
   Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx();
  
    List<Biodata> bioWrapper = biodataModel.findAllMOFAFarmers();
    
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>user Page</title>
      
    </head>
    <body>
       

        <table class="table table-striped table-bordered my-table">
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


            <% for (Biodata bio : bioWrapper) {%>

            <tr>
                <td><%= bio.getFarmerID() %></td>
                <td><%= bio.getLastname()%></td>
                <td><%= bio.getFirstname()  %></td>
                <td><%= bio.getCommunity() %></td>
                <td><%= bio.getMajorCrop() %></td>
                <td><%= bio.getCluster() %></td>
                <td><%= bio.getVillage() %></td>
                <td>
                   
                        <a href="detail.jsp?id=<%=bio.getFarmerID() %>" class="btn btn-info">View</a>
                   
                </td>
            </tr>
            <% }
            
            tx.success();
            
            %>

        </table>
    </body>
</html>
