<%-- 
    Document   : apotoag
    Created on : Jan 4, 2017, 1:48:32 PM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.ictc.models.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.*"%>
<%
      JSONObject x = new JSONObject();
      JSONObject y = new JSONObject();
      JSONArray  apo = new JSONArray();
      JSONArray  ag = new JSONArray();
      
      UserModel user = new UserModel();
      
      x = user.getAgent();
      y = user.getAPO();
      
      apo = y.getJSONArray("apo");
      ag = x.getJSONArray("ags");
      
      

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ob To Agent</title>
    </head>
    <body>
        <div class="widget-content">
            <div class="widget big-stats-container">
                <!-- /widget-header -->
                <div class="widget-content">
                    <div class="widget big-stats-container">
                        <div class="widget-content">
                            <h6 class="bigstats">.</h6>
                            <form action="<%=request.getContextPath()%>/agent/add" method="post" >
                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="ob">Select OutGrower Bussiness Owner<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select id="ob" name="ob" class="form-control" >
                                            <% for (int i = 0; i < apo.length(); i++) {
                                          JSONObject b = apo.getJSONObject(i);%>
                                            <option value="<%= b.getString("apo")%>"> <%= b.getString("name")%></option>

                                            <%}%>
                                        </select>
                                    </div>
                                </div>

                                <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="agent">Select Agent<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select id="at" name="at" class="form-control" >
                                            <% for (int i = 0; i < ag.length(); i++) {
                                        JSONObject b = ag.getJSONObject(i);%>
                                            <option value="<%= b.getString("ag")%>"> <%= b.getString("name")%></option>

                                            <%}%>
                                        </select>
                                    </div>
                                </div>


                                <input type="hidden" name="action" value="sapo" />
                                <div>
                                    <input type="submit" class="btn btn-primary"  value="Assign APO" />
                                </div>
                            </form>
                        </div>

                        <!-- /widget-content --> 

                    </div>
                </div> 

            </div>
        </div>
    </body>
</html>

