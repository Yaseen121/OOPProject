package yaseen.adventuregame.entities.creatures;

import yaseen.adventuregame.Game;
import yaseen.adventuregame.Handler;
import yaseen.adventuregame.entities.Entity;
import yaseen.adventuregame.tiles.Tile;
//Sub type of entity called Creates
public abstract class Creatures extends Entity
{
	//Constants/Default values
	public static final float DEFAULT_SPEED = 3f;
	public static final int DEFAULT_RANGE = 5;
	public static final int DEFAULT_ATTACK = 5;
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;
	
	//Instance variables
	protected float speed;
	protected int range;
	protected int attack;
	protected float xMove;
	protected float yMove;

	//Constructor for Creatures (has call to super constructor in entity)
	public Creatures(Handler Handler, float x, float y, int width, int height) 
	{
		super(Handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		range = DEFAULT_RANGE;
		attack = DEFAULT_ATTACK;
		xMove = 0;
		yMove = 0;
	}
	
	//Move method checks if entity will collide with something, 
	//If it will not collide, then it can move
	public void move()
	{
		//Checks collisions against where the creature will move
		if (!checkEntityCollisions(xMove, 0f))
		{
			moveX();
		}
		if (!checkEntityCollisions(0f, yMove))
		{
			moveY();
		};
	}

	//Checks if tile that entity is trying to move to is solid or not and if not then it will move on X axis
	public void moveX()
	{
		if(xMove > 0)
		{//Moving right
			int tileMovingTox = (int) (posx + xMove + collisionBounds.x + collisionBounds.width) / Tile.TILEWIDTH;
			if(!collisionWithTile(tileMovingTox, (int) (posy + collisionBounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tileMovingTox, (int) (posy + collisionBounds.y + collisionBounds.height) / Tile.TILEHEIGHT))
			{
				posx += xMove;
			}
			else
			{
				posx = tileMovingTox * Tile.TILEWIDTH - collisionBounds.x - collisionBounds.width -2;
			}
		}
		else if(xMove < 0)
		{//Moving left
			int tileMovingTox = (int) (posx + xMove + collisionBounds.x) / Tile.TILEWIDTH;
			if(!collisionWithTile(tileMovingTox, (int) (posy + collisionBounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tileMovingTox, (int) (posy + collisionBounds.y + collisionBounds.height) / Tile.TILEHEIGHT))
			{
				posx += xMove;
			}
			else
			{
				posx = tileMovingTox * Tile.TILEWIDTH - collisionBounds.x + Tile.TILEWIDTH;
			}
		}
	}
	
	//Checks if tile that entity is trying to move to is solid or not and if not then it will move on Y axis
	public void moveY()
	{
		if(yMove > 0) 
		{//Moving down
			int tileMovingToy = (int) (posy + yMove + collisionBounds.y + collisionBounds.height) / Tile.TILEHEIGHT;
			if ((!collisionWithTile((int)(posx + collisionBounds.x)/Tile.TILEWIDTH, tileMovingToy)) && 
					(!collisionWithTile((int)(posx + collisionBounds.x + collisionBounds.x)/Tile.TILEWIDTH, tileMovingToy)))
			{
				posy += yMove;
			}
			else
			{
				posy = tileMovingToy * Tile.TILEHEIGHT - collisionBounds.y - collisionBounds.height -1;
			}
		}
		else if (yMove < 0)
		{//Moving up
			int tileMovingToy = (int) (posy + yMove + collisionBounds.y) / Tile.TILEWIDTH;
			if ((!collisionWithTile((int)(posx + collisionBounds.x)/Tile.TILEWIDTH, tileMovingToy)) && 
					(!collisionWithTile((int)(posx + collisionBounds.x + collisionBounds.x)/Tile.TILEWIDTH, tileMovingToy)))
			{
				posy += yMove;
			}
			else
			{
				posy = tileMovingToy * Tile.TILEHEIGHT - collisionBounds.y + Tile.TILEHEIGHT + 1;
			}
		}
	}
	
	//Method that returns if a tile in a certain position is solid or not
	protected boolean collisionWithTile(int x, int y)
	{
		return handler.getWorld().getMainTile(x, y).isSolidBlock();
	}
	
	//Getters and Setters
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
}
