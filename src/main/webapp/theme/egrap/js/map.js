

function loadGoogleMap(mapDiv, ll, name) {
    var name = name;

    spliterll = ll.split(",");
    var latlng = new google.maps.LatLng(spliterll[0], spliterll[1]);
    
    var myOptions = {
        zoom: 15,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    var map = new google.maps.Map(document.getElementById(mapDiv), myOptions);
    var myMarker = new google.maps.Marker({
        position: latlng, 
        map: map, 
        title: name
    });

}