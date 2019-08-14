package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class WaterLeftTile extends Tile 
{

	public WaterLeftTile(int id) {
		super(Assets.waterLeft, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}
