package inlineAds;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.base.Splitter;

class BannerAdsPodcastPage {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	String fileName = "resources//testdata.csv";

	String term = "ccrpos%3D8004";
   // String sz1 = "sz=320x50%7C300x50";
   
    String key_term = "cust_params";
	String station = "hometab%3Dpodcasts";
	String url = "https://pubads.g.doubleclick.net/gampad/ads?";
	
	
	@Test
	public void banner() throws IOException{
    	List<String> lines = readFile(fileName);
    	List<String> match = lines.stream().filter(line -> termExists(url, line)).collect(Collectors.toList());
        //matches.stream().forEach(line -> System.out.println("banner Ads Call  " + line));
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
                    		if(tokens[j].equals(station)) {
                    			System.out.println(tokens[j]);
                    			
                    			for(int st = 0; st < tokens.length; st++)
                    			if(tokens[st].equals(term)) {
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
    private static boolean termExists(String term2, String line) {
        return line.lastIndexOf(term2) > -1;
    }


}
