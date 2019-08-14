package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class WaterLowerRightTile extends Tile 
{

	public WaterLowerRightTile(int id) {
		super(Assets.waterLowerRight, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}
