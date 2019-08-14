package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class CliffLeftTile extends Tile 
{
	public CliffLeftTile(int id) {
		super(Assets.cliffLeft, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}
