package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class WaterUpperRightTile extends Tile 
{

	public WaterUpperRightTile(int id) {
		super(Assets.waterUpperRight, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}

