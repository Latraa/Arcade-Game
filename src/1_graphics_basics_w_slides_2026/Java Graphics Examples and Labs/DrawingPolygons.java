import java.awt.*;

public class DrawingPolygons extends Canvas
{

	public DrawingPolygons ()
	{
		setBackground(Color.WHITE);		
	}

	public void paint( Graphics window )
	{
		window.setColor(Color.BLACK);

		Font nFont = new Font("SANS_SERIF", Font.BOLD, 18);
		window.setFont( nFont );

		window.drawString("Drawing Polygons ", 50, 40);
		
		int[] xPoints = {200, 300, 100, 400};
		int[] yPoints = {100, 200, 200, 100};

		//change this to use fewer points or more points
		int howManyPointsToUse = 4;
		
		Polygon pol = new Polygon( xPoints, yPoints, howManyPointsToUse);

		window.setColor(Color.GREEN);
		
		//window.drawPolygon( pol );
		window.fillPolygon( pol );
	}
}