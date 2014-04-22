package data;

import java.util.ArrayList;
import java.util.List;

public class TeamGroups {
	
	
	
	public TeamGroups(String groupName) {
		super();
		this.groupName = groupName;
		this.teams = new ArrayList<Team>();
	}
	public TeamGroups() {
		
	}

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
		
		//setup the groups
		
		//Group - A
		TeamGroups groupA = new TeamGroups("GROUP A");
		groupA.teams.add(new Team("BRAZIL"));
		groupA.teams.add(new Team("CROATIA"));
		groupA.teams.add(new Team("MEXICO"));
		groupA.teams.add(new Team("CAMEROON"));
		tg.add(groupA);
		
		//Group - B
		TeamGroups groupB = new TeamGroups("GROUP B");
		groupB.teams.add(new Team("SPAIN"));
		groupB.teams.add(new Team("NETHERLANDS"));
		groupB.teams.add(new Team("CHILE"));
		groupB.teams.add(new Team("AUSTRALIA"));
		tg.add(groupB);
		
		//Group - C
		TeamGroups groupC = new TeamGroups("GROUP C");
		groupC.teams.add(new Team("COLOMBIA"));
		groupC.teams.add(new Team("GREECE"));
		groupC.teams.add(new Team("JAPAN"));
		groupC.teams.add(new Team("IVORY COAST"));
		tg.add(groupC);
		
		//Group - D
		TeamGroups groupD = new TeamGroups("GROUP D");
		groupD.teams.add(new Team("URUGUAY"));
		groupD.teams.add(new Team("COSTA RICA"));
		groupD.teams.add(new Team("ENGLAND"));
		groupD.teams.add(new Team("ITALY"));
		tg.add(groupD);
		
		//Group - E
		TeamGroups groupE = new TeamGroups("GROUP E");
		groupE.teams.add(new Team("SWITZERLAND") );
		groupE.teams.add(new Team("ECUADOR") );
		groupE.teams.add(new Team("FRANCE") );
		groupE.teams.add(new Team("HONDURAS") );
		tg.add(groupE);
		
		//Group - F
		TeamGroups groupF = new TeamGroups("GROUP F");
		groupF.teams.add(new Team("ARGENTINA"));
		groupF.teams.add(new Team("BOSNIA-HERZEGOVINA"));
		groupF.teams.add(new Team("IRAN"));
		groupF.teams.add(new Team("NIGERIA"));
		tg.add(groupF);
		
		//Group - G
		TeamGroups groupG = new TeamGroups("GROUP G");
		groupG.teams.add(new Team("GERMANY"));
		groupG.teams.add(new Team("PORTUGAL"));
		groupG.teams.add(new Team("GHANA"));
		groupG.teams.add(new Team("UNITED STATES"));
		tg.add(groupG);
		
		//Group - H
		TeamGroups groupH = new TeamGroups("GROUP H");
		groupH.teams.add(new Team("BELGIUM"));
		groupH.teams.add(new Team("ALGERIA"));
		groupH.teams.add(new Team("RUSSIA"));
		groupH.teams.add(new Team("SOUTH KOREA"));
		tg.add(groupH);
		
		return tg;
		
	}
	

}
