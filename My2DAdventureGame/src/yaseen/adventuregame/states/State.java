package yaseen.adventuregame.states;

import java.awt.Graphics;

import yaseen.adventuregame.Game;
import yaseen.adventuregame.Handler;

//Superclass for the states
public abstract class State 
{	
	protected Handler handler;
	
	//Constructor
	public State (Handler handler)
	{
		this.handler = handler;
	}
	
	//Game State Manger stuff
	private static State currentState = null;
	
	//Game state methods
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	
	//Getters and Setters
	public static void setState(State state)
	{
		currentState = state;
	}
	
	public static State getState()
	{
		return currentState;
	}
}
