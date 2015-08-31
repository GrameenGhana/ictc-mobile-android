<%-- 
    Document   : index
    Created on : Aug 31, 2015, 8:54:05 AM
    Author     : skwakwa
--%>

<%@page import="com.grameenfoundation.ictc.models.CropCalendarSettingModel"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.wrapper.CropCalendarSettingWrapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
List<CropCalendarSettingWrapper> settings = new CropCalendarSettingModel().getAllSetting();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crop Calendar Settings</title>
    </head>
    <body>
        <table class="table table-striped table-bordered">
            <tr>
                <th>Crop</th>
                <th>Start</th>
                <th>End</th>
                <th>Activity</th>
               
            </tr>


            <% for (CropCalendarSettingWrapper setting : settings) {%>

            <tr>
             <td><%= setting.getCrop() %></td>
              <td><%= setting.getStartWeek()%></td>
              <td><%= setting.getEndWeek()%></td>
              <td><%= setting.getActivity()%></td>
              
            </tr>
            <% }%>

        </table>
    </body>
</html>
