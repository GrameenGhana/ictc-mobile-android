<%-- 
    Document   : acdivoca
    Created on : Mar 23, 2016, 2:11:30 PM
    Author     : Joseph George Davis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.grameenfoundation.ictc.utils.ICTCUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.wrapper.ListItem"%>
<%@page import="com.grameenfoundation.ictc.models.ReportModel"%>
<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%BiodataModel bioModel = new BiodataModel();
   // ReportModel rModel = new ReportModel();

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
                                    
                                    <span class="value"><a href="<%=request.getContextPath() %>/farmer/acdivocafarmer.jsp"><%=bioModel.getACDIVOCAFarmerCount()%></a></span> 
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
                                        <a href="<%=request.getContextPath() %>/agent/acdivoca_agent.jsp"><%=bioModel.getACDIVOCAAgentCount()%> </a></span>    
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



</body>
</html>
