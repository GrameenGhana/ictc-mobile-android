<%-- 
    Document   : gfsummary
    Created on : Mar 27, 2017, 3:29:12 PM
    Author     : spomega
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <span>Total Farmers</span>
            <h2>5000</h2>
            <span class="sparkline_tf" style="height: 160px;">
                <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
            </span>
        </div>
        <div class="col-md-4 col-sm-4 col-xs-8 tile">
            <span>Total Communities</span>
            <h2>100</h2>
            <span class="sparkline_tc" style="height: 160px;">
                <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
            </span>
        </div>
        <div class="col-md-4 col-sm-4 col-xs-8 tile">
            <span>Total Agents</span>
            <h2>100</h2>
            <span class="sparkline_ta" style="height: 160px;">
                  <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
            </span>
        </div>
    </div>
    </body>
</html>
