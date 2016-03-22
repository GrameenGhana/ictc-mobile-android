<%-- 
    Document   : kpi
    Created on : Aug 18, 2015, 1:36:28 PM
    Author     : skwakwa
--%>
<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<% 
BiodataModel bio = new BiodataModel();

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="span4">
            <div class="widget widget-nopad">
                <div class="widget-header"> <i class="icon-list-alt"></i>
                    <h3>ICTC Data</h3>
                </div>
                <!-- /widget-header -->
                <div class="widget-content">
                    <div class="widget big-stats-container">
                        <div class="widget-content"  style="padding: 5px">
                           
                            <table class='table table-striped table-bordered' >
                                <tr>
                                    <th>Parameters</th>
                                    <th>Values</th>
                                </tr>
                               
                                  <tr>
                                    <td>Farmers</td>
                                    <td><%= bio.getFarmerCount()%></td>
                                </tr>
                                 

                                <tr>
                                    <td>Profiling</td>
                                    <td><%= bio.getProfileCount() %></td>
                                </tr>
                                 <tr>
                                      <td>Baseline Production</td>
                                    <td><%= bio.getBaselineProductionCount() %></td>
                                </tr>
                                <tr>
                                    <td>Baseline Production Budget</td>
                                    <td><%= bio.getBaselineProductionBudgetCount() %></td>
                                </tr>
                                
                                <tr>
                                    <td>FMP Production</td>
                                    <td><%= bio.getFMPProductionCount()   %></td>
                                </tr>
                                <tr>
                                    <td>FMP Production Budget</td>
                                    <td><%= bio.getFMPProductionBudgetCount()   %></td>
                                </tr>
                                
                                <tr>
                                    <td>Baseline Post Harvest</td>
                                    <td><%= bio.getBaselinePostHarvestCount()   %></td>
                                </tr>
                                
                                <tr>
                                    <td>Baseline Post Harvest Budget</td>
                                    <td><%= bio.getBaselinePostHarvestBudgetCount()   %></td>
                                </tr>
                                <tr>
                                    <td>FMP Post Harvest</td>
                                    <td><%= bio.getFMPPostHarvestCount()   %></td>
                                </tr>
                                <tr>
                                    <td>FMP Post Harvest Budget</td>
                                    <td><%= bio.getFMPPostHarvestBudgetCount()  %></td>
                                </tr>
                                <tr>
                                    <td>Crop Assessment</td>
                                    <td><%= bio.getCropAssessmentCount()  %></td>
                                </tr>
                                <tr>
                                    <td>Updates</td>
                                    <td><%= bio.getUpdateCount()  %></td>
                                </tr>
                                
                            </table>
                        </div>
                    </div>
                    <!-- /widget-content --> 

                </div>
            </div>
        </div>
    </body>
</html>
