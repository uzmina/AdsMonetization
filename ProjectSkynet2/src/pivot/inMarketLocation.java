package pivot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.google.common.base.Splitter;

class inMarketLocation {

	@Test
public void test() throws IOException {
		
		String fileName = "resources//pivot-registered-zip.csv";
		
		//String key_term = "playlist.m3u8";
		String term = "lat";
		String term1 = "lon";
		
		String url = "revma.ihrhls.com";
		
		List<String> lines = readFile(fileName);
		
		List<String> match = lines.stream().filter(line -> termExists(url, line)).collect(Collectors.toList());
		//match.stream().forEach(line -> System.out.println("live  " + line));
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
                    if(key1.contains(term)) {
                    	
                    	String value1 = entry.getValue();
                    	System.out.println(value1);
                  		
                    		}
                    if(key1.contains(term1)) {
                    	
                    	String value1 = entry.getValue();
                    	System.out.println(value1);
                  		
                    		}
                    	
                        }
                    }
                    
                    
        		
        	}
        	catch (Exception e) {
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

