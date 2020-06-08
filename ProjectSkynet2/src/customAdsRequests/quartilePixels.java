package customAdsRequests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.base.Splitter;

class quartilePixels {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		
		//String fileName = "resources//voidAdstest2.csv";
		String fileName = "resources//customAds.csv";
		
		
		String url = "https://clearchannel.deliveryengine.adswizz.com/vast/2.0-c/q/50";
		
		List<String> lines = readFile(fileName);
		
		List<String> match = lines.stream().filter(line -> termExists(url, line)).collect(Collectors.toList());
		match.stream().forEach(line -> System.out.println("completion rate  " + line));
		
		
		}

	
	private static List<String> readFile(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
    }
    private static boolean termExists(String urlToTest, String line) {
        return line.lastIndexOf(urlToTest) > -1;
    }

}
