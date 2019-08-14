package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class WaterInnerLowerLeftTile extends Tile 
{

	public WaterInnerLowerLeftTile(int id) {
		super(Assets.waterInnerLowerLeft, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}
