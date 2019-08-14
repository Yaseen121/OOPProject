package yaseen.adventuregame.states;

import java.awt.Graphics;
import java.io.IOException;

import yaseen.adventuregame.Game;
import yaseen.adventuregame.Handler;
import yaseen.adventuregame.entities.Entity;
import yaseen.adventuregame.entities.creatures.Enemies;
import yaseen.adventuregame.entities.creatures.Player;
import yaseen.adventuregame.gfx.Assets;
import yaseen.adventuregame.tiles.Tile;
import yaseen.adventuregame.worlds.World;

public class GameState extends State 
{
	//Instance variables for GameState
	private World world;
	private int numberOfEnemies;

	//Constructor
	public GameState(Handler handler) throws IOException
	{
		super(handler);
		world = new World(handler, "res/worlds/world.txt");
		handler.setWorld(world);
	}
	
	//Checks inputs and and number of enemies and sets the state accordingly, also ticks world
	public void tick() 
	{
		world.tick();
		if(handler.getKeyManager().esc)
		{
			setState(handler.getGame().getPauseState());
		}
		numberOfEnemies=0;
		for (int i = 0; i < handler.getWorld().getEntityManager().getEntities().size(); i++)
		{
			Entity e = handler.getWorld().getEntityManager().getEntities().get(i);
			if (e instanceof Enemies)
			{
				numberOfEnemies++;
			}
		}
		if (numberOfEnemies == 0)
		{
			setState(handler.getGame().getWinState());
		}
	}

	//Draws world to screen and also draws highlight around which ever position of inventory is selected
	public void render(Graphics g) 
	{
		world.render(g);
		if (handler.getPlayer().getInventorySelected() == 0)
		{
			g.drawImage(Assets.inventoryUI, 0, 416, null);
		}
		else if (handler.getPlayer().getInventorySelected() > 0 && handler.getPlayer().getInventorySelected()<10)
		{
			g.drawImage(Assets.inventoryUI, 0, 416, null);
			g.drawImage(Assets.inventorySelected, getInventoryOneX(handler.getPlayer().getInventorySelected()), 416, null);
		}
		if (handler.getPlayer().getInventory().size() > 0)
		{
			for (int i =0; i <handler.getPlayer().getInventory().size(); i++)
			{
				g.drawImage(handler.getPlayer().getInventory().get(i).getSprite(), getInventoryOneX(i+1), 416, null);
			}
		}
	}
	
	//Gets x positions of inventory slots 
	private int getInventoryOneX (int itemNumber)
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
