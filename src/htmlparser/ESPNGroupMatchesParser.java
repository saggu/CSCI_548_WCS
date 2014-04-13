package htmlparser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ESPNGroupMatchesParser {

	
	private static String URL = "http://espnfc.com/fixtures/_/league/fifa.world?cc=5901";
	//private int TIME_OUT = 10000; // milliseconds
	
			
	@SuppressWarnings("unchecked")
	public static void parse()
	{
			
			//JSON
			JSONObject topLevel = new org.json.simple.JSONObject();
			
			
			try {
				Document document = Jsoup.connect(URL).get();
				
				Elements e = document.select("div#my-teams-table");
				Element teamsTable = e.get(0); 
				Elements elements = teamsTable.getElementsByClass("mod-content"); //div
				for (Element element : elements) {

					JSONArray eachDay = new JSONArray();
					Elements table = element.getElementsByTag("table");
					Element tableElement = table.get(0);
					Elements statheadRows = tableElement.select("tr.stathead");
					String gameDate  = statheadRows.get(0).child(0).text();
					
					Elements oddRows = tableElement.select("tr.oddrow");
					for(Element oddrow : oddRows){
						
						JSONObject oddRow = new  JSONObject();
						oddRow.put("Time", oddrow.children().get(0).text());
						oddRow.put("TeamA", oddrow.children().get(1).text());
						oddRow.put("TeamB", oddrow.children().get(3).text());
						oddRow.put("Stage", oddrow.children().get(4).text());
						oddRow.put("Venue", oddrow.children().get(6).text());
						eachDay.add(oddRow);
					}
					
					Elements evenRows = tableElement.select("tr.evenrow");
					for(Element evenrow : evenRows){
						JSONObject evenRow = new  JSONObject();
						evenRow.put("Time", evenrow.children().get(0).text());
						evenRow.put("TeamA", evenrow.children().get(1).text());
						evenRow.put("TeamB", evenrow.children().get(3).text());
						evenRow.put("Stage", evenrow.children().get(4).text());
						evenRow.put("Venue", evenrow.children().get(6).text());
						eachDay.add(evenRow);
					}
					
					topLevel.put(gameDate,eachDay);
					
					
				} //end of for loop
				
				try {
					 
					//TODO: FIx this, create a new file , if file does not exists
					//FileWriter file = new FileWriter("C:\\cs548_project\\gameSchedule.json");
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("gameschedule.json"));
					bufferedWriter.write(topLevel.toJSONString());
					bufferedWriter.flush();
					bufferedWriter.close();
			 
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				System.out.println("File Generated");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}
