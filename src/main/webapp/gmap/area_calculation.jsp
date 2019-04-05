<%-- 
    Document   : area_calculation
    Created on : Sep 14, 2015, 2:15:17 PM
    Author     : Joseph George Davis
--%>

<%@page import="java.util.HashMap"%>
<%@page import="com.grameenfoundation.ictc.domains.Biodata"%>
<%@page import="java.util.Map"%>
<%@page import="com.grameenfoundation.ictc.models.BiodataModel"%>
<%@page import="javax.script.ScriptEngineManager"%>
<%@page import="javax.script.ScriptEngine"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% 
   String farmer = "1";
    JSONArray ja = new JSONArray();
   
      //String points = request.getParameter("p");
    String pp = "{\"area\":9.252764755276283E-5,\"points\":[{\"lng\":-0.1721708,\"lat\":5.5686133},{\"lng\":-0.1721612,\"lat\":5.5686134},{\"lng\":-0.1722498,\"lat\":5.5685807},{\"lng\":-0.1722384,\"lat\":5.5685605}]}";
    JSONObject j = new JSONObject(pp);
      
     System.out.print("In jsp page " +j);
       
     ja = (JSONArray) j.get("points");
    farmer = request.getParameter("f"); 
    
   
       
//  request.getParameter("f");
       

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
    <input type="text" id="area" />
        
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
                     
                     
                      <%
                         if(ja.length()>0)
                         {
                        for(int i =0;i<ja.length();i++){
                          JSONObject obj = ja.getJSONObject(i);
                      %>
                      new google.maps.LatLng(<%=obj.getDouble("lat")%>,<%=obj.getDouble("lng")%>),
                  
                <%}}%> ]
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
                document.getElementById("area").value = z;
                
                
                console.log(z);
               //response.sendRedirect("request.getContextPath()/gmap/farm_area.jsp?area=";
               
//    $.post("<%=request.getContextPath()%>/gmap/area_calculator.jsp",
//    {
//        area: z,
//        farmer: <%%>
//    },
//    function(data, status){
//        console.log("Data: " + data + "\nStatus: " + status);
//    });
//      window.location = "<%=request.getContextPath()%>/gmap/farm_area.jsp?area="+z+"&farmer="+<%=farmer%>;  
     <%System.out.print("redirect done");
//      if(null!=request.getParameter("area")&& null!=farmer)
//      {
//             System.out.print(request.getParameter(" In farm area"));
//
//                 BiodataModel bdata = new BiodataModel();
//                 Map<String, String> m = new HashMap<String,String>();
//
//                 m.put(Biodata.FARM_AREA, request.getParameter("area"));
//                 boolean updated = bdata.BiodataUpdate(farmer, m);
//
//                 System.out.println("Farmer update done " + updated);
//      }
//       else
//      {
//          System.out.print("data no recieved");
//      }
     
     %>
     
       
             
     }
     
     
     
        </script>
    </content>

</html>
