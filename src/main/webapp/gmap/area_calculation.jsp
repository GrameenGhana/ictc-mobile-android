<%-- 
    Document   : area_calculation
    Created on : Sep 14, 2015, 2:15:17 PM
    Author     : Joseph George Davis
--%>

<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% 
   
    String points = request.getParameter("p");
    String pp = "{\"area\":0.00100769241714143,\"points\":[{\"lng\":-0.1715416,\"lat\":5.5683899},{\"lng\":-0.1716476,\"lat\":5.5684594},{\"lng\":-0.1717273,\"lat\":5.5684636},{\"lng\":-0.1719507,\"lat\":5.5684822}]}";
    JSONObject j = new JSONObject(pp);
      
     System.out.print(j);
       
     JSONArray ja = (JSONArray) j.get("points");
     String farmer = "12233"; //  request.getParameter("f");
       

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coordinates</title>

        <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
        <meta charset="utf-8">
        <style>
            html, body {
                height: 100%;
                margin: 0;
                padding: 0;
            }
            #map {
                height: 500px;
                width:500px;
            }
        </style>
    </head>
    <body>
    <label>Area</label>
        
        <div id="lmap" ></div>
         
        <!-- <script src="https://maps.googleapis.com/maps/api/js?libraries=geometry&callback=initMap"
               async defer></script>-->
    </body>
    <content tag="scripts">
        <script type="text/javascript">
            var z = 0;

            function initMap() {
//                var map = new google.maps.Map(document.getElementById('lmap'), {
//                    center: {lat: 5.55, lng: -0.196},
//                    zoom: 10,
//                });


                var poly = new google.maps.Polyline({
                    strokeColor: '#000000',
                    strokeOpacity: 1,
                    strokeWeight: 3
                   // map: map
                });
                   var bermudaTriangle = new google.maps.Polygon({
                 paths: [
                      <%for(int i =0;i<ja.length();i++){
                          JSONObject obj = ja.getJSONObject(i);
                      %>
                      new google.maps.LatLng(<%=obj.getDouble("lat")%>,<%=obj.getDouble("lng")%>),
                  
                <%}%> ]
                 });
                 
                   //new google.maps.LatLng(25.774, -80.190)
                 // new google.maps.LatLng(18.466, -66.118),
                   //new google.maps.LatLng(32.321, -64.757
                // Add a listener for the click event
                //google.maps.event.addListener(map, 'click', function (event) {
                    addLatLngToPoly(bermudaTriangle);
              //  });
               // alert("Area: " + z);
            }
         google.maps.event.addDomListener(window, 'load', initMap);


            function addLatLngToPoly(bermudaTriangle) {
                //var path = poly.getPath();
                var path = bermudaTriangle.getPath();
                // Because path is an MVCArray, we can simply append a new coordinate
                // and it will automatically appear
               // path.push(latLng);

                z = google.maps.geometry.spherical.computeArea(path);
                console.log(z);
               
                window.location = "<%=request.getContextPath()%>/gmap/farm_area.jsp?area="+z+"&farmer="+<%=farmer%>;
                
            }
        </script>
    </content>

</html>
