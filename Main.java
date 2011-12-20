//Jordan Nguyen

import javax.swing.*;

public class Main extends JApplet
{
    public void init()
    {
        GamePanel panel = new GamePanel();
        getContentPane().add(panel);
        setSize(350, 100);
    } // init()
} // Game class
