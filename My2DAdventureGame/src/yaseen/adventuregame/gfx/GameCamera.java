package yaseen.adventuregame.gfx;

import yaseen.adventuregame.Game;
import yaseen.adventuregame.Handler;
import yaseen.adventuregame.entities.Entity;

public class GameCamera 
{	
	//Instance variables
	private Handler handler;
	private float yOffset;
	
	//Constructor 
	public GameCamera(Handler handler, float yOffset)
	{
		this.handler = handler;
		this.yOffset = yOffset;
	}

	//Sets camera movement along y axis depending on position of player
	public void moveWithPlayer(Entity player)
	{
		if (player.getPosy()>208 && player.getPosy()<610)
		{
			yOffset = player.getPosy()-handler.getHeight()/2 + player.getHeight()/2;
		}
		else 
		{
			yOffset = yOffset;
		}
	}
	
	//Activates the camera movement
	public void move(float yAmount)
	{
		yOffset =yOffset + yAmount;
	}
	
	//Getters and Setters
	public float getyOffset() 
	{
		return yOffset;
	}

	public void setyOffset(float yOffset) 
	{
		this.yOffset = yOffset;
	}
}
