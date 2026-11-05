import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.MouseInfo;

public class Animation extends JPanel implements Runnable
{
	int x = 0;
	int y = 0;
	
	public Animation()
	{
		setBackground(Color.WHITE);

		//starts the animation moving
		new Thread(this).start();
	}

	public void paint( Graphics window )
	{
		window.setColor(Color.WHITE);

		//draw the full screen white
		//this basically erases the screen
		window.fillRect(0,0,1000,800);

		window.setColor(Color.BLACK);

		//move the square
		x = x + 10;
		y = y + 10;

		if( x > 1000)
			x = 0;
		if( y > 800)
			y = 0;

		//draw the square at the new location
		window.fillRect(x, y, 20, 20);		
	}
	
	//the run method controls how fast 
	//the screen gets refreshed
	public void run()
	{
		try
		{
			while( true )
			{	
			   //how long to wait between
			   //screen refreshes
			   Thread.sleep(50);
			   //repaint() refreshes the screen
			   repaint();
			}
		}
		catch( Exception e )
		{
			//code goes here to handle
			//if anything goes wrong			
		}
	}
}