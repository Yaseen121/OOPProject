package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class CliffRightTile extends Tile 
{
	public CliffRightTile(int id) {
		super(Assets.cliffRight, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}