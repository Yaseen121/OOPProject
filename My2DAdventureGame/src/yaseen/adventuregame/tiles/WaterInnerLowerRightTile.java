package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class WaterInnerLowerRightTile extends Tile 
{

	public WaterInnerLowerRightTile(int id) {
		super(Assets.waterInnerLowerRight, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}
