package yaseen.adventuregame.states;

import java.awt.Graphics;

import yaseen.adventuregame.Game;
import yaseen.adventuregame.Handler;
import yaseen.adventuregame.gfx.Assets;

public class PauseState extends State
{
	//Constructor
	public PauseState(Handler handler)
	{
		super(handler);
	}
	
	//Checks which button is pressed and then does the corresponding action (resumes game, goes to controls or quits)
	public void tick() 
	{
		if (handler.getMouseManager().checkLeftPressed() 
				&& handler.getMouseManager().getMousePosX() > 285 
				&& handler.getMouseManager().getMousePosX() < 515)

		{
			if (handler.getMouseManager().getMousePosY() > 177 && handler.getMouseManager().getMousePosY() <254)
			{
				setState(handler.getGame().getGameState());
			}
			else if (handler.getMouseManager().getMousePosY() > 261 && handler.getMouseManager().getMousePosY() <338)
			{
				setState(handler.getGame().getControlState());
			}
			else if (handler.getMouseManager().getMousePosY() > 345 && handler.getMouseManager().getMousePosY() < 422)
			{
				System.exit(0);
			}
		}
	}
		
	//Draws background and buttons and changes buttons when it hovers
	public void render(Graphics g) 
	{
		g.drawImage(Assets.pausedBackground, 0, 0, null);
		g.drawImage(Assets.resumeButton, 285, 177, null);
		g.drawImage(Assets.controlsButton, 285, 261, null);
		g.drawImage(Assets.quitButton, 285, 345, null);
		if (handler.getMouseManager().getMousePosX() > 285 && handler.getMouseManager().getMousePosX() < 515)
		{
			if (handler.getMouseManager().getMousePosY() > 177 && handler.getMouseManager().getMousePosY() <254)
			{
				g.drawImage(Assets.resumeButtonHover, 285, 177, null);
			}
			else 
			{
				g.drawImage(Assets.resumeButton, 285, 177, null);
			}
			if (handler.getMouseManager().getMousePosY() > 261 && handler.getMouseManager().getMousePosY() < 338)
			{
				g.drawImage(Assets.controlsButtonHover, 285, 261, null);
			}
			else
			{
				g.drawImage(Assets.controlsButton, 285, 261, null);
			}
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
