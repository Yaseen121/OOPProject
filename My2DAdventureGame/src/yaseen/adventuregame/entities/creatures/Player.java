package yaseen.adventuregame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import yaseen.adventuregame.Handler;
import yaseen.adventuregame.entities.Entity;
import yaseen.adventuregame.entities.items.Items;
import yaseen.adventuregame.gfx.Animation;
import yaseen.adventuregame.gfx.Assets;

public class Player extends Creatures
{
	//Instance variables for Player including inventory, animations and collision Boundaries
	private Animation animLeft;
	private Animation animRight;
	private Animation animDown;
	private Animation animUp;
	private Animation animBasicAttackLeft;
	private Animation animBasicAttackRight;
	private Animation animBasicAttackDown;
	private Animation animBasicAttackUp;
	private Animation swordSlashLeft;
	private Animation swordSlashRight;
	private Animation swordSlashDown;
	private Animation swordSlashUp;
	private Animation daggerSlashLeft;
	private Animation daggerSlashRight;
	private Animation daggerSlashDown;
	private Animation daggerSlashUp;
	private Animation animSpecialAttackLeft;
	private Animation animSpecialAttackRight;
	private Animation animSpecialAttackDown;
	private Animation animSpecialAttackUp;
	private String lastAnim = "Down";
	private String playerType;
	private ArrayList<Items> inventory;
	private Rectangle itemCollisionBounds;
	private int inventorySelected =0;
	
	//Constructor for player sets default values
	public Player(Handler handler, float x, float y) 
	{
		super(handler, x, y, Creatures.DEFAULT_CREATURE_WIDTH, Creatures.DEFAULT_CREATURE_HEIGHT);
		inventory = new ArrayList<Items>();
		collisionBounds.x = 21;
		collisionBounds.y= 33;
		collisionBounds.width = 22;
		collisionBounds.height = 28;
		itemCollisionBounds = (new Rectangle(18, 30, 28, 34));
		animLeft = new Animation(100, Assets.knightLeft);
		animRight = new Animation(100, Assets.knightRight);
		animDown = new Animation(100, Assets.knightDown);
		animUp = new Animation(100, Assets.knightUp);
		animBasicAttackLeft = new Animation(100, Assets.knightBasicAttackLeft);
		animBasicAttackRight = new Animation(100, Assets.knightBasicAttackRight); 
		animBasicAttackDown = new Animation(100, Assets.knightBasicAttackDown);
		animBasicAttackUp = new Animation(100, Assets.knightBasicAttackUp);
		swordSlashLeft = new Animation(100, Assets.swordSlashLeft);
		swordSlashRight = new Animation(100, Assets.swordSlashRight);
		swordSlashDown = new Animation(100, Assets.swordSlashDown);
		swordSlashUp = new Animation(100, Assets.swordSlashUp);
		daggerSlashLeft = new Animation(100, Assets.daggerSlashLeft);
		daggerSlashRight = new Animation(100, Assets.daggerSlashRight);
		daggerSlashDown = new Animation(100, Assets.daggerSlashDown);
		daggerSlashUp = new Animation(100, Assets.daggerSlashUp);
		animSpecialAttackLeft  = new Animation(100, Assets.knightSpecialAttackLeft);
		animSpecialAttackRight  = new Animation(100, Assets.knightSpecialAttackRight);
		animSpecialAttackDown  = new Animation(100, Assets.knightSpecialAttackDown);
		animSpecialAttackUp  = new Animation(100, Assets.knightSpecialAttackUp);
	}

	//When player dies system prints you lost
	public void die()
	{
		System.out.println("You lost!");
	}

