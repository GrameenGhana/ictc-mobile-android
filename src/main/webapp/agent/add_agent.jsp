<%-- 
    Document   : add_agent
    Created on : Oct 7, 2015, 6:28:37 PM
    Author     : Joseph George Davis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Agent</title>
    </head>
    <body>
        
           
            <!-- /widget-header -->
            <div class="widget-content">
                <div class="widget big-stats-container">
                    <div class="widget-content">
                        <h6 class="bigstats">.</h6>
                        <form action="<%=request.getContextPath()%>/agent/add" method="post" >
                            <div class="span5">
                                <input type="text" value=""  placeholder="firstname" name="fn"/>
                            </div>
                            
                             <div class="span5">
                                <input type="text" value=""  placeholder="lastname" name="ln"/>
                            </div>
                             <div class="span5">
                                <input type="text" value=""  placeholder="username" name="un"/>
                            </div>
                            <div class="span5">
                                <input type="password" value=""  placeholder="password" name="password"/>
                            </div>
                            <div class="span5">
                                <input type="text" value=""  placeholder="email" name="email"/>
                            </div>
                              
                            <div class="span5">
                                <input type="text" value=""  placeholder="Phone Number" name="pn"/>
                            </div>
                            
                            <div class="span5">
                                <input type="text" value=""  placeholder="Agent Code " name="ac"/>
                            </div>
                           
                             <div class="span5">
                                <input type="text" value=""  placeholder="Agent Type" name="at"/>
                            </div>
                            <div class="span5">
                             <div class="col-md-6 col-sm-6 col-xs-12">
                            <select id="rg" name="rg" class="form-control" >
                                <option value="select">------Select Region--------</option>
                                <option value="Northern">Northern</option>
                                <option value="Upper West">Upper West</option>
                                <option value="Upper East">Upper East</option>
                                <option value="Brong Ahafo">Brong Ahafo</option>
                                <option value="Ashanti">Ashanti</option>
                                <option value="Volta">Volta</option>
                            </select>
                             </div>
                            </div>
                            
                          
                            <input type="hidden" name="action" value="add" />
                            <div>
                                <input type="submit" class="btn btn-primary"  value="Add Agent" />
                            </div>
                        </form>
                    </div>

                    <!-- /widget-content --> 

                </div>
            </div>
   
        
    </body>
</html>
