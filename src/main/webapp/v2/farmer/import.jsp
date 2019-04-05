<%-- 
    Document   : import
    Created on : Nov 10, 2016, 10:31:50 AM
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
    BiodataModel biodataModel = null;
     List<Biodata> bioWrapper = null;
     Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx();
 
     biodataModel = new BiodataModel();
     bioWrapper = biodataModel.findAllACDIVOCA();
    tx.success();
     
    
    //System.out.print("Cluster  " + bioWrapper.get(0).getCluster());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Farmer Page</title>
      
    </head>
    <body>
       

        <table class="table table-striped table-bordered myt-table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Surname</th>
                <th>Othernames</th>
                <th>Age</th>
                <th>Farmer Typer</th>
                <th>Community</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tbody>
            <% for (Biodata bio : bioWrapper) {%>

            <tr>
                <td><%= bio.getACDIVOCAFARMERID()  %></td>
                <td><%= bio.getLastname()  %></td>
                <td><%= bio.getFirstname() %></td>
                <td><%= bio.getAge() %></td>
                <td><%= bio.getFamer_type() %></td>
                <td><%= bio.getCommunity() %></td>
                <td>
                   
                        <a href="detail.jsp?id=<%=bio.getACDIVOCAFARMERID()  %>" class="btn btn-info">View</a>
                   
                </td>
            </tr>
            <% }%>
            </tbody>
        </table>
    </body>
    
    
  
</html>
