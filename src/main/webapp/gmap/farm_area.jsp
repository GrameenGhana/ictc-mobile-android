<%-- 
    Document   : farm_area
    Created on : Sep 15, 2015, 4:03:51 PM
    Author     : Joseph George Davis
--%>

<%@page import="org.neo4j.graphdb.Transaction"%>
<%@page import="com.grameenfoundation.ictc.utils.ICTCDBUtil"%>
<%@page import="com.grameenfoundation.ictc.domains.Biodata"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    System.out.print(request.getParameter("area"));
    out.println(request.getParameter("area"));
    
    BiodataModel bdata = new BiodataModel();
    Map<String,String> m = new HashMap<>();
    
    m.put(Biodata.FARM_AREA, request.getParameter("area"));
    bdata.BiodataUpdate(request.getParameter("farmer"), m);
           
    
    System.out.println("Farmer update done");
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
