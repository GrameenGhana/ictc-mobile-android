<%-- 
    Document   : obtoag
    Created on : Oct 3, 2016, 11:33:41 AM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.ictc.models.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ob To Agent</title>
    </head>
    <body>
        <!-- /widget-header -->
            <div class="widget-content">
                <div class="widget big-stats-container">
                    <div class="widget-content">
                        <h6 class="bigstats">.</h6>
                        <form action="" method="post" >
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="ob">Select OutGrower Bussiness Owner<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <select id="ob" name="ob" class="form-control" >
                                <option></option> 
                            </select>
                        </div>
                      </div>
                          
                        <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="agent">Select Agent<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <select id="at" name="at" class="form-control" >
                                 <option></option>
                            </select>
                        </div>
                      </div>
                               
                            
                            <input type="hidden" name="action" value="add" />
                            <div>
                                <input type="submit" class="btn btn-primary"  value="Assign Agent" />
                            </div>
                        </form>
                    </div>

                    <!-- /widget-content --> 

                </div>
            </div> 
    </body>
</html>
