package yaseen.adventuregame.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils 
{
	public static String loadFileAsString(String path) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String testLine = "";
		String loadedText = "";
		while ((testLine = reader.readLine()) != null)
		{
			loadedText = loadedText +testLine + "\n";
		}
		reader.close();
		return loadedText;
	}
	
	public static int parseInt(String number)
	{
		return Integer.parseInt(number);
	}
	
}
