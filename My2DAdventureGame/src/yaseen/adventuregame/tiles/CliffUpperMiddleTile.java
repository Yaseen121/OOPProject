package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class CliffUpperMiddleTile extends Tile 
{
	public CliffUpperMiddleTile(int id) {
		super(Assets.cliffUpperMiddle, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}