const http = require('http');
const url = require('url');
const fs = require('fs');
const qs = require('querystring');

const port = 9001;
http.createServer(function(req, res) {
  var q = url.parse(req.url, true);
  if (q.pathname === '/' || q.pathname === '') {indexPage(req, res); }
  else if (q.pathname === '/index.html') { indexPage(req, res); }
  else if (q.pathname === '/schedule.html') { indexPage(req, res); }
  else if (q.pathname === '/getSchedule') { readSchedule(req,res,q.search.substring(5)); }
  else if (q.pathname === '/addEvent.html') { indexPage(req, res); }
  else if (q.pathname === '/postEventEntry') { postEventEntry(req, res); }
  else {
    res.writeHead(404, { 'Content-Type': 'text/html' });
    return res.end("404 Not Found");
  }
}).listen(port);


function indexPage(req, res) {
  var path = url.parse(req.url,true).pathname;
  if (path === '/') { path = "/index.html"; }
  fs.readFile('client/' + path, (err, html) => {
    if (err) {
       throw err;
    }
    res.statusCode = 200;
    res.setHeader('Content-type', 'text/html');
    res.write(html);
    res.end();
  });
}

function readSchedule(req, res, day) {
	fs.readFile('schedule.json',(err,jsonString) => {
		if (err) { throw err; }
		var scheduleObj = JSON.parse(jsonString);
		res.statusCode = 200;
		res.setHeader('Content-type','application.json');
		res.write(JSON.stringify(scheduleObj[day]));
		res.end();
	});
}

function postEventEntry(req, res) {
    fs.readFile('schedule.json',(err,jsonString) => {
        if (err) { throw err; }
        var scheduleObj = JSON.parse(jsonString);
        var body = '';
        var day = '';
        req.on('data', function (data) {body += data;});
        
        //post data parsing method found here: https://stackoverflow.com/questions/4295782/how-to-process-post-data-in-node-js
        req.on('end', function () {
            var data = qs.parse(body);
            day = data.day.toLowerCase();
            var eventObj = JSON.parse(
                '{"name":"' + data.event + '",' +
                '"start":"' + data.start + '",' +
                '"end":"' + data.end + '",' +
                '"phone":"' + data.phone + '",' +
                '"location":"' + data.location + '",' +
                '"info":"' + data.info + '",' +
                '"url":"' + data.url + '"}'
            );
            let startTime = 0+eventObj["start"].replace(":",".");
            let i = 0;
            
            while (i < scheduleObj[day].length && 
                   0+scheduleObj[day][i]['start'].replace(":",".") < startTime) {
                i++;
            }
            if (i == scheduleObj[day].length) { scheduleObj[day].push(eventObj); }
            else {
                let firstPart = scheduleObj[day].slice(0,i);
                let lastPart = scheduleObj[day].slice(i,scheduleObj[day].length);
                scheduleObj[day] = firstPart.concat(eventObj).concat(lastPart);
            }
            fs.writeFile("schedule.json",JSON.stringify(scheduleObj,null,'\t'),{flag:"w"},err=>{});
            res.statusCode = 302;
            res.setHeader("Content-type","text/html");
            res.setHeader("Location","/schedule.html");
            res.end();
        });
    });
}
