<%-- 
    Document   : viewapotoag
    Created on : Jan 4, 2017, 3:11:53 PM
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
             x = userModel.getApoUser();
             
             ob = x.getJSONArray("apoagent");
             
        %>
    </head>
    <body>
         <table class="table table-striped table-bordered">
            <tr>
                <th>SAPO</th>
                <th>Agent</th>   
            </tr>


            <% for (int i=0;i<ob.length();i++) {
                 JSONObject b = ob.getJSONObject(i);
            %>

            
            <tr>
                <td><%= b.getString("name") %></td>
                <td><%= b.getString("sapo") %></td>
                
            </tr>
            <% } %>
         </table>
    </body>
</html>
