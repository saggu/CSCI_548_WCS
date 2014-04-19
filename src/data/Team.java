package data;

import java.util.List;

public class Team {
	
	String teamName;
	List<String> teamCodes;
	
	public  Team(String name)
	{
		TeamCodes tCode = new TeamCodes();
		
		this.teamName = name;
		
		this.teamCodes = tCode.GetTeamCodes(name);
		
	}
	
	

}
