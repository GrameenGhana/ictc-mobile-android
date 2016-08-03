<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ include file="/public/security.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>ICTC - <decorator:title default="Welcome" /></title>

    <!-- Bootstrap -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">

    <!-- Datatables -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
    <link href="<%= request.getContextPath()%>/public/js/datepicker/css/datepicker.css" rel="stylesheet" />


    <!-- Custom Theme Style -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/css/custom.min.css" rel="stylesheet">

    <!-- PNotify -->
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="<%=request.getContextPath()%>/v2" class="site_title"><i class="fa fa-umbrella"></i> <span>ICTC</span></a>
                </div>

                <div class="clearfix"></div>

                <br />

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>General</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%=request.getContextPath()%>/v2/index.jsp">General Dashboard</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/dashboards/gf.jsp">GF Dashboard</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/dashboards/acdivoca.jsp">ACDIVOCA Dashboard </a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/dashboards/mofa.jsp">MOFA Dashboard</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-bar-chart-o"></i> Reports <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath()%>/v2/reports/adoptation.jsp">Adoptation Report</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/reports/agent.jsp">Agent Report</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/reports/farmer.jsp">Farmer Report</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/reports/kpi.jsp">KPI Report</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/reports/submissioncount.jsp">Submission Count Report</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/reports/training.jsp">Training Report</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-users"></i> People <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath()%>/v2/agents/index.jsp">Agents</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/farmers/index.jsp">Farmers</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>

                    <div class="menu_section">
                        <h3>System Management</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-group"></i> Users <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath()%>/v2/admin/users/index.jsp">Manage Users</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-globe"></i> Locations <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath()%>/v2/admin/locations/districts.jsp">Manage Districts</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/admin/locations/regions.jsp">Manage Regions</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-cogs"></i> Other <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="<%= request.getContextPath()%>/v2/admin/categories">Manage Categories</a></li>
                                    <li><a href="<%= request.getContextPath()%>/v2/admin/logs/index.jsp">Logs</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /sidebar menu -->

            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <nav class="" role="navigation">
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <img src="<%=request.getContextPath()%>/theme/gentelella/images/img.jpg" alt=""><%= username %>
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right">
                                <li><a href="<%= request.getContextPath()%>/v2/profile.jsp"><i class="fa fa-user pull-right"></i> Profile</a></li>
                                <li><a href="<%= request.getContextPath()%>/v2/help.jsp"><i class="fa fa-question-circle pull-right"></i> Help</a></li>
                                <li><a href="<%= request.getContextPath()%>/v2/login.jsp"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <decorator:body />
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
            <div class="pull-right">
                &copy; 2015 ICTC. Powered By <a href="http://www.grameenfoundation.org">Grameen Foundation.</a> Design by <a href="https://colorlib.com">Colorlib</a>
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
</div>

<!-- jQuery -->
<script src="<%= request.getContextPath()%>/theme/gentelella/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="<%= request.getContextPath()%>/theme/gentelella/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="<%= request.getContextPath()%>/theme/gentelella/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="<%= request.getContextPath()%>/theme/gentelella/vendors/nprogress/nprogress.js"></script>
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
<script type="text/javascript" src="<%= request.getContextPath()%>/public/js/datepicker/js/bootstrap-datepicker.js"></script>

<!-- ECharts -->
<script src="<%= request.getContextPath()%>/theme/gentelella/vendors/echarts/dist/echarts.min.js"></script>
<script src="<%= request.getContextPath()%>/theme/gentelella/vendors/echarts/map/js/world.js"></script>

<!-- Custom Theme Scripts -->
<script src="<%= request.getContextPath()%>/theme/gentelella/js/custom.min.js"></script>

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

<!-- Custom Theme Scripts -->
<script src="<%= request.getContextPath()%>/theme/gentelella/js/custom.min.js"></script>

<!-- PNotify -->
<script>
    $(document).ready(function() {
        var errorMsg = "${generalResponse.error}";
        var successMsg = "${generalResponse.success}";
        if (errorMsg.length > 0) {
            new PNotify({
                nonblock: { nonblock: true },
                title: 'Oh No!',
                text: errorMsg,
                type: 'error',
                styling: 'bootstrap3'});
        }
        if (successMsg.length > 1) {
            new PNotify({
                nonblock: { nonblock: true },
                title: 'Success',
                text: successMsg,
                type: 'success',
                styling: 'bootstrap3'
            });
        }
    });
</script>
<!-- /PNotify -->

<decorator:getProperty property="page.scripts"/>

</body>
</html>