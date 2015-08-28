<%-- 
    Document   : detail
    Created on : Aug 13, 2015, 2:32:20 PM
    Author     : skwakwa
--%>

<%@page import="com.grameenfoundation.ictc.utils.ICTCUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.grameenfoundation.ictc.wrapper.FieldObject"%>
<%@page import="com.grameenfoundation.ictc.domains.Biodata"%>
<%@page import="com.grameenfoundation.ictc.wrapper.BiodataWrapper"%>
<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    BiodataModel bioModel = new BiodataModel();
    BiodataWrapper wrapper = bioModel.getBiodataByFieldValue(Biodata.ID, request.getParameter("id"));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Farmer Details -    <% if(wrapper != null) {%><%=wrapper.getFirstName() + " " + wrapper.getLastName()%> <% } %></title>
    </head>
    <body>
        <% if(wrapper != null) {%>
        <div class="col-sm-6 col-md-6 span5">
            <h2>Farmer Details #<%=wrapper.getFarmID()%></h2>
            <h3>Bio Data</h3>
            <table class="table table-striped table-bordered">
                <tr>
                    <td>Surname</td>
                    <td><%=wrapper.getLastName()%></td>
                </tr>
                <tr>
                    <td>Other names</td>
                    <td><%=wrapper.getFirstName()%></td>
                </tr>
                <tr>
                    <td>Nickname</td>
                    <td><%=wrapper.getNickname()%></td>
                </tr> 
                <tr>
                    <td>Gender</td>
                    <td><%=wrapper.getGender()%></td>
                </tr>
                <tr>
                    <td>Age</td>

                    <td><%=wrapper.getAge()%></td>
                </tr>
                <tr>
                    <td>Education</td>

                    <td><%=wrapper.getEducation()%></td>
                </tr>



                <tr>
                    <td>Education</td>

                    <td><%=wrapper.getEducation()%></td>
                </tr>

                <tr>
                    <td>Village</td>

                    <td><%=wrapper.getVillage()%></td>
                </tr>


                <tr>
                    <td>Marital Status</td>

                    <td><%=wrapper.getMaritalStatus()%></td>
                </tr> 
                <tr>
                    <td>No of Children </td>

                    <td><%=wrapper.getNumberOfChildren()%></td>
                </tr>
                <tr>
                    <td>No of Children </td>

                    <td><%=wrapper.getNumberOfChildren()%></td>
                </tr>
                <tr>
                    <td>No of Dependant </td>

                    <td><%=wrapper.getNumberOfDependants()%></td>
                </tr>


            </table>
            <h3>Location Details</h3>
            <table class="table table-striped table-bordered">
                <tr>
                    <td>Region</td>
                    <td><%=wrapper.getRegion()%></td>
                </tr>
                <tr>
                    <td>District</td>
                    <td><%=wrapper.getDistrict()%></td>
                </tr>
                <tr>
                    <td>Community</td>
                    <td><%=wrapper.getCommunity()%></td>
                </tr>

                <tr>
                    <td>Village</td>
                    <td><%=wrapper.getVillage()%></td>
                </tr>
            </table>
            <h3>Farm Details Details</h3>
            <table class="table table-striped table-bordered">
                <tr>
                    <td>Major Crop</td>
                    <td><%=wrapper.getMajorCrop()%></td>
                </tr>

            </table>
        </div>
        <div class="span6">
            <div>

                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">FMP</a></li>
                    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Visit</a></li>
                    <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Activities</a></li>
                    <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">map</a></li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="home">Farm Management Plan
                        <table>
                            <% List<FieldObject> objs = wrapper.getFmpValues(); 
                            if(null != objs){
                            for(FieldObject obj: objs)
                            {%>
                            <tr>
                                <td><%=ICTCUtil.replaceKeyInObject(obj.getKey()) %></td>
                                <td><%=obj.getValue() %></td>
                            </tr>
                            <% } } %>
                        </table>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="profile">Visits by Agent</div>
                    <div role="tabpanel" class="tab-pane" id="messages">Farmer Activities</div>
                    <div role="tabpanel" class="tab-pane" id="settings">
                        <div id="mmapview" style="width: 100%;height: 350px;background-color: #f0f0f0"></div>
                    </div>
                </div>

            </div>

        </div>
                        <% } %>
    </body>
    <script type="text/javascript">
        //    alert('mapping')
         
    </script>
     <% if(wrapper != null) {%>
    <content tag="scripts">
        <%
        String location ="";
        if(location.isEmpty()) location="5.569313, -0.171332";
        %>
        loadGoogleMap("mmapview", '<%= location %>', "<%=wrapper.getFirstName() + " " + wrapper.getLastName()%>'s Farm")
</content>
        <% } %>
</html>
