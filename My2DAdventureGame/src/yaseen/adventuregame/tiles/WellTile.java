package yaseen.adventuregame.tiles;

import java.awt.image.BufferedImage;

import yaseen.adventuregame.gfx.Assets;

public class WellTile extends Tile
{

	public WellTile(int id) 
	{
		super(Assets.well, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}

}
