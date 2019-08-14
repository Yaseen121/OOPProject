package yaseen.adventuregame.tiles;

import java.awt.image.BufferedImage;

import yaseen.adventuregame.gfx.Assets;

public class WaterTile extends Tile 
{
	public WaterTile(int id) {
		super(Assets.water, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}
