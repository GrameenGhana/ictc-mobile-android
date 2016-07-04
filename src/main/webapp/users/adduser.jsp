<%-- 
    Document   : adduser
    Created on : Jun 1, 2016, 11:34:39 AM
    Author     : Joseph George Davis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
    </head>
    <body>
          <!-- /widget-header -->
            <div class="widget-content">
                <div class="widget big-stats-container">
                    <div class="widget-content">
                        <h6 class="bigstats">.</h6>
                        <form action="<%=request.getContextPath()%>/user/add" method="post" >
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
                                <input type="text" value=""  placeholder="usercode " name="ac"/>
                            </div>
                           
                             <div class="span5">
                                <input type="text" value=""  placeholder="usertype" name="at"/>
                            </div>
                            
                              <div class="span5">
                                <input type="text" value=""  placeholder="organisation" name="org"/>
                            </div>
                          
                           
                            <div>
                                <input type="submit" class="btn btn-primary"  value="Add User" />
                            </div>
                             <input type="hidden" name="action" value="add" />
                        </form>
                    </div>

                    <!-- /widget-content --> 

                </div>
            </div>
   
    </body>
</html>
