<%-- 
    Document   : agenttofarmer
    Created on : Feb 5, 2016, 11:11:54 AM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.ictc.wrapper.BiodataWrapper"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.domains.Biodata"%>
<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Assign Agent To Farmer</title>
       <%
           BiodataModel biodataModel = new BiodataModel();
           
           String agent = request.getParameter("q");
          //  BiodataModel biodataModel = new BiodataModel();
   // String type = request.getParameter("type");
   // String value = request.getParameter("q");

  //  List<BiodataWrapper> bioWrapper = biodataModel.getBioDataSearch(type, value);
         List<BiodataWrapper> bioWrapper = biodataModel.getBioData("", "");
        %>
    </head>
    <body>
        <form action="<%=request.getContextPath()%>/agent/assignfarmer" method="post" >
        <div class="container" style="margin-top:20px;">
          <div class="row">
            <!--<div class="col-xs-6">
            <h3 class="text-center">Basic Example</h3>
            <div class="well" style="max-height: 300px;overflow: auto;">
                <ul class="list-group checked-list-box">
                  <li class="list-group-item">Cras justo odio</li>
                  <li class="list-group-item" data-checked="true">Dapibus ac facilisis in</li>
                  <li class="list-group-item">Morbi leo risus</li>
                  <li class="list-group-item">Porta ac consectetur ac</li>
                  <li class="list-group-item">Vestibulum at eros</li>
                  <li class="list-group-item">Cras justo odio</li>
                  <li class="list-group-item">Dapibus ac facilisis in</li>
                  <li class="list-group-item">Morbi leo risus</li>
                  <li class="list-group-item">Porta ac consectetur ac</li>
                  <li class="list-group-item">Vestibulum at eros</li>
                </ul>
            </div>
        </div>-->
    <ul class="list-group">
        
     <% for(BiodataWrapper bio : bioWrapper ){ %>
     <li class="list-group-item"><input type="checkbox" id="farmer" name="farmer" value="<%=bio.getFarmID()%>"><%= bio.getFirstName()%><%= bio.getLastName()%></li>
    <%}%>
    </ul> 
  
          </div>
            
              <div>
                  <input type="hidden" value="<%=agent%>" name="agent" />
        <input type="submit" class="btn btn-primary"  value="Add Farmer(s)" />
    </div>   
        </div>

        </form>
    </body>
</html>