	//Ticks all animations
	//Checks inputs and does movement and ticks camera
	public void tick() 
	{
		animLeft.tick();
		animRight.tick();
		animDown.tick();
		animUp.tick();
		animBasicAttackLeft.tick();
		animBasicAttackRight.tick();
		animBasicAttackDown.tick();
		animBasicAttackUp.tick();
		swordSlashLeft.tick();
		swordSlashRight.tick();
		swordSlashDown.tick();
		swordSlashUp.tick();
		daggerSlashLeft.tick();
		daggerSlashRight.tick();
		daggerSlashDown.tick();
		daggerSlashUp.tick();
		animSpecialAttackLeft.tick();
		animSpecialAttackRight.tick();
		animSpecialAttackDown.tick();
		animSpecialAttackUp.tick();
		getInput();
		move();
		handler.getGameCamera().moveWithPlayer(this);
		checkAttacks();
	}
	
	//Draws the right animation or frame onto the screen at the right given time  and item
	public void render(Graphics g) 
	{
		//Cast posx and posy as they are floats and draw image takes ints
		
		g.drawImage(getCurrentAnimationFrame(), (int)posx, (int)(posy - handler.getGameCamera().getyOffset()), width, height, null);
		if (inventorySelected !=0 && inventory.size() >= inventorySelected   && !(handler.getKeyManager().specailAttack))
		{
			if (inventory.get(inventorySelected-1).getName().equals("Sword"))
			{
				if (handler.getKeyManager().basicAttackLeft)
				{
					g.drawImage(swordSlashLeft.getCurrentFrame(), (int)posx, (int)(posy - handler.getGameCamera().getyOffset()), width, height, null);
				}
				else if (handler.getKeyManager().basicAttackRight)
				{
					g.drawImage(swordSlashRight.getCurrentFrame(), (int)posx, (int)(posy - handler.getGameCamera().getyOffset()), width, height, null);
				}
				else if (handler.getKeyManager().basicAttackDown)
				{
					g.drawImage(swordSlashDown.getCurrentFrame(), (int)posx, (int)(posy - handler.getGameCamera().getyOffset()), width, height, null);
				}
				else if (handler.getKeyManager().basicAttackUp)
				{
					g.drawImage(swordSlashUp.getCurrentFrame(), (int)posx, (int)(posy - handler.getGameCamera().getyOffset()), width, height, null);
				}
			}
			else if (inventory.get(inventorySelected-1).getName().equals("Dagger"))
			{
				if (handler.getKeyManager().basicAttackLeft)
				{
					g.drawImage(daggerSlashLeft.getCurrentFrame(), (int)posx, (int)(posy - handler.getGameCamera().getyOffset()), width, height, null);
				}
				else if (handler.getKeyManager().basicAttackRight)
				{
					g.drawImage(daggerSlashRight.getCurrentFrame(), (int)posx, (int)(posy - handler.getGameCamera().getyOffset()), width, height, null);
				}
				else if (handler.getKeyManager().basicAttackDown)
				{
					g.drawImage(daggerSlashDown.getCurrentFrame(), (int)posx, (int)(posy - handler.getGameCamera().getyOffset()), width, height, null);
				}
				else if (handler.getKeyManager().basicAttackUp)
				{
					g.drawImage(daggerSlashUp.getCurrentFrame(), (int)posx, (int)(posy - handler.getGameCamera().getyOffset()), width, height, null);
				}
			}
			
		}
		//Checking item collision bounds
		//g.setColor(Color.red);
		//g.fillRect((int)posx+itemCollisionBounds.x, (int) ((int)posy - handler.getGameCamera().getyOffset()+itemCollisionBounds.y), itemCollisionBounds.width, itemCollisionBounds.height);
		//g.drawRect((int)posx+itemCollisionBounds.x, (int) ((int)posy - handler.getGameCamera().getyOffset()+itemCollisionBounds.y), itemCollisionBounds.width, itemCollisionBounds.height);
	}
	
	
	//Method to check what direction and what type attack is done and sets range of attack accordingly
	private void checkAttacks() 
	{
		Rectangle collisionBounds = getCollisionBounds(0, 0);
		Rectangle attackRange = new Rectangle();
		int range = this.getRange();
		attackRange.width = range;
		attackRange.height = range;
		
		//Centering attack range with collision bounds
		if(handler.getKeyManager().basicAttackUp)
		{
			attackRange.x = collisionBounds.x + collisionBounds.width/2 - range/2;
			attackRange.y = collisionBounds.y - range;
		}
		else if(handler.getKeyManager().basicAttackDown)
		{
			attackRange.x = collisionBounds.x + collisionBounds.width/2 - range/2;
			attackRange.y = collisionBounds.y + collisionBounds.height;
		}
		else if(handler.getKeyManager().basicAttackLeft)
		{
			attackRange.x = collisionBounds.x - range;
			attackRange.y = collisionBounds.y + collisionBounds.height/2 - range/2;
		}
		else if(handler.getKeyManager().basicAttackRight)
		{
			attackRange.x = collisionBounds.x + collisionBounds.width;
			attackRange.y = collisionBounds.y + collisionBounds.height/2 - range/2;
		}
		else 
		{
			return;
		}
		
		//Check if any entity in attack range
		for (Entity e: handler.getWorld().getEntityManager().getEntities()) 
		{
			if(e.equals(this))
			{
				continue;
			}
			if(!(e instanceof Items) && e.getCollisionBounds(0,0).intersects(attackRange))
			{
				if (handler.getKeyManager().specailAttack)
				{
					e.hurt(this.attack * 2);
				}
				else if (inventorySelected !=0 && inventory.size() >= inventorySelected   && !(handler.getKeyManager().specailAttack))
				{
					e.hurt(this.attack + inventory.get(inventorySelected-1).getExtraDamage());
				}
				else
				{
					e.hurt(this.attack);
				}
				return;
			}
		}
	}
	
