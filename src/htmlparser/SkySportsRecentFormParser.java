package htmlparser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import data.Team;

public class SkySportsRecentFormParser {
	
	private StringBuilder url = null;
	
	public void TeamRecentResults()
	{
		List<Team> allTeams = Team.AllTeams();
		StringBuilder recentForm = new StringBuilder();
		
		
		for(Team team : allTeams)
		{
			recentForm.append(team.getTeamName() + ",");
			recentForm.append(team.getTeamCodes().get(0) + ",");
			recentForm.append(parse(team.getTeamName().toLowerCase().trim()) + "\n");
		}
		
		try 
		{
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("TeamRecentForm.csv"));
			bufferedWriter.write(recentForm.toString());
			bufferedWriter.flush();
			bufferedWriter.close();
	 
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("File Generated");
		
	} 
	
	private String parse(String teamName)
	{
		
		//will not work if the country has a space in the name. Values taken from website because of the effor not being worth it.
		try
		{
			url = new StringBuilder("http://www1.skysports.com/football/teams/");
			
			String urlTeamNamePart = teamName;
			//Special Case for Bosnia-Herzegovina
			if(teamName.toLowerCase().trim().equals("bosnia-herzegovina"))
			{
				teamName = "bosnia";
			}
			
			//Special Case for ivory-coast
			if(teamName.toLowerCase().trim().equals("ivory coast"))
			{
				urlTeamNamePart = "ivorycoast";
			}
			
			//Special Case for costa rica
			if(teamName.toLowerCase().trim().equals("costa rica"))
			{
				urlTeamNamePart = "costa-rica";
			}
			
			//Special Case for united states
			if(teamName.toLowerCase().trim().equals("united states"))
			{
				urlTeamNamePart = "usa";
				teamName = "usa";
			}
			
			//Special Case for south korea
			if(teamName.toLowerCase().trim().equals("south korea"))
			{
				urlTeamNamePart = "southkorea";
			}
			
			url.append(urlTeamNamePart.toLowerCase().trim());
			url.append("/results");
			System.out.println(url.toString());
			StringBuilder recentForm = new StringBuilder();
			Document doc = Jsoup.connect(url.toString()).get();
			Elements eCol1 = doc.select("div.score-side1");
			Elements eCol2 = doc.select("div.score-side2");
			Elements eColMid = doc.select("div.score-post");
			
						
			int numResults = eCol1.size();
			
			if(numResults > 5)
			{
				numResults = 5;
			}
			
			for(int i=0;i<numResults;i++) //only interested in the last five games
			{
				String teamA = eCol1.get(i).text().split(" ")[0];
				String teamB = eCol2.get(i).text().split(" ")[0];
				String[] score = eColMid.get(i).text().split(" ");
				int scoreA = 0;
				int scoreB = 0;
				
				if(teamName.toUpperCase().equals(teamA.toUpperCase()))
				{
					scoreA = Integer.parseInt(score[0]);
					scoreB = Integer.parseInt(score[2]);
					if(scoreA > scoreB)
					{
						recentForm.append("W-"); //WIN
					}
					else if(scoreA < scoreB)
					{
						recentForm.append("L-");//LOSS
					}
					else
					{
						recentForm.append("D-");//DRAW
					}
					
				}
				else if(teamName.toUpperCase().equals(teamB.toUpperCase()))
				{
					scoreA = Integer.parseInt(score[0]);
					scoreB = Integer.parseInt(score[2]);
					if(scoreA > scoreB)
					{
						recentForm.append("L-");//LOSS
					}
					else if(scoreA < scoreB)
					{
						recentForm.append("W-");//WIN
					}
					else
					{
						recentForm.append("D-");//DRAW
					}
				}
			}
			if(recentForm.length() > 0)
			{
				System.out.print(recentForm.substring(0,recentForm.length() - 1).toString().trim());
				return recentForm.substring(0,recentForm.length() - 1).toString().trim();
			}
			return "";
		}
		catch(IOException e)
		{
			return "";
		}
	}

}
