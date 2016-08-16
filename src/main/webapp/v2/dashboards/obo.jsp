<%@page import="java.util.List" %>
<%@page import="com.grameenfoundation.ictc.utils.ICTCBIUtil" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ICTCBIUtil.DashboardData data = ICTCBIUtil.getDashboardDataAsObject("obo");
    List<String> years = data.getYears();
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


        <div class="row" style="margin:10px 0;">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="dashboard_graph">

                    <div class="row x_title">
                        <div class="col-md-6">
                            <h3>Registered Farmers by Community<small>Total: <%= data.getFarmerRegistrationTotal() %><</small></h3>
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
        </div>

        <br/>

        <div class="row">

            <!-- Land/Yield Indicators -->
            <div style="margin-bottom: 30px; margin-top:30px" class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Land Usage and Yield Indicators <small></small></h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li>
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
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>

                        <div class="x_content">
                            <table id="yield-table" class="table table-striped table-bordered jambo_table">
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

            <!-- Credit Indicators -->
            <div style="margin-bottom: 30px" class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Credit Indicators <small>for credit provision by OB</small></h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li>
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
                                </li>
                            </ul>

                            <div class="clearfix"></div>
                        </div>

                        <div class="x_content">
                            <table id="ciob-table" class="table table-striped table-bordered jambo_table">
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
                    return  "<%= request.getContextPath() %>/api/v1?action=get_indicator"
                            + "&year=" + $("#year-"+table).val()
                            + "&season=" + $("#season-"+table).val()
                            + "&indicator=obo-get-" + table;
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

                var ytoa = {ajax:  { url: getAjaxUrl("yield-table") } };
                var ytoc = {columns : [ { "data": "indicator" }, { "data": "planned" }, { "data": "actual" } ] };
                var yto = $.extend({}, options, ytoa, ytoc);
                var yieldTable = $('#yield-table').DataTable(yto);

                var ciobtoa =  {ajax: { url: getAjaxUrl("ciob-table") } };
                var ciobtoc = {columns: [ { "data": "indicator" }, { "data": "planned" }, { "data": "actual" } ] };
                var ciobto = $.extend({}, options, ciobtoa, ciobtoc);
                var ciobTable = $('#ciob-table').DataTable(ciobto);

                var ciftoa =  {ajax: { url: getAjaxUrl("cif-table") }};
                var ciftoc = {columns:[ { "data": "indicator" }, { "data": "planned" }, { "data": "actual" } ]};
                var cifto = $.extend({}, options, ciftoa, ciftoc);
                var cifTable = $('#cif-table').DataTable(cifto);

                $("#year-yield-table").change(function() { console.log("changing"); yieldTable.ajax.url(getAjaxUrl("yield-table")).load(); });
                $("#seasons-yield-table").change(function() { yieldTable.ajax.url(getAjaxUrl("yield-table")).load(); });

                $("#year-ciob-table").change(function() { console.log("changing"); ciobTable.ajax.url(getAjaxUrl("ciob-table")).load(); });
                $("#seasons-ciob-table").change(function() { ciobTable.ajax.url(getAjaxUrl("ciob-table")).load(); });

                $("#year-cif-table").change(function() { console.log("changing"); cifTable.ajax.url(getAjaxUrl("cif-table")).load(); });
                $("#seasons-cif-table").change(function() { cifTable.ajax.url(getAjaxUrl("cif-table")).load(); });
            });
        </script>
        <!-- /Datatables -->

        <!-- eChart Line -->
        <script>
            //color: [ '#26B99A', '#34495E', '#BDC3C7', '#3498DB', '#9B59B6', '#8abb6f', '#759c6a', '#bfd3b7' ],
            var theme = {
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
                        data:  <%= data.getFarmerRegistrationEChartAxis() %>
                    }],
                    yAxis: [{
                        type: 'value'
                    }],
                    series: <%= data.getFarmerRegistrationEChartSeries() %>
                });
            });
        </script>
        <!-- /EChart -->

    </content>
</html>
