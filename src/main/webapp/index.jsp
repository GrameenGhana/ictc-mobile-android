<%-- 
    Document   : index.php
    Created on : Aug 13, 2015, 1:48:09 PM
    Author     : skwakwa
--%>

<%@page import="com.grameenfoundation.ictc.utils.ICTCUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.wrapper.ListItem"%>
<%@page import="com.grameenfoundation.ictc.models.ReportModel"%>
<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%BiodataModel bioModel = new BiodataModel();
    ReportModel rModel = new ReportModel();
    
    int farmercount = bioModel.getACDIVOCAFarmerCount().intValue() + bioModel.getMOFAFarmerCount().intValue();
    
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ICT Challenge</title>
    </head>
    <body>
        <div class="span11">
            <div class="widget widget-nopad">
                <div class="widget-header"> <i class="icon-list-alt"></i>
                    <h3>Stats</h3>
                </div>
                <!-- /widget-header -->
                <div class="widget-content">
                    <div class="widget big-stats-container">
                        <div class="widget-content">
                     
                            <div id="big_stats" class="cf">
                                <div class="stat"> <i class="icon-anchor"></i>
                                    
                                    <span class="value"><a href="<%=request.getContextPath() %>/farmer"><%=farmercount %></a></span> 
                                    <div>Total Farmers</div>
                                </div>
                                <!-- .stat -->

                                <div class="stat"> <i class="icon-thumbs-up-alt"></i> <span class="value">
                                        <a href="<%=request.getContextPath() %>/community">
                                            <%=bioModel.getCommunityCount()%></a></span>    
                                    <div>Communities</div></div>
                                <!-- .stat -->

                                <div class="stat">
                                    <i class="icon-twitter-sign"></i> <span class="value">
                                        <a href="<%=request.getContextPath() %>/agent/view_agent.jsp"><%=bioModel.getAgentCount()%> </a></span>    
                                    <div>Agents</div>
                                    
                                         
                                </div>
                                <!-- .stat -->

                            </div>
                            <!-- .stat --> 
                        </div>
                    </div>
                    <!-- /widget-content --> 

                </div>
            </div>
        </div>

            <div class="span4">
            <div class="widget widget-nopad">
                <div class="widget-header"> <i class="icon-list-alt"></i>
                    <h3>Farmer Registration </h3>
                </div>
                <!-- /widget- -->
                <div class="widget-content">
                    <div class="widget big-stats-container">
                     <div class="widget-content" style="padding: 5px">
                           
                    <div style="width: 400px; height: 200px; margin: 0 auto">
                                <div id="container-speed" style="width: 300px; height:200px; float:none"></div>
                       
                           
                       </div>
                    </div>
                    <!-- /widget-content --> 

                </div>
            </div>
        </div>
            </div>
   
   <div class="span4">
            <div class="widget widget-nopad">
                <div class="widget-header"> <i class="icon-list-alt"></i>
                    <h3>Registered Farmer Chart</h3>
                </div>
                <!-- /widget- -->
                <div class="widget-content">
                    <div class="widget big-stats-container">
                     <div class="widget-content" style="padding: 5px">
                         
                          <div id="container"  style="width: 300px;" ></div> 
                     </div>
                    <!-- /widget-content --> 

                </div>
            </div>
        </div>
            </div>
        <div class="span4">
            <div class="widget widget-nopad">
                <div class="widget-header"> <i class="icon-list-alt"></i>
                    <h3>Totals</h3>
                </div>
                <!-- /widget-header -->
                <div class="widget-content">
                    <div class="widget big-stats-container">
                        <div class="widget-content" style="padding: 5px">
                           
                            <table class='table table-striped table-bordered' >
                                <tr>
                                    <th>Totals</th>
                                    <th>Values</th>
                                </tr>
                                <%
                                    List<ListItem> totals = rModel.getInfos();
                                    for (ListItem item : totals) {
                                       
                                %>

                                <tr>
                                    <td><%=item.getName()%></td>
                                    <td><%=ICTCUtil.formatToDecimal(item.getValue(),2)%></td>
                                </tr>
                                <% }%>
                            </table>
                        </div>
                    </div>
                    <!-- /widget-content --> 

                </div>
            </div>
        </div>



        <div class="span3">
            <div class="widget widget-nopad">
                <div class="widget-header"><i class="icon-list-alt"></i>
                    <h3>Averages</h3>
                </div>
                <!-- /widget-header -->
                <div class="widget-content">
                    <div class="widget big-stats-container">
                        <div class="widget-content"  style="padding: 5px">
                        
                            <table class='table table-striped table-bordered' >
                                <tr>
                                    <th>Averages</th>
                                    <th>Values</th>
                                </tr>
                                <%
                                    totals = rModel.getAverageInfos();
                                    for (ListItem item : totals) {
                                %>

                                <tr>
                                    <td><%=item.getName()%></td>
                                    <td><%=ICTCUtil.formatToDecimal(item.getValue(),2)%></td>
                                </tr>
                                <% } %>
                            </table>
                        </div>
                    </div>
                    <!-- /widget-content --> 

                </div>
            </div>
        </div>

        <div class="span4">
            <div class="widget widget-nopad">
                <div class="widget-header"> <i class="icon-list-alt"></i>
                    <h3>Revenue</h3>
                </div>
                <!-- /widget-header -->
                <div class="widget-content">
                    <div class="widget big-stats-container">
                        <div class="widget-content"  style="padding: 5px">
                           
                            <table class='table table-striped table-bordered' >
                                <tr>
                                    <th>Totals</th>
                                    <th>Values</th>
                                </tr>
                                <%
                                    totals = rModel.getRevenues();
                                    for (ListItem item : totals) {
                                %>

                                <tr>
                                    <td><%=item.getName()%></td>
                                    <td><%=ICTCUtil.formatToDecimal(item.getValue(),2)%></td>
                                </tr>
                                <% }%>
                            </table>
                        </div>
                    </div>
                    <!-- /widget-content --> 

                </div>
            </div>
        </div>
  
   <script type="text/javascript">
                            
     $(function () {

    var gaugeOptions = {

        chart: {
            type: 'solidgauge'
        },

        title: null,

        pane: {
            center: ['50%', '85%'],
            size: '140%',
            startAngle: -90,
            endAngle: 90,
            background: {
                backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || '#EEE',
                innerRadius: '60%',
                outerRadius: '100%',
                shape: 'arc'
            }
        },

        tooltip: {
            enabled: false
        },

        // the value axis
        yAxis: {
            stops: [
                [0.1, '#55BF3B'], // green
                [0.5, '#DDDF0D'], // yellow
                [0.9, '#DF5353'] // red
            ],
            lineWidth: 0,
            minorTickInterval: null,
            tickPixelInterval: 400,
            tickWidth: 0,
            title: {
                y: -70
            },
            labels: {
                y: 16
            }
        },

        plotOptions: {
            solidgauge: {
                dataLabels: {
                    y: 5,
                    borderWidth: 0,
                    useHTML: true
                }
            }
        }
    };

    // The speed gauge
    $('#container-speed').highcharts(Highcharts.merge(gaugeOptions, {
        yAxis: {
            min: 0,
            max: 5000,
            title: {
                text: 'Farmers'
            }
        },

        credits: {
            enabled: false
        },

        series: [{
            name: 'Farmers',
            data: [<%= farmercount %>],
            dataLabels: {
                format: '<div style="text-align:center"><span style="font-size:25px;color:' +
                    ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y}</span><br/>' +
                       '<span style="font-size:12px;color:silver">Farmers</span></div>'
            },
            tooltip: {
                valueSuffix: 'Farmers'
            }
        }]

    }));

    // The RPM gauge
    $('#container-rpm').highcharts(Highcharts.merge(gaugeOptions, {
        yAxis: {
            min: 0,
            max: 5,
            title: {
                text: 'RPM'
            }
        },

        series: [{
            name: 'RPM',
            data: [1],
            dataLabels: {
                format: '<div style="text-align:center"><span style="font-size:25px;color:' +
                    ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y:.1f}</span><br/>' +
                       '<span style="font-size:12px;color:silver">* 1000 / min</span></div>'
            },
            tooltip: {
                valueSuffix: ' revolutions/min'
            }
        }]

    }));

    // Bring life to the dials
   /* setTimeout(function () {
        // Speed
        var chart = $('#container-speed').highcharts(),
            point,
            newVal,
            inc;

        if (chart) {
            point = chart.series[0].points[0];
            inc = Math.round((Math.random() - 0.5) * 100);
            newVal = point.y + inc;

            if (newVal < 0 || newVal > 5000) {
                newVal = point.y - inc;
            }

            point.update(newVal);
        }

        // RPM
        chart = $('#container-rpm').highcharts();
        if (chart) {
            point = chart.series[0].points[0];
            inc = Math.random() - 0.5;
            newVal = point.y + inc;

            if (newVal < 0 || newVal > 5) {
                newVal = point.y - inc;
            }

            point.update(newVal);
        }
    }, 2000);*/


});  

$(function () {
    $('#container').highcharts({
        chart: {
            type: 'column',
            options3d: {
                enabled: true,
                alpha: 10,
                beta: 25,
                depth: 50
            }
        },
        title: {
            text: ''
        },
        subtitle: {
            text: ''
        },
        plotOptions: {
            column: {
                depth: 25
            }
        },
        xAxis: {
            categories: ['ACDIVOCA','MOFA']
        },
        yAxis: {
            title: {
                text: null
            }
        },
        series: [{
            name: 'Registered Farmers By Partner',
            data: [<%=bioModel.getACDIVOCAFarmerCount().intValue()%>,<%= bioModel.getMOFAFarmerCount().intValue()%>]
        }]
    });
});

    </script>
</body>
</html>
