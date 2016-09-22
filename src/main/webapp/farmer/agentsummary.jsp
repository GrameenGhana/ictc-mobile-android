<%-- 
    Document   : agentsummary
    Created on : May 30, 2016, 2:32:23 PM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.wrapper.AgentWrapper"%>
<%@page import="com.grameenfoundation.ictc.utils.ICTCDBUtil"%>
<%@page import="org.neo4j.graphdb.Transaction"%>
<%@page import="com.grameenfoundation.ictc.models.AgentModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
 AgentModel agentModel = new AgentModel();
 BiodataModel biodataModel = new BiodataModel();
 
   Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx();
   List<AgentWrapper> agent = agentModel.findAllAgents();

   


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agent Summary</title>
    </head>
    <body>
       <table class="table table-striped table-bordered my-table">
            <tr>
                <th>Agent</th>
                <th>Farmers</th>
                <th>Profiling</th>
                <th>Baseline Production</th>
                <th>Baseline Production Budget</th>
                <th>Baseline Post Harvest</th>
                <th>Baseline Post Harvest Budget</th>
                <th>FMP Production</th>
                <th>FMP Post Harvest</th>
                <th>Crop Assessment</th>
                
                
              
                
            </tr>


            <% for (AgentWrapper a :agent) {%>

            <tr>
                <td><%= a.getFirstname()  + " " + a.getLastname() %></td>
                <td><%= biodataModel.getFarmerCountByAgent(a.getAgentId())  %></td>
                <td><%= biodataModel.getFarmerProfileCountByAgent(a.getAgentId())  %></td>
                <td><%= biodataModel.getFarmerBaselinProductionCountByAgent(a.getAgentId())  %></td>
                <td><%= biodataModel.getFarmerBaselineProductionBudgetCountByAgent(a.getAgentId()) %></td>
                <td><%= biodataModel.getFarmerBaselinePostHarvestCountByAgent(a.getAgentId()) %></td>
                <td><%= biodataModel.getFarmerBaselinePostHarvestBudgetCountByAgent(a.getAgentId()) %></td>
                <td><%= biodataModel.getFarmerFMPProductionCountByAgent(a.getAgentId()) %></td>
                <td><%= biodataModel.getFarmerFMPPostHarvestCountByAgent(a.getAgentId()) %></td>
                <td><%= biodataModel.getFarmerCropAssessment(a.getAgentId()) %></td>
            </tr>
            <% }
            
            tx.success();
            
            %>

        </table>
    </body>
</html>
