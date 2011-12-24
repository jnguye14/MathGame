/*** Chris Jeffery ***/

import java.awt.event.*;
import javax.swing.JOptionPane;

public class Controller implements ActionListener, KeyListener
{
    protected GamePanel GAME_PANEL;
    private int startClock;

    Controller()
    {
        GAME_PANEL = new GamePanel();
        
        startClock = GAME_PANEL.MODEL.numNeeded;
        
        GAME_PANEL.entry.addKeyListener(this);
        GAME_PANEL.clear.addActionListener(new ButtonListener());

        for(int i = 0; i < GAME_PANEL.buttons.length; i++)
            GAME_PANEL.buttons[i].addActionListener(new ButtonListener());
    }

/*** LISTENERS AND EVENTS ***/

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource().equals(GAME_PANEL.clear))
            {
                GAME_PANEL.msg.setText(""); /** added **/
                GAME_PANEL.entry.setText("");
                GAME_PANEL.entry.requestFocus();
            }
            else
            {
                GAME_PANEL.entry.replaceSelection(event.getActionCommand());
                check();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0)
    {

    }

    @Override
    public void keyReleased(KeyEvent arg0)
    {
        check();
    }

    @Override
    public void keyTyped(KeyEvent arg0)
    {

    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {

    }

	private void check()
    {
        // returns if entry field is empty
        if(GAME_PANEL.entry.getText().length() <= 0)
            return;

        // returns if entered something that's not a digit
        for(int i = 0; i < GAME_PANEL.entry.getText().length(); i++)
        {
            boolean isDigit = false;
            for(char digit = '0'; digit <= '9'; digit++)
            {
                if(GAME_PANEL.entry.getText().charAt(i) == digit)
                    isDigit = true;
            }
            if(!isDigit)
            {
                GAME_PANEL.Update("invalid");
                return;
            }
        }


        // CHECK: I don't know if it's better to start the clock here or when the app opens?
        /** I moved this up an if statement so the clock would start when they enter anything in **/
        // Start Clock
        if(GAME_PANEL.MODEL.watch.notRunning() && (GAME_PANEL.MODEL.numNeeded > 0))
        {
            GAME_PANEL.MODEL.watch.start();
            GAME_PANEL.MODEL.timer.start();
        }

        if(Integer.parseInt(GAME_PANEL.entry.getText()) == GAME_PANEL.MODEL.product)
        {
            GAME_PANEL.Update("correct");

            if(GAME_PANEL.MODEL.numNeeded == 0)
            {
                GAME_PANEL.MODEL.watch.stop();
                GAME_PANEL.MODEL.timer.stop();
                GAME_PANEL.MODEL.accessSFX.play();
                
                
                //Object Internet = "Internet";
                Object[] possibleValues = {"Internet", "Replay", "Exit" };
                int selectedValue = JOptionPane.showOptionDialog(null,
                        "<html><font size=\"6\">"
                        + "Congratulations! You've got Internetz! ☺"
                        + "</font></html>"
                        + "\nHere's your average time: "
                        + GAME_PANEL.MODEL.watch.getAverageTime(startClock)
                        + "ms",
                        "", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null,
                        possibleValues, possibleValues[0]);
                
                switch(selectedValue)
                {
                case 0:
                	// TODO: Unlock and Open the Internet(Chrome)
                	break;
                case 1:
                	GAME_PANEL.MODEL.numNeeded = startClock;
                	GAME_PANEL.Update("replay");
                	break;
                case 2:
                	// TODO: Quit -> Applets don't have a quit.
                	// TODO: Back -> Create a Main Menu 
                	/** No Settings Button, Keep all settings in the main menu with a play/start button **/
                	// GAME_PANEL.goToMainMenu();
                	break;
                default:
                	// TODO: Quit program
                	break;
                }
              
                //TODO: Record Time to Answer all Questions
            }
        }
        else
        {
            // See if too many numbers in TextField
            if((Integer.toString(GAME_PANEL.MODEL.product)).length() <= GAME_PANEL.entry.getText().length())
                GAME_PANEL.Update("wrong");
            else
            	GAME_PANEL.msg.setText("");
        }
    } // check()
    
}
