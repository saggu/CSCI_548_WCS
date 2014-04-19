package data;

import java.util.ArrayList;
import java.util.List;

public class TeamGroups {
	
	String groupName;
	Team one;
	Team two;
	Team three;
	Team four;
	
	public List<TeamGroups> TeamGroupDetails()
	{
		List<TeamGroups> tg = new ArrayList<TeamGroups>();
				
		//setup the groups
		
		//Group - A
		TeamGroups groupA = new TeamGroups();
		groupA.groupName = "GROUP A";
		groupA.one = new Team("BRAZIL");
		groupA.two = new Team("CROATIA");
		groupA.three = new Team("MEXICO");
		groupA.four = new Team("CAMEROON");
		
		tg.add(groupA);
		
		//Group - B
		TeamGroups groupB = new TeamGroups();
		groupB.groupName = "GROUP B";
		groupB.one = new Team("SPAIN");
		groupB.two = new Team("NETHERLANDS");
		groupB.three = new Team("CHILE");
		groupB.four = new Team("AUSTRALIA");
		
		tg.add(groupB);
		
		//Group - C
		TeamGroups groupC = new TeamGroups();
		groupC.groupName = "GROUP C";
		groupC.one = new Team("COLOMBIA");
		groupC.two = new Team("GREECE");
		groupC.three = new Team("JAPAN");
		groupC.four = new Team("IVORY COAST");
		
		tg.add(groupC);
		
		//Group - D
		TeamGroups groupD = new TeamGroups();
		groupD.groupName = "GROUP D";
		groupD.one = new Team("URUGUAY");
		groupD.two = new Team("COSTA RICA");
		groupD.three = new Team("ENGLAND");
		groupD.four = new Team("ITALY");
		
		tg.add(groupD);
		
		//Group - E
		TeamGroups groupE = new TeamGroups();
		groupE.groupName = "GROUP E";
		groupE.one = new Team("SWITZERLAND");
		groupE.two = new Team("ECUADOR");
		groupE.three = new Team("FRANCE");
		groupE.four = new Team("HONDURAS");
		
		tg.add(groupE);
		
		//Group - 1
		TeamGroups groupF = new TeamGroups();
		groupF.groupName = "GROUP F";
		groupF.one = new Team("ARGENTINA");
		groupF.two = new Team("BOSNIA-HERZEGOVIA");
		groupF.three = new Team("IRAN");
		groupF.four = new Team("NIGERIA");
		
		tg.add(groupF);
		
		//Group - G
		TeamGroups groupG = new TeamGroups();
		groupG.groupName = "GROUP G";
		groupG.one = new Team("GERMANY");
		groupG.two = new Team("PORTUGAL");
		groupG.three = new Team("GHANA");
		groupG.four = new Team("UNITED STATES");
		
		tg.add(groupG);
		
		//Group - H
		TeamGroups groupH = new TeamGroups();
		groupH.groupName = "GROUP H";
		groupH.one = new Team("BELGIUM");
		groupH.two = new Team("ALGERIA");
		groupH.three = new Team("RUSSIA");
		groupH.four = new Team("SOUTH KOREA");
		
		tg.add(groupH);
		
		return tg;
		
	}
	

}
