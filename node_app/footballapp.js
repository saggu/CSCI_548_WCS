	
/*
 * Module dependencies
 */
var express = require('express')
  , stylus = require('stylus')
  , nib = require('nib')
  , util = require('./util.js')
  , http = require('http')
  , async = require('async');	

var app = express();
function compile(str, path) {
  return stylus(str)
    .set('filename', path)
    .use(nib())
}
app.set('views', __dirname + '/views');
app.set('view engine', 'jade');
app.use(express.logger('dev'));
app.use(stylus.middleware(
  { src: __dirname + '/public'
  , compile: compile
  }
));
app.use(express.static(__dirname + '/public'));



var requestParams = new Object();
requestParams.host = "localhost";
requestParams.port = "9000"	;
requestParams.endpoint = "/openrdf-sesame/repositories/footballapp?query="	;
requestParams.query = "CONSTRUCT { ?s ?p ?o } where { ?s ?p ?o }"	;
requestParams.uris = new Array();
requestParams.jadePageName = 'footballindex'; 
requestParams.uris = [   {  useRegEx: "true" , uriString: "^" + 'http://cs548.com/fifawc/stage/group' + "[a-z]" , 
	createObject: function(results, globalData,parsedJSON){
		globalData.groupUris = results;
	}
 }

];




app.get('/groups',function(req,res){
	requestParams.jadeName = "groupdetailsindex";
	//requestParams.jadeName = "divisionindex";
	util.getAllGroupsTeams(requestParams,res);
})


app.get('/predict',function(req,res){
	console.log("I m here");
	var teamA = req.query.teamA;
	var teamB = req.query.teamB;
	console.log(teamB);
	var teamUris = new Array();
	teamUris[0] = teamA;
	teamUris[1] = teamB;
	global.mydata.selectedTeamUris = teamUris;
	var tAUniCode = global.mydata.alltriples[teamA]['http://www.semanticweb.org/saggu/ontologies/2014/3/FIFAWC#UniqueCode'][0].value;
	var tBUniCode = global.mydata.alltriples[teamB]['http://www.semanticweb.org/saggu/ontologies/2014/3/FIFAWC#UniqueCode'][0].value;
	var s = "http://cs548.com/fifawc/h2h/"+tAUniCode+tBUniCode;
	
	if(s == "http://cs548.com/fifawc/h2h/braesp") {
		 global.mydata.winningTeamUri = 'http://cs548.com/fifawc/team/bra';
	}
	
	if(s == "http://cs548.com/fifawc/h2h/colgre"){
		 global.mydata.winningTeamUri = 'http://cs548.com/fifawc/team/col';
	}
	
	console.log(s);
	var q = global.mydata.alltriples[s] ;
//	var q = global.mydata.alltriples['http://cs548.com/fifawc/h2h/colgre']
	
	var formUris = new Array();
	formUris['http://cs548.com/fifawc/player/fal'] = "red.png";
	formUris['http://cs548.com/fifawc/player/maryep'] = "orange.png";;
	formUris['http://cs548.com/fifawc/player/teogut'] =  "orange.png";
	
	formUris['http://cs548.com/fifawc/player/dimsal'] = "orange.png";
	formUris['http://cs548.com/fifawc/player/giokar'] = "red.png";;
	formUris['http://cs548.com/fifawc/player/mit'] =  "orange.png";

	formUris['http://cs548.com/fifawc/player/julces'] = "orange.png"
	formUris['http://cs548.com/fifawc/player/ney'] = "red.png";
	formUris['http://cs548.com/fifawc/player/rob'] = "red.png";
	
	formUris['http://cs548.com/fifawc/player/cesfab'] = "red.png";
	formUris['http://cs548.com/fifawc/player/davvil'] = "orange.png";
	formUris['http://cs548.com/fifawc/player/ped'] = "red.png";
	
	if(q) {
		global.mydata.h2hUri = s;
		global.mydata.playerFormUris = formUris;
	}

	console.log(global.mydata.playerFormUris);
	res.render("predictlayoutindex.jade",global.mydata);
	
})

app.get('/oneonone',function(req,res){
	requestParams.jadeName = "oneononeindex";
	
	if(req.query.group){
		console.log(req.query.group);
		requestParams.selectedGroup = req.query.group;
		util.getSelectedGroupTeams(requestParams,res);
	} else {
		util.getAllGroupsTeams(requestParams,res);
	}
	console.log("-----------------");
	
})

app.get('/', function (req, res) {
	util.getJSON(requestParams,res);
})

app.listen(3000);
console.log('Listening on port 3000');

module.exports=app;