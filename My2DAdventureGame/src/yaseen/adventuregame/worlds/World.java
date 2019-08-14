package yaseen.adventuregame.worlds;

import java.awt.Graphics;
import java.io.IOException;

import yaseen.adventuregame.Handler;
import yaseen.adventuregame.entities.EntityManager;
import yaseen.adventuregame.entities.creatures.EnemyBrute;
import yaseen.adventuregame.entities.creatures.Player;
import yaseen.adventuregame.entities.items.Dagger;
import yaseen.adventuregame.entities.items.Sword;
import yaseen.adventuregame.tiles.Tile;

public class World
{
	//Instance variables of object type World
	private Handler handler;
	private int width;
	private int height;
	private int spawnPosX;
	private int spawnPosY;
	private int[][] backgroundTiles;
	private int[][] mainTiles;
	private EntityManager entityManager;
	
	//Constructor
	public World(Handler handler, String path) throws IOException
	{
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		loadWorld(path);
		handler.setPlayer(entityManager.getPlayer());
		entityManager.getPlayer().setPosx(spawnPosX*32);
		entityManager.getPlayer().setPosy(spawnPosY*32);
		entityManager.addEntity(new Dagger(handler, (float)(13*32), (float)(16*32)));
		entityManager.addEntity(new Sword(handler, (float)(15*32), (float)(16*32)));
		entityManager.addEntity(new EnemyBrute(handler, (float)(20*32), (float)(3*32)));
	}

	//Ticks all the entities in the arraylist
	public void tick()
	{
		entityManager.tick();
	}
	
	//Rendering/Drawing the map and entities 
	public void render(Graphics g)
	{
		//Rendering background and Rendering actual world
		for (int y = 0;y<height;y++)
		{
			for (int x = 0;x<width;x++)
			{
				getBackgroundTile(x, y).render(g, (x*Tile.TILEWIDTH), (int)(y*Tile.TILEHEIGHT -handler.getGameCamera().getyOffset()));
				getMainTile(x, y).render(g, (x*Tile.TILEWIDTH), (int)(y*Tile.TILEHEIGHT -handler.getGameCamera().getyOffset())); //Uses tile sizes instead of pixels
			}
		}
		entityManager.render(g);
	}
	
	//Loads in a textfile into a string
	//Splits string into an array split by white space
	//Then reads the array into the right variables in order to load world correctly 
	private void loadWorld(String path) throws IOException
	{
		String worldFile = Utils.loadFileAsString(path); 
		String[] worldStuff = worldFile.split("\\s+");//Separates world file text into array separated by the spaces
		width = Utils.parseInt(worldStuff[0]);
		height = Utils.parseInt(worldStuff[1]);
		spawnPosX = Utils.parseInt(worldStuff[2]);
		spawnPosY = Utils.parseInt(worldStuff[3]);
		mainTiles = new int [width][height];
		backgroundTiles = new int [width][height];
		for (int x = 0;x<width;x++)
		{
			for (int y = 0;y<height;y++)
			{
				backgroundTiles[x][y]=Utils.parseInt(worldStuff[(x+y * width) + 5]);
				mainTiles[x][y]=Utils.parseInt(worldStuff[(x+y * width) + 656]);
			}
		}
	}
	
	//Getters and Setters
	public Tile getBackgroundTile(int x, int y)
	{
		Tile t = Tile.tiles[(backgroundTiles[x][y])];
		if (t == null)
		{
			return Tile.grassTile;
		}
		return t;
	}
	
	public Tile getMainTile(int x, int y)
	{
		Tile t = Tile.tiles[(mainTiles[x][y])];
		if (t == null)
		{
			return Tile.grassTile;
		}
		return t;
	}
	
	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public Handler getHandler()
	{
		return handler;
	}

	public void setHandler(Handler handler) 
	{
		this.handler = handler;
	}
	
	public int getSpawnPosX()
	{
		return spawnPosX;
	}

	public int getSpawnPosY()
	{
		return spawnPosY;
	}
}
