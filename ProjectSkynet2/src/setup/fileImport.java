package setup;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;



class fileImport{
	public void test() throws IOException{
	String fileName = "resources//testads.csv";
	List<String> lines = readFile(fileName);

	}
private static List<String> readFile(String fileName) throws IOException {
    return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
}
@SuppressWarnings("unused")
private static boolean termExists(String urlToTest, String line) {
    return line.lastIndexOf(urlToTest) > -1;
}
}