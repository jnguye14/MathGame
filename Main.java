/*** Jordan Nguyen ***/

import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JApplet
{
    public void init()
    {
    	Controller panel = new Controller();
        getContentPane().add(panel.GAME_PANEL);
        setSize(350, 300); // Should the Button Panel be placed underneath
        //setSize(500, 200); // or to the side?
		
    } // init()
} // Game class
