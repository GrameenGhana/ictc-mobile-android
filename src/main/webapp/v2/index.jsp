<%@ page import="org.json.JSONObject" %>
<%@ page import="com.grameenfoundation.ictc.utils.ICTCBIUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ICTCBIUtil.DashboardData data = ICTCBIUtil.getDashboardDataAsObject("general");
    String barColor = "bg-green";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome</title>

    <content tag="stylesheets">
        <!-- bootstrap-progressbar -->
        <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    </content>
</head>

<body>
    <div class="row top_tiles" style="margin: 10px 0;">
        <div class="col-md-4 col-sm-4 col-xs-8 tile">
            <span>Total Farmers</span>
            <h2><%= data.getFarmerRegistrationTotal() %></h2>
            <span class="sparkline_tf" style="height: 160px;">
                <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
            </span>
        </div>
        <div class="col-md-4 col-sm-4 col-xs-8 tile">
            <span>Total Communities</span>
            <h2><%= data.getCommunityRegistrationTotal() %></h2>
            <span class="sparkline_tc" style="height: 160px;">
                <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
            </span>
        </div>
        <div class="col-md-4 col-sm-4 col-xs-8 tile">
            <span>Total Agents</span>
            <h2><%= data.getAgentRegistrationTotal() %></h2>
            <span class="sparkline_ta" style="height: 160px;">
                  <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
            </span>
        </div>
    </div>

    <br />

    <div class="row" style="margin:10px 0;">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="dashboard_graph">

                <div class="row x_title">
                    <div class="col-md-6">
                        <h3>Registered Farmers</h3>
                    </div>
                </div>

                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_content">
                        <div id="echart_line" style="height:350px;"></div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

    </div>

    <br/>

    <div class="row">
        <div class="col-md-6 col-sm-6 col-xs-12">
            <div class="x_panel fixed_height_350">
                <div class="x_title">
                    <h2>Farmer Registration <small>Target Progress</small></h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <h4>ACDI VOCA</h4>
                    <div class="widget_summary">
                        <div class="w_left w_55">
                            <div class="progress" >
                                <%  barColor = (Integer.valueOf(data.getFarmerRegistrationProgressForACDI()) > 33)
                                             ? (Integer.valueOf(data.getFarmerRegistrationProgressForACDI()) < 66 ? "progress-bar-warning" : "bg-green") : "bg-red"; %>
                                <div class="progress-bar <%=barColor%>" role="progressbar" aria-valuenow="<%= data.getFarmerRegistrationProgressForACDI() %>"
                                     aria-valuemin="0" aria-valuemax="100" style="width: <%= data.getFarmerRegistrationProgressForACDI() %>%;">
                                    <span class="sr-only"><%= data.getFarmerRegistrationProgressForACDI()%>% Complete</span>
                                </div>
                            </div>
                        </div>
                        <div class="w_center w_25">
                            <span style="padding-left:20px"><%= data.getFarmerRegistrationTotalForACDI() + " / " + data.getFarmerRegistrationTargetForACDI() %></span>
                        </div>
                        <div class="w_right w_20">
                            <span><%= data.getFarmerRegistrationProgressForACDI() %>%</span>
                        </div>
                        <div class="clearfix"></div>
                    </div>

                    <h4>MOFA</h4>
                    <div class="widget_summary">
                        <div class="w_left w_55">
                            <div class="progress">
                                <%  barColor = (Integer.valueOf(data.getFarmerRegistrationProgressForMOFA()) > 33)
                                        ? (Integer.valueOf(data.getFarmerRegistrationProgressForMOFA()) < 66 ? "progress-bar-warning" : "bg-green") : "bg-red"; %>
                                <div class="progress-bar <%=barColor%>" role="progressbar" aria-valuenow="<%= data.getFarmerRegistrationProgressForMOFA() %>"
                                     aria-valuemin="0" aria-valuemax="100" style="width: <%= data.getFarmerRegistrationProgressForMOFA() %>%;">
                                    <span class="sr-only"><%= data.getFarmerRegistrationProgressForMOFA()%>% Complete</span>
                                </div>
                            </div>
                        </div>
                        <div class="w_center w_25">
                            <span style="padding-left:20px"><%= data.getFarmerRegistrationTotalForMOFA() + " / " + data.getFarmerRegistrationTargetForMOFA() %></span>
                        </div>
                        <div class="w_right w_20">
                            <span><%= data.getFarmerRegistrationProgressForMOFA() %>%</span>
                        </div>
                        <div class="clearfix"></div>
                    </div>

                    <h4>CIFCSF</h4>
                    <div class="widget_summary">
                        <div class="w_left w_55">
                            <div class="progress">
                                <%  barColor = (Integer.valueOf(data.getFarmerRegistrationProgressForCIF()) > 33)
                                        ? (Integer.valueOf(data.getFarmerRegistrationProgressForCIF()) < 66 ? "progress-bar-warning" : "bg-green") : "bg-red"; %>
                                <div class="progress-bar <%=barColor%>" role="progressbar" aria-valuenow="<%= data.getFarmerRegistrationProgressForCIF() %>"
                                    aria-valuemin="0" aria-valuemax="100" style="width: <%= data.getFarmerRegistrationProgressForCIF() %>%;">
                                    <span class="sr-only"><%= data.getFarmerRegistrationProgressForCIF()%>% Complete</span>
                                </div>
                            </div>
                        </div>
                        <div class="w_center w_25">
                            <span style="padding-left:20px"><%= data.getFarmerRegistrationTotalForCIF() + " / " + data.getFarmerRegistrationTargetForCIF() %></span>
                        </div>
                        <div class="w_right w_20">
                            <span><%= data.getFarmerRegistrationProgressForCIF() %>%</span>
                        </div>
                        <div class="clearfix"></div>
                    </div>

                    <h4>Grameen Foundation</h4>
                    <div class="widget_summary">
                        <div class="w_left w_55">
                            <div class="progress">
                                <%  barColor = (Integer.valueOf(data.getFarmerRegistrationProgressForGF()) > 33)
                                        ? (Integer.valueOf(data.getFarmerRegistrationProgressForGF()) < 66 ? "progress-bar-warning" : "bg-green") : "bg-red"; %>
                                <div class="progress-bar <%=barColor%>" role="progressbar" aria-valuenow="<%= data.getFarmerRegistrationProgressForGF() %>"
                                    aria-valuemin="0" aria-valuemax="100" style="width: <%= data.getFarmerRegistrationProgressForGF() %>%;">
                                    <span class="sr-only"><%= data.getFarmerRegistrationProgressForGF()%>% Complete</span>
                                </div>
                            </div>
                        </div>
                        <div class="w_center w_25">
                            <span style="padding-left:20px"><%= data.getFarmerRegistrationTotalForGF() + " / " + data.getFarmerRegistrationTargetForGF() %></span>
                        </div>
                        <div class="w_right w_20">
                            <span><%= data.getFarmerRegistrationProgressForGF() %>%</span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-6 col-sm-6 col-xs-12 widget_tally_box">
            <div class="x_panel">
                <div class="x_title">
                    <h2>Cultivated Land<small>In Acres</small></h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">

                    <div id="graph_bar1" style="width:100%; height:200px;"></div>

                    <div class="col-xs-12 bg-white progress_summary">
                        <div class="row">
                            <div class="col-xs-4">
                                <span class="sparkline_line" style="height: 160px;">
                                   <canvas width="200" height="60" style="display: inline-block;vertical-align: top; width: 94px; height: 30px;"></canvas>
                                </span>
                            </div>
                            <div class="col-xs-2"><span>Total</span></div>
                            <div class="col-xs-2 more_info"><span>89</span></div>
                        </div>
                        <div class="row">
                            <div class="col-xs-4">
                                <span class="sparkline_line" style="height: 160px;">
                                   <canvas width="200" height="60" style="display: inline-block;vertical-align: top; width: 94px; height: 30px;"></canvas>
                                </span>
                            </div>
                            <div class="col-xs-2">
                                <span>Average</span>
                            </div>
                            <div class="col-xs-2 more_info">
                                <span>20</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-4">
                                <span class="sparkline_line" style="height: 160px;">
                                   <canvas width="200" height="60" style="display: inline-block;vertical-align: top; width: 94px; height: 30px;"></canvas>
                                </span>
                            </div>
                            <div class="col-xs-2">
                                <span>Largest</span>
                            </div>
                            <div class="col-xs-2 more_info">
                                <span>25</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-4">
                                <span class="sparkline_line" style="height: 160px;">
                                   <canvas width="200" height="60" style="display: inline-block;vertical-align: top; width: 94px; height: 30px;"></canvas>
                                </span>
                            </div>
                            <div class="col-xs-2">
                                <span>Smallest</span>
                            </div>
                            <div class="col-xs-2 more_info">
                                <span>2</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <br/>

    <div class="row">
        <div class="col-md-4 col-sm-6 col-xs-12 widget_tally_box">
            <div class="x_panel">
                <div class="x_title">
                    <h2>Costs <small></small></h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <div id="graph_bar2" style="width:100%; height:200px;"></div>
                    <div class="col-xs-12 bg-white progress_summary">
                        <div class="row">
                            <div class="col-xs-3">
                                <span class="sparkline_line" style="height: 160px;">
                                   <canvas width="200" height="60" style="display: inline-block;vertical-align: top; width: 94px; height: 30px;"></canvas>
                                </span>
                            </div>
                            <div class="col-xs-4">
                                <span>Total</span>
                            </div>
                            <div class="col-xs-2 more_info">
                                <span>89</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-3">
                                <span class="sparkline_line" style="height: 160px;">
                                   <canvas width="200" height="60" style="display: inline-block;vertical-align: top; width: 94px; height: 30px;"></canvas>
                                </span>
                            </div>
                            <div class="col-xs-4">
                                <span>Average</span>
                            </div>
                            <div class="col-xs-2 more_info">
                                <span>89</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-3">
                                <span class="sparkline_line" style="height: 160px;">
                                   <canvas width="200" height="60" style="display: inline-block;vertical-align: top; width: 94px; height: 30px;"></canvas>
                                </span>
                            </div>
                            <div class="col-xs-4">
                                <span>Average per acre</span>
                            </div>
                            <div class="col-xs-2 more_info">
                                <span>20</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4 col-sm-6 col-xs-12 widget_tally_box">
            <div class="x_panel">
                <div class="x_title">
                    <h2>Revenues <small></small></h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <div id="graph_bar3" style="width:100%; height:200px;"></div>
                    <div class="col-xs-12 bg-white progress_summary">
                        <div class="row">
                            <div class="col-xs-3">
                                <span class="sparkline_line" style="height: 160px;">
                                   <canvas width="200" height="60" style="display: inline-block;vertical-align: top; width: 94px; height: 30px;"></canvas>
                                </span>
                            </div>
                            <div class="col-xs-4">
                                <span>Total</span>
                            </div>
                            <div class="col-xs-2 more_info">
                                <span>89</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-3">
                                <span class="sparkline_line" style="height: 160px;">
                                   <canvas width="200" height="60" style="display: inline-block;vertical-align: top; width: 94px; height: 30px;"></canvas>
                                </span>
                            </div>
                            <div class="col-xs-4">
                                <span>Average</span>
                            </div>
                            <div class="col-xs-2 more_info">
                                <span>20</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-3">
                                <span class="sparkline_line" style="height: 160px;">
                                   <canvas width="200" height="60" style="display: inline-block;vertical-align: top; width: 94px; height: 30px;"></canvas>
                                </span>
                            </div>
                            <div class="col-xs-4">
                                <span>Average per acre</span>
                            </div>
                            <div class="col-xs-2 more_info">
                                <span>25</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4 col-sm-6 col-xs-12 widget_tally_box">
            <div class="x_panel">
                <div class="x_title">
                    <h2>Gross Margins <small></small></h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">

                    <div id="graph_bar4" style="width:100%; height:200px;"></div>

                    <div class="col-xs-12 bg-white progress_summary">
                        <div class="row">
                            <div class="col-xs-3">
                                <span class="sparkline_line" style="height: 160px;">
                                   <canvas width="200" height="60" style="display: inline-block;vertical-align: top; width: 94px; height: 30px;"></canvas>
                                </span>
                            </div>
                            <div class="col-xs-4">
                                <span>Total</span>
                            </div>
                            <div class="col-xs-2 more_info">
                                <span>89</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-3">
                                <span class="sparkline_line" style="height: 160px;">
                                   <canvas width="200" height="60" style="display: inline-block;vertical-align: top; width: 94px; height: 30px;"></canvas>
                                </span>
                            </div>
                            <div class="col-xs-4">
                                <span>Average</span>
                            </div>
                            <div class="col-xs-2 more_info">
                                <span>89</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-3">
                                <span class="sparkline_line" style="height: 160px;">
                                   <canvas width="200" height="60" style="display: inline-block;vertical-align: top; width: 94px; height: 30px;"></canvas>
                                </span>
                            </div>
                            <div class="col-xs-4">
                                <span>Average per acre</span>
                            </div>
                            <div class="col-xs-2 more_info">
                                <span>20</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-3">
                                <span class="sparkline_line" style="height: 160px;">
                                   <canvas width="200" height="60" style="display: inline-block;vertical-align: top; width: 94px; height: 30px;"></canvas>
                                </span>
                            </div>
                            <div class="col-xs-4">
                                <span>Average per farmer</span>
                            </div>
                            <div class="col-xs-2 more_info">
                                <span>25</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

