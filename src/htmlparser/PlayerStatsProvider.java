package htmlparser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import data.Player;

public class PlayerStatsProvider {
	
	
	//private static String URL = "http://espnfc.com/player/_/id/41952/michael-bradley?cc=5901";
	
	private static int TIME_OUT = 80000; // milliseconds
	
	public static void main(String[] args) {
		parse();
	}
	
	public static void parse(){

		List<Player> allplayers = Player.AllPlayers();
		String URL = "";
		JSONArray jsonArray = new JSONArray();
		for (Player player : allplayers) {
			String playerName = player.getPlayerName();
			String playerCode = player.getPlayerCodes().get(0);
			String espnPlayerCode = player.getPlayerCodes().get(1);
			
			if(espnPlayerCode.equals("notpresent")){
				if(playerName.equals("JULIO CESAR"))
					URL = "http://espnfc.com/player?id=39748&cc=5901";
				else if(playerName.equals("TEO GUTIERREZ"))
					URL = "http://espnfc.com/player?id=98576&cc=5901";
				else
					URL = "http://espnfc.com/player?id=38178&cc=5901";
			}
			else {
			  URL = "http://espnfc.com/player/_/id/"+espnPlayerCode+"/"+player.getPlayerCodes().get(2)+"?cc=5901";
			  System.out.println(URL);
			}
			
			try {
				Elements tablesToBeConsidered = getRelevantStats(URL);
				int gamesStarted = 0;
				int usedAsSubstitute = 0;
				int goals = 0;
				int assists = 0;
				int shots = 0;
				int shotsOnGoals = 0;
				int foulsCommitted = 0;
				int foulsSuffered = 0;
				int yellowCards = 0;
				int redCards = 0;
				JSONObject jsonObject = new JSONObject();
				for (Element table : tablesToBeConsidered) {
					Elements stats = getSeasonsTotalStats(table);
					if(stats != null){
						gamesStarted += Integer.parseInt(stats.get(0).text());
						usedAsSubstitute += Integer.parseInt(stats.get(1).text());
						goals += Integer.parseInt(stats.get(2).text());
						assists += Integer.parseInt(stats.get(3).text());
						shots += Integer.parseInt(stats.get(4).text());
						shotsOnGoals += Integer.parseInt(stats.get(5).text());
						foulsCommitted += Integer.parseInt(stats.get(6).text());
						foulsSuffered += Integer.parseInt(stats.get(7).text());
						yellowCards += Integer.parseInt(stats.get(8).text());
						redCards += Integer.parseInt(stats.get(9).text());
					}
				}
				
				jsonObject.put("gamesStarted",gamesStarted);
				jsonObject.put("substitute", usedAsSubstitute);
				jsonObject.put("goals", goals);
				jsonObject.put("assists", assists);
				jsonObject.put("shots", shots);
				jsonObject.put("shotsOnGoals", shotsOnGoals);
				jsonObject.put("foulsCommitted", foulsCommitted);
				jsonObject.put("foulsSuffered", foulsSuffered);
				jsonObject.put("yellowCards", yellowCards);
				jsonObject.put("redCards", redCards);
				jsonObject.put("playerName", playerName);
				jsonObject.put("playerCode", playerCode);
				
				jsonArray.add(jsonObject);

			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		
		//System.out.println(jsonArray);
		writeToFile(jsonArray);
}

	private static void writeToFile(JSONArray jsonArray) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("playerESPNStats.json"));
			bufferedWriter.write(jsonArray.toJSONString());
			bufferedWriter.flush();
			bufferedWriter.close();
	 
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private static Elements getRelevantStats(String URL) throws IOException {
		Document document = Jsoup.connect(URL).timeout(TIME_OUT).get();
		System.out.println("Fetched..");
		Elements contents = document.select("div#content-change");
		Element e = contents.get(0);
		Elements tables = e.getElementsByTag("table");
		Elements tablesToBeConsidered = new Elements();
		for (Element table : tables) {
			Elements rows = table.select("tr.stathead");
			if(!rows.isEmpty()){
				Element row = rows.get(0);
				Elements cols = row.children();
				for (Element col : cols) {
					if(col.hasAttr("colspan")) {
						int year = Integer.parseInt(col.text().substring(0, 4));
						if(year >= 2013){
							tablesToBeConsidered.add(table);
						}
					}
				}
			}
		}
		return tablesToBeConsidered;
	}

	private static Elements getSeasonsTotalStats(Element table) {
		Elements cols = table.getElementsByTag("td");
		for (Element col : cols) {
			//Season Totals
			if(col.text().equals("Season Totals"))
				return col.siblingElements();
		}
		return null;
	}
}
