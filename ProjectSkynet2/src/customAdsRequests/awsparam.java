package customAdsRequests;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.google.common.base.Splitter;

class awsparam {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() throws IOException {
		
		String fileName = "resources//customAds.csv";
		
		String key_term = "awParams";
		String term = "companionAds:true";
		
		String url = "https://clearchannel.deliveryengine.adswizz.com/www/delivery";
		
		List<String> lines = readFile(fileName);
		
		List<String> match = lines.stream().filter(line -> termExists(url, line)).collect(Collectors.toList());
       
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
                    	//System.out.println(value1);
                    	String[] tokens = value1.split(";");
                    	for (String t : tokens)
                    	  System.out.println("value of custparam   "+ t);
                    	
                    	for(int j = 0; j < tokens.length; j++) {
                    		if(tokens[j].equals(term)) {
                    			System.out.println(tokens[j]);
                    			
                    			
                    			
                    		}
                    	
                        }
                    }
                    
                    
        		}
        	}}
        	catch (IllegalArgumentException e) {
        		//System.out.println(e + "\n");
        		
        	}}
        }
	}
        	
			//return false;
        	
   
	private static List<String> readFile(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
    }
    private static boolean termExists(String urlToTest, String line) {
        return line.lastIndexOf(urlToTest) > -1;
    }
   

}
