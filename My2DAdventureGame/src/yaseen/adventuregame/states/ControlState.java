package yaseen.adventuregame.states;

import java.awt.Graphics;

import yaseen.adventuregame.Handler;
import yaseen.adventuregame.gfx.Assets;

public class ControlState extends State
{
	//Constructor
	public ControlState(Handler handler) 
	{
		super(handler);
	}

	//Returns to pause state when esc pressed
	public void tick() 
	{
		if(handler.getKeyManager().esc)
		{
			setState(handler.getGame().getPauseState());
		}
	}

	//Draws control screen 
	public void render(Graphics g)
	{
		g.drawImage(Assets.controlsBackground, 0, 0, null);
	}
}
