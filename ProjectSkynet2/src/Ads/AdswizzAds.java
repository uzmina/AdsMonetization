package Ads;

//import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class AdswizzAds {
	String fileName = "resources//testdata.csv";
	String term3 = "reporting";
	//List<String> strings = Arrays.asList("song_spot", "adID","spotInstanceId");
	String adID;
	String songSpot = "\"song_spot\": \"T\""; 
	String actualss;
	String urlToTest = "https://us.api.iheart.com/api/v3/playback/liveStation/reporting";
	@Test
	public void Adswizz() throws IOException {
		
		List<String> lines = readFile(fileName);
    	List<String> matches = lines.stream().filter(line -> termExists(urlToTest, line)).collect(Collectors.toList());
      
    	matches.stream().forEach(line -> System.out.println(line));
        if (matches.size() != 0) {
        	
        	
            
        	//List<String> matches1 = lines.stream().filter(line -> termExists(adID, line)).collect(Collectors.toList());
            //matches1.stream().forEach(line -> System.out.println(line));
      	   
            
      		   assertTrue(matches.contains(songSpot));
      	   
        } 
        		//return true;
        }
		
		
	
	
	private static List<String> readFile(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
    }
    private static boolean termExists(String term, String line) {
        return line.lastIndexOf(term) > -1;
    }

}
