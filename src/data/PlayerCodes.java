package data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class PlayerCodes {
	
	public Multimap<String,String> playerCodes;
	
	public PlayerCodes()
	{
		SetPlayerCodes();
	}
	
	private void SetPlayerCodes()
	{
		playerCodes = ArrayListMultimap.create();
		
		//unique player code at index 0
		playerCodes.put("MADJID BOUGHERRA","MADBOU");
		playerCodes.put("ISLAM SLIMANI","ISLSLI");
		playerCodes.put("JAVIER MASCHERANO","JAVMAS");
		playerCodes.put("TIM CAHILL","TIMCAH");
		playerCodes.put("LUCAS NEILL","LUCNEI");
		playerCodes.put("BRETT HOLMAN","BREHOL");
		playerCodes.put("JULIO CESAR","JULCES");
		playerCodes.put("ALEX SONG","ALESON");
		playerCodes.put("EDUARDO VARGAS","EDUVAR");
		playerCodes.put("MATIAS FERNANDEZ","MATFER");
		playerCodes.put("TEO GUTIERREZ","TEOGUT");
		playerCodes.put("BRYAN RUIZ","BRYRUI");
		playerCodes.put("ALVARO SABORIO","ALVSAB");
		playerCodes.put("DIDIER DROGBA","DIDDRO");
		playerCodes.put("DARIJO SRNA","DARSRN");
		playerCodes.put("EDUARDO","EDU");
		playerCodes.put("ANTONIO VALENCIA","ANTVAL");
		playerCodes.put("FELIPE CAICEDO","FELCAI");
		playerCodes.put("EDISON MENDEZ","EDIMEN");
		playerCodes.put("MICHAEL ESSIEN","MICESS");
		playerCodes.put("ASAMOAH GYAN","ASAGYA");
		playerCodes.put("GIORGOS KARAGOUNIS","GIOKAR");
		playerCodes.put("DIMITRIOS SALPINGIDIS","DIMSAL");
		playerCodes.put("MITROGLOU","MIT");
		playerCodes.put("EMILIO IZAGUIRRE","EMIIZA");
		playerCodes.put("NOEL VALLADARES","NOEVAL");
		playerCodes.put("WILSON PALACIOS","WILPAL");
		playerCodes.put("JAVAD NEKOUNAM","JAVNEK");
		playerCodes.put("MASOUD SHOJAEI","MASSHO");
		playerCodes.put("REZA GHOOCHANNEJHAD","REZGHO");
		playerCodes.put("PABLO OSVALDO","PABOSV");
		playerCodes.put("KEISUKE HONDA","KEIHON");
		playerCodes.put("SHINJI KAGAWA","SHIKAG");
		playerCodes.put("KIM SHINWOOK","KIMSHI");
		playerCodes.put("LEE KEUNHO","LEEKEU");
		playerCodes.put("LEE CHUNGYONG","LEECHU");
		playerCodes.put("ANDRES GUARDADO","ANDGUA");
		playerCodes.put("ORIBE PERALTA","ORIPER");
		playerCodes.put("JERMAINE LENS","JERLEN");
		playerCodes.put("NANI","NAN");
		playerCodes.put("IGOR AKINFEEV","IGOAKI");
		playerCodes.put("ROMAN SHIROKOV","ROMSHI");
		playerCodes.put("VICTOR FAYZULIN","VICFAY");
		playerCodes.put("CESC FABREGAS","CESFAB");
		playerCodes.put("FABIAN SCHAR","FABSCH");
		playerCodes.put("DIEGO LUGANO","DIELUG");
		playerCodes.put("CLINT DEMPSEY","CLIDEM");
		playerCodes.put("MICHAEL BRADLEY","MICBRA");
		
		
		//espn id at the index 1
		playerCodes.put("MADJID BOUGHERRA","74714");
		playerCodes.put("ISLAM SLIMANI","173504");
		playerCodes.put("JAVIER MASCHERANO","40380");
		playerCodes.put("TIM CAHILL","5105");
		playerCodes.put("LUCAS NEILL","5084");
		playerCodes.put("BRETT HOLMAN","125305");
		playerCodes.put("JULIO CESAR","notpresent");
		playerCodes.put("ALEX SONG","43447");
		playerCodes.put("EDUARDO VARGAS","169773");
		playerCodes.put("MATIAS FERNANDEZ","47952");
		playerCodes.put("TEO GUTIERREZ","notpresent");
		playerCodes.put("BRYAN RUIZ","137779");
		playerCodes.put("ALVARO SABORIO","110477");
		playerCodes.put("DIDIER DROGBA","18727");
		playerCodes.put("DARIJO SRNA","25253");
		playerCodes.put("EDUARDO","notpresent");
		playerCodes.put("ANTONIO VALENCIA","65629");
		playerCodes.put("FELIPE CAICEDO","98025");
		playerCodes.put("EDISON MENDEZ","86660");
		playerCodes.put("MICHAEL ESSIEN","9799");
		playerCodes.put("ASAMOAH GYAN","42068");
		playerCodes.put("GIORGOS KARAGOUNIS","57129");
		playerCodes.put("DIMITRIOS SALPINGIDIS","124883");
		playerCodes.put("MITROGLOU","108333");
		playerCodes.put("EMILIO IZAGUIRRE","119981");
		playerCodes.put("NOEL VALLADARES","3007");
		playerCodes.put("WILSON PALACIOS","93145");
		playerCodes.put("JAVAD NEKOUNAM","16452");
		playerCodes.put("MASOUD SHOJAEI","121620");
		playerCodes.put("REZA GHOOCHANNEJHAD","77503");
		playerCodes.put("PABLO OSVALDO","104954");
		playerCodes.put("KEISUKE HONDA","90718");
		playerCodes.put("SHINJI KAGAWA","102139");
		playerCodes.put("KIM SHINWOOK","133245");
		playerCodes.put("LEE KEUNHO","100902");
		playerCodes.put("LEE CHUNGYONG","120260");
		playerCodes.put("ANDRES GUARDADO","76932");
		playerCodes.put("ORIBE PERALTA","31225");
		playerCodes.put("JERMAINE LENS","76942");
		playerCodes.put("NANI","67716");
		playerCodes.put("IGOR AKINFEEV","39740");
		playerCodes.put("ROMAN SHIROKOV","88529");
		playerCodes.put("VICTOR FAYZULIN","124912");
		playerCodes.put("CESC FABREGAS","38886");
		playerCodes.put("FABIAN SCHAR","174555");
		playerCodes.put("DIEGO LUGANO","71137");
		playerCodes.put("CLINT DEMPSEY","39928");
		playerCodes.put("MICHAEL BRADLEY","41952");
		
		//espn name at index 2
		playerCodes.put("MADJID BOUGHERRA","madjid-bougherra");
		playerCodes.put("ISLAM SLIMANI","islam-slimani");
		playerCodes.put("JAVIER MASCHERANO","javier-alejandro-mascherano");
		playerCodes.put("TIM CAHILL","tim-cahill");
		playerCodes.put("LUCAS NEILL","lucas-neill");
		playerCodes.put("BRETT HOLMAN","brett-holman");
		playerCodes.put("JULIO CESAR","0");
		playerCodes.put("ALEX SONG","alexandre-song-billong");
		playerCodes.put("EDUARDO VARGAS","eduardo-vargas");
		playerCodes.put("MATIAS FERNANDEZ","matias-ariel-fernandez-fernandez");
		playerCodes.put("TEO GUTIERREZ","0");
		playerCodes.put("BRYAN RUIZ","bryan-ruiz");
		playerCodes.put("ALVARO SABORIO","alvaro-saborio");
		playerCodes.put("DIDIER DROGBA","didier-drogba");
		playerCodes.put("DARIJO SRNA","darijo-srna");
		playerCodes.put("EDUARDO","0");
		playerCodes.put("ANTONIO VALENCIA","antonio-luis-valencia");
		playerCodes.put("FELIPE CAICEDO","felipe-salvador-caicedo");
		playerCodes.put("EDISON MENDEZ","edison-mendez");
		playerCodes.put("MICHAEL ESSIEN","michael-essien");
		playerCodes.put("ASAMOAH GYAN","asamoah-gyan");
		playerCodes.put("GIORGOS KARAGOUNIS","giorgias-karagounis");
		playerCodes.put("DIMITRIOS SALPINGIDIS","dimitris-salpingidis");
		playerCodes.put("MITROGLOU","kostas-mitroglou");
		playerCodes.put("EMILIO IZAGUIRRE","emilio-izaguirre");
		playerCodes.put("NOEL VALLADARES","noel-valladares");
		playerCodes.put("WILSON PALACIOS","wilson-palacios");
		playerCodes.put("JAVAD NEKOUNAM","javad-nekounam");
		playerCodes.put("MASOUD SHOJAEI","masoud-shojaei");
		playerCodes.put("REZA GHOOCHANNEJHAD","reza-ghoochannejhad");
		playerCodes.put("PABLO OSVALDO","pablo-daniel-osvaldo");
		playerCodes.put("KEISUKE HONDA","keisuke-honda");
		playerCodes.put("SHINJI KAGAWA","shinji-kagawa");
		playerCodes.put("KIM SHINWOOK","shin-wook-kim");
		playerCodes.put("LEE KEUNHO","lee-keun-ho");
		playerCodes.put("LEE CHUNGYONG","lee-chung-yong");
		playerCodes.put("ANDRES GUARDADO","andres-guardado");
		playerCodes.put("ORIBE PERALTA","oribe-peralta-morones");
		playerCodes.put("JERMAINE LENS","jeremain-lens");
		playerCodes.put("NANI","luis-carlos-almeida-da-cunha-nani");
		playerCodes.put("IGOR AKINFEEV","igor-akinfeev");
		playerCodes.put("ROMAN SHIROKOV","roman-shirokov");
		playerCodes.put("VICTOR FAYZULIN","viktor-faizulin");
		playerCodes.put("CESC FABREGAS","francesc-fabregas");
		playerCodes.put("FABIAN SCHAR","fabian-schar");
		playerCodes.put("DIEGO LUGANO","diego-alfredo-lugano-moreno-");
		playerCodes.put("CLINT DEMPSEY","clinton-dempsey");
		playerCodes.put("MICHAEL BRADLEY","michael-bradley");
	}
	
	public List<String> GetPlayerCodes(String playerName)
	{
		List<String> playerCode =  new ArrayList<String>();
		
		Collection<String> pc = playerCodes.get(playerName.toUpperCase());
		
		
		for(String code : pc)
		{
			playerCode.add(code);
		}
		
		return playerCode;
	}

}
