import javax.swing.JFrame;

public class RunThis extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public RunThis()
	{
		super("Run this file - this is the main Graphics runner ");

		setSize(WIDTH,HEIGHT);

		//uncomment each file when you need to run it
		//comment off any files you are not using

		//getContentPane().add(new DrawingLines() );

		//getContentPane().add(new DrawingRectangles() );

		//getContentPane().add(new DrawingOvals() );

		//getContentPane().add(new DrawingArcs() );

		//getContentPane().add(new DrawingPolygons() );

      	//getContentPane().add(new FontsAndColors() );
      	
      	getContentPane().add(new Animation() );

      	//DRAW YOUR PICTURE USING THIS FILE
      	//getContentPane().add(new Picture() );
      	
      	//DRAW YOUR SPOOKY SCENCE USING THIS FILE
      	//getContentPane().add(new SpookyScene() );
		
		setVisible(true);	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		RunThis run = new RunThis();
	}
}