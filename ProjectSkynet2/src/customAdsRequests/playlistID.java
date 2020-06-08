package customAdsRequests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.base.Splitter;

class playlistID {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		
		String fileName = "resources//customAds.csv";
		
		String playlistId = "aw_0_1st.playlistid";
		
		
		String urlToTest = "https://clearchannel.deliveryengine.adswizz.com/www";
		
		List<String> lines = readFile(fileName);
		
		List<String> match = lines.stream().filter(line -> termExists(urlToTest, line)).collect(Collectors.toList());
        
        	for(String temp : match){
        	
        	try {
        		for(int i = 0; i<=temp.length(); i++) {
        		String query = temp.split("&")[i];
                final Map<String, String> map = Splitter.on('&').trimResults().withKeyValueSeparator('=').split(query);
                //System.out.println("map  " + map);
               
                Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator(); 
                
                while(itr.hasNext()) 
                { 
                     Map.Entry<String, String> entry = itr.next(); 
                     //System.out.println("Key = " + entry.getKey() + "\n"+ "Value = " + entry.getValue()); 
                    String key1 = entry.getKey();
                    //System.out.println(key1);
                    if(key1.contains(playlistId)) {
                    	String value1 = entry.getValue();
                    	//System.out.println(key1 +"\n" + value1);
                    	if(value1 != null) {
                    		//return true;
                    		System.out.println("playlist value is a pass   " + value1);
                    	}
                    		else {
                    			System.out.println("playlist value is a fail   " + value1);
                    		}
                    	}
                    }
                    
                    
                } }
        	catch (IllegalArgumentException e) {
        		//System.out.println(e + "\n");
        		
        	}}
	}
        	
			//return false;
   
	private static List<String> readFile(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
    }
    private static boolean termExists(String urlToTest, String line) {
        return line.lastIndexOf(urlToTest) > -1;
    }
   

}
