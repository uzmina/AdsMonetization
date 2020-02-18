package Ads;

import java.net.*;
import java.io.*;

/**
 *
 * A complete Java class that shows how to open a URL, then read data (text) from that URL,
 * just using the URL class, in combination with an InputStreamReader and BufferedReader.
 *
 * 
 *
 */
public class UrlReader
{
  public static void main(String[] args) throws Exception
  {
    String urlString = "http://www.iheart.com";
    
    // create the url
    URL url = new URL(urlString);
    
    // open the url stream, wrap it an a few "readers"
    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

    // write the output to stdout
    String line;
    while ((line = reader.readLine()) != null)
    {
      System.out.println(line);
    }

    // close our reader
    reader.close();
  }
}