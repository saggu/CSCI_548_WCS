package data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class TeamCodes {
	
	public Multimap<String,String> teamCodes;
	
	public TeamCodes()
	{
		SetTeamCodes();
	}
	
	public void SetTeamCodes()
	{
		teamCodes = ArrayListMultimap.create();
		
		//Team Codes from FIFA at index 0
		teamCodes.put("ALGERIA", "alg");
		teamCodes.put("AUSTRALIA", "aus");
		teamCodes.put("ARGENTINA", "arg");
		teamCodes.put("BELGIUM", "bel");
		teamCodes.put("BOSNIA-HERZEGOVINA","bih");
		teamCodes.put("BRAZIL", "bra");
		teamCodes.put("CAMEROON", "cmr");
		teamCodes.put("CHILE", "chi");
		teamCodes.put("COLOMBIA", "col");
		teamCodes.put("COSTA RICA", "crc");
		teamCodes.put("CROATIA", "cro");
		teamCodes.put("ECUADOR", "ecu");
		teamCodes.put("ENGLAND", "eng");
		teamCodes.put("FRANCE", "fra");
		teamCodes.put("GERMANY", "ger");
		teamCodes.put("GHANA", "gha");
		teamCodes.put("GREECE", "gre");
		teamCodes.put("HONDURAS", "hon");
		teamCodes.put("IRAN", "irn");
		teamCodes.put("ITALY", "ita");
		teamCodes.put("IVORY COAST", "civ");
		teamCodes.put("JAPAN", "jpn");
		teamCodes.put("MEXICO", "mex");
		teamCodes.put("NETHERLANDS", "ned");
		teamCodes.put("NIGERIA", "nga");
		teamCodes.put("PORTUGAL", "por");
		teamCodes.put("RUSSIA", "rus");
		teamCodes.put("SOUTH KOREA", "kor");
		teamCodes.put("SPAIN", "esp");
		teamCodes.put("SWITZERLAND", "sui");
		teamCodes.put("UNITED STATES", "usa");
		teamCodes.put("URUGUAY", "uru");
		
		//Team Codes from http://www.soccerbase.com at index 1
		teamCodes.put("ALGERIA", "67");
		teamCodes.put("AUSTRALIA", "152");
		teamCodes.put("ARGENTINA", "128");
		teamCodes.put("BELGIUM", "275");
		teamCodes.put("BOSNIA-HERZEGOVINA","2984");
		teamCodes.put("BRAZIL", "395");
		teamCodes.put("CAMEROON", "615");
		teamCodes.put("CHILE", "550");
		teamCodes.put("COLOMBIA", "613");
		teamCodes.put("COSTA RICA", "661");
		teamCodes.put("CROATIA", "670");
		teamCodes.put("ECUADOR", "868");
		teamCodes.put("ENGLAND", "909");
		teamCodes.put("FRANCE", "1040");
		teamCodes.put("GERMANY", "1084");
		teamCodes.put("GHANA", "3116");
		teamCodes.put("GREECE", "1139");
		teamCodes.put("HONDURAS", "3173");
		teamCodes.put("IRAN", "1377");
		teamCodes.put("ITALY", "1384");
		teamCodes.put("IVORY COAST", "3115");
		teamCodes.put("JAPAN", "1392");
		teamCodes.put("MEXICO", "1788");
		teamCodes.put("NETHERLANDS", "1843");
		teamCodes.put("NIGERIA", "1833");
		teamCodes.put("PORTUGAL", "2082");
		teamCodes.put("RUSSIA", "2204");
		teamCodes.put("SOUTH KOREA", "717");
		teamCodes.put("SPAIN", "2428");
		teamCodes.put("SWITZERLAND", "2527");
		teamCodes.put("UNITED STATES", "2652");
		teamCodes.put("URUGUAY", "2651");
		
		
		//Other or alternative name for Team in SoccerBase Data source at index 2
		teamCodes.put("ALGERIA", "ALGERIA");
		teamCodes.put("AUSTRALIA", "AUSTRALIA");
		teamCodes.put("ARGENTINA", "ARGENTINA");
		teamCodes.put("BELGIUM", "BELGIUM");
		teamCodes.put("BOSNIA-HERZEGOVINA","BOSNIA-HZ.");
		teamCodes.put("BRAZIL", "BRAZIL");
		teamCodes.put("CAMEROON", "CAMEROON");
		teamCodes.put("CHILE", "CHILE");
		teamCodes.put("COLOMBIA", "COLOMBIA");
		teamCodes.put("COSTA RICA", "COSTA RICA");
		teamCodes.put("CROATIA", "CROATIA");
		teamCodes.put("ECUADOR", "ECUADOR");
		teamCodes.put("ENGLAND", "ENGLAND");
		teamCodes.put("FRANCE", "FRANCE");
		teamCodes.put("GERMANY", "GERMANY");
		teamCodes.put("GHANA", "GHANA");
		teamCodes.put("GREECE", "GREECE");
		teamCodes.put("HONDURAS", "HONDURAS");
		teamCodes.put("IRAN", "IRAN");
		teamCodes.put("ITALY", "ITALY");
		teamCodes.put("IVORY COAST", "IVORY COAST");
		teamCodes.put("JAPAN", "JAPAN");
		teamCodes.put("MEXICO", "MEXICO");
		teamCodes.put("NETHERLANDS", "HOLLAND");
		teamCodes.put("NIGERIA", "NIGERIA");
		teamCodes.put("PORTUGAL", "PORTUGAL");
		teamCodes.put("RUSSIA", "RUSSIA");
		teamCodes.put("SOUTH KOREA", "SOUTH KOREA");
		teamCodes.put("SPAIN", "SPAIN");
		teamCodes.put("SWITZERLAND", "SWITZERLAND");
		teamCodes.put("UNITED STATES", "USA");
		teamCodes.put("URUGUAY", "URUGUAY");
		
	}

	
	public List<String> GetTeamCodes(String teamName)
	{
		List<String> teamCode =  new ArrayList<String>();
		
		Collection<String> tc = teamCodes.get(teamName.toUpperCase());
		
		
		for(String code : tc)
		{
			teamCode.add(code);
		}
		
		return teamCode;
	}
}
