<%-- 
    Document   : index
    Created on : Aug 13, 2015, 2:03:20 PM
    Author     : skwakwa
--%>


<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.grameenfoundation.ictc.wrapper.MobileTrackerWrapper"%>
<%@page import="com.grameenfoundation.ictc.models.MobileTrackerModel"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%@page import="com.grameenfoundation.ictc.wrapper.BiodataWrapper"%>
<%@page import="com.grameenfoundation.ictc.domains.Biodata"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  MobileTrackerModel biodataModel = new MobileTrackerModel();
    List<MobileTrackerWrapper> trackItems = biodataModel.findAll();
       String format = "EEE, MMM d, ''yy  HH:mm";
      
        SimpleDateFormat simpleDate = new SimpleDateFormat(format);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logs Page</title>

    </head>
    <body>


        <table class="table table-striped table-bordered">
            <tr>
                <th>ID</th>
                <th>User</th>
                <th>Module</th>
                <th>Page</th>
                <th>Section</th>
               
                <th>Start</th>
                <th>End</th>
                <th>Version</th>
                <th>Battery</th>
                <th>IMEI</th>
            </tr>
            <% for (MobileTrackerWrapper mobileTracker : trackItems) {%>
            <tr>
                <td><%= mobileTracker.getId()%></td>
                <td><%= mobileTracker.getUserId()%></td>
                <td><%= mobileTracker.getModule()%></td>
                <td><%= mobileTracker.getPage()%></td>
                <td><%= mobileTracker.getSection()%></td>

               
                <td><%=
                simpleDate.format(new Date(mobileTracker.getStartTime()))
               %></td>
                <td><%= simpleDate.format(new Date(mobileTracker.getEndTime()))%></td>
                <td><%= mobileTracker.getVersion()%></td>
                <td><%= mobileTracker.getBattery()%></td>
                <td><%= mobileTracker.getImei()%></td>
            </tr>
            <% }%>

        </table>
    </body>
</html>
