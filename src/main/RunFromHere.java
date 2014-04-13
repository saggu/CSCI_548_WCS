package main;

import java.util.Collection;

import com.google.common.collect.Multimap;

import data.TeamCodes;
import htmlparser.ESPNGroupMatchesParser;

public class RunFromHere {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ESPNGroupMatchesParser.parse();
		Multimap<String,String> data = TeamCodes.GetTeamCodes();
		
		Collection<String> teamCode = data.get("ARGENTINA");
		
				
		for(String team:teamCode)
		{
			System.out.print("teams: " + team);
		}
		
		

	}

}
