package yaseen.adventuregame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
	//All the keys that are used in the game and a key array
	private boolean[] keys;
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	public boolean space;
	public boolean enter;
	public boolean one;
	public boolean two;
	public boolean three;
	public boolean four;
	public boolean five;
	public boolean six;
	public boolean seven;
	public boolean eight;
	public boolean nine;
	public boolean zero;
	public boolean esc;
	public boolean basicAttackUp;
	public boolean basicAttackDown;
	public boolean basicAttackLeft;
	public boolean basicAttackRight;
	public boolean specailAttack;
	
	//All keyboards have an input keycode, 
	//when a key is pressed keys[keycode] will be set to true and vice versa
	//Constructor
	public KeyManager()
	{
		keys = new boolean[256];
	}
	
	//Tick method that will update boolean values when the right key is pressed
	public void tick()
	{
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE];
		enter = keys[KeyEvent.VK_ENTER];
		one = keys[KeyEvent.VK_1];
		two = keys[KeyEvent.VK_2];
		three = keys[KeyEvent.VK_3];
		four = keys[KeyEvent.VK_4];
		five = keys[KeyEvent.VK_5];
		six = keys[KeyEvent.VK_6];
		seven = keys[KeyEvent.VK_7];
		eight = keys[KeyEvent.VK_8];
		nine = keys[KeyEvent.VK_9];
		zero = keys[KeyEvent.VK_0];
		esc = keys[KeyEvent.VK_ESCAPE];
		basicAttackUp = keys[KeyEvent.VK_UP];
		basicAttackDown = keys[KeyEvent.VK_DOWN];
		basicAttackLeft = keys[KeyEvent.VK_LEFT];
		basicAttackRight = keys[KeyEvent.VK_RIGHT];
		specailAttack = keys[KeyEvent.VK_ALT];
	}
	
	//Checks if key is pressed and if it is it will make the array position for the key = true
	public void keyPressed(KeyEvent e) 
	{
		keys[e.getKeyCode()] = true;
		System.out.println("key pressed");
	}

	//Makes array position of key false when key is realeased 
	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) 
	{

	}
}
