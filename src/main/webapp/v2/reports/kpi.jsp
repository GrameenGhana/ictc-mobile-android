<%@ page import="com.grameenfoundation.ictc.models.BiodataModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% BiodataModel bio = new BiodataModel(); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>KPI Reports</title>
</head>

<body>

    <div class="page-title">
        <div class="title_left">
            <h3>KPI Reports</h3>
        </div>
    </div>

    <div class="clearfix"></div>

    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2>ICTC KPI Data</h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Parameter</th>
                            <th>Value</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Farmers</td>
                            <td><%= bio.getFarmerCount()%></td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Profiling</td>
                            <td><%= bio.getProfileCount() %></td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Baseline Production</td>
                            <td><%= bio.getBaselineProductionCount() %></td>
                        </tr>
                        <tr>
                            <th scope="row">4</th>
                            <td>Baseline Production Budget</td>
                            <td><%= bio.getBaselineProductionBudgetCount() %></td>
                        </tr>

                        <tr>
                            <th scope="row">5</th>
                            <td>FMP Production</td>
                            <td><%= bio.getFMPProductionCount()   %></td>
                        </tr>
                        <tr>
                            <th scope="row">6</th>
                            <td>FMP Production Budget</td>
                            <td><%= bio.getFMPProductionBudgetCount()   %></td>
                        </tr>

                        <tr>
                            <th scope="row">7</th>
                            <td>Baseline Post Harvest</td>
                            <td><%= bio.getBaselinePostHarvestCount()   %></td>
                        </tr>

                        <tr>
                            <th scope="row">8</th>
                            <td>Baseline Post Harvest Budget</td>
                            <td><%= bio.getBaselinePostHarvestBudgetCount()   %></td>
                        </tr>
                        <tr>
                            <th scope="row">9</th>
                            <td>FMP Post Harvest</td>
                            <td><%= bio.getFMPPostHarvestCount()   %></td>
                        </tr>
                        <tr>
                            <th scope="row">10</th>
                            <td>FMP Post Harvest Budget</td>
                            <td><%= bio.getFMPPostHarvestBudgetCount()  %></td>
                        </tr>
                        <tr>
                            <th scope="row">11</th>
                            <td>Crop Assessment</td>
                            <td><%= bio.getCropAssessmentCount()  %></td>
                        </tr>
                        <tr>
                            <th scope="row">12</th>
                            <td>Updates</td>
                            <td><%= bio.getUpdateCount()  %></td>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>

</body>
</html>

