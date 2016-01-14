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
                                    
                                    <span class="value"><a href="<%=request.getContextPath() %>/farmer"><%=bioModel.getFarmerCount()%></a></span> 
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
    </div>
</body>
</html>
