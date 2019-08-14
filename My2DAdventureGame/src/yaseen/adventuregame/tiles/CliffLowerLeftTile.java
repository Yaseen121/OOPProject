package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class CliffLowerLeftTile extends Tile 
{
	public CliffLowerLeftTile(int id) {
		super(Assets.cliffLowerLeft, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}