package customAdsRequests;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter.MapSplitter;

class sessionStart {

	@Test
	public void test() throws IOException {
		
		//String fileName = "resources//Adstest2.csv";
		String fileName = "resources//customAds.csv";
		
		String sessionStart = "aw_0_1st.sessionstart";
		
		String urlToTest = "https://clearchannel.deliveryengine.adswizz.com/www/delivery";
		
		//String link = "www/delivery";
		List<String> lines = readFile(fileName);
		
		List<String> match = lines.stream().filter(line -> termExists(urlToTest, line)).collect(Collectors.toList());
		//match.stream().forEach(line -> System.out.println(line));
        //System.out.println(match);
        	for(String temp : match){
        	//List<String> matches1 = lines.stream().filter(line -> termExists(sessionID, line)).collect(Collectors.toList());
        	//System.out.println("session id " + matches1);
        	try {
        		for(int i = 0; i<=temp.length(); i++) {
        		String query = temp.split("&")[i];
        		//System.out.println("query  \n "+query);
                final Map<String, String> map =  Splitter.on('&').trimResults().withKeyValueSeparator('=').split(query);
                //System.out.println(map);
               
               
                Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator(); 
                
                while(itr.hasNext()) 
                { 
                     Map.Entry<String, String> entry = itr.next(); 
                     //System.out.println("Key = " + entry.getKey() + "\n" +"Value = " + entry.getValue()); 
                    String key1 = entry.getKey();
                   // System.out.println(key1);
                    if(key1.contains(sessionStart)) {
                    String value1 = entry.getValue();
                    	System.out.println(key1 + "\n" + value1);
                    	
                    	
                    	
                    
                } }}}
        	catch (Exception e) {
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
