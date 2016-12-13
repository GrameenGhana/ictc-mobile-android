<%-- 
    Document   : top
    Created on : Nov 14, 2016, 1:09:57 PM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.ictc.models.AisDashboardModel"%>
<%@page import="com.grameenfoundation.ictc.domains.Aisdashboard"%>
<%@page import="com.grameenfoundation.ictc.models.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.*"%>
<%
   UserModel userModel = new UserModel();
   AisDashboardModel  ais  = new AisDashboardModel(); 
    String farm = "farmmonitoring";
    JSONObject x = new JSONObject();
     JSONObject y = new JSONObject();
     x = userModel.getOb();
     
     JSONArray ja = x.getJSONArray("obs");
     JSONObject  fact =  new JSONObject(ais.getIndicatorWrapper(Aisdashboard.TYPE,farm).getData());
     JSONObject  f = fact.getJSONObject(farm);
   

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ACDIVOCA-Main</title>
    <content tag="stylesheets">
        <!-- bootstrap-progressbar -->
        <link href="<%= request.getContextPath()%>/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    </content>
</head>
<body>
    <div class="page-title">
        <div class="title_left">
            <h3>Dashboard</h3>
        </div>

        <div class="title_right">
            <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Go!</button>
                    </span>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="">
                <div class="x_content">
                    <div class="row">
                        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                            <div class="tile-stats">
                                <div class="icon"><a href="<%=request.getContextPath()%>/v2/farmer/acdivocafarmer.jsp"><i class="fa fa-caret-square-o-right"></i></a>
                                </div>
                                <div class="count">SOUTH(ICTC)</div>
                                <h3><a href="<%=request.getContextPath()%>/v2/users/viewobtoag.jsp">OB(s)-<%= ja.length()%></a></h3>
                                <h3><a href="<%=request.getContextPath()%>/v2/farmer/acdivocafarmer.jsp">Farmer(s)-2792</a></h3>

                            </div>
                        </div>
                        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                            <div class="tile-stats">
                                <div class="icon"><a href="#"><i class="fa fa-caret-square-o-right"></i></a>
                                </div>
                                <div class="count">NORTH(AIS)</div>
                                <h3>OB(s)-0</h3>
                                <h3><a href="#">Farmer(s)-<%=f.get("farmercount")%></a></h3>

                            </div>
                        </div>
                    <!--    <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                            <div class="tile-stats">
                                <div class="icon"><a href="<%=request.getContextPath()%>/v2/farmer/import.jsp"><i class="fa fa-caret-square-o-right"></i></a>
                                </div>
                                <div class="count">ADVANCE</div>
                                <h3>OB(s)-0</h3>
                                <h3><a href="<%=request.getContextPath()%>/v2/farmer/import.jsp">Farmer(s)-0</a></h3>

                            </div>
                        </div>-->
                    </div>



                </div>
            </div>
            <div class="row">
                <div>
                    <div class="col-md-3">

                        <div class="x_panel">
                            <div class="x_title">
                                <h2 style="font-size: 15px">SOUTH(ICTC)</h2>
                               
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="buttons">
                                    <!-- Standard button -->
                                    <a href="<%=request.getContextPath()%>/v2/dashboards/outputindicators.jsp"><button type="button"  class="btn btn-default btn-lg" style="width: 150px" >Output Indicators</button></a>
                                    
                                    <br>
                                    <a href="<%=request.getContextPath()%>/v2/dashboards/farmermonitoring.jsp"> <button type="button" class="btn btn-default btn-lg" style="width: 150px" >Farmer Activity Monitoring</button></a>
                                    <br>
                                    
                                   <a href="<%=request.getContextPath()%>/v2/dashboards/agentmonitoring.jsp"><button type="button" class="btn btn-default btn-lg" style="width: 150px" >Agent Activity Monitoring</button></a>
                                    <br>

                                   <!-- <button type="button" class="btn btn-info btn-lg" style="width: 150px" >ADVANCE</button>

                                    <br>-->
                                </div>
                            </div>

                        </div>
                    </div> 
                </div>
                <div >
                    <div class="col-md-3">

                        <div class="x_panel">
                            <div class="x_title">
                                <h2 style="font-size: 15px">NORTH(AIS)</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="buttons">
                                    <!-- Standard button -->
                                     <a href="<%=request.getContextPath()%>/v2/dashboards/aisoutputindicators.jsp"><button type="button" class="btn btn-success btn-lg" style="width: 150px" >NORTH(AIS)</button></a>

                                    <br>

                                    <a href="<%=request.getContextPath()%>/v2/dashboards/aisfarmermonitoring.jsp"><button type="button" class="btn btn-success btn-lg" style="width: 150px" >NORTH(AIS)</button></a>

                                    <br>

                                    <!--<button type="button" class="btn btn-info btn-lg" style="width: 150px" >ADVANCE</button>-->

                                    <br>
                                </div>
                            </div>

                        </div>
                    </div> 
                </div>  
                <div>
                    <div class="col-md-3">

                        <div class="x_panel">
                            <div class="x_title">
                                <h2 style="font-size: 15px">Agent Activity Monitoring</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="buttons">
                                    <!-- Standard button -->
                                    <a href="<%=request.getContextPath()%>/v2/dashboards/agentmonitoring.jsp"><button type="button" class="btn btn-default btn-lg" style="width: 150px" >SOUTH(ICTC)</button></a>
                                    <br>

                                    <a href="<%=request.getContextPath()%>/v2/dashboards/aisagentmonitoring.jsp"><button type="button" class="btn btn-success btn-lg" style="width: 150px" >NORTH(AIS)</button></a>

                                    <br>

                                    <button type="button" class="btn btn-info btn-lg" style="width: 150px" >ADVANCE</button>

                                    <br>
                                </div>
                            </div>

                        </div>
                    </div> 
                </div>  
            </div>
        </div>
    </div>


</body>
</html>
