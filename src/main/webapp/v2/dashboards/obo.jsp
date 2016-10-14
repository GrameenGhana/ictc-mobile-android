<%@page import="com.grameenfoundation.ictc.domains.Agent"%>
<%@page import="com.grameenfoundation.ictc.domains.User"%>
<%@page import="com.grameenfoundation.ictc.models.UserModel"%>
<%@page import="com.grameenfoundation.ictc.utils.BIDataManager"%>
<%@page import="com.grameenfoundation.ictc.utils.security.Authenticator"%>
<%@page import="com.grameenfoundation.ictc.utils.security.SessionKeys"%>
<%@page import="com.grameenfoundation.ictc.wrapper.LoginUser"%>
<%@page import="java.util.List" %>
<%@page import="com.grameenfoundation.ictc.utils.BIDashboard" %>
  <%@page import="org.json.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    BIDashboard data = new BIDashboard("obo");
    List<String> years = data.getYears();
    BIDataManager bi = BIDataManager.getInstance();
    
    LoginUser u = Authenticator.loginUser(session);
    System.out.println(u.getUserId());
    //Agent a = new UserModel()
    List<String> ags = new UserModel().getAgents(u.getUserId());
    
    System.out.print("agent " + ags.size()+ " " + ags.get(1));
    
    JSONObject x = bi.GetOBData(ags.get(1));
  
    
    
    
    
    
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Outgrower Business Owner Dashboard</title>

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
                <h3>Outgrower Business Dashboard <small></small></h3>
            </div>
        </div>

        <div class="clearfix"></div>


       <!-- <div class="row" style="margin:10px 0;">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="dashboard_graph">

                    <div class="row x_title">
                        <div class="col-md-6">
                            <h2>Registered Farmers by Community <small>Total: <%= data.getFarmerRegistrationTotalForACDI() %></small></h2>
                        </div>
                    </div>

                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_content">
                            <div id="echart_bar" style="height:350px;"></div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>-->
        <div class="row top_tiles" style="margin: 10px 0;">
        <div class="col-md-4 col-sm-4 col-xs-8 tile">
            <span>Total Farmers</span>
            <h2><%= x.get("farmers") %></h2>
            <span class="sparkline_tf" style="height: 160px;">
                <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
            </span>
        </div>
     
    </div>

        <br/>

        <div class="row">

            <!-- Land/Yield Indicators -->
            <div style="margin-bottom: 30px; margin-top:30px" class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Land Usage and Yield Indicators <small></small></h2>
                            <ul class="nav navbar-right panel_toolbox">
                               <!-- <li>
                                <form id="yield-form" class="form-inline" method="get">
                                    <div class="form-group">
                                        <select id="year-yield-table" class="form-control">
                                            <option value="all">Year: All</option>
                                            <% for(String y : years ) { %>
                                            <option value="<%=y%>"><%=y%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <select id="season-yield-table" class="form-control">
                                            <option value="all">Season: All</option>
                                            <option value="Major Season">Major Season</option>
                                            <option value="Minor Season">Minor Season</option>
                                        </select>
                                    </div>
                                </form>
                                </li>-->
                            </ul>
                            <div class="clearfix"></div>
                        </div>

                        <div class="x_content">
                           <!-- <table id="yield-table" class="table table-striped table-bordered jambo_table">-->
                            <table class="table table-striped table-bordered jambo_table">
                                <thead>
                                    <tr>
                                        <th>Indicator</th>
                                        <th>Planned</th>
                                        <th>Actual</th>
                                    </tr>
                                </thead>
                                <tbody>
                                     <tr>
                                        <td>Total area (acres) under registered farmers</td>
                                        <td><%= x.get("tap")  %></td>
                                        <td><%= x.get("tac")%></td>
                                    </tr>
                                    <tr>
                                        <td>Largest area (acres)</td>
                                        <td><%= x.get("lap")%></td>
                                        <td><%= x.get("lac")%></td>
                                    </tr>
                                    <tr>
                                        <td>Smallest area (acres)</td>
                                        <td><%= x.get("sap") %></td>
                                        <td><%= x.get("sac")%></td>
                                    </tr>
                                    <tr>
                                        <td>Average area cultivated</td>
                                        <td><%= x.get("avap") %></td>
                                        <td><%= x.get("avac")%></td>
                                    </tr>
                                     <tr>
                                        <td>Average yield per acre</td>
                                        <td><%= x.get("ayap") %></td>
                                        <td><%= x.get("ayac")%></td>
                                    </tr>
                                    <tr>
                                        <td>Total production from registered farmers</td>
                                        <td><%= x.get("tpp") %></td>
                                        <td><%= x.get("tpc")%></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
            </div>

            <!-- Credit Indicators -->
            <div style="margin-bottom: 30px" class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Credit Indicators <small>for credit provision by OB</small></h2>
                            <ul class="nav navbar-right panel_toolbox">
                             <!--   <li>
                                    <form id="ciob-form" class="form-inline" method="get">
                                        <div class="form-group">
                                            <select id="year-ciob-table" class="form-control">
                                                <option value="all">Year: All</option>
                                                <% for(String y : years ) { %>
                                                <option value="<%=y%>"><%=y%></option>
                                                <% } %>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <select id="season-ciob-table" class="form-control">
                                                <option value="all">Season: All</option>
                                                <option value="Major Season">Major Season</option>
                                                <option value="Minor Season">Minor Season</option>
                                            </select>
                                        </div>
                                    </form>
                                </li>-->
                            </ul>

                            <div class="clearfix"></div>
                        </div>

                        <div class="x_content">
                           <!-- <table id="ciob-table" class="table table-striped table-bordered jambo_table">-->
                           <table  class="table table-striped table-bordered jambo_table">
                                <thead>
                                    <tr>
                                        <th>Indicator</th>
                                        <th>Planned</th>
                                        <th>Actual</th>
                                    </tr>
                                </thead>
                                <tbody>
                                      <tr>
                                        <td>Total number of farmers taking credit from OB</td>
                                        <td><%= x.get("tfcp")  %></td>
                                        <td><%= x.get("tfca")%></td>
                                    </tr>
                                    <tr>
                                        <td>Total number of farmers taking cash credit from OB</td>
                                        <td><%= x.get("tccp")  %></td>
                                        <td><%= x.get("tcca")%></td>
                                    </tr>
                                    <tr>
                                        <td>Total number of farmers taking input credit from OB</td>
                                        <td><%= x.get("tccp")  %></td>
                                        <td><%= x.get("tcca")%></td>
                                    </tr>
                                      <tr>
                                        <td>Total amount of cash credit  from OB</td>
                                        <td><%= x.get("taccp")  %></td>
                                        <td><%= x.get("tacca")%></td>
                                    </tr>
                                      <tr>
                                        <td>Total value of cash credit payback (due or paid) OB</td>
                                        <td><%= x.get("tcpbp")  %></td>
                                        <td><%= x.get("tcpba")%></td>
                                    </tr>
                                    <tr>
                                        <td>Total quantity of produce as payback (no of bags of produce) due to OB</td>
                                        <td><%= x.get("tqpbp")  %></td>
                                        <td><%= x.get("tqpba")%></td>
                                    </tr>
                                     <tr>
                                        <td>Number of farmers taking seed on credit from OB</td>
                                        <td><%= x.get("nscp")  %></td>
                                        <td><%= x.get("nsca")%></td>
                                    </tr>
                                     <tr>
                                        <td>Number of farmers taking fertilizer on credit from OB</td>
                                        <td><%= x.get("nfcp")  %></td>
                                        <td><%= x.get("nfca")%></td>
                                    </tr>
                                     <tr>
                                        <td>Number of farmers taking pre-plant herbicide on credit from OB</td>
                                        <td><%= x.get("nfcp")  %></td>
                                        <td><%= x.get("nfca")%></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                </div>
            </div>

            <!-- Credit Indicators: All farmers -->
            <div style="margin-bottom: 30px" class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Credit Indicators <small>for all farmers</small></h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li>
                                <form id="cif-form" class="form-inline" method="get">
                                    <div class="form-group">
                                        <select id="year-cif-table" class="form-control">
                                            <option value="all">Year: All</option>
                                            <% for(String y : years ) { %>
                                            <option value="<%=y%>"><%=y%></option>
                                            <% } %>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <select id="season-cif-table" class="form-control">
                                            <option value="all">Season: All</option>
                                            <option value="Major Season">Major Season</option>
                                            <option value="Minor Season">Minor Season</option>
                                        </select>
                                    </div>
                                </form>
                            </li>
                        </ul>

                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <table id="cif-table" class="table table-striped table-bordered jambo_table">
                            <thead>
                            <tr>
                                <th>Indicator</th>
                                <th>Planned</th>
                                <th>Actual</th>
                            </tr>
                            </thead>
                            <tbody>
                                
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
        <!-- ECharts -->
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/echarts/dist/echarts.min.js"></script>

        <!-- Datatables -->
        <script>
            $(document).ready(function() {
                var getAjaxUrl = function(table) {
                    return  "<%= request.getContextPath() %>/api/v1?action=get_bi_data"
                            + "&year=" + $("#year-"+table).val()
                            + "&season=" + $("#season-"+table).val()
                            + "&data_set=obo-get-" + table;
                } 

                var options = {
                    dom: "Bfrtip",
                    buttons: [
                        { extend: "copy", className: "btn-sm" },
                        { extend: "csv", className: "btn-sm" },
                        { extend: "excel", className: "btn-sm" },
                        { extend: "pdfHtml5", className: "btn-sm" },
                        { extend: "print", className: "btn-sm" }
                    ],
                    responsive: true,
                    paging: false,
                    searching: false
                };

                var ytoa = {ajax:  { url: getAjaxUrl("yield-table") } };
                var ytoc = {columns : [ { "data": "indicator" }, { "data": "planned" }, { "data": "actual" } ] };
                var yto = $.extend({}, options, ytoa, ytoc);
                var yieldTable = $('#yield-table').DataTable(yto);

               ciobtoa =  {ajax: { url: getAjaxUrl("ciob-table") } };
                var ciobtoc = {columns: [ { "data": "indicator" }, { "data": "planned" }, { "data": "actual" } ] };
                var ciobto = $.extend({}, options, ciobtoa, ciobtoc);
                var ciobTable = $('#ciob-table').DataTable(ciobto);

              var ciftoa =  {ajax: { url: getAjaxUrl("cif-table") }};
                var ciftoc = {columns:[ { "data": "indicator" }, { "data": "planned" }, { "data": "actual" } ]};
                var cifto = $.extend({}, options, ciftoa, ciftoc);
                var cifTable = $('#cif-table').DataTable(cifto);

                $("#year-yield-table").change(function() {   yieldTable.ajax.url(getAjaxUrl("yield-table")).load(); });
                $("#season-yield-table").change(function() { yieldTable.ajax.url(getAjaxUrl("yield-table")).load(); });

                $("#year-ciob-table").change(function() {   ciobTable.ajax.url(getAjaxUrl("ciob-table")).load(); });
                $("#season-ciob-table").change(function() { ciobTable.ajax.url(getAjaxUrl("ciob-table")).load(); });

                $("#year-cif-table").change(function() {   cifTable.ajax.url(getAjaxUrl("cif-table")).load(); });
                $("#season-cif-table").change(function() { cifTable.ajax.url(getAjaxUrl("cif-table")).load(); });
            });
        </script>
        <!-- /Datatables -->

        <!-- eChart Line -->
        <script>
            //color: [ '#26B99A', '#34495E', '#BDC3C7', '#3498DB', '#9B59B6', '#8abb6f', '#759c6a', '#bfd3b7' ],
           /** var theme = {
                color: [ '#639a9F', '#9B59B6', '#8abb6f', '#759c6a', '#bfd3b7', '#34495E', '#BDC3C7', '#3498DB'],
                title: { itemGap: 8, textStyle: { fontWeight: 'normal', color: '#408829' } },
                dataRange: { color: ['#1f610a', '#97b58d'] },
                toolbox: { color: ['#408829', '#408829', '#408829', '#408829'] },
                tooltip: {
                    backgroundColor: 'rgba(0,0,0,0.5)',
                    axisPointer: {
                        type: 'line',
                        lineStyle: { color: '#408829', type: 'dashed' },
                        crossStyle: { color: '#408829' },
                        shadowStyle: { color: 'rgba(200,200,200,0.3)' }
                    }
                },
                dataZoom: { dataBackgroundColor: '#eee', fillerColor: 'rgba(64,136,41,0.2)', handleColor: '#408829' },
                grid: { borderWidth: 0 },
                categoryAxis: {
                    axisLine: { lineStyle: { color: '#408829' } },
                    splitLine: { lineStyle: { color: ['#eee'] } }
                },
                valueAxis: {
                    axisLine: { lineStyle: { color: '#408829' } },
                    splitArea: { show: true, areaStyle: { color: ['rgba(250,250,250,0.1)', 'rgba(200,200,200,0.1)'] } },
                    splitLine: { lineStyle: { color: ['#eee'] } }
                },
                timeline: {
                    lineStyle: { color: '#408829' },
                    controlStyle: { normal: {color: '#408829'}, emphasis: {color: '#408829'} }
                },

                k: { itemStyle: { normal: { color: '#68a54a', color0: '#a9cba2', lineStyle: { width: 1, color: '#408829', color0: '#86b379' } } } },
                map: {
                    itemStyle: {
                        normal: { areaStyle: { color: '#ddd' }, label: { textStyle: { color: '#c12e34' } } },
                        emphasis: { areaStyle: { color: '#99d2dd' }, label: { textStyle: { color: '#c12e34' } } }
                    }
                },
                force: { itemStyle: { normal: { linkStyle: { strokeColor: '#408829' } } } },
                chord: {
                    padding: 4,
                    itemStyle: {
                        normal: {
                            lineStyle: { width: 1, color: 'rgba(128, 128, 128, 0.5)' },
                            chordStyle: { lineStyle: { width: 1, color: 'rgba(128, 128, 128, 0.5)' } }
                        },
                        emphasis: {
                            lineStyle: { width: 1, color: 'rgba(128, 128, 128, 0.5)' },
                            chordStyle: { lineStyle: { width: 1, color: 'rgba(128, 128, 128, 0.5)' } }
                        }
                    }
                },
                gauge: {
                    startAngle: 225, endAngle: -45,
                    axisLine: { show: true, lineStyle: { color: [[0.2, '#86b379'], [0.8, '#68a54a'], [1, '#408829']], width: 8 } },
                    axisTick: { splitNumber: 10, length: 12, lineStyle: { color: 'auto' } },
                    axisLabel: { textStyle: { color: 'auto' } },
                    splitLine: { length: 18, lineStyle: { color: 'auto' } },
                    pointer: { length: '90%', color: 'auto' },
                    title: { textStyle: { color: '#333' } },
                    detail: { textStyle: { color: 'auto' } }
                },
                textStyle: { fontFamily: 'Arial, Verdana, sans-serif' }
            };

            $(document).ready(function() {
                var echartBar = echarts.init(document.getElementById('echart_bar'), theme);
                echartBar.setOption({
                    title: { text: '', subtext: '' },
                    tooltip: { trigger: 'axis' },
                    legend: { x: 220, y: 40, data: <%= data.getFarmerRegistrationEChartLegend()%> },
                    toolbox: {
                        show: true,
                        feature: {
                            magicType: {
                                show: true,
                                title: {
                                    bar: 'Bar',
                                    stack: 'Stack',
                                    tiled: 'Tiled'
                                },
                                type: ['bar', 'stack', 'tiled']
                            },
                            restore: {
                                show: true,
                                title: "Restore"
                            },
                            saveAsImage: {
                                show: true,
                                title: "Save Image"
                            }
                        }
                    },
                    calculable: false,
                    xAxis: [{
                        type: 'category',
                        boundaryGap: false,
                        axisLabel: { rotate: 45 },
                        data:  <%= data.getFarmerRegistrationEChartAxis() %>
                    }],
                    yAxis: [{
                        type: 'value'
                    }],
                    series: <%= data.getFarmerRegistrationEChartSeries() %>
                });
            }); **/
        </script>
        <!-- /EChart -->

    </content>
</html>
