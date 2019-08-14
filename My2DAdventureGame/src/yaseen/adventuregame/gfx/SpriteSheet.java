package yaseen.adventuregame.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet 
{
	//Instance variable
	private BufferedImage sheet;
	
	
	//Loads sprite sheet into object (Constructor)
	public SpriteSheet(BufferedImage sheet)
	{
		this.sheet = sheet;
	}
	
	//Returns a crop part of the sprite sheet
	public BufferedImage crop(int x, int y, int width, int height)
	{
		return sheet.getSubimage(x, y, width, height);
	}
}
