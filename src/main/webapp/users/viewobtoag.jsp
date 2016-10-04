<%-- 
    Document   : viewobtoag
    Created on : Oct 3, 2016, 4:45:00 PM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.ictc.domains.User"%>
<%@page import="com.grameenfoundation.ictc.wrapper.UserWrapper"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.models.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.*"%>
<!DOCTYPE html>
<html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View User</title>
        <%
             UserModel userModel = new UserModel();
             JSONArray  ob = new JSONArray();
             JSONObject x = new JSONObject();
             JSONObject y = new JSONObject();
             x = userModel.getObUser();
             
             ob = x.getJSONArray("obagent");
             
        %>
    </head>
    <body>
         <table class="table table-striped table-bordered">
            <tr>
                <th>OutGrower Bussiness Owner</th>
                <th>Agent</th>   
            </tr>


            <% for (int i=0;i<ob.length();i++) {
                 JSONObject b = ob.getJSONObject(i);
            %>

            
            <tr>
                <td><%= b.getString("ob") %></td>
                <td><%= b.getString("ag") %></td>
                
            </tr>
            <% } %>
         </table>
    </body>
</html>
