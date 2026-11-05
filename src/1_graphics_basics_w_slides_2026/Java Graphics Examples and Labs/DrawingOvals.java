import java.awt.*;

public class DrawingOvals extends Canvas
{

    public DrawingOvals ()
    {
        setBackground(Color.WHITE);
    }

    public void paint( Graphics window )
    {
        window.setColor(Color.BLACK);

        Font nFont = new Font("SANS_SERIF", Font.BOLD, 18);
        window.setFont( nFont );

        window.drawString("Drawing Circles - Ovals ", 50, 30);

        /*OVALS */
        window.setColor(Color.ORANGE);
        //drawOval(int x1, int y1, int width, int height)
        window.drawOval(50,50,40,40);

        window.setColor(Color.GREEN);
        window.drawOval(150,50,100,50);

        window.setColor(Color.YELLOW);
        window.fillOval(350,50,70,70);

        window.setColor(Color.BLUE);
        window.fillOval(150,150,43,82);

    }
}