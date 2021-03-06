package htmlparser;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import data.Team;
import data.TeamGroups;

/**
 * Calculates head to head stats for six games played by the four teams in a group.
 * This calculation is done for all the 8 groups.
 * @author MARGI
 *
 */
public class HeadToHeadStatsProvider {
	
	private static String  URL = "http://www.soccerbase.com/teams/head_to_head.sd?";
	private static int TIME_OUT = 10000; // milliseconds
	
	public static void parse(){
		TeamGroups teamGroups = new TeamGroups();
		List<TeamGroups>  list  = teamGroups.TeamGroupDetails();
		JSONArray toplevel = new JSONArray();
		
		// for each group, calculate the head to head stats for six games played by its four teams
		for (TeamGroups tg : list) {
			//System.out.println(tg.getGroupName());
			//System.out.println("----------------------");
			List<Team> teams = tg.getTeams();

			//each group has four teams
			for(int i=0 ; i < 4 ; i++){
				for (int j = i+1; j < 4  ; j++) {
					Team a = teams.get(i);
					Team b = teams.get(j);
				//	System.out.println("Team A:"+a.getTeamName());
					//System.out.println("Team B:"+b.getTeamName());
					//String STATS_URL = URL+"team_id="+2204+"+&team2_id="+717;
					String STATS_URL = URL+"team_id="+a.getTeamCodes().get(1)+"&team2_id="+b.getTeamCodes().get(1);
					
					try {
						Document document = Jsoup.connect(STATS_URL).timeout(TIME_OUT).get();
						Elements e = document.select("div.soccerContent");
						Elements tables =  e.get(0).getElementsByTag("table");
						
						if(!tables.isEmpty()) {
							
							// here, it means the two teams have played in the past.
							Element table = tables.get(0);
							JSONObject jsonObject = new JSONObject();
							Element row = table.select("tr.total").get(0);
							String winsTeamA = row.children().get(1).text();
							String draws = row.children().get(2).text();
							String winsTeamB = row.children().get(3).text();
							jsonObject.put("winsTeamA",winsTeamA);
							jsonObject.put("draws",draws);
							jsonObject.put("winsTeamB",winsTeamB);
							jsonObject.put("teamA", a.getTeamName());
							jsonObject.put("teamACode", a.getTeamCodes().get(0));
							jsonObject.put("teamB", b.getTeamName());
							jsonObject.put("teamBCode",b.getTeamCodes().get(0));
							jsonObject.put("goalsScoredA", 0);
							jsonObject.put("goalsScoredB", 0);
							
							Element soccerGridTable = document.select("table.soccerGrid").get(0);
							Elements trMatches = soccerGridTable.select("tr.match");
							
							//count the total no of goals scored by each team
							for (Element match : trMatches) {
								
								Element homeTeam = match.select("td.homeTeam").get(0);
								Element anchor = homeTeam.getElementsByTag("a").get(0);
								String left_hand_side_Team = anchor.text();
								//System.out.println(left_hand_side_Team);
								
								Element awayTeam = match.select("td.awayTeam").get(0);
								anchor = awayTeam.getElementsByTag("a").get(0);
								String right_hand_side_team = anchor.text();
								//System.out.println(right_hand_side_team);
								
								Element score  = match.select("td.score").get(0);
								Element info = score.getElementsByTag("a").get(0);
								Elements s = info.getElementsByTag("em");
								int goalScoredLeftside = Integer.parseInt(s.get(0).text());
								int goalScoredRightside = Integer.parseInt(s.get(1).text());
								//System.out.println(s.get(1).text());
								
								if(left_hand_side_Team.toUpperCase().equals(a.getTeamName()) || left_hand_side_Team.toUpperCase().equals(a.getTeamCodes().get(2)) ) {
									
									int goalsA =  (Integer) jsonObject.get("goalsScoredA") + goalScoredLeftside;
									jsonObject.put("goalsScoredA",goalsA);
									
									if(right_hand_side_team.toUpperCase().equals(b.getTeamName()) || right_hand_side_team.toUpperCase().equals(b.getTeamCodes().get(2))){
										int goalsB = (Integer) jsonObject.get("goalsScoredB") + goalScoredRightside;
										jsonObject.put("goalsScoredB",goalsB);
									}
								}
								else {
									//means left hand side team is team B 
									int goalsB = (Integer) jsonObject.get("goalsScoredB") + goalScoredLeftside;
									jsonObject.put("goalsScoredB",goalsB);
									
									if(right_hand_side_team.toUpperCase().equals(a.getTeamName()) || right_hand_side_team.toUpperCase().equals(a.getTeamCodes().get(2))){
										int goalsA = (Integer) jsonObject.get("goalsScoredA") + goalScoredRightside;
										jsonObject.put("goalsScoredA",goalsA);
									}
								}
								
								
							} // for loop ends
							
							toplevel.add(jsonObject);
							
						} // condition ends
						
						else {
							System.out.println(STATS_URL);
							
							JSONObject jsonObject = new JSONObject();
							jsonObject.put("winsTeamA",0);
							jsonObject.put("draws",0);
							jsonObject.put("winsTeamB",0);
							jsonObject.put("teamA", a.getTeamName());
							jsonObject.put("teamACode", a.getTeamCodes().get(0));
							jsonObject.put("teamB", b.getTeamName());
							jsonObject.put("teamBCode",b.getTeamCodes().get(0));
							jsonObject.put("goalsScoredA", 0);
							jsonObject.put("goalsScoredB", 0);
							toplevel.add(jsonObject);
							
							
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			}
			
		}
		
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("headToheadStats.json"));
			bufferedWriter.write(toplevel.toJSONString());
			bufferedWriter.flush();
			bufferedWriter.close();
	 
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("File Generated");
		System.out.println("############################");
		System.out.println(toplevel);		
	}
	
	public static void main(String[] args) {
		parse();
	}

}
