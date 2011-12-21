/*** Chris Jeffery ***/

import java.awt.event.*;

import javax.swing.JOptionPane;

public class Controller implements ActionListener, KeyListener {

	protected GamePanel GAME_PANEL;
	
	Controller()
	{
		GAME_PANEL = new GamePanel();
		
		GAME_PANEL.entry.addKeyListener(this);
		GAME_PANEL.clear.addActionListener(new ButtonListener());
	}
	
/*** LISTENERS AND EVENTS ***/

	private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            GAME_PANEL.entry.setText("");
            GAME_PANEL.entry.requestFocus();
        }
    }
	
	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		String str = "";
		
		if(Integer.parseInt(GAME_PANEL.entry.getText()) == GAME_PANEL.product)
        {
            // correctSFX.play();
			
			// Message
			GAME_PANEL.numNeeded--;
            str = "You need to get " + GAME_PANEL.numNeeded + " more right before you get internet.";
            GAME_PANEL.score.setText(str);
            //str = "Correct!";
            
            
            if(GAME_PANEL.numNeeded == 0)
            {
                JOptionPane.showMessageDialog(null, "<html><font size=\"6\">"
                        + "Congratulations! You've got Internetz! ☺"
                        + "</font></html>");
                //TODO: Open up the Internet.
                //      More than the OK button
                //      Need Internet AND Replay Button
            }else if(GAME_PANEL.numNeeded <= 0) //Is this necessary?
                str = "Congratulations! You've got Internetz! ☺";
            else
            {
            	GAME_PANEL.entry.setText("");
            	GAME_PANEL.entry.requestFocus();

            	GAME_PANEL.generateProb();	
            }
        }
        else
        {
        	// See if too many numbers in TextField
        	if((Integer.toString(GAME_PANEL.product)).length() <= GAME_PANEL.entry.getText().length())
        	{
        		GAME_PANEL.score.setText("Your answer is wrong. Double check your math.");
            	// TODO: wrongSFX.play();
        	}
        	else
        		GAME_PANEL.score.setText(GAME_PANEL.str);
        	
        }		
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		
	}
}
