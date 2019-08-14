package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class CliffUpperLeftTile extends Tile 
{
	public CliffUpperLeftTile(int id) {
		super(Assets.cliffUpperLeft, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}