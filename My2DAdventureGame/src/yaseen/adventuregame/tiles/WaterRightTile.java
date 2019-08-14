package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class WaterRightTile extends Tile 
{

	public WaterRightTile(int id) {
		super(Assets.waterRight, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}
