package yaseen.adventuregame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import yaseen.adventuregame.Game;
import yaseen.adventuregame.Handler;

public abstract class Entity 
{
	//Instance varaiables for object of type entity
	protected Handler handler;
	protected float posx;
	protected float posy;
	protected int width;
	protected int height;
	protected int health;
	public static final int DEFAULT_HEALTH = 10;
	protected Rectangle collisionBounds;
	protected boolean alive = true;
	
	//Constructor for type entity 
	public Entity(Handler handler, float x, float y, int width, int height)
	{
		this.handler = handler;
		health = DEFAULT_HEALTH;
		this.posx = x;
		this.posy = y;
		this.width = width;
		this.height = height;
		collisionBounds = new Rectangle(0, 0, width, height);
	}
		
	//Method that reduces health of entity when called on and sets alive to false and calls die if
	//Health reaches 0
	public void hurt(int amount)
	{
		health = health - amount;
		if (health <= 0)
		{
			alive = false;
			die();
		}
	}

	//Method that checks if the entity is collidiing with antoher entity 
	public boolean checkEntityCollisions(float xMove, float f)
	{
		//Enhanced for loop for all the entities in EntityManager
		for (Entity e: handler.getWorld().getEntityManager().getEntities())
		{
			if(e.equals(this))
			{
				//Skip if checking against itself
				continue;
			}
			//0f--> 0float
			if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xMove, f)))
			{
				return true;
			}
		}
		return false;
	}
	
	//Method that returns a rectangle around the collision bounds of the entity 
	public Rectangle getCollisionBounds(float xOffset, float yOffset)
	{
		return new Rectangle ((int)(posx + collisionBounds.x + xOffset), (int)(posy + collisionBounds.y + yOffset), collisionBounds.width, collisionBounds.height);
	}
	
	//Abstract methods tick and render so all objects of type entity implement a tick and render and die
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void die();
	
	//Getters and Setters
	public float getPosx() 
	{
		return posx;
	}

	public void setPosx(float posx) 
	{
		this.posx = posx;
	}

	public float getPosy() 
	{
		return posy;
	}

	public void setPosy(float posy) 
	{
		this.posy = posy;
	}

	public int getWidth() 
	{
		return width;
	}

	public void setWidth(int width) 
	{
		this.width = width;
	}

	public int getHeight() 
	{
		return height;
	}

	public void setHeight(int height) 
	{
		this.height = height;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
