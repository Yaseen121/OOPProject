package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class CliffBendLeftTile extends Tile 
{
	public CliffBendLeftTile(int id) {
		super(Assets.cliffBendLeft, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}