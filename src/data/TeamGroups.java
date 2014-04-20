package data;

import java.util.ArrayList;
import java.util.List;

public class TeamGroups {
	
	private String groupName;
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	private List<Team> teams;
	
	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<TeamGroups> TeamGroupDetails()
	{
		List<TeamGroups> tg = new ArrayList<TeamGroups>();
		List<Team> temp = new ArrayList<Team>();
		
		//setup the groups
		
		//Group - A
		TeamGroups groupA = new TeamGroups();
		groupA.groupName = "GROUP A";
		temp.add(new Team("BRAZIL"));
		temp.add(new Team("CROATIA"));
		temp.add(new Team("MEXICO"));
		temp.add(new Team("CAMEROON"));
		groupA.teams =  temp;
		tg.add(groupA);
		temp.clear();
		
		//Group - B
		TeamGroups groupB = new TeamGroups();
		groupB.groupName = "GROUP B";
		temp.add(new Team("SPAIN"));
		temp.add(new Team("NETHERLANDS"));
		temp.add(new Team("CHILE"));
		temp.add(new Team("AUSTRALIA"));
		groupB.teams = temp;
		tg.add(groupB);
		temp.clear();
		
		//Group - C
		TeamGroups groupC = new TeamGroups();
		groupC.groupName = "GROUP C";
		temp.add(new Team("COLOMBIA"));
		temp.add(new Team("GREECE"));
		temp.add(new Team("JAPAN"));
		temp.add(new Team("IVORY COAST"));
		groupC.teams = temp;
		tg.add(groupC);
		temp.clear();
		
		//Group - D
		TeamGroups groupD = new TeamGroups();
		groupD.groupName = "GROUP D";
		temp.add(new Team("URUGUAY"));
		temp.add(new Team("COSTA RICA"));
		temp.add(new Team("ENGLAND"));
		temp.add(new Team("ITALY"));
		groupD.teams = temp;
		tg.add(groupD);
		temp.clear();
		
		//Group - E
		TeamGroups groupE = new TeamGroups();
		groupE.groupName = "GROUP E";
		temp.add(new Team("SWITZERLAND"));
		temp.add(new Team("ECUADOR"));
		temp.add(new Team("FRANCE"));
		temp.add(new Team("HONDURAS"));
		groupE.teams = temp;
		tg.add(groupE);
		temp.clear();
		
		//Group - F
		TeamGroups groupF = new TeamGroups();
		groupF.groupName = "GROUP F";
		temp.add(new Team("ARGENTINA"));
		temp.add(new Team("BOSNIA-HERZEGOVIA"));
		temp.add(new Team("IRAN"));
		temp.add(new Team("NIGERIA"));
		groupF.teams = temp;
		tg.add(groupF);
		temp.clear();
		
		//Group - G
		TeamGroups groupG = new TeamGroups();
		groupG.groupName = "GROUP G";
		temp.add(new Team("GERMANY"));
		temp.add(new Team("PORTUGAL"));
		temp.add(new Team("GHANA"));
		temp.add(new Team("UNITED STATES"));
		groupG.teams = temp;
		tg.add(groupG);
		temp.clear();
		
		//Group - H
		TeamGroups groupH = new TeamGroups();
		groupH.groupName = "GROUP H";
		temp.add(new Team("BELGIUM"));
		temp.add(new Team("ALGERIA"));
		temp.add(new Team("RUSSIA"));
		temp.add(new Team("SOUTH KOREA"));
		groupH.teams = temp;
		tg.add(groupH);
		
		return tg;
		
	}
	

}
