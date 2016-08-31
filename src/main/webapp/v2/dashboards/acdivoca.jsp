<%@page import="java.util.List" %>
<%@page import="com.grameenfoundation.ictc.utils.BIDashboard" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    BIDashboard data = new BIDashboard("acdivoca");
    List<String> crops = data.getCrops();
    List<String> locations = data.getLocations();
%>
<!DOCTYPE html>
<html>
    <head>
        <title>ACDI VOCA Dashboard</title>

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
                <h3>ACDI VOCA Dashboard <small>indicators</small></h3>
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
                                <li>
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
                                        <th>Land Area/Quantity</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
            </div>

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
                                    <td>Farmers Registered (% of target)</td>
                                    <td><%= data.getFarmerRegistrationTotalForACDI() %> / <%= data.getFarmerRegistrationTargetForACDI() %> (<%= data.getFarmerRegistrationProgressForACDI()%>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through Previous Performance (Production, Post-harvest, Credit)</td>
                                    <td><%= data.getFarmerPPTotalForACDI() %> (<%= data.getFarmerPPProgressForACDI() %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through FMP (Production, Post-harvest, Credit)</td>
                                    <td><%= data.getFarmerFMPTotalForACDI() %> (<%= data.getFarmerFMPProgressForACDI() %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through FMP Update (Production, Harvest, Post-harvest, Marketing, Credit)</td>
                                    <td><%= data.getFarmerFMPUpdateTotalForACDI() %> (<%= data.getFarmerFMPUpdateProgressForACDI() %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farms (% of target) measured</td>
                                    <td><%= data.getFarmerFarmsMeasuredTotalForACDI() %> (<%= data.getFarmerFarmsMeasuredProgressForACDI() %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farms (% of target) assessed</td>
                                    <td><%= data.getFarmerFarmsAssessedTotalForACDI() %> (<%= data.getFarmerFarmsAssessedProgressForACDI() %>%)</td>
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
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Agents Registered (% of target)</td>
                                <td><%= data.getAgentRegistrationTotalForACDI() %> / <%= data.getAgentRegistrationTargetForACDI() %> (<%= data.getAgentRegistrationProgressForACDI()%>%)</td>
                            </tr>
                            <tr>
                                <td style="width: 20%">Number of agents (% of target) with more than 50 Previous Performance surveys (Production, Post-harvest, Credit) completed</td>
                                <td><%= data.getAgentPPTotalForACDI() %> (<%= data.getAgentPPProgressForACDI() %>%)</td>
                            </tr>
                            <tr>
                                <td style="width: 20%">Number of agents (% of target) with more than 50 FMP (Production, Post-harvest, Credit) completed</td>
                                <td><%= data.getAgentFMPTotalForACDI() %> (<%= data.getAgentFMPProgressForACDI() %>%)</td>
                            </tr>
                            <tr>
                                <td style="width: 20%">Number of agents (% of target) with more than 50 FMP Update (Production, Harvest, Post-harvest, Marketing, Credit) completed</td>
                                <td><%= data.getAgentFMPUpdateTotalForACDI() %> (<%= data.getAgentFMPUpdateProgressForACDI() %>%)</td>
                            </tr>
                            <tr>
                                <td style="width: 20%">Number of agents (% of target) who have measured more than 50 farms</td>
                                <td><%= data.getAgentFarmsMeasuredTotalForACDI() %> (<%= data.getAgentFarmsMeasuredProgressForACDI() %>%)</td>
                            </tr>
                            <tr>
                                <td style="width: 20%">Number of agents (% of target) who have assessed more than 50 farms</td>
                                <td><%= data.getAgentFarmsAssessedTotalForACDI() %> (<%= data.getAgentFarmsAssessedProgressForACDI() %>%)</td>
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
                var getAjaxUrl = function(table) {
                    return  "<%= request.getContextPath() %>/api/v1?action=get_bi_data&partner=ACDIVOCA"
                            + "&gender=" + $("#gender-"+table).val()
                            + "&location=" + $("#location-"+table).val()
                            + "&crop=" + $("#crop-"+table).val()
                            + "&data_set=gf-get-" + table;
                }

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

                var oajax =  {ajax:{ url: getAjaxUrl("output-table")  }};
                var ocolumns = {columns: [ { "data": "indicator" }, { "data": "farmers" }, { "data": "area" } ]};
                var oopts = $.extend({}, options, oajax, ocolumns);
                var outputTable = $('#output-table').DataTable(oopts);

                $("#gender-output-table").change(function() { console.log("changing"); outputTable.ajax.url(getAjaxUrl("output-table")).load(); });
                $("#location-output-table").change(function() { outputTable.ajax.url(getAjaxUrl("output-table")).load(); });
                $("#crop-output-table").change(function() { outputTable.ajax.url(getAjaxUrl("output-table")).load(); });
            });
        </script>
        <!-- /Datatables -->

    </content>
</html>
