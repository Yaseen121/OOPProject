package yaseen.adventuregame.tiles;

import java.awt.image.BufferedImage;

import yaseen.adventuregame.gfx.Assets;

public class SmallRockTile extends Tile
{

	public SmallRockTile(int id) 
	{
		super(Assets.smallRock, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}
