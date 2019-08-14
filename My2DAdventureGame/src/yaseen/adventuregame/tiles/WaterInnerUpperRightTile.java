package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class WaterInnerUpperRightTile extends Tile 
{

	public WaterInnerUpperRightTile(int id) {
		super(Assets.waterInnerUpperRight, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}
