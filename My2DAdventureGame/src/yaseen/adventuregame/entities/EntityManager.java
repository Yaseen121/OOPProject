package yaseen.adventuregame.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import yaseen.adventuregame.Handler;
import yaseen.adventuregame.entities.creatures.Player;
import yaseen.adventuregame.entities.items.Items;

public class EntityManager 
{
	//Instance variables
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	
	//Constructor of EntityManager, adds player to entities aray list
	public EntityManager(Handler handler, Player player)
	{
		this.handler =  handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	//Goes through all entities in the arraylist and ticks each one
	//Also checks if player collides with an item and checks if player can pick up the item
	//Also removes any entities that are dead
	public void tick()
	{
		for (int i = 0; i < entities.size(); i++)
		{
			Entity e = entities.get(i);
			e.tick();
			if (e instanceof Items && e.getCollisionBounds(0, 0).intersects(player.getItemCollisionBounds()) && handler.getKeyManager().enter)
			{
				if (handler.getPlayer().getInventory().size() < 9)
				{
					System.out.println("You have picked up " + ((Items) e).getName() + " in slot " + (handler.getPlayer().getInventory().size()+1));
					handler.getPlayer().addToInventory(e);
					entities.remove(e);
				}
				else 
				{
					System.out.println("Inventory is full");
				}
			}
			if(!e.alive)
			{
				entities.remove(e);
			}
		}
	}
	
	//Loops through entities in array list and renders them all to screen
	public void render(Graphics g)
	{
		for (int i = 0; i < entities.size(); i++)
		{
			Entity e = entities.get(i);
			e.render(g);
		}
	}
	
	//Adds an entity to the array list in entity manager
	public void addEntity(Entity e)
	{
		entities.add(e);
	}
	
	//Removes an entity from the array list in entity manager
	public void removeEntity(Entity e)
	{
		entities.remove(e);
	}

	//Getters and Setters
	public Handler getHandler() 
	{
		return handler;
	}

	public void setHandler(Handler handler)
	{
		this.handler = handler;
	}

	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer(Player player) 
	{
		this.player = player;
	}

	public ArrayList<Entity> getEntities() 
	{
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) 
	{
		this.entities = entities;
	}
}
