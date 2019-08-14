package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class CliffTile extends Tile 
{
	public CliffTile(int id) {
		super(Assets.cliff, id);
	}
	
	public boolean isSolidBlock()
	{
		return false;
	}
}