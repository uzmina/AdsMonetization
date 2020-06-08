package triggerAds;
//import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.google.common.base.Splitter;

//import org.testng.annotations.Test;


public class TriggerAds {
private static final String podcasts = null;

String fileName = "resources//testdata.csv";
	
	String term = "ccrpos%3D8005";
    String sz1 = "sz=300x250";
    String pagename = "genre%3Dplaylists";
    List<String> strings = Arrays.asList("ccrpos%3D8005", "sz=320x50%7C300x250");
    String url= "https://pubads.g.doubleclick.net/gampad/ads";
    String key_term = "cust_params";
    
   @Test
    public void trigger() throws IOException{
    	List<String> lines = readFile(fileName);
    	List<String> match = lines.stream().filter(line -> termExists(url, line)).collect(Collectors.toList());
        //matches.stream().forEach(line -> System.out.println(line));
        //assertTrue(matches.contains(term));
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
                    	/*for (String t : tokens)
                    	  System.out.println("value of custparam   "+ t);*/
                    	
                    	for(int j = 0; j < tokens.length; j++) {
                    		if(tokens[j].equals(pagename)) {
                    			System.out.println(tokens[j]);
                    			
                    			for(int st = 0; st < tokens.length; st++)
                    			if(tokens[st].equals(term)) {
                    				System.out.println(tokens[st]);
                    			}
                    			
                    		}else {
                    			System.out.println("no trigger ads on playlist player");
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

