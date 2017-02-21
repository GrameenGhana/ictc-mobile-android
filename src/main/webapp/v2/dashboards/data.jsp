<%-- 
    Document   : data
    Created on : Feb 8, 2017, 4:10:01 PM
    Author     : spomega
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="nav-md">
         <div class="page-title" style="margin-bottom: 30px;">
            <div class="title_left">
                <h3>Grameen Dashboard <small>indicators for m&e</small></h3>
            </div>
        </div>

        <div class="clearfix"></div>

        <div class="row">
              <!-- Output Indicators -->
            <div style="margin-bottom: 30px; margin-top:30px" class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Farmer:John Gbafa(Ofa Yoo) <small></small></h2>
                            <ul class="nav navbar-right panel_toolbox">
                              
                            </ul>
                            <div class="clearfix"></div>
                        </div>

                        <div class="x_content">
                            <table id="output-table" class="table table-striped table-bordered jambo_table">
                                <thead>
                                    <tr>
                                        <th>Indicator</th>
                                        <th>Previous</th>
                                        <th>Target</th>
                                        <th>Actual</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Area(acres)</td>
                                        <td>1</td>
                                        <td>2</td>
                                        <td>2</td>
                                    </tr>
                                    <tr>
                                        <td>Total yield(bags=100kg)</td>
                                        <td>15</td>
                                        <td>20</td>
                                        <td>23</td>
                                    </tr>
                                    <tr>
                                        <td>Total Revenue(GHS)</td>
                                        <td>1500</td>
                                        <td>2000</td>
                                        <td>2760</td>
                                    </tr>
                                    <tr>
                                        <td>Total Cost(GHS)</td>
                                        <td>600</td>
                                        <td>900</td>
                                        <td>1000</td>
                                    </tr>
                                    <tr>
                                        <td>Gross Margin(GHS)</td>
                                        <td>900</td>
                                        <td>1100</td>
                                        <td>1760</td>
                                    </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
            </div>
        </div>

    </body>
</html>
