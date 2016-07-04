<%-- 
    Document   : deleteaggent
    Created on : Jun 27, 2016, 5:38:43 PM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.ictc.wrapper.AgentWrapper"%>
<%@page import="com.grameenfoundation.ictc.models.AgentModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Agent</title>
         <%
             AgentModel agentModel = new AgentModel();
          
             AgentWrapper agent = agentModel.findAgent(request.getParameter("q"));
             System.out.print("agent user " + agent.getUsername());
             
        %>
    </head>
    <body>
        
           <!-- /widget-header -->
            <div class="widget-content">
                <div class="widget big-stats-container">
                    <div class="widget-content">
                        <h6 class="bigstats">.</h6>
                        <form action="<%=request.getContextPath()%>/agent/add" method="post" >
                            <div class="span5">
                             <input type="text" value="<%= agent.getFirstname()   %>"  placeholder="firstname" name="fn"/>
                            </div>
                            
                            <div class="span5">
                                <input type="text" value="<%= agent.getLastname()   %>"  placeholder="lastname" name="ln"/>
                            </div>
                             <div class="span5">
                                <input type="text" value="<%= agent.getUsername()   %>"  placeholder="username" name="un"/>
                            </div>
                             <div class="span5">
                                <input type="text" value="<%= agent.getAgenttype()   %>"  placeholder="Agent Type" name="at"/>
                            </div>
                          
                            <input type="hidden" name="action" value="delete" />
                           
                            <div>
                                <input type="submit" class="btn btn-primary"  value="delete Agent" />
                            </div>
                            
                          

                        </form>
                    </div>
                </div>
            </div>
                    <!-- /widget-content --> 
        
    </body>
</html>
