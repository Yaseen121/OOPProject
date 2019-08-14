package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class WaterUpperLeftTile extends Tile 
{

	public WaterUpperLeftTile(int id) {
		super(Assets.waterUpperLeft, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}