package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class WaterLowerLeftTile extends Tile 
{

	public WaterLowerLeftTile(int id) {
		super(Assets.waterLowerLeft, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}
