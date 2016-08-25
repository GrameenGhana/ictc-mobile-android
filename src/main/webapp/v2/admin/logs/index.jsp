<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.grameenfoundation.ictc.wrapper.MobileTrackerWrapper"%>
<%@page import="com.grameenfoundation.ictc.models.MobileTrackerModel"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    MobileTrackerModel biodataModel = new MobileTrackerModel();
    String format = "EEE, MMM d, ''yy  HH:mm";
      
    SimpleDateFormat simpleDate = new SimpleDateFormat(format);
        
    String s = request.getParameter("s");
    String e = request.getParameter("d");
    SimpleDateFormat todateDate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat todateDates = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    if(s==null || s.isEmpty()){ s= todateDate.format(new Date()) ; }
    if(e==null || e.isEmpty()){ e= todateDate.format(new Date()) ; }
        
    Date startDate = todateDates.parse(s+" 00:00:00");
    Date endDate = todateDates.parse(e+" 23:59:59");
        
    List<MobileTrackerWrapper> trackItems = biodataModel.findAll(startDate,endDate);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Logs Page</title>
    </head>
    <body class="nav-md">
        <div class="page-title">
                <div class="title_left">
                    <h3>Logs <small>service usage logs</small></h3>
                </div>
            </div>

        <div class="clearfix"></div>

        <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <form class="form-inline" method="get">
                                <div class="form-group">
                                    <input class="form-control" type="text" name="q" placeholder="search" />
                                </div>
                                <div class="form-group">
                                    <input type="text" name="s" data-date-format="yyyy-mm-dd"  id='sdate' placeholder="Start Date"  class="form-control" value="<%=s %>"/>
                                </div>
                                <div class="form-group">
                                    <input type="text" name="e" data-date-format="yyyy-mm-dd" id='edate' placeholder="End Date" class="form-control"  value="<%=e %>" />
                                </div>
                                <button type="submit" name="Search" class="btn btn-info">Search</button>
                                <!--
                                <a href='<%=request.getContextPath() %>//sys/report?action=logs&s=<%=s %>&e=<%=e %>'>Download</a>
                                -->
                            </form>
                            <!--
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a> </li>
                            </ul>
                            -->
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">


                            <table id="datatable-buttons" class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>User</th>
                                        <th>Module</th>
                                        <th>Page</th>
                                        <th>Section</th>
                                        <th>Start</th>
                                        <th>End</th>
                                        <th>Time Spent</th>
                                        <th>Version</th>
                                        <th>Battery</th>
                                        <th>IMEI</th>
                                    </tr>
                                </thead>

                                <tbody>
                                <% for (MobileTrackerWrapper mobileTracker : trackItems) {%>
                                    <tr>
                                        <td><%= mobileTracker.getId()%></td>
                                        <td><%= mobileTracker.getUserId()  %></td>
                                        <td><%= mobileTracker.getModule()%></td>
                                        <td><%= mobileTracker.getPage()%></td>
                                        <td><%= mobileTracker.getSection()%></td>
                                        <td><%= simpleDate.format(new Date(mobileTracker.getStartTime())) %></td>
                                        <td><%= simpleDate.format(new Date(mobileTracker.getEndTime()))%></td>
                                        <td><%= String.valueOf(mobileTracker.getTimeSpent()/1000)%></td>
                                        <td><%= mobileTracker.getVersion()%></td>
                                        <td><%= mobileTracker.getBattery()%></td>
                                        <td><%= mobileTracker.getImei()%></td>
                                    </tr>
                                <% }%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
    </body>
    
    <content tag="scripts"><!-- Datatables -->
        <script>
            $(document).ready(function() {
                var handleDataTableButtons = function() {
                    if ($("#datatable-buttons").length) {
                        $("#datatable-buttons").DataTable({
                            dom: "Bfrtip",
                            buttons: [
                                {
                                    extend: "copy",
                                    className: "btn-sm"
                                },
                                {
                                    extend: "csv",
                                    className: "btn-sm"
                                },
                                {
                                    extend: "excel",
                                    className: "btn-sm"
                                },
                                {
                                    extend: "pdfHtml5",
                                    className: "btn-sm"
                                },
                                {
                                    extend: "print",
                                    className: "btn-sm"
                                },
                            ],
                            responsive: true
                        });
                    }
                };
                TableManageButtons = function () {
                    "use strict";
                    return {
                        init: function () {
                            handleDataTableButtons();
                        }
                    };
                }();
                TableManageButtons.init();
            });
        </script>
        <!-- /Datatables -->

        <script type="text/javascript">
           $('#sdate').datepicker();
           $('#edate').datepicker();
        </script>
    </content>
</html>
