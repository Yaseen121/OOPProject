package yaseen.adventuregame.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display 
{
	//Main Jframe/window
	private JFrame mainFrame;
	//Canvas for images 
	private Canvas canvas;
	//Title, width and height of game window
	private String title;
	private int width;
	private int height;
	
	//Constructor method of Display to create the window
	public Display(String title, int width, int height)
	{
		//Setting title, width and height of Display
		this.title = title;
		this.width = width;
		this.height = height;
		createDisplay();
	}
	
	//Method that makes the winodw visable and sets location and size etc.
	private void createDisplay()
	{
		//Initialising JFrame and setting size and close operation and making it load on center of screen
		mainFrame = new JFrame(title);
		mainFrame.setSize(width,  height);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		
		//Initialising canvas, setting canvas size
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		//Adding canvas to frame
		mainFrame.add(canvas);
		mainFrame.pack();
	}
	
	//Getters
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public JFrame getFrame()
	{
		return mainFrame;
	}
	
}
