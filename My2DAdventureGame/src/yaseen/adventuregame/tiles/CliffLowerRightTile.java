package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class CliffLowerRightTile extends Tile 
{
	public CliffLowerRightTile(int id) {
		super(Assets.cliffLowerRight, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}