var express = require("express");
var app = express();
var bodyparser = require('body-parser');
var fs = require("fs");

app.listen(9001);
app.get('/addEvent.html', function(req,res) {
	fs.readFile('client/addEvent.html', function(err, html) {   
		if(err) {      throw err;    }    
		res.statusCode = 200;    
		res.setHeader('Content-type', 'text/html');    
		res.write(html);    
		res.end();  
	});
});