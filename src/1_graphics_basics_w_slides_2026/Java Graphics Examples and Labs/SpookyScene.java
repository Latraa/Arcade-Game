import java.awt.*;

public class SpookyScene extends Canvas
{

	public SpookyScene()
	{
		setBackground(Color.WHITE);		
	}

	public void paint( Graphics window )
	{
		window.setColor(Color.BLACK);

		Font nFont = new Font("SANS_SERIF", Font.BOLD, 18);
		window.setFont( nFont );

		window.drawString("DRAW SOMETHING SPOOKY!", 50, 40);
		window.drawString("Use the examples! ", 50, 80);

		window.setColor( Color.ORANGE);
		window.drawLine(50,175,150,150);
		  
      	window.setColor(Color.YELLOW);
		window.fillOval(350,50,70,70);
      
      //ADD YOUR CODE HERE TO DRAW A COOL PICTURE
	}
}