package yaseen.adventuregame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener
{
	//Instance variables to keep track of left and right mouse buttons and x and y co-ords of mosue
	private boolean leftMouseButtonPressed;
	private boolean rightMouseButtonPressed;
	private int mousePosX;
	private int mousePosY;
	
	//Constructor
	public MouseManager()
	{
		
	}
	
	public void mouseDragged(MouseEvent e) 
	{
		
	}

	//Updates mouse pos x and y instance variables 
	public void mouseMoved(MouseEvent e) 
	{
		mousePosX = e.getX();
		mousePosY = e.getY();
	}

	public void mouseClicked(MouseEvent e) 
	{
		
	}

	public void mouseEntered(MouseEvent e) 
	{
		
	}

	public void mouseExited(MouseEvent e) 
	{
		
	}

	//Set boolean values to true when mouse buttons pressed
	public void mousePressed(MouseEvent e) 
	{
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			leftMouseButtonPressed = true;
		}
		else if (e.getButton() == MouseEvent.BUTTON3)
		{
			rightMouseButtonPressed = true;
		}
	}
	
	//Sets boolean values to false when mouse buttons released
	public void mouseReleased(MouseEvent e) 
	{
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			leftMouseButtonPressed = false;
		}
		else if (e.getButton() == MouseEvent.BUTTON3)
		{
			rightMouseButtonPressed = false;
		}
	}

	public void tick() 
	{
		
	}
	
	//Getters
	public int getMousePosX()
	{
		return mousePosX;
	}
	
	public int getMousePosY()
	{
		return mousePosY;
	}
	
	public boolean checkLeftPressed() 
	{
		return leftMouseButtonPressed;
	}
	
	public boolean checkRightPressed()
	{
		return rightMouseButtonPressed;
	}

}
