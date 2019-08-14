package yaseen.adventuregame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import yaseen.adventuregame.Handler;
import yaseen.adventuregame.gfx.Animation;
import yaseen.adventuregame.gfx.Assets;
//Enemy type Brute 
public class EnemyBrute extends Enemies
{
	//Instance variable to keep track of last animation
	private String lastAnim="Left";
	
	//Constructor for Brute
	public EnemyBrute(Handler Handler, float x, float y)
	{
		super(Handler, x, y, 64, 64);
		this.health = 200;
		this.speed = 3;
		animLeft = new Animation(100, Assets.enemyBruteWalkLeft);
		animRight = new Animation(100, Assets.enemyBruteWalkRight);
		animDown = new Animation(100, Assets.enemyBruteWalkDown);
		animUp = new Animation(100, Assets.enemyBruteWalkUp);
	}
	
	//Tick method for brute to go through all animations and generate random movement 
	public void tick() 
	{
		animLeft.tick();
		animRight.tick();
		animDown.tick();
		animUp.tick();
		//Generate random number between 0-2 (-1 to make it -1, 0, 1 for movement)
		int moveAlongX = random.nextInt(3);
		if (moveAlongX == 0)
		{
			xMove = -speed;
		}
		else if (moveAlongX == 1)
		{
			xMove = 0;
		}
		else if (moveAlongX == 2)
		{
			xMove = speed;
		}
		int moveAlongY = random.nextInt(3);
		if (moveAlongY == 0)
		{
			yMove = -speed;
		}
		else if (moveAlongY == 1)
		{
			yMove = 0;
		}
		else if (moveAlongY == 2)
		{
			yMove = speed;
		}
		move();
	}

	//Render method to draw to the screen the right frame of animation
	public void render(Graphics g) 
	{
		g.drawImage(getCurrentAnimationFrame(), (int)this.posx, (int)(this.posy - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	//Method that returns the current animation frame while assigning the last animation
	private BufferedImage getCurrentAnimationFrame()
	{	
		if (xMove == 0 && yMove ==0)
		{
			if (lastAnim.equals("Left"))
			{
				return animLeft.getFirstFrame();
			}
			else if (lastAnim.equals("Right"))
			{
				return animRight.getFirstFrame();
			}
			else if (lastAnim.equals("Down"))
			{
				return animDown.getFirstFrame();
			}
			else
			{
				return animUp.getFirstFrame();
			}
		}
		else if (xMove < 0) // Moving left
		{
			lastAnim = "Left";
			//return animLeft.getCurrentFrame();
			return animLeft.getCurrentFrame();
		}
		else if (xMove > 0) // Moving right
		{
			lastAnim = "Right";
			return animRight.getCurrentFrame();
		}
		else if (yMove > 0) // Moving down
		{
			lastAnim = "Down";
			return animDown.getCurrentFrame();
		}
		else  // Moving up
		{
			lastAnim = "Up";
			return animUp.getCurrentFrame();
		}
	}

}
