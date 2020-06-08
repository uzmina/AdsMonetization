package Ads;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class CustomAdRequest {

	@Test
	public void test() throws IOException {
		
		String fileName = "resources//testdata.csv";
		List<String> strings = Arrays.asList("awParams","aw_0_1st.sessionid","aw_0_1st.sessionstart","aw_0_1st.playlistid","aw_0_1st.playlisttype","aw_0_1st.ihmgenre");
		String urlToTest = "https://clearchannel.deliveryengine.adswizz.com";
		
		List<String> lines = readFile(fileName);
		
		List<String> matches = lines.stream().filter(line -> termExists(urlToTest, line)).collect(Collectors.toList());
        matches.stream().forEach(line -> System.out.println(line));
        
        if(matches.size() == 0) {
        	System.out.println("Custom Ad request not made");
        }
        else {
        	//List<String> matches1 = lines.stream().filter(line -> termExists(strings, line)).collect(Collectors.toList());
        	List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        	if(filtered.size() != 0) {
        		
        		assertArrayEquals(strings,filtered);
        		System.out.println("Filtered List: " + filtered);
        		//return true;
        	}
        }
        
		
	}

	private void assertArrayEquals(List<String> strings, List<String> filtered) {
		
		
	}

	private static List<String> readFile(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
    }
    private static boolean termExists(String urlToTest, String line) {
        return line.lastIndexOf(urlToTest) > -1;
    }

}