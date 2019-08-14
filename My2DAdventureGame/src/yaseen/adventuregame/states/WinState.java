package yaseen.adventuregame.states;

import java.awt.Graphics;

import yaseen.adventuregame.Handler;
import yaseen.adventuregame.gfx.Assets;

public class WinState extends State
{
	//Constructor
	public WinState(Handler handler) 
	{
		super(handler);
	}

	//Checks if mouse is hovering over buttton and if mouse is pressed will quit the game
	public void tick() 
	{
		if (handler.getMouseManager().checkLeftPressed() 
				&& handler.getMouseManager().getMousePosX() > 285 
				&& handler.getMouseManager().getMousePosX() < 515)

		{
			if (handler.getMouseManager().getMousePosY() > 345 && handler.getMouseManager().getMousePosY() < 422)
			{
				System.exit(0);
			}
		}
	}
	
	//Renders the background and ui buttons and if mouse is hovering over buttons will change the button
	public void render(Graphics g) 
	{
		g.drawImage(Assets.winBackground, 0, 0, null);
		g.drawImage(Assets.quitButton, 285, 345, null);
		if (handler.getMouseManager().getMousePosX() > 285 && handler.getMouseManager().getMousePosX() < 515)
		{
			if (handler.getMouseManager().getMousePosY() > 345 && handler.getMouseManager().getMousePosY() < 422)
			{
				g.drawImage(Assets.quitButtonHover, 285, 345, null);
			}
			else
			{
				g.drawImage(Assets.quitButton, 285, 345, null);
			}
		}
	}
}
