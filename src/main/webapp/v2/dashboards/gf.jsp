<%@page import="com.grameenfoundation.ictc.utils.TempReport"%>
<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
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
    BiodataModel bio = new BiodataModel();
    TempReport temp = new TempReport();
    JSONObject  x = data.getACDIVOCADATA();
    JSONObject  in = bi.getIndicatorInfo("GRAMEEN");
    JSONObject  mn = bi.getFarmerActivitMonitoring("MOFA");
    JSONObject  mnp = bi.getFarmerActivitMonitoringProgress("MOFA");
    JSONObject y = bi.getAllAgentActivity();
    JSONArray ja = y.getJSONArray("agentactivity");
    JSONObject b = new JSONObject();
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
                                <!--<th>AIS-BA</th>
                                <th>AIS-UE</th>
                                <th>AIS-UW</th>
                                <th>AIS-NR</th>
                                <th>AIS-VR</th-->
                            </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Number of farmers with access to Agent (registered)(% of target)</td>
                                    <td><%= bio.getACDIVOCAFarmerCount()%> / <%= data.getFarmerRegistrationTargetForACDI() %> (<%= temp.getFarmerRegistrationProgressForACDI()  %>%)</td>
                                    <td><%= bio.getMOFAFarmerCount() %> / <%= data.getFarmerRegistrationTargetForMOFA() %> (<%= temp.getFarmerRegistrationProgressForMOFA()  %>%)</td>
                                    
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through Previous Performance Production</td>
                                    <td><%= bio.getACDIVOCABaselineProductionCount() %> (<%= temp.getFarmerPPProgressForACDI() %>%)</td>
                                     <td><%= mn.get("ppp") %> (<%= mnp.get("pppp") %>%)</td> 
                                    
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through Previous Performance PostHarvest)</td>
                                   <td><%= bio.getACDIVOCABaselinePostHarvestCount() %> (<%= temp.getFarmerPHProgressForACDI() %>%)</td> 
                                     <td><%= mn.get("pph") %> (<%= mnp.get("pphp")  %>%)</td> 
                                   
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through Previous Performance Credit</td>
                                      <td><%= bio.getACDIVOCAFarmCreditPreviousCount() %> (<%= temp.getFarmerFCPPHProgressForACDI() %>%)</td> 
                                      <td><%= mn.get("fcp") %> (<%= mnp.getString("fcpp") %>%)</td> 
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target)  coached to produce Farm Management Plan on Production</td>
                                     <td><%= bio.getACDIVOCAFMPProductionCount() %> (<%= temp.getFarmerFMPPProgressForACDI() %>%)</td>
                                     <td><%= mn.get("fmp") %> (<%= mnp.getString("fmpp") %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target)  coached to produce Farm Management Plan on PostHarvest</td>
                                     <td><%= bio.getACDIVOCAFMPPostHarvestCount() %> (<%= temp.getFarmerFMPPHProgressForACDI() %>%)</td>
                                      <td><%= mn.get("fmph") %> (<%= mnp.getString("fmphp") %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target)  coached to produce Farm Management Plan on Credit</td>
            
                                     <td><%= bio.getACDIVOCAFFarmCreditPlanCount() %> (<%= temp.getFarmerFCPPHProgressForACDI() %>%)</td>
                                     <td><%= mn.get("fmpc")%> (<%= mnp.getString("fmpcp") %>%)</td>
                                </tr>
                               <tr>
                                   <td style="width: 20%">Number of farms (% of target) measured</td>
                                    <td><%= bio.getACDIVOCAFFMPProductionUpdateCount() %> (<%= temp.getFarmerPUProgressForACDI() %>%)</td>
                                    <td><%= mn.get("fm") %> (<%= mnp.getString("fmp") %>%)</td>
                                </tr>
                                 <tr>
                                    <td style="width: 20%">Number of farms (% of target) assessed</td>
                                  
                                    <td><%= bio.getACDIVOCAFCPCount() %> (<%= temp.getFarmerFCAProgressForACDI()  %>%)</td>
                                     <td><%= mn.get("fa") %> (<%= mnp.getString("fap")  %>%)</td>
                                </tr>
                                 <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through FMP Update Production</td>
                                      <td><%= bio.getACDIVOCAFFMPProductionUpdateCount() %> (<%= temp.getFarmerPUProgressForACDI() %>%)</td>
                                     <td><%= mn.get("fm") %> (<%= mnp.getString("fmp") %>%)</td>
                                </tr>
                                <tr>
                                   <td style="width: 20%">Number of farmers (% of target) taken through FMP Update Post Harvest</td>
                                    <td><%= bio.getACDIVOCAPostHarvestUpdateCount() %> (<%= temp.getFarmerPHUProgressForACDI() %>%)</td>
                                    <td><%= mn.get("fphu") %> (<%= mnp.getString("fphup") %>%)</td>
                                </tr>
                                <tr>
                                    <td style="width: 20%">Number of farmers (% of target) taken through FMP Update Credit</td>
                                    <td><%= bio.getACDIVOCAFarmCreditUpdateCount() %> (<%= temp.getFarmerFCUProgressForACDI() %>%)</td>
                                    <td><%= mn.get("fcu") %> (<%= mnp.getString("fcup") %>%)</td>
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
                                <th>Agent</th>
                                <th>No farmers with access to Agent</th>
                                <th>No farmers taken through Previous performance (Production)</th>
                                <th>No farmers taken through Previous performance (Post-harvest)</th>
                                <th>No farmers taken through Previous performance (Credit)</th>
                                <th>No farmers coached to produce Farm Management Plan on Production</th>
                                <th>No farmers coached to produce Farm Management Plan on Post-harvest</th>
                                <th>No farmers coached to produce Farm Management Plan on Farm Credit</th>
                                <th>No farms measured by Agent</th>
                                <th>No farms accessed by Agent</th>
                                <th>No of Updated records [FMP production]</th>
                                <th>No of Updated records [FMP Post-harvest / Marketing] </th>
                                <th>Number of Updated records [Credit]</th>
                                
                            </tr>
                           
                            </thead>
                            <tbody>
                             <% for (int i =0;i<ja.length();i++) { b = ja.getJSONObject(i);%>
                               
                            <tr>
                                <td><%= b.getString("name") %></td>
                                <td><%= b.get("farmers") %></td>
                                <td><%= b.get("blproduction") %></td>
                                <td><%= b.get("blpostharvest")%></td>
                                <td><%= b.get("blcredit")%></td>
                                <td><%= b.get("fmpproduction")%></td>
                                <td><%= b.get("fmppostharvest")%></td>
                                <td><%= b.get("fmpcredit")%></td>
                                <td><%= b.get("measured")%></td>
                                <td><%= b.get("assessed")%></td>
                                <td><%= b.get("productionupdate") %></td>
                                <td><%= b.get("postharvestupdate") %></td>
                                <td><%= b.get("creditupdate")  %></td>
                            </tr>
                            <% }%>
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
