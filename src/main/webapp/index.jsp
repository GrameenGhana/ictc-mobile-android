<%-- 
    Document   : index.php
    Created on : Aug 13, 2015, 1:48:09 PM
    Author     : skwakwa
--%>

<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%BiodataModel bioModel = new BiodataModel(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ICT Challenge</title>
    </head>
    <body>
        <div class="span6">
            <div class="widget widget-nopad">
                <div class="widget-header"> <i class="icon-list-alt"></i>
                    <h3>Stats</h3>
                </div>
                <!-- /widget-header -->
                <div class="widget-content">
                    <div class="widget big-stats-container">
                        <div class="widget-content">
                            <h6 class="bigstats">.</h6>
                            <div id="big_stats" class="cf">
                                <div class="stat"> <i class="icon-anchor"></i> <span class="value"><%=bioModel.getFarmerCount() %></span> 
                                    <div>Total Farmers</div>
                                </div>
                                <!-- .stat -->

                                <div class="stat"> <i class="icon-thumbs-up-alt"></i> <span class="value"><%=bioModel.getCommunityCount() %></span>    
                                    <div>Communities</div></div>
                                <!-- .stat -->

                                <div class="stat"> <i class="icon-twitter-sign"></i> <span class="value">-</span>    
                                    <div>Agents</div></div>
                                <!-- .stat -->

                             </div>
                                <!-- .stat --> 
                            </div>
                        </div>
                        <!-- /widget-content --> 

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
