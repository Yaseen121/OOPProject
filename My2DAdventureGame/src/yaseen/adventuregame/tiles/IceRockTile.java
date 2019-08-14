package yaseen.adventuregame.tiles;

import java.awt.image.BufferedImage;

import yaseen.adventuregame.gfx.Assets;

public class IceRockTile extends Tile
{
	
	
	public IceRockTile(int id) {
		super(Assets.iceRock, id);
	}

	public boolean isSolidBlock()
	{
		return true;
	}
}
