package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class CliffUpperRightTile extends Tile 
{
	public CliffUpperRightTile(int id) {
		super(Assets.cliffUpperRight, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}