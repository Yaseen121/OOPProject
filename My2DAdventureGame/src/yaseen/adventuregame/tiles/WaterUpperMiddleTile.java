package yaseen.adventuregame.tiles;

import yaseen.adventuregame.gfx.Assets;

public class WaterUpperMiddleTile extends Tile 
{

	public WaterUpperMiddleTile(int id) {
		super(Assets.waterUpperMiddle, id);
	}
	
	public boolean isSolidBlock()
	{
		return true;
	}
}


