/*
 * Script for MySchedule.html.
**/

//variables (particularly for the schedule and big image)
var bigImg = document.getElementsByClassName("bigImage")[0];
var weekEvents = document.querySelectorAll("th table tr th");
var tempMem = "";

var weekEventsIdxs = [7,13,19,24,29,35,40,46,51,56,62,67,72,78];
var weekEventsSrcs = ["lab.jpg","html5.png","UML.png","dna.jpg",
                      "CyberSec.jpg","html5.png","CyberSec.jpg",
					  "UML.png","dna.jpg","CyberSec.jpg","dna.jpg",
					  "teslaworks.png","DnD.jpg","chores.png"];
var weekEventsAlts = ["Study Time","CSCI4131 Lecture",
					 "CSCI5801 Lecture","CSCI3003 Lecture",
                     "CSCI4271W Lecture","CSCI4131 Lecture",
					 "CSCI4271W Lab","CSCI5801 Lecture",
					 "CSCI3003 Lecture","CSCI4271W Lecture",
					 "CSCI3003 Lab","Tesla Works Club",
					 "Dungeons and Dragons Club","Weekend Chores"];

//set up eventListeners for mouseenter and mouseleave
for (let i = 0; i < weekEventsIdxs.length; i++) {
	for (let j = 0; j < 5; j++) {
		//swap big image to correct one, put correct image in the cell
		weekEvents[weekEventsIdxs[i]+j].addEventListener("mouseenter", function(event) {
			tempMem = weekEvents[weekEventsIdxs[i]+j].innerHTML;
			bigImg.src = "img/" + weekEventsSrcs[i];
			bigImg.alt = weekEventsAlts[i];
			if (!tempMem.includes("<br><img")) {
				weekEvents[weekEventsIdxs[i]+j].innerHTML =
					"<th>" + tempMem + "</th>" + '<br><img src="img/' +
					weekEventsSrcs[i] + '" alt=' + weekEventsAlts[i] + "></th>";
			}
		});
		//remove image from the cell mouse just left
		weekEvents[weekEventsIdxs[i]+j].addEventListener("mouseleave", function(event) {
			if (weekEvents[weekEventsIdxs[i]+j].innerHTML.includes("<br><img")) {
				lastChar = tempMem.slice(-1);
				if (lastChar == ">") {lastChar = "";}
				weekEvents[weekEventsIdxs[i]+j].innerHTML =
					tempMem.slice(0,tempMem.indexOf("<br><img")) + lastChar + "</th>";
			}
		});
	}
}

//animation for big image (Go Away! and Come Back!)
var fadeButton = document.getElementById('fadeToggle');
var faded = false;
fadeButton.addEventListener("click",function(event) {
	if (faded) {
		bigImg.animate([{opacity:0},{opacity:1}],2000);
		bigImg.style.opacity = 1;
		fadeButton.innerHTML = "Go Away!";
		faded = false;
	} else {
		bigImg.animate([{opacity:1},{opacity:0}],2000);
		bigImg.style.opacity = 0;
		fadeButton.innerHTML = "Come Back!";
		faded = true;
	}
});

//map script
var map = null;
var directionsService = null;
var directionsRenderer = null;
function initMap() {
	map = new google.maps.Map(document.getElementById("map"),
		{
			zoom: 14,
			center: { lat: 44.9727, lng: -93.23540000000003 },
			mapId: "b045800e9be6e168"
		}
	);
	directionsService = new google.maps.DirectionsService(map);
	directionsRenderer = new google.maps.DirectionsRenderer();
}

//dynamically extract table elements
var events = [];
var singleEvent = [];
var day = "";
const daysOfTheWeek = ["Day","Sunday", "Monday", "Tuesday",
	"Wednesday", "Thursday", "Friday", "Saturday"];
for (let i = 0; i < weekEvents.length; i++) {
	if (singleEvent.length >= 6) {
		events.push(singleEvent);
		singleEvent = [];
	}
	if (daysOfTheWeek.includes(weekEvents[i].textContent)) {
		day = weekEvents[i].textContent;
	}
	if (singleEvent.length == 0) {
		singleEvent.push(day);
	}
	if (singleEvent.length < 6 && singleEvent.length >= 1 && !singleEvent[0].includes(weekEvents[i].textContent)) {
		singleEvent.push(weekEvents[i].textContent);
	}
}
if (singleEvent.length >= 6) events.push(singleEvent);

