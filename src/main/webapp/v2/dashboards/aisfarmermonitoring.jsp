<%-- 
    Document   : aisfarmermonitoring
    Created on : Dec 6, 2016, 3:42:06 PM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.ictc.models.AisDashboardModel"%>
<%@page import="com.grameenfoundation.ictc.domains.Aisdashboard"%>
<%@page import="com.grameenfoundation.ictc.utils.BIDashboard"%>
<%@page import="com.grameenfoundation.ictc.utils.TempReport"%>
<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%@page import="org.json.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    
    AisDashboardModel  ais  = new AisDashboardModel(); 
    String farm = "farmmonitoring";
    
    JSONObject  fact =  new JSONObject(ais.getIndicatorWrapper(Aisdashboard.TYPE,farm).getData());
    JSONObject  f = fact.getJSONObject(farm);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Farmer Monitoring Activity</title>
    </head>
    <body>
                 <!-- Farmer Monitoring -->
            <div style="margin-bottom: 30px" class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Farmer Activity Monitoring <small></small></h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <table id="farmer-monitoring-table" class="table table-striped table-bordered  jambo_table">
                            <thead>
                            <tr>
                                <th>Indicator</th>
                                <th>ICTC-ACDI/VOCA</th>
                            </tr>
                            </thead>
                            <tbody>
                                 <tr>
                                    <td>Number of farmers with access to Agent (registered)(% of target)</td>
                                    
                                    <td><%= f.get("farmercount")%></td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through Previous Performance Production</td>
                                    <td><%= f.get("baselineproduction") %></td> 
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through Previous Performance PostHarvest</td>
                                    <td><%= f.get("baselinepostharvest") %></td> 
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through Previous Performance Credit</td>
                                    <td><%= f.get("farmcreditprevious") %></td> 
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target)  coached to produce Farm Management Plan on Production</td>
                                    <td><%= f.get("fmpproduction") %></td>
                                </tr>
                                 <tr>
                                    <td style="width: 20%">Number of farmers (% of target)  coached to produce Farm Management Plan on PostHarvest</td>
                                    <td><%= f.get("fmppostharvest") %></td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target)  coached to produce Farm Management Plan on Credit</td>
                                    <td><%= f.get("farmcreditplan") %></td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farms (% of target) measured</td>
                                    <td><%= f.get("fmpproductionupdate")%></td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farms (% of target) assessed</td>
                                   <td><%= f.get("fieldcropassessment")%></td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through FMP Update Production</td>
                                    <td><%= f.get("fmpproductionupdate")%></td>
                                </tr>
                                <tr>
                                   <td style="width: 20%">Number of farmers (% of target) taken through FMP Update Post Harvest</td>
                                    <td><%= f.get("fmppostharvestupdate") %></td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through FMP Update Credit</td>
                                    <td><%= f.get("farmcreditupdate")%></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
    </body>
</html>

