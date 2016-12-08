<%-- 
    Document   : aisoutputindicators
    Created on : Dec 6, 2016, 3:28:13 PM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.ictc.domains.Aisdashboard"%>
<%@page import="com.grameenfoundation.ictc.models.AisDashboardModel"%>
<%@page import="com.grameenfoundation.ictc.utils.BIDashboard"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.utils.BIDataManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.*"%>
<%
     
       String output = "outputindicator";
      BIDataManager bi = BIDataManager.getInstance();
      AisDashboardModel ais = new AisDashboardModel();
      JSONObject x = new JSONObject(ais.getIndicatorWrapper(Aisdashboard.TYPE, output).getData());

       JSONObject in = x.getJSONObject("outindicators");
    
     
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Output Indicators</title>
        <content tag="stylesheets">
        <!-- Datatables -->
        <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
        <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
        <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
        <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

      </content>
    </head>
    
    <body class="nav-md">
        
           <!-- Output Indicators -->
            <div style="margin-bottom: 30px; margin-top:30px" class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Output Indicators <small></small></h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li>
                               
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>

                        <div class="x_content">
                            <table id="output-table" class="table table-striped table-bordered jambo_table">
                                <thead>
                                    <tr>
                                        <th>Indicator</th>
                                        <th>Number of Farmers</th>
                                        <!--<th>Land Area/Quantity</th>-->
                                    </tr>
                                </thead>
                                <tbody>
                                     <tr>
                                        <td>Using improved practices and technologies</td>
                                        <td><%= in.get("ipt")  %></td>
                                        <!--<td><%= x.getString("ipt_area")%></td>-->
                                    </tr>
                                    <tr>
                                        <td>Using improved seed</td>
                                        <td><%= in.get("is")   %></td>
                                        <!--<td><%= x.getString("is_area")%></td>-->
                                    </tr>
                                      <tr>
                                        <td>Using recommended crop density and arrangement</td>
                                        <td><%= in.get("cda") %></td>
                                        <!--<td><%= x.getString("cda_area")%></td>-->
                                    </tr>
                                    <tr>
                                        <td>Using pre-plant herbicide</td>
                                        <td><%= in.get("preh") %></td>
                                        <!--<td><%= x.getString("preh_area")%></td>-->
                                    </tr>
                                     <tr>
                                        <td>Using post-plant herbicide</td>
                                        <td><%= in.get("posth")  %></td>
                                        <!--<td><%= x.getString("posth_area")%></td>-->
                                    </tr>
                                    <tr>
                                        <td>Using inorganic fertilizer</td>
                                        <td><%= in.get("if")   %></td>
                                        <!--<td><%= x.getString("if_area")%></td>-->
                                    </tr>
                                     <tr>
                                        <td>Using post-harvest thresher</td>
                                        <td><%= in.get("pht")  %></td>
                                       <!-- <td><%= x.getString("pht_area")%></td>-->
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
            </div>
    </body>
</html>
