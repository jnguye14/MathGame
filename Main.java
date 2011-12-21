/*** Jordan Nguyen ***/

import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JApplet
{
    public void init()
    {
    	Controller panel = new Controller();
        getContentPane().add(panel.GAME_PANEL);
        setSize(350, 100);
		
    } // init()
} // Game class
