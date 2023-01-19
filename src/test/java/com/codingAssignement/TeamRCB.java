package com.codingAssignement;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class TeamRCB {
	
	@Test
	public void case1_verify_team_has_4_foreign_players() throws FileNotFoundException, IOException, ParseException {	
		int expected_no_of_foreign_players = 4;
	
		// parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("src/test/resources/TeamRCB.json"));
          
        // type casting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        
        // getting players
        JSONArray ja = (JSONArray) jo.get("player");
              
        int count=0;
        for(int i=0;i<ja.size()-1;i++) {
        	JSONObject str = (JSONObject)ja.get(i);
        	if(!str.get("country").equals("India"))
        	{
        		count=count+1;
        		System.out.println(str.get("name")+" : "+str.get("country"));
        	}            
        }
        
       Assert.assertEquals("Expected no of foreign players are not matching with actual no of players.", expected_no_of_foreign_players, count);
        
	}
	
	@Test
	public void case2_verify_team_has_one_wicket_keeper() throws FileNotFoundException, IOException, ParseException {
		int expected_no_of_wicket_keepers = 1;
		// parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("src/test/resources/TeamRCB.json"));
          
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        
        // getting players
        JSONArray ja = (JSONArray) jo.get("player");
              
        int count=0;
        for(int i=0;i<ja.size()-1;i++) {
        	JSONObject str = (JSONObject)ja.get(i);
        	if(str.get("role").equals("Wicket-keeper"))
        	{
        		count=count+1;
        		System.out.println(str.get("name")+" : "+str.get("role"));
        	}            
        }
        
       Assert.assertEquals("Expected no of wicket keepers are not matching with actual no of wicket keepers.", expected_no_of_wicket_keepers, count);        
	}
}
