package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class WaterLowerMiddleTile extends Tile 
{

	public WaterLowerMiddleTile(int id) {
		super(Assets.waterLowerMiddle, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}
