<%-- 
    Document   : index
    Created on : Aug 18, 2015, 1:36:35 PM
    Author     : skwakwa
--%>

<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% BiodataModel biomModel = new BiodataModel();

    List<String> communities = biomModel.getCommunitiesList();
    List<String> vils = biomModel.getVillageList(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report</title>
    </head>
    <body>
        <div class="span5">
            <div class="widget widget-nopad">
                <div class="widget-header"> <i class="icon-list-alt"></i>
                    <h3>Farmer Reports</h3>
                </div>
                <!-- /widget-header -->
                <div class="widget-content">
                    <div class="widget big-stats-container">
                        <div class="widget-content">
                            <h6 class="bigstats">.</h6>
                            <form action="<%=request.getContextPath() %>/sys/report" method="get" >
                            <div class="span5">
                                <input type="text" value=""  placeholder="Name" name="nm"/>
                            </div>
                            <div class="span5">
                                <select name="mc">
                                    <option value="">All Crops</option>
                                    
                                </select>
                            </div>
                            <div class="span5">
                                <select name="cm">
                                    <option value="">All Communities</option>
                                    <%  for (String cm : communities) {%>
                                    <option value="<%=cm%>"><%=cm%></option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="span5">
                                <select name="vl">
                                    <option value="">All Villages</option>
                                    <%  for (String cm : vils) {%>
                                    <option value="<%=cm%>"><%=cm%></option>
                                    <% }%>
                                </select>
                            </div>
                                <input type="hidden" name="action" value="farmer" />
                                <input type="submit" class="btn btn-primary"  value="Farmer Report" />
 </form>
                        </div>
                                   
                        <!-- /widget-content --> 

                    </div>
                </div>
            </div>
        </div>  <div class="span5">
            <div class="widget widget-nopad">
                <div class="widget-header"> <i class="icon-list-alt"></i>
                    <h3>Agent Reports</h3>
                </div>
                <!-- /widget-header -->
                <div class="widget-content">
                    <div class="widget big-stats-container">
                        <div class="widget-content">
                            <h6 class="bigstats">.</h6>

                        </div>
                        <!-- /widget-content --> 

                    </div>
                </div>
            </div>
        </div>

        <div class="span5">
            <div class="widget widget-nopad">
                <div class="widget-header"> <i class="icon-list-alt"></i>
                    <h3>Adoptation Reports</h3>
                </div>
                <!-- /widget-header -->
                <div class="widget-content">
                    <div class="widget big-stats-container">
                        <div class="widget-content">
                            <h6 class="bigstats">.</h6>

                        </div>
                        <!-- /widget-content --> 

                    </div>
                </div>
            </div>
        </div><div class="span5">
            <div class="widget widget-nopad">
                <div class="widget-header"> <i class="icon-list-alt"></i>
                    <h3>Training Reports</h3>
                </div>
                <!-- /widget-header -->
                <div class="widget-content">
                    <div class="widget big-stats-container">
                        <div class="widget-content">
                            <h6 class="bigstats">.</h6>

                        </div>
                        <!-- /widget-content --> 

                    </div>
                </div>
            </div>
        </div>

        <div class="span5">
            <div class="widget widget-nopad">
                <div class="widget-header"> <i class="icon-list-alt"></i>
                    <h3>KPI Reports</h3>
                </div>
                <!-- /widget-header -->
                <div class="widget-content">
                    <div class="widget big-stats-container">
                        <div class="widget-content">
                            <h6 class="bigstats">.</h6>

                        </div>
                        <!-- /widget-content --> 

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
