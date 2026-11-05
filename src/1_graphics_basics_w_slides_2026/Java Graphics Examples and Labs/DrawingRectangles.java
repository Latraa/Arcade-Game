import java.awt.*;

public class DrawingRectangles extends Canvas
{

    public DrawingRectangles ()
    {
        setBackground(Color.WHITE);
    }

    public void paint( Graphics window )
    {
        window.setColor(Color.BLACK);

        Font nFont = new Font("SANS_SERIF", Font.BOLD, 18);
        window.setFont( nFont );

        window.setColor(Color.BLACK);
        window.drawString("Drawing  Squares ", 70, 100);

        /* RECTANGLES */
        window.setColor(Color.BLUE);
        //fillRect(int x1, int y1, int width, int height)
        window.fillRect(50, 150, 100, 20 );

        window.setColor(Color.GRAY);
        window.drawRect(200,150,50,50);

        window.setColor(Color.RED);
        window.drawRoundRect(300,150,50,50,20,20);

        window.setColor(Color.ORANGE);
        window.fillRoundRect(400,150,50,50,20,20);
    }
}