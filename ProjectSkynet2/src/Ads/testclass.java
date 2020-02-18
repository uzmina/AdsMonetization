package Ads;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import java.util.Map;
import com.google.common.base.Splitter;
public class testclass {
	
	
	
	public static void main (String[] args) throws IOException {
		String filename = "resources//testdata.csv";
		String term2 = "ccrpos%3D8000";
		List<String> lines = readFile(filename);
		char[] arr = new char[50];
		int offset=0;
	    int len=37;
	    String[]  ar1 = new String[50];
		
		List<String> matches2 = lines.stream().filter(line -> termExists(term2, line)).collect(Collectors.toList());
        matches2.stream().forEach(line -> System.out.println(line));
        
        FileReader file=new FileReader(filename);
        BufferedReader reader= new BufferedReader(file);
        
        reader.read(arr,offset,len);
        reader.readLine();

        //print the array
        for(char c: arr)
          System.out.print(c);
        
        for(String str: ar1) System.out.println(str);

		//String uri = "matches2";
        //String query = uri.split("\\?")[0];
        //final Map<String, String> map = Splitter.on('&').trimResults().withKeyValueSeparator('=').split(query);
        //System.out.println(map);
}
	private static List<String> readFile(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
    }
    private static boolean termExists(String term, String line) {
        return line.lastIndexOf(term) > -1;
    }
    
}