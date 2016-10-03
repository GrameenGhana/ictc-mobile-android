<%@page import="com.grameenfoundation.ictc.utils.BIDataManager"%>
<%@page import="java.util.List" %>
<%@page import="com.grameenfoundation.ictc.utils.BIDashboard" %>
<%@page import="org.json.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    BIDashboard data = new BIDashboard("gf");
    BIDataManager bi = BIDataManager.getInstance();
    List<String> crops = data.getCrops();
    List<String> locations = data.getLocations();
    
    JSONObject  x = data.getACDIVOCADATA();
    JSONObject  in = bi.getIndicatorInfo("GRAMEEN");
    System.out.println(in.toString());
    
    
%>
<!DOCTYPE html>
<html>
    <head>
        <title>GF Dashboard</title>

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

        <div class="page-title" style="margin-bottom: 30px;">
            <div class="title_left">
                <h3>Grameen Dashboard <small>indicators for m&e</small></h3>
            </div>
        </div>

        <div class="clearfix"></div>

        <div class="row">

            <!-- Output Indicators -->
            <div style="margin-bottom: 30px; margin-top:30px" class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Output Indicators <small></small></h2>
                            <ul class="nav navbar-right panel_toolbox">
                               <!-- <li>
                                <form id="output-form" class="form-inline" method="get">
                                    <div class="form-group">
                                        <select id="gender-output-table" class="form-control">
                                            <option value="all">Gender: All</option>
                                            <option value="female">Female</option>
                                            <option value="male">Male</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <select id="location-output-table" class="form-control">
                                            <option value="all">Location: All</option>
                                            <% for(String l : locations ) { %>
                                                <option value="<%=l%>"><%=l%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <select id="crop-output-table" class="form-control">
                                            <option value="all">Crops: All</option>
                                            <% for(String c : crops ) { %>
                                            <option value="<%=c%>"><%=c%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                </form>
                                </li>-->
                            </ul>
                            <div class="clearfix"></div>
                        </div>

                        <div class="x_content">
                            <table id="output-table" class="table table-striped table-bordered jambo_table">
                                <thead>
                                    <tr>
                                        <th>Indicator</th>
                                        <th>Number of Farmers</th>
                                       <!-- <th>Land Area/Quantity</th>-->
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

            <!-- Activity Indicators
            <div style="margin-bottom: 30px" class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Activity Indicators <small></small></h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li>
                                    <form id="activity-form" class="form-inline" method="get">
                                    <div class="form-group">
                                        <select id="gender-activity-table" class="form-control">
                                            <option value="all">Gender: All</option>
                                            <option value="female">Female</option>
                                            <option value="male">Male</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <select id="location-activity-table" class="form-control">
                                            <option value="all">Location: All</option>
                                            <% for(String l : locations ) { %>
                                            <option value="<%=l%>"><%=l%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <select id="crop-activity-table" class="form-control">
                                            <option value="all">Crops: All</option>
                                            <% for(String c : crops ) { %>
                                            <option value="<%=c%>"><%=c%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                    </form>
                                </li>
                            </ul>

                            <div class="clearfix"></div>
                        </div>

                        <div class="x_content">
                            <table id="activity-table" class="table table-striped table-bordered jambo_table">
                                <thead>
                                    <tr>
                                        <th>Indicator</th>
                                        <th>Number of Farmers</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            -->

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
                                <th>ICTC-MOFA</th>
                                <th>AIS-BA</th>
                                <th>AIS-UE</th>
                                <th>AIS-UW</th>
                                <th>AIS-NR</th>
                                <th>AIS-VR</th>
                            </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Farmers Registered (% of target)</td>
                                    <td><%= data.getFarmerRegistrationTotalForACDI() %> / <%= data.getFarmerRegistrationTargetForACDI() %> (<%= data.getFarmerRegistrationProgressForACDI()%>%)</td>
                                    <td><%= data.getFarmerRegistrationTotalForMOFA() %> / <%= data.getFarmerRegistrationTargetForMOFA() %> (<%= data.getFarmerRegistrationProgressForMOFA()%>%)</td>
                                    <td><%= data.getFarmerRegistrationTotalForAISBA() %> / <%= data.getFarmerRegistrationTargetForAISBA() %> (<%= data.getFarmerRegistrationProgressForAISBA()%>%)</td>
                                    <td><%= data.getFarmerRegistrationTotalForAISUE() %> / <%= data.getFarmerRegistrationTargetForAISUE() %> (<%= data.getFarmerRegistrationProgressForAISUE()%>%)</td>
                                    <td><%= data.getFarmerRegistrationTotalForAISUW() %> / <%= data.getFarmerRegistrationTargetForAISUW() %> (<%= data.getFarmerRegistrationProgressForAISUW()%>%)</td>
                                    <td><%= data.getFarmerRegistrationTotalForAISNR() %> / <%= data.getFarmerRegistrationTargetForAISNR() %> (<%= data.getFarmerRegistrationProgressForAISNR()%>%)</td>
                                    <td><%= data.getFarmerRegistrationTotalForAISVR() %> / <%= data.getFarmerRegistrationTargetForAISVR() %> (<%= data.getFarmerRegistrationProgressForAISVR()%>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through Previous Performance (Production, Post-harvest, Credit)</td>
                                    <td><%= data.getFarmerPPTotalForACDI() %> (<%= data.getFarmerPPProgressForACDI() %>%)</td>
                                    <td><%= data.getFarmerPPTotalForMOFA() %> (<%= data.getFarmerPPProgressForMOFA() %>%)</td>
                                    <td><%= data.getFarmerPPTotalForAISBA() %> (<%= data.getFarmerPPProgressForAISBA() %>%)</td>
                                    <td><%= data.getFarmerPPTotalForAISUE() %> (<%= data.getFarmerPPProgressForAISUE() %>%)</td>
                                    <td><%= data.getFarmerPPTotalForAISUW() %> (<%= data.getFarmerPPProgressForAISUW() %>%)</td>
                                    <td><%= data.getFarmerPPTotalForAISNR() %> (<%= data.getFarmerPPProgressForAISNR() %>%)</td>
                                    <td><%= data.getFarmerPPTotalForAISVR() %> (<%= data.getFarmerPPProgressForAISVR() %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through FMP (Production, Post-harvest, Credit)</td>
                                    <td><%= data.getFarmerFMPTotalForACDI() %> (<%= data.getFarmerFMPProgressForACDI() %>%)</td>
                                    <td><%= data.getFarmerFMPTotalForMOFA() %> (<%= data.getFarmerFMPProgressForMOFA() %>%)</td>
                                    <td><%= data.getFarmerFMPTotalForAISBA() %> (<%= data.getFarmerFMPProgressForAISBA() %>%)</td>
                                    <td><%= data.getFarmerFMPTotalForAISUE() %> (<%= data.getFarmerFMPProgressForAISUE() %>%)</td>
                                    <td><%= data.getFarmerFMPTotalForAISUW() %> (<%= data.getFarmerFMPProgressForAISUW() %>%)</td>
                                    <td><%= data.getFarmerFMPTotalForAISNR() %> (<%= data.getFarmerFMPProgressForAISNR() %>%)</td>
                                    <td><%= data.getFarmerFMPTotalForAISVR() %> (<%= data.getFarmerFMPProgressForAISVR() %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through FMP Update (Production, Harvest, Post-harvest, Marketing, Credit)</td>
                                    <td><%= data.getFarmerFMPUpdateTotalForACDI() %> (<%= data.getFarmerFMPUpdateProgressForACDI() %>%)</td>
                                    <td><%= data.getFarmerFMPUpdateTotalForMOFA() %> (<%= data.getFarmerFMPUpdateProgressForMOFA() %>%)</td>
                                    <td><%= data.getFarmerFMPUpdateTotalForAISBA() %> (<%= data.getFarmerFMPUpdateProgressForAISBA() %>%)</td>
                                    <td><%= data.getFarmerFMPUpdateTotalForAISUE() %> (<%= data.getFarmerFMPUpdateProgressForAISUE() %>%)</td>
                                    <td><%= data.getFarmerFMPUpdateTotalForAISUW() %> (<%= data.getFarmerFMPUpdateProgressForAISUW() %>%)</td>
                                    <td><%= data.getFarmerFMPUpdateTotalForAISNR() %> (<%= data.getFarmerFMPUpdateProgressForAISNR() %>%)</td>
                                    <td><%= data.getFarmerFMPUpdateTotalForAISVR() %> (<%= data.getFarmerFMPUpdateProgressForAISVR() %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farms (% of target) measured</td>
                                    <td><%= data.getFarmerFarmsMeasuredTotalForACDI() %> (<%= data.getFarmerFarmsMeasuredProgressForACDI() %>%)</td>
                                    <td><%= data.getFarmerFarmsMeasuredTotalForMOFA() %> (<%= data.getFarmerFarmsMeasuredProgressForMOFA() %>%)</td>
                                    <td><%= data.getFarmerFarmsMeasuredTotalForAISBA() %> (<%= data.getFarmerFarmsMeasuredProgressForAISBA() %>%)</td>
                                    <td><%= data.getFarmerFarmsMeasuredTotalForAISUE() %> (<%= data.getFarmerFarmsMeasuredProgressForAISUE() %>%)</td>
                                    <td><%= data.getFarmerFarmsMeasuredTotalForAISUW() %> (<%= data.getFarmerFarmsMeasuredProgressForAISUW() %>%)</td>
                                    <td><%= data.getFarmerFarmsMeasuredTotalForAISNR() %> (<%= data.getFarmerFarmsMeasuredProgressForAISNR() %>%)</td>
                                    <td><%= data.getFarmerFarmsMeasuredTotalForAISVR() %> (<%= data.getFarmerFarmsMeasuredProgressForAISVR() %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farms (% of target) assessed</td>
                                    <td><%= data.getFarmerFarmsAssessedTotalForACDI() %> (<%= data.getFarmerFarmsAssessedProgressForACDI() %>%)</td>
                                    <td><%= data.getFarmerFarmsAssessedTotalForMOFA() %> (<%= data.getFarmerFarmsAssessedProgressForMOFA() %>%)</td>
                                    <td><%= data.getFarmerFarmsAssessedTotalForAISBA() %> (<%= data.getFarmerFarmsAssessedProgressForAISBA() %>%)</td>
                                    <td><%= data.getFarmerFarmsAssessedTotalForAISUE() %> (<%= data.getFarmerFarmsAssessedProgressForAISUE() %>%)</td>
                                    <td><%= data.getFarmerFarmsAssessedTotalForAISUW() %> (<%= data.getFarmerFarmsAssessedProgressForAISUW() %>%)</td>
                                    <td><%= data.getFarmerFarmsAssessedTotalForAISNR() %> (<%= data.getFarmerFarmsAssessedProgressForAISNR() %>%)</td>
                                    <td><%= data.getFarmerFarmsAssessedTotalForAISVR() %> (<%= data.getFarmerFarmsAssessedProgressForAISVR() %>%)</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <!-- Agent Monitoring -->
            <div style="margin-bottom: 30px" class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Agent Activity Monitoring <small></small></h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <table id="agent-monitoring-table" class="table table-striped table-bordered jambo_table">
                            <thead>
                            <tr>
                                <th>Indicator</th>
                                <th>ICTC-ACDI/VOCA</th>
                                <th>ICTC-MOFA</th>
                                <th>AIS-BA</th>
                                <th>AIS-UE</th>
                                <th>AIS-UW</th>
                                <th>AIS-NR</th>
                                <th>AIS-VR</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Agents Registered (% of target)</td>
                                <td><%= data.getAgentRegistrationTotalForACDI() %> / <%= data.getAgentRegistrationTargetForACDI() %> (<%= data.getAgentRegistrationProgressForACDI()%>%)</td>
                                <td><%= data.getAgentRegistrationTotalForMOFA() %> / <%= data.getAgentRegistrationTargetForMOFA() %> (<%= data.getAgentRegistrationProgressForMOFA()%>%)</td>
                                <td><%= data.getAgentRegistrationTotalForAISBA() %> / <%= data.getAgentRegistrationTargetForAISBA() %> (<%= data.getAgentRegistrationProgressForAISBA()%>%)</td>
                                <td><%= data.getAgentRegistrationTotalForAISUE() %> / <%= data.getAgentRegistrationTargetForAISUE() %> (<%= data.getAgentRegistrationProgressForAISUE()%>%)</td>
                                <td><%= data.getAgentRegistrationTotalForAISUW() %> / <%= data.getAgentRegistrationTargetForAISUW() %> (<%= data.getAgentRegistrationProgressForAISUW()%>%)</td>
                                <td><%= data.getAgentRegistrationTotalForAISNR() %> / <%= data.getAgentRegistrationTargetForAISNR() %> (<%= data.getAgentRegistrationProgressForAISNR()%>%)</td>
                                <td><%= data.getAgentRegistrationTotalForAISVR() %> / <%= data.getAgentRegistrationTargetForAISVR() %> (<%= data.getAgentRegistrationProgressForAISVR()%>%)</td>
                            </tr>
                            <tr>
                                <td style="width: 20%">Number of agents (% of target) with more than 50 Previous Performance surveys (Production, Post-harvest, Credit) completed</td>
                                <td><%= data.getAgentPPTotalForACDI() %> (<%= data.getAgentPPProgressForACDI() %>%)</td>
                                <td><%= data.getAgentPPTotalForMOFA() %> (<%= data.getAgentPPProgressForMOFA() %>%)</td>
                                <td><%= data.getAgentPPTotalForAISBA() %> (<%= data.getAgentPPProgressForAISBA() %>%)</td>
                                <td><%= data.getAgentPPTotalForAISUE() %> (<%= data.getAgentPPProgressForAISUE() %>%)</td>
                                <td><%= data.getAgentPPTotalForAISUW() %> (<%= data.getAgentPPProgressForAISUW() %>%)</td>
                                <td><%= data.getAgentPPTotalForAISNR() %> (<%= data.getAgentPPProgressForAISNR() %>%)</td>
                                <td><%= data.getAgentPPTotalForAISVR() %> (<%= data.getAgentPPProgressForAISVR() %>%)</td>
                            </tr>
                            <tr>
                                <td style="width: 20%">Number of agents (% of target) with more than 50 FMP (Production, Post-harvest, Credit) completed</td>
                                <td><%= data.getAgentFMPTotalForACDI() %> (<%= data.getAgentFMPProgressForACDI() %>%)</td>
                                <td><%= data.getAgentFMPTotalForMOFA() %> (<%= data.getAgentFMPProgressForMOFA() %>%)</td>
                                <td><%= data.getAgentFMPTotalForAISBA() %> (<%= data.getAgentFMPProgressForAISBA() %>%)</td>
                                <td><%= data.getAgentFMPTotalForAISUE() %> (<%= data.getAgentFMPProgressForAISUE() %>%)</td>
                                <td><%= data.getAgentFMPTotalForAISUW() %> (<%= data.getAgentFMPProgressForAISUW() %>%)</td>
                                <td><%= data.getAgentFMPTotalForAISNR() %> (<%= data.getAgentFMPProgressForAISNR() %>%)</td>
                                <td><%= data.getAgentFMPTotalForAISVR() %> (<%= data.getAgentFMPProgressForAISVR() %>%)</td>
                            </tr>
                            <tr>
                                <td style="width: 20%">Number of agents (% of target) with more than 50 FMP Update (Production, Harvest, Post-harvest, Marketing, Credit) completed</td>
                                <td><%= data.getAgentFMPUpdateTotalForACDI() %> (<%= data.getAgentFMPUpdateProgressForACDI() %>%)</td>
                                <td><%= data.getAgentFMPUpdateTotalForMOFA() %> (<%= data.getAgentFMPUpdateProgressForMOFA() %>%)</td>
                                <td><%= data.getAgentFMPUpdateTotalForAISBA() %> (<%= data.getAgentFMPUpdateProgressForAISBA() %>%)</td>
                                <td><%= data.getAgentFMPUpdateTotalForAISUE() %> (<%= data.getAgentFMPUpdateProgressForAISUE() %>%)</td>
                                <td><%= data.getAgentFMPUpdateTotalForAISUW() %> (<%= data.getAgentFMPUpdateProgressForAISUW() %>%)</td>
                                <td><%= data.getAgentFMPUpdateTotalForAISNR() %> (<%= data.getAgentFMPUpdateProgressForAISNR() %>%)</td>
                                <td><%= data.getAgentFMPUpdateTotalForAISVR() %> (<%= data.getAgentFMPUpdateProgressForAISVR() %>%)</td>
                            </tr>
                            <tr>
                                <td style="width: 20%">Number of agents (% of target) who have measured more than 50 farms</td>
                                <td><%= data.getAgentFarmsMeasuredTotalForACDI() %> (<%= data.getAgentFarmsMeasuredProgressForACDI() %>%)</td>
                                <td><%= data.getAgentFarmsMeasuredTotalForMOFA() %> (<%= data.getAgentFarmsMeasuredProgressForMOFA() %>%)</td>
                                <td><%= data.getAgentFarmsMeasuredTotalForAISBA() %> (<%= data.getAgentFarmsMeasuredProgressForAISBA() %>%)</td>
                                <td><%= data.getAgentFarmsMeasuredTotalForAISUE() %> (<%= data.getAgentFarmsMeasuredProgressForAISUE() %>%)</td>
                                <td><%= data.getAgentFarmsMeasuredTotalForAISUW() %> (<%= data.getAgentFarmsMeasuredProgressForAISUW() %>%)</td>
                                <td><%= data.getAgentFarmsMeasuredTotalForAISNR() %> (<%= data.getAgentFarmsMeasuredProgressForAISNR() %>%)</td>
                                <td><%= data.getAgentFarmsMeasuredTotalForAISVR() %> (<%= data.getAgentFarmsMeasuredProgressForAISVR() %>%)</td>
                            </tr>
                            <tr>
                                <td style="width: 20%">Number of agents (% of target) who have assessed more than 50 farms</td>
                                <td><%= data.getAgentFarmsAssessedTotalForACDI() %> (<%= data.getAgentFarmsAssessedProgressForACDI() %>%)</td>
                                <td><%= data.getAgentFarmsAssessedTotalForMOFA() %> (<%= data.getAgentFarmsAssessedProgressForMOFA() %>%)</td>
                                <td><%= data.getAgentFarmsAssessedTotalForAISBA() %> (<%= data.getAgentFarmsAssessedProgressForAISBA() %>%)</td>
                                <td><%= data.getAgentFarmsAssessedTotalForAISUE() %> (<%= data.getAgentFarmsAssessedProgressForAISUE() %>%)</td>
                                <td><%= data.getAgentFarmsAssessedTotalForAISUW() %> (<%= data.getAgentFarmsAssessedProgressForAISUW() %>%)</td>
                                <td><%= data.getAgentFarmsAssessedTotalForAISNR() %> (<%= data.getAgentFarmsAssessedProgressForAISNR() %>%)</td>
                                <td><%= data.getAgentFarmsAssessedTotalForAISVR() %> (<%= data.getAgentFarmsAssessedProgressForAISVR() %>%)</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </body>
    
    <content tag="scripts">
        <!-- Datatables -->
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/jszip/dist/jszip.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/pdfmake/build/pdfmake.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/pdfmake/build/vfs_fonts.js"></script>

        <!-- Datatables -->
        <script>
            $(document).ready(function() {
                 /**var getAjaxUrl = function(table) {
                  return  "<%= request.getContextPath() %>/api/v1?action=get_bi_data&partner=all"
                            + "&gender=" + $("#gender-"+table).val()
                            + "&location=" + $("#location-"+table).val()
                            + "&crop=" + $("#crop-"+table).val()
                            + "&data_set=gf-get-" + table; 
                }
                 **/
                var options = {
                    dom: "Bfrtip",
                    buttons: [
                        { extend: "copy", className: "btn-sm" },
                        { extend: "csv", className: "btn-sm" },
                        { extend: "excel", className: "btn-sm" },
                        { extend: "pdfHtml5", className: "btn-sm" },
                        { extend: "print", className: "btn-sm" },
                    ],
                    responsive: true,
                    paging: false,
                    searching: false
                };

                $("#farmer-monitoring-table").DataTable(options);
                $('#agent-monitoring-table').DataTable(options);

               // var oajax =  {ajax:{ url: getAjaxUrl("output-table")  }};
               // var ocolumns = {columns: [ { "data": "indicator" }, { "data": "farmers" }, { "data": "area" } ]};
               // var oopts = $.extend({}, options, oajax, ocolumns);
                //var outputTable = $('#output-table').DataTable(oopts);

              //  $("#gender-output-table").change(function() { console.log("changing"); outputTable.ajax.url(getAjaxUrl("output-table")).load(); });
               // $("#location-output-table").change(function() { outputTable.ajax.url(getAjaxUrl("output-table")).load(); });
               // $("#crop-output-table").change(function() { outputTable.ajax.url(getAjaxUrl("output-table")).load(); });

                //var aajax =  {ajax: { url: getAjaxUrl("activity-table") } };
                //var acolumns = {columns: [ { "data": "indicator" }, { "data": "farmers" } ] };
                //var aopts = $.extend({}, options, aajax, acolumns);
                //var activityTable = $('#activity-table').DataTable(aopts);
                //$("#gender-activity-table").change(function() { activityTable.ajax.url(getAjaxUrl("activity-table")).load(); });
                //$("#location-activity-table").change(function() { activityTable.ajax.url(getAjaxUrl("activity-table")).load(); });
                //$("#crop-activity-table").change(function() { activityTable.ajax.url(getAjaxUrl("activity-table")).load(); });
            });
        </script>
        <!-- /Datatables -->

    </content>
</html>
