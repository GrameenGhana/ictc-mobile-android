<%-- 
    Document   : view_agent
    Created on : Nov 2, 2015, 10:47:02 AM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.ictc.wrapper.AgentWrapper"%>
<%@page import="com.grameenfoundation.ictc.domains.Agent"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.models.AgentModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agents</title>
        <%
            AgentModel agentModel = new AgentModel();
            List<AgentWrapper> agents = agentModel.findAllAgents();
        
        %>
    </head>
    <body>
         <table class="table table-striped table-bordered">
            <tr>
                <th>Agent Code</th>
                <th>Surname</th>
                <th>Othernames</th>
                <th>Username</th>
                <th>Agent Type</th>
                <th></th>
            </tr>


            <% for (AgentWrapper ag : agents) {%>

            <tr>
                <td><%=ag.getAgentcode()%></td>
                <td><%= ag.getFirstname() %></td>
                <td><%= ag.getLastname() %></td>
                <td><%= ag.getUsername() %></td>
                <td><%= ag.getAgenttype()%></td>
                <td>
                        <a href="<%=request.getContextPath() %>/farmer/search.jsp?type=CreatedById&q=<%=ag.getAgentId() %>" class="label label-important">Farmers </a>
                </td>
                <td>
                    <a href="<%=request.getContextPath() %>/agent/agenttofarmer.jsp?type=CreatedById&q=<%=ag.getAgentId() %>" class="btn btn-info">Assign Farmer(s) </a>
                </td>
            </tr>
            <% }%>
         </table>
    </body>
</html>

</html>
