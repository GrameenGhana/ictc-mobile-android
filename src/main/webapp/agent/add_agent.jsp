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
          <div class="container" style="margin-left:250px">
            <div class="row">
                <div class="col-md-6">
                    
                        <div class="panel-body">
                            
                            <form  class="form-horizontal"  method="POST" action="<%=request.getContextPath()%>/AgentController">
                                <div class="form-group">
                                    <label for="firstname" class="col-sm-4 control-label">First Name</label>
                                    <div class="col-sm-6">   
                                        <input type="text" class="form-control" id="firstname" name="firstname" placeholder="firstname" required/>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="lastname" class="col-sm-4 control-label">Last Name</label>
                                    <div class="col-sm-6">   
                                       <input type ="text" class="form-control" name="lastname" id="lastname" required>
                                    </div>
                                </div>
                                
                                 <div class="form-group">
                                    <label for="agentcode" class="col-sm-4 control-label">Agent Code</label>
                                    <div class="col-sm-6">
                                         <input type ="text" class="form-control" name="agentcode" id="agentcode" required>
                                    </div>
                                </div>
                                
                                 <div class="form-group">
                                    <label for="agenttype" class="col-sm-4 control-label">Agent Type </label>
                                    <div class="col-sm-6">
                                        <input type ="text" class="form-control" name="agenttype" id="agenttype" required>
                                    </div> 
                                </div>
                               
                                  <div class="form-group">
                                    <label for="orgainisation" class="col-sm-4 control-label">Organisation</label>
                                    <div class="col-sm-6">
                                        <input type ="text" class="form-control" name="organisation" id="organisation" required>
                                    
                                    </div>
                                </div>
                                  <div class="form-group">
                                    <label for="submit" class="col-sm-4 control-label"></label>
                                    
                                     <div class="col-sm-4">   
                                         <input type="submit" name="submit"  class="btn btn-info btn-sm btn-block" value="Submit"/>
                                         <input type="hidden" name="action" value ="ADD"/>
                                    </div>
                                    
                                </div>
                                  
                               
                            </form>

                        </div>

                    </div> 

                </div>
            </div>
        
    </body>
</html>
