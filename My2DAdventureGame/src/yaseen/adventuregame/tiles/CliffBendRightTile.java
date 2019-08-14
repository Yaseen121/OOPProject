package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class CliffBendRightTile extends Tile 
{
	public CliffBendRightTile(int id) {
		super(Assets.cliffBendRight, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}