//place markers
var markedPlaces = [];
const ignoredPlaces = ["Event Location","Wherever","None"];
var currMarker = 0;
var eventMarkers = [];
window.addEventListener("load", function(event) {
	var service = new google.maps.places.PlacesService(map);
	function placeMarker(results, Status) {
		if (results != null) {
			//marker
			let place = markedPlaces[currMarker];
			currMarker++;
			let markerText = "";
			for (let i = 0; i < events.length; i++) {
				if (events[i][3].includes(place) && !markerText.includes(events[i][3])) {
					markerText += events[i][1] + ": " + events[i][3] + "\n";
				}
			}
			
			let latlng = { lat: results[0].geometry.location.lat(),
						   lng: results[0].geometry.location.lng()
						 };
			let markerDets = {
				position: latlng,
				map: map,
				title: markerText,
				icon: "img/marker.jpg"
			};
			const marker = new google.maps.Marker(markerDets);
			
			//info window
			let infoText = "";
			for (let i = 0; i < events.length; i++) {
				if (events[i][3].includes(place)) {
					infoText += "<b>" + events[i][0] + " at " + events[i][2] + ":</b><br>";
					infoText += events[i][1] + " at " + events[i][3] + "<br>";
				}
			}
			const infowindow = new google.maps.InfoWindow({ content: infoText});
			
			marker.addListener("click", function(event) {
				infowindow.open({
					anchor: marker,
					map,
					shouldFocus: false
				});
			});
			eventMarkers.push(marker);
		} else if (Status != "OK") {
			console.log("Error! " + Status);
		}
	}
	//send request to PlacesService API
	for (let i = 0; i < events.length; i++) {
		let place = events[i][3];
		if (place.includes("Keller Hall")) { place = "Keller Hall"; }
		if (place.includes("Blegen Hall")) { place = "Blegen Hall"; }
		if (place.includes("Bruininks Hall")) { place = "Bruininks Hall"; }
		if (!ignoredPlaces.includes(place) && !markedPlaces.includes(place)) {
			markedPlaces.push(place);
			let queryRequest = {query:place,fields:["geometry.location"]};
			service.findPlaceFromQuery(queryRequest,placeMarker);
		}
	}
});

//input area
var category = document.getElementById("placeCategory");
var other = document.getElementById("placeOther");
var radius = document.getElementById("placeRadius");
var search = document.getElementById("placeSearch");
category.addEventListener("change",function(event) {
	if (category.value == "Other") {
		other.disabled = false;
	} else {
		other.disabled = true;
		other.value = "";
	}
});
//search for locations
var otherMarkers = [];
search.addEventListener("click",function(event) {
	for (let i = 0; i < eventMarkers.length; i++) eventMarkers[i].setMap(null);
	for (let i = 0; i < otherMarkers.length; i++) otherMarkers[i].setMap(null);
	otherMarkers.length = 0;
	var service = new google.maps.places.PlacesService(map);
	function addMarker(results, Status) {
		if (results != null) {
			//place results' markers
			for (let i = 0; i < results.length; i++) {
				let markerInfo = {
					content: "<b>" + results[i].name + ":</b> " + results[i].vicinity
				};
				let markerDets = {
					position: results[i].geometry.location,
					map: map,
					title: markerInfo.content
				}
				const marker = new google.maps.Marker(markerDets);
				const infowindow = new google.maps.InfoWindow(markerInfo);
				marker.addListener("click", function(event) {
					infowindow.open({
						anchor: marker,
						map,
						shouldFocus: false
					});
				});
				otherMarkers.push(marker);
			}
		} else if (Status != "OK") {
			console.log("Error! " + Status)
		}
	}
	let queryText = category.value;
	let searchType = false;
	if (queryText == "Other") {
		queryText = other.value;
		searchType = true;
	}
	if (queryText != "") {
		query = {
			location: new google.maps.LatLng(44.9727, -93.23540000000003),
			radius: radius.value * 1609.34
		};
		if (searchType) {
			query.type = queryText;
		} else {
			query.keyword = queryText;
		}
		service.nearbySearch(query, addMarker);
	} else {
		for (let i = 0; i < eventMarkers.length; i++) eventMarkers[i].setMap(map);
		console.log("Invalid search query");
	}
});

//directions
var destination = document.getElementById("destination");
var method = document.getElementsByName("trMethod");
var goButton = document.getElementById("getDirections");
var directionsText = document.getElementById("directions");
goButton.addEventListener("click", function(event) {
	destinationValue = destination.value;
	if (destinationValue != "") {
		if (navigator.geolocation) {
			function usePosition(position) {
				coordinates = {
					lat: position.coords.latitude,
					lng: position.coords.longitude
				};
				methodValue = "DRIVING";
				for (let i = 0; i < method.length; i++) {
					if (method[i].checked) methodValue = method[i].value.toUpperCase();
				}
				query = {
					origin: coordinates,
					destination: destinationValue,
					travelMode: methodValue
				};
				
				directionsRenderer.setMap(map);
				directionsService.route(query,function(result, status) {
					if (status == "OK") {
						directionsRenderer.setDirections(result);
						directionsText.innerHTML = "<p>Directions:</p><div id='directionsPanel'></div>";
						directionsRenderer.setPanel(document.getElementById("directionsPanel"));
					}
				});
			}
			navigator.geolocation.getCurrentPosition(usePosition);
			
		} else {
			directionsText.innerHTML = "<p>Directions:</p><br>Browser does not support Geolocation.";
		}
	} else {
		directionsText.innerHTML = "<p>Directions:</p><br>Enter in a destination!";
	}
});

//clock
function clock() {
	var datetoday = new Date();
	var timenow = datetoday.toLocaleTimeString();
	document.getElementById("time").innerHTML = "Current Time: " + timenow;
	dayOfWeek = datetoday.getDay();
	let found = false;
	let day = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
	nextDay = day[(datetoday.getDay() + 1) % 7];
	day = day[datetoday.getDay()];
	for (let i = 0; i < weekEvents.length; i++) {
		if (weekEvents[i].textContent == day) { found = true; }
		if (weekEvents[i].textContent == nextDay) { found = false; }
		if (found) { weekEvents[i].style.color = "rgb(0,150,0)"; }
		else { weekEvents[i].style.color = "rgb(0,50,100)"; }
		}
}

var intId = setInterval(function(){clock()},1000);