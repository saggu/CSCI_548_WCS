package data;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	String playerName;
	List<String> playerCodes;
	
	//getters and setters
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public List<String> getPlayerCodes() {
		return playerCodes;
	}
	public void setPlayerCodes(List<String> playerCodes) {
		this.playerCodes = playerCodes;
	}
	
	public Player(String name)
	{
		PlayerCodes pc = new PlayerCodes();
		
		this.playerName = name;
		this.playerCodes = pc.GetPlayerCodes(name.toUpperCase().trim());
	}
	
	
	public List<Player> AllPlayers()
	{
		List<Player> allPlayers = new ArrayList<Player>();
		
		allPlayers.add(new Player("MADJID BOUGHERRA"));
		allPlayers.add(new Player("ISLAM SLIMANI"));
		allPlayers.add(new Player("JAVIER MASCHERANO"));
		allPlayers.add(new Player("TIM CAHILL"));
		allPlayers.add(new Player("LUCAS NEILL"));
		allPlayers.add(new Player("BRETT HOLMAN"));
		allPlayers.add(new Player("JULIO CESAR"));
		allPlayers.add(new Player("ALEX SONG"));
		allPlayers.add(new Player("EDUARDO VARGAS"));
		allPlayers.add(new Player("MATIAS FERNANDEZ"));
		allPlayers.add(new Player("TEO GUTIERREZ"));
		allPlayers.add(new Player("BRYAN RUIZ"));
		allPlayers.add(new Player("ALVARO SABORIO"));
		allPlayers.add(new Player("DIDIER DROGBA"));
		allPlayers.add(new Player("DARIJO SRNA"));
		allPlayers.add(new Player("EDUARDO"));
		allPlayers.add(new Player("ANTONIO VALENCIA"));
		allPlayers.add(new Player("FELIPE CAICEDO"));
		allPlayers.add(new Player("EDISON MENDEZ"));
		allPlayers.add(new Player("MICHAEL ESSIEN"));
		allPlayers.add(new Player("ASAMOAH GYAN"));
		allPlayers.add(new Player("GIORGOS KARAGOUNIS"));
		allPlayers.add(new Player("DIMITRIOS SALPINGIDIS"));
		allPlayers.add(new Player("MITROGLOU"));
		allPlayers.add(new Player("EMILIO IZAGUIRRE"));
		allPlayers.add(new Player("NOEL VALLADARES"));
		allPlayers.add(new Player("WILSON PALACIOS"));
		allPlayers.add(new Player("JAVAD NEKOUNAM"));
		allPlayers.add(new Player("MASOUD SHOJAEI"));
		allPlayers.add(new Player("REZA GHOOCHANNEJHAD"));
		allPlayers.add(new Player("PABLO OSVALDO"));
		allPlayers.add(new Player("KEISUKE HONDA"));
		allPlayers.add(new Player("SHINJI KAGAWA"));
		allPlayers.add(new Player("KIM SHINWOOK"));
		allPlayers.add(new Player("LEE KEUNHO"));
		allPlayers.add(new Player("LEE CHUNGYONG"));
		allPlayers.add(new Player("ANDRES GUARDADO"));
		allPlayers.add(new Player("ORIBE PERALTA"));
		allPlayers.add(new Player("JERMAINE LENS"));
		allPlayers.add(new Player("NANI"));
		allPlayers.add(new Player("IGOR AKINFEEV"));
		allPlayers.add(new Player("ROMAN SHIROKOV"));
		allPlayers.add(new Player("VICTOR FAYZULIN"));
		allPlayers.add(new Player("CESC FABREGAS"));
		allPlayers.add(new Player("FABIAN SCHAR"));
		allPlayers.add(new Player("DIEGO LUGANO"));
		allPlayers.add(new Player("CLINT DEMPSEY"));
		allPlayers.add(new Player("MICHAEL BRADLEY"));
		
		return allPlayers;

	}
	
	

}
