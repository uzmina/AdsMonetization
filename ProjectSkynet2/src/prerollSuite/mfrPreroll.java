package prerollSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.google.common.base.Splitter;

class mfrPreroll {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	String fileName = "resources//adstest2.csv";
    List<String> strings = Arrays.asList("ccrpos%3D8000", "sz=320x50%7C300x250","locale=en-US");
	@Test
	public void prerollLive() throws Exception{
		
		   BufferedReader in = new BufferedReader(new FileReader(fileName));
	    
	    
	    //Path pathToFile = Paths.get(fileName);
	    //System.out.println(pathToFile.toAbsolutePath());
	    
	    
	    String term = "ccrpos%3D8000";
	    String key_term = "cust_params";
	    String station = "genre%3Dartist";
	    String url= "https://pubads.g.doubleclick.net/gampad/ads";
	    List<String> lines = readFile(fileName);
	   
	    //checking for pre-rolls
	    List<String> match = lines.stream().filter(line -> termExists(url, line)).collect(Collectors.toList());
	    //matches.stream().forEach(line -> System.out.println(line));
	    
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
                    		if(tokens[j].equals(term)) {
                    			System.out.println(tokens[j]);
                    			
                    			for(int st = 0; st < tokens.length; st++)
                    			if(tokens[st].equals(station)) {
                    				System.out.println(tokens[st]);
                    			}
                    			
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
