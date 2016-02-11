<%-- 
    Document   : create
    Created on : Aug 31, 2015, 8:53:44 AM
    Author     : skwakwa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crop Calendar</title>
    </head>
    <body>
        <form  method="post">
            <div class="row">
                <div class="span1">#</div>
                <div class="span6">Activity</div>
                <div class="span2">Start Wk</div>
                <div class="span2">End Wk</div>
            </div>
            <% for(int i=1;i<=8;i++) { %>
            <div class="row" id="item_<%= i %>">
                <div class="span1"><%= i %></div>
                <input type="text" name="activity_<%= i %>"  class="span6" placeholder="Activity"/>
                <input type="text" name="start_1<%= i %>" class="span2"  placeholder="Start Week"/>
                <input type="text" name="end_<%= i %>" class="span6"  placeholder="End Week"/>
            </div>
            <% } %>
            <input type="hidden" name="cnt" value="1" id="cnt_cnt"/>
        </form>
    </body
</html>
