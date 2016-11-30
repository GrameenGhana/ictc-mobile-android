<%-- 
    Document   : top
    Created on : Nov 14, 2016, 1:09:57 PM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.ictc.models.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.*"%>
<%
   UserModel userModel = new UserModel();
   
    JSONObject x = new JSONObject();
     JSONObject y = new JSONObject();
     x = userModel.getOb();
     
     JSONArray ja = x.getJSONArray("obs");
   

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
                                <div class="count">ICTC</div>
                                <h3><a href="<%=request.getContextPath()%>/v2/users/viewobtoag.jsp">OB(s)-<%= ja.length()%></a></h3>
                                <h3><a href="<%=request.getContextPath()%>/v2/farmer/acdivocafarmer.jsp">Farmer(s)-2792</a></h3>

                            </div>
                        </div>
                        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                            <div class="tile-stats">
                                <div class="icon"><a href="#"><i class="fa fa-caret-square-o-right"></i></a>
                                </div>
                                <div class="count">AIS</div>
                                <h3>OB(s)-120</h3>
                                <h3><a href="#">Farmer(s)-300</a></h3>

                            </div>
                        </div>
                        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                            <div class="tile-stats">
                                <div class="icon"><a href="<%=request.getContextPath()%>/v2/farmer/import.jsp"><i class="fa fa-caret-square-o-right"></i></a>
                                </div>
                                <div class="count">ADVANCE</div>
                                <h3>OB(s)-100</h3>
                                <h3><a href="<%=request.getContextPath()%>/v2/farmer/import.jsp">Farmer(s)-123</a></h3>

                            </div>
                        </div>
                    </div>



                </div>
            </div>
            <div class="row">
                <div>
                    <div class="col-md-3">

                        <div class="x_panel">
                            <div class="x_title">
                                <h2 style="font-size: 15px">Output Indicators</h2>
                               
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="buttons">
                                    <!-- Standard button -->
                                    <a href="<%=request.getContextPath()%>/v2/dashboards/outputindicators.jsp"><button type="button"  class="btn btn-default btn-lg" style="width: 150px" >ICTC</button></a>
                                    <br>

                                    <button type="button" class="btn btn-success btn-lg" style="width: 150px" >AIS</button>

                                    <br>

                                    <button type="button" class="btn btn-info btn-lg" style="width: 150px" >ADVANCE</button>

                                    <br>
                                </div>
                            </div>

                        </div>
                    </div> 
                </div>
                <div >
                    <div class="col-md-3">

                        <div class="x_panel">
                            <div class="x_title">
                                <h2 style="font-size: 15px">Farmer Activity Monitoring</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="buttons">
                                    <!-- Standard button -->
                                    <a href="<%=request.getContextPath()%>/v2/dashboards/farmermonitoring.jsp"> <button type="button" class="btn btn-default btn-lg" style="width: 150px" >ICTC</button></a>
                                    <br>

                                    <button type="button" class="btn btn-success btn-lg" style="width: 150px" >AIS</button>

                                    <br>

                                    <button type="button" class="btn btn-info btn-lg" style="width: 150px" >ADVANCE</button>

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
                                    <a href="<%=request.getContextPath()%>/v2/dashboards/agentmonitoring.jsp"> <button type="button" class="btn btn-default btn-lg" style="width: 150px" >ICTC</button></a>
                                    <br>

                                    <button type="button" class="btn btn-success btn-lg" style="width: 150px" >AIS</button>

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
