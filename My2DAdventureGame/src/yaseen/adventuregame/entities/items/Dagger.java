package yaseen.adventuregame.entities.items;

import java.awt.image.BufferedImage;

import yaseen.adventuregame.Handler;
import yaseen.adventuregame.gfx.Assets;

public class Dagger extends Items
{
	//Constant for damage done
	private static final int extraDamageDagger = 1;
	
	//Constructor for item
	public Dagger(Handler handler, float x, float y)
	{
		super(handler, x, y, Assets.dagger, Assets.daggerSprite, "Dagger", extraDamageDagger);
		collisionBounds.x = 19;
		collisionBounds.width = 4;
		collisionBounds.height = 16;
		collisionBounds.y  = 23;
	}

	public void die() 
	{
		
	}

}
