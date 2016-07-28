<%-- 
    Document   : submissioncount
    Created on : Jun 28, 2016, 4:32:34 PM
    Author     : Joseph George Davis
--%>

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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ICTC Challenge</title>
    </head>
    <body>
        <div class="span4">
            <div class="widget widget-nopad">
                <div class="widget-header"> <i class="icon-list-alt"></i>
                    <h3>ICTC Aggregated Data</h3>
                </div>
                <!-- /widget-header -->
                <div class="widget-content">
                    <div class="widget big-stats-container">
                        <div class="widget-content"  style="padding: 5px">
                           
                            <table class='table table-striped table-bordered' >
                                <tr>
                                    <th>Activity</th>
                                    <th>ACDIVOCA</th>
                                    <th>MOFA</th>
                                    <th>Total</th>
                                </tr>
                               
                                  <tr>
                                    <td>Farmer Registration</td>
                                    <td><%= bio.getACDIVOCAFarmerCount()   %></td>
                                    <td><%= bio.getMOFAFarmerCount()%></td>
                                    <td><%= bio.getACDIVOCAFarmerCount().intValue() + bio.getMOFAFarmerCount().intValue()  %></td>
                                    
                                </tr>
                                 

                                <tr>
                                    <td>Profiling</td>
                                    <td><%= profile.getACDIVOCAProfileCount()%></td>
                                    <td><%= profile.getMOFAProfileCount()%></td>
                                    <td><%= profile.getACDIVOCAProfileCount().intValue() + profile.getMOFAProfileCount().intValue()%></td>

                                </tr>
                                 <tr>
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
                                    <td>Crop Assessment</td>
                                    <td><%= fca.getACDIVOCAFCPCount()  %></td>
                                    <td><%= fca.getMOFAFCPCount()  %></td>
                                    <td><%= fca.getACDIVOCAFCPCount().intValue() + fca.getMOFAFCPCount().intValue()   %></td>
                                </tr>
                                <tr>
                                    <td>Updates</td>
                                    <td><%= bio.getACDIVOCAUpdateCount() %></td>
                                    <td><%= bio.getMOFAUpdateCount() %></td>
                                     <td><%=bio.getACDIVOCAUpdateCount().intValue() + bio.getMOFAUpdateCount().intValue()   %></td>
                                </tr>
                                
                            </table>
                        </div>
                    </div>
                    <!-- /widget-content --> 

                </div>
            </div>
        </div>
    </body>
</html>