	//Adds item to inventory and checks if inventory full and prints item was added
	public void addToInventory(Entity e) 
	{
		if(inventory.size() < 9)
		{
			inventory.add((Items) e);
			System.out.println(((Items) e).getName() + " added to inventory");
		}
		else
		{
			System.out.println("Inventory is full");
		}
	}

	//Gets input
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		//The speed defines how many pixels player would move per button press
		if(handler.getKeyManager().up)
		{
			yMove = - speed;
		}
		if(handler.getKeyManager().down)
		{
			yMove = speed;
		}
		if(handler.getKeyManager().left)
		{
			xMove = -speed;
		}
		if(handler.getKeyManager().right)
		{
			xMove = speed;
		}
		if(handler.getKeyManager().one)
		{
			inventorySelected =1;
		}
		else if(handler.getKeyManager().two)
		{
			inventorySelected =2;
		}
		else if(handler.getKeyManager().three)
		{
			inventorySelected =3;
		}
		else if(handler.getKeyManager().four)
		{
			inventorySelected =4;
		}
		else if(handler.getKeyManager().five)
		{
			inventorySelected =5;
		}
		else if(handler.getKeyManager().six)
		{
			inventorySelected =6;
		}
		else if(handler.getKeyManager().seven)
		{
			inventorySelected =7;
		}
		else if(handler.getKeyManager().eight)
		{
			inventorySelected =8;
		}
		else if(handler.getKeyManager().nine)
		{
			inventorySelected =9;
		}
		else if(handler.getKeyManager().zero)
		{
			inventorySelected =0;
		}
	}

	//Getters and Setters
	public int getInventorySelected() {
		return inventorySelected;
	}
	
	private BufferedImage getCurrentAnimationFrame()
	{	
		if (handler.getKeyManager().basicAttackLeft && handler.getKeyManager().specailAttack)
		{
			lastAnim = "Left";
			return animSpecialAttackLeft.getCurrentFrame();
		}
		else if (handler.getKeyManager().basicAttackRight && handler.getKeyManager().specailAttack)
		{
			lastAnim = "Right";
			return animSpecialAttackRight.getCurrentFrame();
		}
		else if (handler.getKeyManager().basicAttackDown && handler.getKeyManager().specailAttack)
		{
			lastAnim = "Down";
			return animSpecialAttackDown.getCurrentFrame();
		}
		else if (handler.getKeyManager().basicAttackUp && handler.getKeyManager().specailAttack)
		{
			lastAnim = "Up";
			return animSpecialAttackUp.getCurrentFrame();
		}
		else if (handler.getKeyManager().basicAttackLeft)
		{
			lastAnim = "Left";
			return animBasicAttackLeft.getCurrentFrame();
		}
		else if (handler.getKeyManager().basicAttackRight)
		{
			lastAnim = "Right";
			return animBasicAttackRight.getCurrentFrame();
		}
		else if (handler.getKeyManager().basicAttackDown)
		{
			lastAnim = "Down";
			return animBasicAttackDown.getCurrentFrame();
		}
		else if (handler.getKeyManager().basicAttackUp)
		{
			lastAnim = "Up";
			return animBasicAttackUp.getCurrentFrame();
		}
	
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
	
	//Takes playerType string and sets animations accordingly 
	public void setPlayerAnim(String playerType)
	{
		//100 is speed in milliseconds between animations
		if (playerType.equals("Knight"))
		{
			animLeft = new Animation(100, Assets.knightLeft);
			//animLeft = new Animation(100, Assets.knightBasicAttackLeft);
			animRight = new Animation(100, Assets.knightRight);
			animDown = new Animation(100, Assets.knightDown);
			animUp = new Animation(100, Assets.knightUp);
			animBasicAttackLeft = new Animation(100, Assets.knightBasicAttackLeft);
			animBasicAttackRight = new Animation(100, Assets.knightBasicAttackRight); 
			animBasicAttackDown = new Animation(100, Assets.knightBasicAttackDown);
			animBasicAttackUp = new Animation(100, Assets.knightBasicAttackUp);
			animSpecialAttackLeft  = new Animation(100, Assets.knightSpecialAttackLeft);
			animSpecialAttackRight  = new Animation(100, Assets.knightSpecialAttackRight);
			animSpecialAttackDown  = new Animation(100, Assets.knightSpecialAttackDown);
			animSpecialAttackUp  = new Animation(100, Assets.knightSpecialAttackUp);
		}
		else
		{
			animLeft = new Animation(100, Assets.mageLeft);
			animRight = new Animation(100, Assets.mageRight);
			animDown = new Animation(100, Assets.mageDown);
			animUp = new Animation(100, Assets.mageUp);
			animBasicAttackLeft = new Animation(100, Assets.mageBasicAttackLeft);
			animBasicAttackRight = new Animation(100, Assets.mageBasicAttackRight); 
			animBasicAttackDown = new Animation(100, Assets.mageBasicAttackDown);
			animBasicAttackUp = new Animation(100, Assets.mageBasicAttackUp);
			animSpecialAttackLeft  = new Animation(100, Assets.mageSpecialAttackLeft);
			animSpecialAttackRight  = new Animation(100, Assets.mageSpecialAttackRight);
			animSpecialAttackDown  = new Animation(100, Assets.mageSpecialAttackDown);
			animSpecialAttackUp  = new Animation(100, Assets.mageSpecialAttackUp);
		}
	}

	public Rectangle getItemCollisionBounds()
	{
		return new Rectangle ((int)(posx + itemCollisionBounds.x), (int)(posy + itemCollisionBounds.y), itemCollisionBounds.width, itemCollisionBounds.height);
	}	

	public ArrayList<Items> getInventory() {
		return inventory;
	}
	
	//Returns the x position for the item number given to draw to inventory bar
	private int getInvertoryOnex (int itemNumber)
	{
		if (itemNumber==1)
		{
			return 230;
		}
		else if (itemNumber==2)
		{
			return 268;
		}
		else if (itemNumber==3)
		{
			return 306;
		}
		else if (itemNumber==4)
		{
			return 344;
		}
		else if (itemNumber==5)
		{
			return 382;
		}
		else if (itemNumber==6)
		{
			return 420;
		}
		else if (itemNumber==7)
		{
			return 458;
		}
		else if (itemNumber==8)
		{
			return 496;
		}
		else
		{
			return 534;
		}
	}
}
