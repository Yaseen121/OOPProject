package yaseen.adventuregame.tiles;

import java.awt.image.BufferedImage;

import yaseen.adventuregame.gfx.Assets;

public class CrackedRockTile extends Tile
{

	public CrackedRockTile(int id) 
	{
		super(Assets.crackedRock, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}

}
