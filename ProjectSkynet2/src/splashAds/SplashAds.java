package splashAds;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.google.common.base.Splitter;


public class SplashAds {
String fileName = "resources//testads.csv";
	
	String term = "ccrpos%3D8009";
    String terms = "includeDoritos=true";
    String key_term = "cust_params";
	String station = "hometab%3Dradio";
	String url = "https://pubads.g.doubleclick.net/gampad/ads?";
	
	
   @Test
    public void splash() throws IOException{
    	List<String> lines = readFile(fileName);
    	List<String> match = lines.stream().filter(line -> termExists(term, line)).collect(Collectors.toList());
        //match.stream().forEach(line -> System.out.println(line));
        
        
        if(match.size() != 0) {

        	for(String temp : match){
        
        	try {
        		for(int i = 0;i<temp.length(); i++) {
        		String query = temp.split("&")[i];
                final Map<String, String> map = Splitter.on('&').trimResults().withKeyValueSeparator('=').split(query);
                //System.out.println(map);
               
                Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator(); 
                
                while(itr.hasNext()) 
                { 
                     Map.Entry<String, String> entry = itr.next(); 
                     //System.out.println("Key = " + entry.getKey() + "\n"+ "Value = " + entry.getValue()); 
                    String key1 = entry.getKey();
                    //System.out.println(key1);
                    if(key1.contains(key_term)) {
                    	
                    	String value1 = entry.getValue();
                    	String s = value1;
                    	String[] tokens = s.split("%26");
                    	//for (String t : tokens)
                    	  //System.out.println("value of custparam   "+ t);
                    	
                    	for(int j = 0; j < tokens.length; j++) {
                    		if(tokens[j].equals(term)) {
                    			System.out.println("PASS  "+tokens[j]);
                    		
                    		}
                    		
                    	}

                    	
                    	
						//System.out.println("session start value is a pass   " + value1);
                    	}
                    }
                    
                    
                } 
        	}
        	catch (IllegalArgumentException e) {
        		//System.out.println(e + "\n");
        		
        	}}
        }
   }
	
    
    private static List<String> readFile(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
    }
    private static boolean termExists(String term, String line) {
        return line.lastIndexOf(term) > -1;
    }
}
