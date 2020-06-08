package prerollSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.base.Splitter;

class completionRate {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		
		//String fileName = "resources//Adstest2.csv";
		String fileName = "resources//LiveAds.csv";
		
		String station = "hometab%3Dradio";
		String url = "https://pubads.g.doubleclick.net/pagead/conversion";
		String label = "label";
		String label1 = "videoplaytime25";
		String label2 = "videoplaytime50";
		String label3 = "videoplaytime75";
		String label4 = "videoplaytime100";
		
		List<String> lines = readFile(fileName);
		
		List<String> match = lines.stream().filter(line -> termExists(url, line)).collect(Collectors.toList());
		//match.stream().forEach(line -> System.out.println("preroll completion rate  " + line));
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
                    if(key1.contains(label)) {
                    	
                    	String value1 = entry.getValue();
                    	if(value1.contains(label1)) {
                    		System.out.println("25  "+true);
                    	}
                    	if(value1.contains(label2)) {
                    		System.out.println("50  " + true);
                    	}
                    	if(value1.contains(label3)) {
                    		System.out.println("75  " + true);
                    	}
                    	if(value1.contains(label4)) {
                    		System.out.println("100  " + true);
                    	}
                    }
                    
                    
                    
                } 
        	}}
        	catch (Exception e) {
        		//System.out.println(e + "\n");
        		
        	}}
        }
    			
    		
		}

	
	private static List<String> readFile(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
    }
    private static boolean termExists(String urlToTest, String line) {
        return line.lastIndexOf(urlToTest) > -1;
    }

}
