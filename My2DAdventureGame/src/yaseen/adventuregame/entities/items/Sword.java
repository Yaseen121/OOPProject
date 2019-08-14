package yaseen.adventuregame.entities.items;

import java.awt.image.BufferedImage;

import yaseen.adventuregame.Handler;
import yaseen.adventuregame.gfx.Assets;

public class Sword extends Items
{
	//Constant for damage done
	private static final int extraDamageSword = 1;
	
	//Constructor for item
	public Sword(Handler handler, float x, float y)
	{
		super(handler, x, y, Assets.sword, Assets.swordSprite, "Sword", extraDamageSword);
		collisionBounds.x = 19;
		collisionBounds.width = 6;
		collisionBounds.height = 27;
		collisionBounds.y  = 16;
	}

	public void die()
	{
		
	}

}
