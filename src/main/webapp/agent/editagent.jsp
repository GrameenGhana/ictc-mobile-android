<%-- 
    Document   : editagent
    Created on : Jun 27, 2016, 12:17:57 PM
    Author     : Joseph George Davis
--%>

<%@page import="org.neo4j.graphdb.Transaction"%>
<%@page import="com.grameenfoundation.ictc.utils.ICTCDBUtil"%>
<%@page import="com.grameenfoundation.ictc.domains.Agent"%>
<%@page import="com.grameenfoundation.ictc.wrapper.AgentWrapper"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.models.AgentModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Agent</title>
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
                      
                          <!--  <div class="span5">
                                <input type="text" value="<%= agent.getEmail()   %>"  placeholder="email" name="email"/>
                            </div>-->
                              
                         <!--   <div class="span5">
                                <input type="text" value="<%= agent.getAgenttype()   %>"  placeholder="Phone Number" name="pn"/>
                            </div>-->
                             
                             <div class="span5">
                                <input type="text" value="<%= agent.getAgenttype()   %>"  placeholder="Agent Type" name="at"/>
                            </div>
                            
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="region">Region <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <select id="rg" name="rg" class="form-control" >
                                <option value="select">------Select Region--------</option>
                                <option value="Upper East">Upper East</option>
                                <option value="Upper West">Upper West</option>
                                <option value="Northern">Northern</option>
                                <option value="Ashanti">Ashanti</option>
                                <option value="Brong Ahafo">Brong Ahafo</option>
                                <option value="Volta">Volta</option>
                            </select>
                        </div>
                      </div>
                          
                            <input type="hidden" name="action" value="edit" />
                           
                            <div>
                                <input type="submit" class="btn btn-primary"  value="Edit Agent" />
                            </div>
                            
                          

                        </form>
                    </div>
                </div>
            </div>
                    <!-- /widget-content --> 
        
    </body>
</html>
