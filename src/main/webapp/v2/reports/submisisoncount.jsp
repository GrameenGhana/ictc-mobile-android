<%@page import="com.grameenfoundation.ictc.models.FieldCropAssessmentModel"%>
<%@page import="com.grameenfoundation.ictc.models.FmpPostHarvestBudgetModel"%>
<%@page import="com.grameenfoundation.ictc.models.PostHarvestModel"%>
<%@page import="com.grameenfoundation.ictc.models.BaselinePostHarvestBudgetModel"%>
<%@page import="com.grameenfoundation.ictc.models.BaselinePostHarvestModel"%>
<%@page import="com.grameenfoundation.ictc.models.FmpProductionBudgetModel"%>
<%@page import="com.grameenfoundation.ictc.models.ProductionModel"%>
<%@page import="com.grameenfoundation.ictc.models.BaselineProductionBudgetModel"%>
<%@page import="com.grameenfoundation.ictc.models.BaselineProductionModel"%>
<%@page import="com.grameenfoundation.ictc.models.ProfilingModel"%>
<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BiodataModel bio = new BiodataModel();
    ProfilingModel profile = new ProfilingModel();
    BaselineProductionModel bp = new BaselineProductionModel();
    BaselineProductionBudgetModel bpb = new BaselineProductionBudgetModel();
    ProductionModel prod = new ProductionModel();
    FmpProductionBudgetModel prodbudget = new FmpProductionBudgetModel();
    BaselinePostHarvestModel bph = new BaselinePostHarvestModel();
    BaselinePostHarvestBudgetModel bphb = new BaselinePostHarvestBudgetModel();
    PostHarvestModel ph = new PostHarvestModel();
    FmpPostHarvestBudgetModel phb = new FmpPostHarvestBudgetModel();
    FieldCropAssessmentModel fca = new FieldCropAssessmentModel();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Submission Reports</title>
</head>

<body>

    <div class="page-title">
        <div class="title_left">
            <h3>Submission Reports</h3>
        </div>
    </div>

    <div class="clearfix"></div>

    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2>ICTC Aggregated Data</h2>
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
                            <th>Activity</th>
                            <th>ACDIVOCA</th>
                            <th>MOFA</th>
                            <th>Total</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Farmer Registration</td>
                            <td><%= bio.getACDIVOCAFarmerCount()   %></td>
                            <td><%= bio.getMOFAFarmerCount()%></td>
                            <td><%= bio.getACDIVOCAFarmerCount().intValue() + bio.getMOFAFarmerCount().intValue()  %></td>
                        </tr>

                        <tr>
                            <td>Profiling</td>
                            <th scope="row">2</th>
                            <td><%= profile.getACDIVOCAProfileCount()%></td>
                            <td><%= profile.getMOFAProfileCount()%></td>
                            <td><%= profile.getACDIVOCAProfileCount().intValue() + profile.getMOFAProfileCount().intValue()%></td>

                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Baseline Production</td>
                            <td><%= bp.getACDIVOCABaselineProductionCount() %></td>
                            <td><%= bp.getMOFABaselineProductionCount() %></td>
                            <td><%= bp.getACDIVOCABaselineProductionCount().intValue() + bp.getMOFABaselineProductionCount().intValue() %></td>
                        </tr>
                        <!--   <tr>
                                    <td>Baseline Production Budget</td>
                                    <td><%= bpb.getACDIVOCABaselineProductionBudgetCount() %></td>
                                    <td><%= bpb.getMOFABaselineProductionBudgetCount() %></td>
                                    <td><%= bpb.getMOFABaselineProductionBudgetCount().intValue() + bpb.getMOFABaselineProductionBudgetCount().intValue() %></td>
                                </tr>-->

                        <tr>
                            <th scope="row">4</th>
                            <td>FMP Production</td>
                            <td><%= prod.getACDIVOCAFMPProductionCount()   %></td>
                            <td><%= prod.getMOFAFMPProductionCount()   %></td>
                            <td><%= prod.getMOFAFMPProductionCount().intValue() + prod.getMOFAFMPProductionCount().intValue() %></td>
                        </tr>
                        <!--<tr>
                                    <td>FMP Production Budget</td>
                                    <td><%= prodbudget.getACDIVOCAFMPProductionBudgetCount()%></td>
                                    <td><%= prodbudget.getMOFAFMPProductionBudgetCount()%></td>
                                    <td><%= prodbudget.getACDIVOCAFMPProductionBudgetCount().intValue() + prodbudget.getMOFAFMPProductionBudgetCount()%></td>
                                </tr>-->

                        <tr>
                            <th scope="row">5</th>
                            <td>Baseline Post Harvest</td>
                            <td><%= bph.getACDIVOCABaselinePostHarvestCount()   %></td>
                            <td><%= bph.getMOFABaselinePostHarvestCount()   %></td>
                            <td><%= bph.getACDIVOCABaselinePostHarvestCount().intValue() + bph.getMOFABaselinePostHarvestCount().intValue()   %></td>
                        </tr>

                        <!-- <tr>
                                    <td>Baseline Post Harvest Budget</td>
                                    <td><%= bphb.getACDIVOCABaselinePostHarvestBudgetCount()   %></td>
                                    <td><%= bphb.getMOFABaselinePostHarvestBudgetCount()   %></td>
                                    <td><%= bphb.getACDIVOCABaselinePostHarvestBudgetCount()+ bphb.getMOFABaselinePostHarvestBudgetCount()   %></td>
                                </tr>-->
                        <tr>
                            <th scope="row">6</th>
                            <td>FMP Post Harvest</td>
                            <td><%= ph.getACDIVOCAFMPPostHarvestCount()   %></td>
                            <td><%= ph.getMOFAFMPPostHarvestCount()  %></td>
                            <td><%= ph.getACDIVOCAFMPPostHarvestCount().intValue() + ph.getMOFAFMPPostHarvestCount().intValue()   %></td>
                        </tr>
                        <!-- <tr>
                                    <td>FMP Post Harvest Budget</td>
                                    <td><%= phb.getACDIVOCAFMPPostHarvestBudgetBudgetCount()%></td>
                                    <td><%= phb.getMOFAFMPPostHarvestBudgetCount()%></td>
                                    <td><%= phb.getACDIVOCAFMPPostHarvestBudgetBudgetCount().intValue() + phb.getMOFAFMPPostHarvestBudgetCount().intValue()  %></td>
                                </tr>-->
                        <tr>
                            <th scope="row">7</th>
                            <td>Crop Assessment</td>
                            <td><%= fca.getACDIVOCAFCPCount()  %></td>
                            <td><%= fca.getACDIVOCAFCPCount()  %></td>
                            <td><%= fca.getACDIVOCAFCPCount().intValue() + fca.getMOFAFCPCount().intValue()   %></td>
                        </tr>
                        <tr>
                            <th scope="row">8</th>
                            <td>Updates</td>
                            <td><%= bio.getACDIVOCAUpdateCount() %></td>
                            <td><%= bio.getMOFAUpdateCount() %></td>
                            <td><%= bio.getACDIVOCAUpdateCount().intValue() + bio.getMOFAUpdateCount().intValue()   %></td>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>
</body>
</html>

