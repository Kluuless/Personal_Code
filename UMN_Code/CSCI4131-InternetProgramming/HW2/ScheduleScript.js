var bigImg = document.getElementsByClassName("bigImage")[0];
var weekEvents = document.querySelectorAll("th table tr th");
var tempMem = "";
console.log(weekEvents.length);

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

for (let i = 0; i < weekEventsIdxs.length; i++) {
	for (let j = 0; j < 5; j++) {
		weekEvents[weekEventsIdxs[i]+j].addEventListener("mouseenter", function(event) {
			tempMem = weekEvents[weekEventsIdxs[i]+j].innerHTML;
			bigImg.src = "img/" + weekEventsSrcs[i];
			bigImg.alt = weekEventsAlts[i];
			if (!tempMem.includes("<br><img")) {
				weekEvents[weekEventsIdxs[i]+j].innerHTML =
					"<th>" + tempMem + "</th>" + '<br><img src="img/' +
					weekEventsSrcs[i] + '" alt=' + weekEventsAlts[i] + "></th>";
			}
			console.log("Enter: " + tempMem);
		});
		weekEvents[weekEventsIdxs[i]+j].addEventListener("mouseleave", function(event) {
			if (weekEvents[weekEventsIdxs[i]+j].innerHTML.includes("<br><img")) {
				lastChar = tempMem.slice(-1);
				if (lastChar == ">") {lastChar = "";}
				weekEvents[weekEventsIdxs[i]+j].innerHTML =
					tempMem.slice(0,tempMem.indexOf("<br><img")) + lastChar + "</th>";
				console.log("Slice: " + tempMem.slice(0,tempMem.indexOf("<br><img")) + "</th>");
			}
		});
	}
}