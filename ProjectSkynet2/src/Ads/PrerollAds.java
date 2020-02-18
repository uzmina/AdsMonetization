package Ads;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

//import org.testng.annotations.Test;
public class PrerollAds {
	
	
	@Test
	 public void preroll() throws Exception {
	        String fileName = "resources//testdata.csv";
	        BufferedReader in = new BufferedReader(new FileReader(fileName));
	        
	        
	        Path pathToFile = Paths.get(fileName);
	        System.out.println(pathToFile.toAbsolutePath());
	        
	        
	        String term = "ccrpos%3D8000";
	        List<String> strings = Arrays.asList("ccrpos%3D8000", "sz=320x50%7C300x250");
	        
	        List<String> lines = readFile(fileName);
	       
	        //checking for pre-rolls
	        List<String> matches2 = lines.stream().filter(line -> termExists(term, line)).collect(Collectors.toList());
	        matches2.stream().forEach(line -> System.out.println(line));
	        
	        
	       if (matches2.size() != 0) {
	        	
	        	
	        	//assertTrue(matches2.contains(term));
	    	   List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

	        	if(filtered.size() != 0) {
	        		
	        		
	        		assertArrayEquals(strings,filtered);
	        		System.out.println("Filtered List: " + filtered);
	        	}
	            
	       }
	        
	      
	 }
	    private void assertArrayEquals(List<String> strings, List<String> filtered) {
		// TODO Auto-generated method stub
		
	}
		private static List<String> readFile(String fileName) throws IOException {
	        return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
	    }
	    private static boolean termExists(String term, String line) {
	        return line.lastIndexOf(term) > -1;
	    }
	    
	}

