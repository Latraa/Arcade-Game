import java.awt.*;

public class DrawingArcs extends Canvas
{

    public DrawingArcs ()
    {
        setBackground(Color.WHITE);
    }

    public void paint( Graphics window )
    {
        window.setColor(Color.BLACK);

        Font nFont = new Font("SANS_SERIF", Font.BOLD, 18);
        window.setFont( nFont );

        window.drawString("Drawing Arcs ", 50, 90);

        /* MAKING A COLOR */
        //Color( int red, int green, int blue )
        Color newColor = new Color(40,			60,			80);

        window.setColor(newColor);
        window.drawArc(50,100,50,50,0,-180);

        newColor = new Color(140,			160,			180);
        window.setColor(newColor);
        window.drawArc(150,200,50,50,0,180);

        newColor = new Color(240,			120,			80);
        window.setColor(newColor);
        window.fillArc(250,300,77,33,0,180);

    }
}