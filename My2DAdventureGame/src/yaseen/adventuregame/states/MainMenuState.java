package yaseen.adventuregame.states;

import java.awt.Graphics;

import yaseen.adventuregame.Game;
import yaseen.adventuregame.Handler;
import yaseen.adventuregame.gfx.Assets;

public class MainMenuState extends State
{
	//Constructor
	public MainMenuState(Handler handler)
	{
		super(handler);
	}
	
	//Checks what button is pressed and does corresponding action
	public void tick() 
	{
		if (handler.getMouseManager().checkLeftPressed() 
				&& handler.getMouseManager().getMousePosX() > 285 
				&& handler.getMouseManager().getMousePosX() < 515)
		{
			if (handler.getMouseManager().getMousePosY() > 177 && handler.getMouseManager().getMousePosY() <254)
			{
				setState(handler.getGame().getSelectCharacterState());
			}
			else if (handler.getMouseManager().getMousePosY() > 345 && handler.getMouseManager().getMousePosY() < 422)
			{
				System.exit(0);
			}
		}
	}

	//Draws background and ui buttons to screen and changes buttons when hovering
	public void render(Graphics g) 
	{
		g.drawImage(Assets.mainMenuBackground, 0, 0, null);
		g.drawImage(Assets.playButton, 285, 177, null);
		g.drawImage(Assets.quitButton, 285, 345, null);
		if (handler.getMouseManager().getMousePosX() > 285 && handler.getMouseManager().getMousePosX() < 515)
		{
			if (handler.getMouseManager().getMousePosY() > 177 && handler.getMouseManager().getMousePosY() <254)
			{
				g.drawImage(Assets.playButtonHover, 285, 177, null);
			}
			else 
			{
				g.drawImage(Assets.playButton, 285, 177, null);
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
