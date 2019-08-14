package yaseen.adventuregame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import yaseen.adventuregame.display.Display;
import yaseen.adventuregame.gfx.Assets;
import yaseen.adventuregame.gfx.GameCamera;
import yaseen.adventuregame.gfx.SpriteSheet;
import yaseen.adventuregame.input.KeyManager;
import yaseen.adventuregame.input.MouseManager;
import yaseen.adventuregame.states.ControlState;
import yaseen.adventuregame.states.GameState;
import yaseen.adventuregame.states.MainMenuState;
import yaseen.adventuregame.states.PauseState;
import yaseen.adventuregame.states.SelectCharacterState;
import yaseen.adventuregame.states.State;
import yaseen.adventuregame.states.WinState;

//Implements runnable needed for threads
public class Game implements Runnable 
{
	//Display is an object created which will create the frame/window of the game
	private Display display;
	//Width and height and title of the game
	private int width;
	private int height;
	public String title;
	//Buffer is like a hidden preloaded screen for the next scene to prevent flickering
	private BufferStrategy bs;
	//Graphics object
	private Graphics g;
	//Boolean to control if game is running 
	private boolean running = false;
	//Thread allows for multi-tasking (running multiple things at the same time)
	private Thread thread;
	
	//Creating game state object
	private State gameState;
	private State mainMenuState;
	private State selectCharacterState;
	private State pauseState;
	private State winState;
	private State controlState;
	//Keyboard and mouse listeners and camera object
	private KeyManager keyManager;
	private MouseManager mouseManager;
	private GameCamera gameCamera;
	//Handler to be able to pass around objects all through handler
	private Handler handler;
	
	//Creating an instance of game will create a new display
	public Game(String title, int width, int height)
	{	
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	//Method that will initialise my display and all my assets and game states and 
	//add appropriate listeners to my display
	private void initialise() throws IOException
	{
		//Initialises display and assets objects
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.initialise();
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0);
		//Initialising game state objects and passing game object (object of this class)
		gameState = new GameState(handler);
		mainMenuState = new MainMenuState(handler);
		selectCharacterState = new SelectCharacterState(handler);
		pauseState = new PauseState(handler);
		winState = new WinState(handler);
		controlState = new ControlState(handler);
		State.setState(mainMenuState);
	}
	
	//Ticks update all variables, objects and positions 
	private void tick()
	{
		keyManager.tick();
		//If a state exists it will tick that state
		if (State.getState() != null)
		{
			State.getState().tick();
		}
	}
		
	//Render updates the graphics and draws onto screen
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		//Checks if the display has a buffer strategy if not creates a 3 screen buffer
		if (bs==null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		//graphics object used to draw on canvas
		g = bs.getDrawGraphics();
		//Clears screen
		g.clearRect(0, 0, width, height);
			
		//Draw here
		//If state exists render that state
		if (State.getState() != null)
		{
			State.getState().render(g);
		}	
		//Shows the next buffer
		bs.show();
		//Makes sure graphics object is used and cleared properly  
		g.dispose();
	}
		
	//Method needed for interface runnable
	public void run()
	{
		try {
			initialise();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Limiting ticks and renders to 60 times a second
		int framesPerSecond = 60;
		double timePerTick = 1000000000 / framesPerSecond; //1000000000 nanoseconds = 1 second
		double delta = 0; //Keeps track of change in time
		long timeNow;
		long lastTime = System.nanoTime(); //Gets current time in nanoseconds
		//Test values
		long timer = 0;
		int ticks = 0;
		
		while (running)
		{
			timeNow = System.nanoTime(); //Constantly updated with current time 
			delta += (timeNow - lastTime) / timePerTick;
			timer += timeNow - lastTime; //Remove after testing
			lastTime = timeNow; //Replaces last time with the time from timeNow so timeNow can be updated 
			//If time past is equal to the time per tick then it will tick and render and decrease delta
			if (delta>=1)
			{
				ticks++;
				tick();
				render();
				delta--;
			}
			//Printing the ticks and frames to check if its 60 per second
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
		
	//Starts thread, synchronised needed to let threads function correctly 
	public synchronized void start()
	{
		//Doesnt execute any of this method of running is already true
		if (running)
		{
			return;
		}
		running = true;
		//Initialising thread
		thread = new Thread(this);
		thread.start();
	}
		
	//Stops thread
	public synchronized void stop()
	{
		//Doesnt execute any of this method of running is already false
		if (!running)
		{
			return;
		}
		running = false;
		try 
		{
			thread.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	//Getters 
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
	
	public MouseManager getMouseManager()
	{
		return mouseManager;
	}
	
	public GameCamera getGameCamera()
	{
		return gameCamera;
	}
	
	public int getWidth() 
	{
		return width;
	}

	public int getHeight() 
	{
		return height;
	}
	
	public State getGameState() {
		return gameState;
	}

	public State getMainMenuState() {
		return mainMenuState;
	}
	
	public State getSelectCharacterState() {
		return selectCharacterState;
	}

	public State getPauseState() {
		return pauseState;
	}
	
	public State getWinState() {
		return winState;
	}

	public State getControlState() 
	{
		return controlState;
	}
}
