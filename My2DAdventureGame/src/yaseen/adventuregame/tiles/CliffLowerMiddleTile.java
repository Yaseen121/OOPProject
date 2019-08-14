package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class CliffLowerMiddleTile extends Tile 
{
	public CliffLowerMiddleTile(int id) {
		super(Assets.cliffLowerMiddle, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}