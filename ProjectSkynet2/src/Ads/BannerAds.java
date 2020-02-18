package Ads;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
public class BannerAds {

	
	String fileName = "resources//testdata.csv";
	
	String term3 = "ccrpos%3D8004";
    String sz1 = "sz=320x50%7C300x50";
    List<String> strings = Arrays.asList("ccrpos%3D8004", "sz=320x50%7C300x50");
   @Test
    public void banner() throws IOException{
    	List<String> lines = readFile(fileName);
    	List<String> matches3 = lines.stream().filter(line -> termExists(term3, line)).collect(Collectors.toList());
        matches3.stream().forEach(line -> System.out.println(line));
        if (matches3.size() != 0) {
            // This means the match was not found
        	//System.out.println("8004 Ad call not made");
        //} else {
            
        	//assertTrue(matches3.contains(term3));
        	//System.out.println("8004 ad call made");
        	List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        	if(filtered.size() != 0) {
        		
        		
        		assertArrayEquals(strings,filtered);
        		System.out.println("Filtered List: " + filtered);
        	}
        		//return true;
       }
   }
	
    
    private void assertArrayEquals(List<String> strings2, List<String> filtered) {
	// TODO Auto-generated method stub
	
}


	private static List<String> readFile(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
    }
    private static boolean termExists(String term, String line) {
        return line.lastIndexOf(term) > -1;
    }
}
