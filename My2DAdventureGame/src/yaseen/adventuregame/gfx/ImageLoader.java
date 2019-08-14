package yaseen.adventuregame.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//Class that loads images
public class ImageLoader 
{
	//Buffered Image stores images
	public static BufferedImage loadImage(String path)
	{
		try {
			//Returns the buffered image 
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			//Exits game if image not loaded
			System.exit(1);
		}
		return null;
	}
}
