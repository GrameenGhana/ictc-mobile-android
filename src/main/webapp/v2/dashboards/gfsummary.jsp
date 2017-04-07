<%-- 
    Document   : gfsummary
    Created on : Mar 27, 2017, 3:29:12 PM
    Author     : spomega
--%>

<%@page import="org.json.JSONObject"%>
<%@page import="com.grameenfoundation.ictc.utils.BIDataManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
      BIDataManager bi = BIDataManager.getInstance();
      JSONObject data = bi.getGFSummary();

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary</title>
    <content tag="stylesheets">
        <!-- bootstrap-progressbar -->
        <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    </content>
    </head>
    <body>
          <div class="row top_tiles" style="margin: 10px 0;">
        <div class="col-md-4 col-sm-4 col-xs-8 tile">
            <span>Farmers registered</span>
            <h2><%= data.get("farmers") %></h2>
            <span class="sparkline_tf" style="height: 160px;">
                <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
            </span>
        </div>
        <div class="col-md-4 col-sm-4 col-xs-8 tile">
            <span>Farmers profiled</span>
            <h2><%=data.get("profiling")%></h2>
            <span class="sparkline_tc" style="height: 160px;">
                <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
            </span>
        </div>
        <div class="col-md-4 col-sm-4 col-xs-8 tile">
            <span>Farmers coached on Production through Farm Management Plan</span>
            <h2><%=data.get("fmp")%></h2>
            <span class="sparkline_ta" style="height: 160px;">
                  <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
            </span>
        </div>
            
            <div class="col-md-4 col-sm-4 col-xs-8 tile">
                <span>Farmers coached on Post harvest through Farm Management Plan</span>
                <h2><%=data.get("fmph")%></h2>
                <span class="sparkline_ta" style="height: 160px;">
                    <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
                </span>
            </div>

         <div class="col-md-4 col-sm-4 col-xs-8 tile">
            <span>Farmers coached on Farm Credit through Farm Management Plan </span>
            <h2><%=data.get("credit")%></h2>
            <span class="sparkline_ta" style="height: 160px;">
                  <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
            </span>
        </div>
        <div class="col-md-4 col-sm-4 col-xs-8 tile">
            <span>Farms measured </span>
            <h2><%=data.get("measurement")%></h2>
            <span class="sparkline_ta" style="height: 160px;">
                  <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
            </span>
        </div>
         <div class="col-md-4 col-sm-4 col-xs-8 tile">
            <span>Updated Post-harvest information </span>
            <h2><%=data.get("postharvestupdate")%></h2>
            <span class="sparkline_ta" style="height: 160px;">
                  <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
            </span>
        </div>
            
            
         <div class="col-md-4 col-sm-4 col-xs-8 tile">
            <span>Updated Production information </span>
            <h2><%=data.get("measurement")%></h2>
            <span class="sparkline_ta" style="height: 160px;">
                  <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
            </span>
        </div>
            
         <div class="col-md-4 col-sm-4 col-xs-8 tile">
            <span>Updated Production information </span>
            <h2><%=data.get("measurement")%></h2>
            <span class="sparkline_ta" style="height: 160px;">
                  <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
            </span>
        </div>
    </div>
    </body>
</html>
