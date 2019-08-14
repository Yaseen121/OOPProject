package yaseen.adventuregame;

import yaseen.adventuregame.entities.creatures.Player;
import yaseen.adventuregame.gfx.GameCamera;
import yaseen.adventuregame.input.KeyManager;
import yaseen.adventuregame.input.MouseManager;
import yaseen.adventuregame.worlds.World;

//Class to pass along all the variables
//Allows passing one object and having access to a lot more such as game, world, game camera 
public class Handler 
{
	//Objects that it will hold
	private Game game;
	private World world;
	private Player player;
	
	//Constructor
	public Handler(Game game)
	{
		this.game = game;
	}
	
	//Getters
	public GameCamera getGameCamera()
	{
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager()
	{
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager()
	{
		return game.getMouseManager();
	}
	
	public int getWidth()
	{
		return game.getWidth();
	}
	
	public int getHeight()
	{
		return game.getHeight();
	}

	public Game getGame() 
	{
		return game;
	}

	public void setGame(Game game) 
	{
		this.game = game;
	}

	public World getWorld() 
	{
		return world;
	}

	public void setWorld(World world) 
	{
		this.world = world;
	}
	
	public void setPlayer(Player player) 
	{
		this.player = player;
	}
	
	public Player getPlayer()
	{
		return player;
	}
}
