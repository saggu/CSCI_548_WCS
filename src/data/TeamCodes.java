package data;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class TeamCodes {
	
	public static Multimap<String,String> teamCodes;
	
	public static Multimap<String, String> GetTeamCodes()
	{
		teamCodes = ArrayListMultimap.create();
		
		teamCodes.put("ALGERIA", "alg");
		teamCodes.put("AUSTRALIA", "aus");
		teamCodes.put("ARGENTINA", "arg");
		teamCodes.put("BELGIUM", "bel");
		teamCodes.put("BOSNIA-HERZEGOVIA","bih");
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
		
		return teamCodes;
	}

}
