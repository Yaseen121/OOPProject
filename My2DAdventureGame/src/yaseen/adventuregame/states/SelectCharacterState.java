package yaseen.adventuregame.states;

import java.awt.Graphics;

import yaseen.adventuregame.Handler;
import yaseen.adventuregame.gfx.Assets;

public class SelectCharacterState extends State
{
	
	//Constructor
	public SelectCharacterState(Handler handler) 
	{
		super(handler);
	}

	//Checks which button is pressed and creates character and sets states accordingly 
	public void tick() 
	{
		if (handler.getMouseManager().checkLeftPressed() 
				&& handler.getMouseManager().getMousePosY() > 309	 
				&& handler.getMouseManager().getMousePosY() < 339)

		{
			if (handler.getMouseManager().getMousePosX() > 185 && handler.getMouseManager().getMousePosX() <287)
			{
				//Select Knight
				handler.getPlayer().setPlayerAnim("Knight");
				handler.getPlayer().setHealth(9);
				handler.getPlayer().setAttack(8);
				handler.getPlayer().setRange(8);
				handler.getPlayer().setSpeed(9f/3f);
				setState(handler.getGame().getGameState());
			}
			else if (handler.getMouseManager().getMousePosX() > 513 && handler.getMouseManager().getMousePosX() < 615)
			{
				//Select Mage
				handler.getPlayer().setPlayerAnim("Mage");
				handler.getPlayer().setHealth(7);
				handler.getPlayer().setAttack(4);
				handler.getPlayer().setRange(16);
				handler.getPlayer().setSpeed(8f/2f);
				setState(handler.getGame().getGameState());
			}
		}
	}
		
	//Draws background and buttons and changes buttons when mouse is hovering
	public void render(Graphics g) 
	{
		g.drawImage(Assets.selectCharacterBackground, 0, 0, null);
		g.drawImage(Assets.selectKnight, 185, 309, null);
		g.drawImage(Assets.selectMage, 513, 309, null);
		if (handler.getMouseManager().getMousePosY() > 309 && handler.getMouseManager().getMousePosY() < 339)
		{
			if (handler.getMouseManager().getMousePosX() > 185 && handler.getMouseManager().getMousePosX() <287)
			{
				g.drawImage(Assets.selectKnightHover, 185, 309, null);
			}
			else 
			{
				g.drawImage(Assets.selectKnight, 185, 309, null);
			}
			if (handler.getMouseManager().getMousePosX() > 513 && handler.getMouseManager().getMousePosY() < 615)
			{
				g.drawImage(Assets.selectMageHover, 513, 309, null);
			}
			else
			{
				g.drawImage(Assets.selectMage, 513, 309, null);
			}
		}
	}
}
