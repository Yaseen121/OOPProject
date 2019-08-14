package yaseen.adventuregame.worlds;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils 
{
	//Method that will take a path and read all the text inside to string which it will then return
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
	
	//Method that converts string to int
	public static int parseInt(String number)
	{
		return Integer.parseInt(number);
	}
	
}
