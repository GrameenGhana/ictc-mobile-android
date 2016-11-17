<%-- 
    Document   : farmermonitoring
    Created on : Nov 15, 2016, 3:43:31 PM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.ictc.utils.BIDashboard"%>
<%@page import="com.grameenfoundation.ictc.utils.TempReport"%>
<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    BIDashboard data = new BIDashboard("acdivoca");
    BiodataModel bio = new BiodataModel();   
    TempReport temp = new TempReport();
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
                                    <!--<td><%= data.getFarmerRegistrationTotalForACDI() %> / <%= data.getFarmerRegistrationTargetForACDI() %> (<%= data.getFarmerRegistrationProgressForACDI()%>%)</td>-->
                                    <td><%= bio.getACDIVOCAFarmerCount()%> / <%= data.getFarmerRegistrationTargetForACDI() %> (<%= temp.getFarmerRegistrationProgressForACDI()  %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through Previous Performance Production</td>
                                   <!-- <td><%= data.getFarmerPPTotalForACDI() %> (<%= data.getFarmerPPProgressForACDI() %>%)</td>-->
                                    <td><%= bio.getACDIVOCABaselineProductionCount() %> (<%= temp.getFarmerPPProgressForACDI() %>%)</td> 
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through Previous Performance PostHarvest</td>
                                   <!-- <td><%= data.getFarmerPPTotalForACDI() %> (<%= data.getFarmerPPProgressForACDI() %>%)</td>-->
                                    <td><%= bio.getACDIVOCABaselinePostHarvestCount() %> (<%= temp.getFarmerPHProgressForACDI() %>%)</td> 
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through Previous Performance Credit</td>
                                   <!-- <td><%= data.getFarmerPPTotalForACDI() %> (<%= data.getFarmerPPProgressForACDI() %>%)</td>-->
                                    <td><%= bio.getACDIVOCAFarmCreditPreviousCount() %> (<%= temp.getFarmerFCPPHProgressForACDI() %>%)</td> 
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target)  coached to produce Farm Management Plan on Production</td>
                                    <!--<td><%= data.getFarmerFMPTotalForACDI() %> (<%= data.getFarmerFMPProgressForACDI() %>%)</td>-->
                                     <td><%= bio.getACDIVOCAFMPProductionCount() %> (<%= temp.getFarmerFMPPProgressForACDI() %>%)</td>
                                </tr>
                                 <tr>
                                    <td style="width: 20%">Number of farmers (% of target)  coached to produce Farm Management Plan on PostHarvest</td>
                                    <!--<td><%= data.getFarmerFMPTotalForACDI() %> (<%= data.getFarmerFMPProgressForACDI() %>%)</td>-->
                                     <td><%= bio.getACDIVOCAFMPPostHarvestCount() %> (<%= temp.getFarmerFMPPHProgressForACDI() %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target)  coached to produce Farm Management Plan on Credit</td>
                                    <!--<td><%= data.getFarmerFMPTotalForACDI() %> (<%= data.getFarmerFMPProgressForACDI() %>%)</td>-->
                                     <td><%= bio.getACDIVOCAFFarmCreditPlanCount() %> (<%= temp.getFarmerFCPPHProgressForACDI() %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farms (% of target) measured</td>
                                   <!-- <td><%= bio.getACDIVOCAFFMPProductionUpdateCount()%> (<%= data.getFarmerFarmsMeasuredProgressForACDI() %>%)</td>-->
                                    <td><%= bio.getACDIVOCAFFMPProductionUpdateCount() %> (<%= temp.getFarmerPUProgressForACDI() %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farms (% of target) assessed</td>
                                    <!--<td><%= data.getFarmerFarmsAssessedTotalForACDI() %> (<%= data.getFarmerFarmsAssessedProgressForACDI() %>%)</td>-->
                                    <td><%= bio.getACDIVOCAFCPCount() %> (<%= temp.getFarmerFCAProgressForACDI()  %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through FMP Update Production</td>
                                   <!--<td><%= data.getFarmerFMPUpdateTotalForACDI() %> (<%= data.getFarmerFMPUpdateProgressForACDI() %>%)</td>-->
                                     <td><%= bio.getACDIVOCAFFMPProductionUpdateCount() %> (<%= temp.getFarmerPUProgressForACDI() %>%)</td>
                                </tr>
                                <tr>
                                   <td style="width: 20%">Number of farmers (% of target) taken through FMP Update Post Harvest</td>
                                    <td><%= bio.getACDIVOCAPostHarvestUpdateCount() %> (<%= temp.getFarmerPHUProgressForACDI() %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through FMP Update Credit</td>
                                    <td><%= bio.getACDIVOCAFarmCreditUpdateCount() %> (<%= temp.getFarmerFCUProgressForACDI() %>%)</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
    </body>
</html>
