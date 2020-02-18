package Ads;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;


public class SplashAds {
String fileName = "resources//testdata.csv";
	
	String term = "ccrpos%3D8009";
    //String sz1 = "sz=320x50%7C300x50";
	
   @Test
    public void splash() throws IOException{
    	List<String> lines = readFile(fileName);
    	List<String> matches = lines.stream().filter(line -> termExists(term, line)).collect(Collectors.toList());
        matches.stream().forEach(line -> System.out.println(line));
        if (matches.size() != 0) {
        	
        	assertTrue(matches.contains(term));
        
        }
   }
	
    
    private static List<String> readFile(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
    }
    private static boolean termExists(String term, String line) {
        return line.lastIndexOf(term) > -1;
    }
}
