package yaseen.adventuregame.entities.creatures;

import java.util.Random;

import yaseen.adventuregame.Handler;
import yaseen.adventuregame.gfx.Animation;
//Sub class for Creatures 
public abstract class Enemies extends Creatures
{
	//Instance variables for Enemies
	Random random = new Random();
	protected Animation animLeft;
	protected Animation animRight;
	protected Animation animDown;
	protected Animation animUp;
	protected Animation slashLeft;
	protected Animation slashRight;
	protected Animation slashDown;
	protected Animation slashUp;
	
	//Constructor for enemy type 
	public Enemies(Handler Handler, float x, float y, int width, int height) 
	{
		super(Handler, x, y, width, height);
		collisionBounds.x = 21;
		collisionBounds.y= 33;
		collisionBounds.width = 22;
		collisionBounds.height = 28;
	}

	//A die method to print that enemy was defeated 
	public void die() {
		System.out.println("Enemy defeated");
	}
}
