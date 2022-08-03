// include the express module which is a Node.js web application framework
var express = require("express");

// create an express application
var app = express();

// helps in extracting the body portion of an incoming request stream
var bodyparser = require('body-parser');

// fs module - provides an API for interacting with the file system
var fs = require("fs");

// required for reading XML files
var xml2js = require('xml2js');


var parser = new xml2js.Parser();
var theinfo;

fs.readFile(__dirname + '/test.xml', function(err, data) {
	if (err) throw err;
	console.log("data: \n" + data);
    parser.parseString(data, function (err, result) {
		if (err) throw err;
		console.log("The first name stored in the info record:\n" + result.info.fname[0]);
        theinfo = result;
       
	});
});

let printstuff() = function() {
	console.log("First name: " + theinfo.getElementsByName("fname")[0]);
	console.log("Last name: " + theinfo.getElementsByName("lname")[0]);
	console.log("Social Security Number: " + theinfo.getElementsByName("ssn")[0]);
	console.log("Location: " + theinfo.getElementsByName("location")[0]);
	console.log("Age: " + theinfo.getElementsByName("age")[0]);
}