<content tag="scripts">
    <!-- Chart.js -->
    <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- jQuery Sparklines -->
    <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
    <!-- morris.js -->
    <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/raphael/raphael.min.js"></script>
    <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/morris.js/morris.min.js"></script>
    <!-- gauge.js -->
    <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/bernii/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- Skycons -->
    <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/Flot/jquery.flot.js"></script>
    <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/Flot/jquery.flot.pie.js"></script>
    <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/Flot/jquery.flot.time.js"></script>
    <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/Flot/jquery.flot.stack.js"></script>
    <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="<%= request.getContextPath()%>/theme/gentelella/js/flot/jquery.flot.orderBars.js"></script>
    <script src="<%= request.getContextPath()%>/theme/gentelella/js/flot/date.js"></script>
    <script src="<%= request.getContextPath()%>/theme/gentelella/js/flot/jquery.flot.spline.js"></script>
    <script src="<%= request.getContextPath()%>/theme/gentelella/js/flot/curvedLines.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="<%= request.getContextPath()%>/theme/gentelella/js/moment/moment.min.js"></script>
    <script src="<%= request.getContextPath()%>/theme/gentelella/js/datepicker/daterangepicker.js"></script>

    <!-- ECharts -->
    <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/echarts/dist/echarts.min.js"></script>
    <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/echarts/map/js/world.js"></script>

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
    </script>

    <!-- eChart Line -->
    <script>
    $(document).ready(function() {
        var echartLine = echarts.init(document.getElementById('echart_line'), theme);
        echartLine.setOption({
            title: { text: '', subtext: '' },
            tooltip: { trigger: 'axis' },
            legend: { x: 220, y: 40, data: <%= data.getFarmerRegistrationEChartLegend()%> },
            toolbox: {
                show: true,
                feature: {
                    magicType: {
                        show: true,
                        title: {
                            line: 'Line',
                            bar: 'Bar',
                            stack: 'Stack',
                            tiled: 'Tiled'
                        },
                        type: ['line', 'bar', 'stack', 'tiled']
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
            calculable: true,
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

    <!-- jQuery Sparklines -->
    <script>
    $(document).ready(function() {
        var options = {
            type: 'line',
            width: '200',
            height: '40',
            lineColor: '#26B99A',
            fillColor: 'rgba(223, 223, 223, 0.57)',
            lineWidth: 2,
            spotColor: '#26B99A',
            minSpotColor: '#26B99A'
        };

        $(".sparkline_line").sparkline([2, 4, 3, 4, 5, 4, 5, 4, 3, 4, 5, 6, 4, 5, 6, 3, 5], {
            type: 'line',
            lineColor: '#26B99A',
            fillColor: '#ffffff',
            width: 85,
            spotColor: '#34495E',
            minSpotColor: '#34495E'
        });


        $(".sparkline_tf").sparkline([<%= data.getFarmerRegistrationSparkline() %>],options);
        $(".sparkline_tc").sparkline([<%= data.getCommunityRegistrationSparkline() %>], options);
        $(".sparkline_ta").sparkline([<%= data.getAgentRegistrationSparkline() %>], options);
    });
    </script>
    <!-- /jQuery Sparklines -->

    <!-- morris.js -->
    <script>
    $(document).ready(function() {
        Morris.Bar({
            element: 'graph_bar1',
            data: [
                { "period": "Jan", "Hours worked": 80 },
                { "period": "Feb", "Hours worked": 125 },
                { "period": "Mar", "Hours worked": 176 },
                { "period": "Apr", "Hours worked": 224 },
                { "period": "May", "Hours worked": 265 },
                { "period": "Jun", "Hours worked": 314 },
                { "period": "Jul", "Hours worked": 347 },
                { "period": "Aug", "Hours worked": 287 },
                { "period": "Sep", "Hours worked": 240 },
                { "period": "Oct", "Hours worked": 211 }
            ],
            xkey: 'period',
            hideHover: 'auto',
            barColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
            ykeys: ['Hours worked', 'sorned'],
            labels: ['Hours worked', 'SORN'],
            xLabelAngle: 60,
            resize: true
        });

        Morris.Bar({
            element: 'graph_bar2',
            data: [
                { "period": "Jan", "Hours worked": 80 },
                { "period": "Feb", "Hours worked": 125 },
                { "period": "Mar", "Hours worked": 176 },
                { "period": "Apr", "Hours worked": 224 },
                { "period": "May", "Hours worked": 265 },
                { "period": "Jun", "Hours worked": 314 },
                { "period": "Jul", "Hours worked": 347 },
                { "period": "Aug", "Hours worked": 287 },
                { "period": "Sep", "Hours worked": 240 },
                { "period": "Oct", "Hours worked": 211 }
            ],
            xkey: 'period',
            hideHover: 'auto',
            barColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
            ykeys: ['Hours worked', 'sorned'],
            labels: ['Hours worked', 'SORN'],
            xLabelAngle: 60,
            resize: true
        });

        Morris.Bar({
            element: 'graph_bar3',
            data: [
                { "period": "Jan", "Hours worked": 80 },
                { "period": "Feb", "Hours worked": 125 },
                { "period": "Mar", "Hours worked": 176 },
                { "period": "Apr", "Hours worked": 224 },
                { "period": "May", "Hours worked": 265 },
                { "period": "Jun", "Hours worked": 314 },
                { "period": "Jul", "Hours worked": 347 },
                { "period": "Aug", "Hours worked": 287 },
                { "period": "Sep", "Hours worked": 240 },
                { "period": "Oct", "Hours worked": 211 }
            ],
            xkey: 'period',
            hideHover: 'auto',
            barColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
            ykeys: ['Hours worked', 'sorned'],
            labels: ['Hours worked', 'SORN'],
            xLabelAngle: 60,
            resize: true
        });

        Morris.Bar({
            element: 'graph_bar4',
            data: [
                { "period": "Jan", "Hours worked": 80 },
                { "period": "Feb", "Hours worked": 125 },
                { "period": "Mar", "Hours worked": 176 },
                { "period": "Apr", "Hours worked": 224 },
                { "period": "May", "Hours worked": 265 },
                { "period": "Jun", "Hours worked": 314 },
                { "period": "Jul", "Hours worked": 347 },
                { "period": "Aug", "Hours worked": 287 },
                { "period": "Sep", "Hours worked": 240 },
                { "period": "Oct", "Hours worked": 211 }
            ],
            xkey: 'period',
            hideHover: 'auto',
            barColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
            ykeys: ['Hours worked', 'sorned'],
            labels: ['Hours worked', 'SORN'],
            xLabelAngle: 60,
            resize: true
        });


        $MENU_TOGGLE.on('click', function() {
            $(window).resize();
        });
    });
    </script>
    <!-- /morris.js -->

</content>

</html>
