package Ads;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.junit.jupiter.api.Test;

public class ParsingURI  {
	@Test
	public void parseingURI() throws URISyntaxException{
	String url = "resources//testdata.csv";

	List<NameValuePair> params = URLEncodedUtils.parse(new URI(url), Charset.forName("UTF-8"));
	{
		System.out.println("step1");
	for (NameValuePair param : params) {
		System.out.println("step2");
	  System.out.println(param.getName() + " : " + param.getValue());
	}
	System.out.println("step3");
}
}}