package yaseen.adventuregame;

import yaseen.adventuregame.display.Display;

public class GameLauncher 
{
	//Main method that creates and initialises an object of type game which it then calls the start method on
	public static void main(String[] args) 
	{
		//Create a Game object
		Game myGame = new Game("Yaseen's Adventure Game!", 800, 450);
		myGame.start();
	}
}
