package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class WaterInnerUpperLeftTile extends Tile 
{

	public WaterInnerUpperLeftTile(int id) {
		super(Assets.waterInnerUpperLeft, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}
