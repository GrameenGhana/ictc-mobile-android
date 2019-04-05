<%-- 
    Document   : index
    Created on : Aug 13, 2015, 2:03:20 PM
    Author     : skwakwa
--%>


<%@page import="com.grameenfoundation.ictc.utils.ICTCUtil"%>
<%@page import="com.grameenfoundation.ictc.utils.ICTCDBUtil"%>
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
       String format = "EEE, MMM d, ''yy  HH:mm";
      
        SimpleDateFormat simpleDate = new SimpleDateFormat(format);
        
        String s = request.getParameter("s");
        String e = request.getParameter("d");
        SimpleDateFormat todateDate = new SimpleDateFormat(
                "yyyy-MM-dd");
        SimpleDateFormat todateDates = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        if(s==null || s.isEmpty()){
            s= todateDate.format(new Date()) ;
        }if(e==null || e.isEmpty()){
            e= todateDate.format(new Date()) ;
        }
        
   
        
       System.out.println("Start s : "+s);
       System.out.println("Start s : "+e);
        Date startDate = todateDates.parse(s+" 00:00:00");
        Date endDate = todateDates.parse(e+" 23:59:59");
        
    List<MobileTrackerWrapper> trackItems = biodataModel.findAll(startDate,endDate);
        
        
        
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logs Page</title>

    </head>
    <body>

        <form method="get">
            <table width="99%">
                <tr>
                    <td><input type="text" name="q" placeholder="search" class="form-control" /></td>
                    <td><input type="text" name="s" data-date-format="yyyy-mm-dd"  id='sdate' placeholder="Start Date"  class="form-control" value="<%=s %>"/></td>
                    <td><input type="text" name="e" data-date-format="yyyy-mm-dd" id='edate' placeholder="End Date" class="form-control"  value="<%=e %>" /></td>
                    <td><input type="submit" name="Search" value="Search" class="btn btn-info"/><a href='<%=request.getContextPath() %>//sys/report?action=logs&s=<%=s %>&e=<%=e %>'>Download</a></td>
                </tr>
                    
            </table>
        </form>
        <table class="table table-striped table-bordered myt-table">
            <thead>
            <tr>
                <th>ID</th>
                <th>User</th>
                <th>Module</th>
                <th>Page</th>
                <th>Section</th>
               
                <th>Start</th>
                <th>End</th>
                <th>Time Spent</th>
                <th>Version</th>
                <th>Battery</th>
                <th>IMEI</th>
            </tr>
            </thead>
            <tbody>
            <% for (MobileTrackerWrapper mobileTracker : trackItems) {%>
            <tr>
                <td><%= mobileTracker.getId()%></td>
                <td><%= mobileTracker.getUserId()  %></td>
                <td><%= mobileTracker.getModule()%></td>
                <td><%= mobileTracker.getPage()%></td>
                <td><%= mobileTracker.getSection()%></td>

               
                <td><%=
                simpleDate.format(new Date(mobileTracker.getStartTime()))
               %></td>
                <td><%= simpleDate.format(new Date(mobileTracker.getEndTime()))%></td>
                <td><%= String.valueOf(mobileTracker.getTimeSpent()/1000)%></td>
                <td><%= mobileTracker.getVersion()%></td>
                <td><%= mobileTracker.getBattery()%></td>
                <td><%= mobileTracker.getImei()%></td>
            </tr>
            <% }%>
</tbody>
        </table>
    </body>
    
    <content tag="scripts">
        <script type="text/javascript">
           $('#sdate').datepicker();
             $('#edate').datepicker();
        </script>
    </content>
</html>
