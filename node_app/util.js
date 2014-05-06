var async = require('async')
  , http = require('http')

	
  
module.exports = {

getSelectedGroupTeams: function(requestParams,res){
	
	var groupUri = requestParams.selectedGroup;
	var query = "select ?y ?t where { BIND( <"+groupUri+"> AS ?t) ?y <http://www.semanticweb.org/saggu/ontologies/2014/3/FIFAWC#TeamGroup> ?t }";
	var data = '';
	var myparams = '';
	async.series([
		              function(callback){
		              //1. Get all the triples from the endpoint
		          		var encodedquerystring = encodeURIComponent(query);
		          		var options = {
		        		    host: requestParams.host,
		        		    port: requestParams.port,
		        		    path: requestParams.endpoint +encodedquerystring,
		        	        headers: {
		        	            'Content-Type': 'application/x-www-form-urlencoded',
		        	            'Accept': 'application/json',
		        	        }
		        		  };
		    		
		          		var req = http.get(options, function(res) {
		        	    res.on('data', function (chunk) {
		        	      data += chunk;
		        	    });
		        	    res.on('end', function () {
		        	    //	console.log(data);
		        	    	callback();
		        	    });
		        	  }).on('error', function(e) {
		        	    console.log("Got error: " + e.message);
		        	  });
		              },
		              
		              function(callback) {
		            	  //2. Construct data to be rendered by jade
			              var parsedJSON = JSON.parse(data);
			              var gUri = parsedJSON.results.bindings[0].t.value;
			              var teams = new Array();
			              teams.push(parsedJSON.results.bindings[0].y.value);
			              teams.push(parsedJSON.results.bindings[1].y.value);
			              teams.push(parsedJSON.results.bindings[2].y.value);
			              teams.push(parsedJSON.results.bindings[3].y.value);
			              global.mydata.alltriples[gUri].hasTeamUris=teams;
			              callback();
		              }
		              
		], function(){
		 	global.mydata.selectedGroupUri =  groupUri;
			res.render('oneononeindex',global.mydata);
		});

}
,
	
getAllGroupsTeams: function(requestParams,res){
	var groupUris = global.mydata.groupUris;
	
	//get the teams for each group
    async.forEachLimit(groupUris, 8, function(uri, callback) {
    	//console.log(uri);
    	var data = '';
    	var query = "select ?y ?t where { BIND( <"+uri+"> AS ?t) ?y <http://www.semanticweb.org/saggu/ontologies/2014/3/FIFAWC#TeamGroup> ?t }";
		async.series([
		              function(callback){
		              //1. Get all the triples from the endpoint
		          		var encodedquerystring = encodeURIComponent(query);
		          		var options = {
		        		    host: requestParams.host,
		        		    port: requestParams.port,
		        		    path: requestParams.endpoint +encodedquerystring,
		        	        headers: {
		        	            'Content-Type': 'application/x-www-form-urlencoded',
		        	            'Accept': 'application/json',
		        	        }
		        		  };
		    		
		          		var req = http.get(options, function(res) {
		        	    res.on('data', function (chunk) {
		        	      data += chunk;
		        	    });
		        	    res.on('end', function () {
		        	    //	console.log(data);
		        	    	callback();
		        	    });
		        	  }).on('error', function(e) {
		        	    console.log("Got error: " + e.message);
		        	  });
		              },
		              
		              function(callback) {
		            	  //2. Construct data to be rendered by jade
			              var parsedJSON = JSON.parse(data);
			              var gUri = parsedJSON.results.bindings[0].t.value;
			              var teams = new Array();
			              teams.push(parsedJSON.results.bindings[0].y.value);
			              teams.push(parsedJSON.results.bindings[1].y.value);
			              teams.push(parsedJSON.results.bindings[2].y.value);
			              teams.push(parsedJSON.results.bindings[3].y.value);
			              global.mydata.alltriples[gUri].hasTeamUris=teams;
			              callback();
		              }
		              
		], function(){
			callback();
		});  //aysnc series ends
    	
    }, function(err) {
        if (err) return next(err);
        console.log("done");
        console.log("******************************");
        global.mydata.selectedGroupUri =  '';
        
    	res.render(requestParams.jadeName,global.mydata);
        
    });

	
}	
,	
	
getJSON : function(requestParameters,res){
	var pagedata = new Object();
	var data = '';
	async.series([
	              function(callback){
	              //1. Get all the triples from the endpoint
	          		var encodedquerystring = encodeURIComponent(requestParameters.query);
	          		var options = {
	        		    host: requestParameters.host,
	        		    port: requestParameters.port,
	        		    path: requestParameters.endpoint +encodedquerystring,
	        	        headers: {
	        	            'Content-Type': 'application/x-www-form-urlencoded',
	        	            'Accept': 'application/rdf+json',
	        	        }
	        		  };
	    		
	          		var req = http.get(options, function(res) {
	        	    res.on('data', function (chunk) {
	        	      data += chunk;
	        	    });
	        	    res.on('end', function () {
	        	    	//console.log(data);
	        	    	callback(); //the current task is finished, go onto the next task.
	        	    });
	        	  }).on('error', function(e) {
	        	    console.log("Got error: " + e.message);
	        	  });
	              },
	              
	              function(callback) {
	              //2. Construct data to be rendered by jade
	            	  var parsedJSON = JSON.parse(data);
	            	  pagedata.alltriples = parsedJSON;
	            	  requestParameters.uris.forEach(function(entry){
	            		  	if(entry.useRegEx){
	            		  		var a = new Array();
	            		  		var re = new RegExp(entry.uriString);
	            		        for (key in parsedJSON){
	            		        	if (re.test(key)) {
	            		        		//var results = parsedJSON[key];
	            		        		//a.push(results);
	            		        		a.push(key);
	            		        	}
	            		        }
	            		      entry.createObject(a,pagedata,parsedJSON);  		
	            		  	} 
	            		  	else {
	            		  		// for conditions where regEx is not required. We have a topLevel uri.
	            		  		pagedata.topLevel = parsedJSON[requestParameters.topLevelUri];
	            		  		requestParameters.uris.forEach(function(entry){
	                           		var results = pagedata.topLevel[entry.uriString];
	                           		entry.createObject(results,pagedata,parsedJSON);
	                           	});
	            		  		
	            		  		
	            		  	}
	                  	});
	            	  callback();
	              }
	              
	], function(){
		//console.log(pagedata);
		global.mydata = pagedata;
		res.render(requestParameters.jadePageName);
	}); //aysnc series ends
	
	
} ,


sort: function(arrayToSort,globalData,parsedJSON, sortCriteria,object){
		
	var sortedArray = new Array();
	globalData[object]= new Array();
	var counter = 0;
	for (var i = 0; i < arrayToSort.length; i++) {
		 var uri = arrayToSort[i];
		 var d = parsedJSON[uri][sortCriteria][0].value;
		 if(d){
			 sortedArray[counter] = new Object();
			 sortedArray[counter].uri = uri;
			 sortedArray[counter].d = d;
			 counter++;
		 }	 
	 }

	sortedArray.sort(function(a,b){
		 var displayValueA = a.d;
		 var displayValueB = b.d;
		 return displayValueA - displayValueB; //ascending	
	 });

	 for (var i = 0; i < sortedArray.length; i++) {
			globalData[object].push(sortedArray[i].uri);
	}
	
}
,
sortOnDate: function(results,globalData,parsedJSON, sortCriteria,object){
		
		var sortedArray = new Array();
		globalData[object]= new Array();
		var counter = 0;
		for (var i = 0; i < results.length; i++) {
			 var uri = results[i].value;
			 var date = parsedJSON[uri][sortCriteria];
			 if(date){
				 sortedArray[counter] = new Object();
				 sortedArray[counter].uri = uri;
				 sortedArray[counter].date = date[0].value;
				 counter++;
			 }	 
		 }

		sortedArray.sort(function(a,b){
			 var dateA=new Date(a.date), dateB=new Date(b.date)
			 return dateA - dateB; //ascending
		 });

		 for (var i = 0; i < sortedArray.length; i++) {
				globalData[object].push(sortedArray[i].uri);
		}
	}
};
