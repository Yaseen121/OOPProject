package yaseen.adventuregame.gfx;

import java.awt.image.BufferedImage;

import yaseen.adventuregame.entities.items.Items;

public class Animation 
{
	//Instance variables for Animation objects
	private int speed;
	private int animationFramePos;
	private BufferedImage[] animationFrames;
	private long timePassed;
	private long timer;
	
	//Constructor 
	public Animation(int speed, BufferedImage[] animationFrames)
	{
		this.speed = speed;
		this.animationFrames = animationFrames;
		timePassed = System.currentTimeMillis();
	}
	
	//Ticks the animations every something milliseconds (number of seconds defined by speed of animations)
	public void tick()
	{
		timer = timer + System.currentTimeMillis() - timePassed;
		timePassed = System.currentTimeMillis();
		
		if (timer > speed)
		{
			animationFramePos++;
			timer = 0;
			if (animationFramePos > animationFrames.length - 1)
			{
				animationFramePos = 0;
			}
		}
	}
	
	//Getters
	public BufferedImage getCurrentFrame()
	{
		return animationFrames[animationFramePos];
	}
	
	public BufferedImage getFirstFrame()
	{
		return animationFrames[0];
	}
}
