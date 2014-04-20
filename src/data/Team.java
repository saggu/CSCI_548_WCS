package data;

import java.util.ArrayList;
import java.util.List;

public class Team {
	
	String teamName;
	List<String> teamCodes;	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<String> getTeamCodes() {
		return teamCodes;
	}

	public void setTeamCodes(List<String> teamCodes) {
		this.teamCodes = teamCodes;
	}

	
	
	public  Team(String name)
	{
		TeamCodes tCode = new TeamCodes();
		
		this.teamName = name;
		
		this.teamCodes = tCode.GetTeamCodes(name);
		
	}
	
	public static List<Team> AllTeams()
	{
		List<Team>  allTeams = new ArrayList<Team>();
		
		
		allTeams.add(new Team("BRAZIL"));
		allTeams.add(new Team("CROATIA"));
		allTeams.add(new Team("MEXICO"));
		allTeams.add(new Team("CAMEROON"));
		allTeams.add(new Team("SPAIN"));
		allTeams.add(new Team("NETHERLANDS"));
		allTeams.add(new Team("CHILE"));
		allTeams.add(new Team("AUSTRALIA"));
		allTeams.add(new Team("COLOMBIA"));
		allTeams.add(new Team("GREECE"));
		allTeams.add(new Team("JAPAN"));
		allTeams.add(new Team("IVORY COAST"));
		allTeams.add(new Team("URUGUAY"));
		allTeams.add(new Team("COSTA RICA"));
		allTeams.add(new Team("ENGLAND"));
		allTeams.add(new Team("ITALY"));
		allTeams.add(new Team("SWITZERLAND"));
		allTeams.add(new Team("ECUADOR"));
		allTeams.add(new Team("FRANCE"));
		allTeams.add(new Team("HONDURAS"));
		allTeams.add(new Team("ARGENTINA"));
		allTeams.add(new Team("BOSNIA-HERZEGOVINA"));
		allTeams.add(new Team("IRAN"));
		allTeams.add(new Team("NIGERIA"));
		allTeams.add(new Team("GERMANY"));
		allTeams.add(new Team("PORTUGAL"));
		allTeams.add(new Team("GHANA"));
		allTeams.add(new Team("UNITED STATES"));
		allTeams.add(new Team("BELGIUM"));
		allTeams.add(new Team("ALGERIA"));
		allTeams.add(new Team("RUSSIA"));
		allTeams.add(new Team("SOUTH KOREA"));
		
		
		return allTeams;
	}
	
	

}
