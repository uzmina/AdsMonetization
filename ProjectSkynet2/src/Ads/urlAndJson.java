package Ads;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.stream.JsonReader;

public class urlAndJson {
	public void urlandjsoncombined() throws IOException {

	String fileName = "resources//testads.csv";
	 
    List<String> strings = Arrays.asList("ccrpos%3D8000", "sz=320x50%7C300x250","locale=en-US");
	
	BufferedReader in = new BufferedReader(new FileReader(fileName));
    
    
    //Path pathToFile = Paths.get(fileName);
    //System.out.println(pathToFile.toAbsolutePath());
    
    
    //String term = "ccrpos%3D8000";
    //String term= "https://pubads.g.doubleclick.net/gampad/ads";
    
    List<String> term = Arrays.asList("ccrpos%3D8000", "sz=320x50%7C300x250","locale=en-US");
    
    //List<String> lines = readFile(fileName);
   
    //checking for pre-rolls
    //List<String> matches = lines.stream().filter(line -> termExists(term, line)).collect(Collectors.toList());
    //matches.stream().forEach(line -> System.out.println(line));
    
	
	long n = 0;
	final String[] streamURI = Stream.generate(() -> {
		try {
			return  in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return term;
	}).limit(n).toArray(String[]::new);
	

	
	if (streamURI.length != 0) {
		
		
	}

	
	/*JsonReader reader = new JsonReader(null);
	reader.beginObject(streamURI);
	while (reader.hasNext()) {
		String name = reader.nextName();
		if (name.equals("key")) {
			String value = reader.nextString();
		}
	}
	reader.endObject();*/

}
}
