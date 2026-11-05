import java.awt.*;

public class DrawingLines extends Canvas
{

    public DrawingLines ()
    {
        setBackground(Color.WHITE);
    }

    public void paint( Graphics window )
    {
        window.setColor(Color.BLACK);

        Font nFont = new Font("SANS_SERIF", Font.BOLD, 18);
        window.setFont( nFont );

        window.drawString("Drawing Lines ", 50, 40);

        window.setColor( Color.GREEN);
        window.drawLine(50,175,150,250);

        window.setColor( Color.RED);
        window.drawLine(250,275,450,300);

        window.setColor( Color.BLUE);
        window.drawLine(350,375,450,300);
    }
}