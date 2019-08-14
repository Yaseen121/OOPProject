package yaseen.adventuregame.entities.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import yaseen.adventuregame.Handler;
import yaseen.adventuregame.entities.Entity;

public abstract class Items extends Entity
{
	//Instance variables for items
	protected BufferedImage tileImage;
	protected BufferedImage sprite;
	protected String name;
	protected int extraDamage;
	private final static int width = 32;
	private final static int height = 32;

	//Super constructor for item which is called by all the sub classes of Item
	public Items(Handler handler, float x, float y, BufferedImage tileImage, BufferedImage sprite, String name, int extraDamage)
	{
		super(handler, x, y, width, height);
		health = 1;
		this.tileImage = tileImage;
		this.sprite = sprite;
		this.name = name;
		this.extraDamage = extraDamage;
	}

	//Tick method that needs to be in every entity 
	public void tick() 
	{

	}

	//Render method to draw the item to the screen on map
	public void render(Graphics g) 
	{
		g.drawImage(this.getTileImage(), (int)posx, (int)(posy - handler.getGameCamera().getyOffset()), 32, 64, null);
	}
	
	//Getters
	public BufferedImage getSprite() 
	{
		return sprite;
	}

	public String getName() 
	{
		return name;
	}

	public BufferedImage getTileImage() 
	{
		return tileImage;
	}
	
	public int getExtraDamage()
	{
		return extraDamage;
	}
	
}
