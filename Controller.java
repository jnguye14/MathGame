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
                // GAME_PANEL.MODEL.wrongSFX.play();
                // GAME_PANEL.msg.setText("<html><font color =\"RED\">"
                //         + "Please enter only digits."
                //         + "</font></html>");
                GAME_PANEL.Update("invalid");
                return;
            }
        }

        if(Integer.parseInt(GAME_PANEL.entry.getText()) == GAME_PANEL.MODEL.product)
        {
            // GAME_PANEL.MODEL.correctSFX.play();
            
            // CHECK: I don't know if it's better to start the clock here or when the app opens?
            // Start Clock
            if(GAME_PANEL.MODEL.numNeeded == startClock)
            {
            	GAME_PANEL.watch.start();
            	GAME_PANEL.timer.start();
            }

            // Message
            // GAME_PANEL.MODEL.numNeeded--;
            // str = "You need to get " + GAME_PANEL.MODEL.numNeeded + " more right before you get internet.";
            // GAME_PANEL.score.setText(str);
            // GAME_PANEL.msg.setText("Correct!");
            // TODO: get average time for each answer (StopWatch Method?)?
            GAME_PANEL.Update("correct");

            if(GAME_PANEL.MODEL.numNeeded == 0)
            {
                GAME_PANEL.watch.stop();
                GAME_PANEL.timer.stop();
                GAME_PANEL.MODEL.accessSFX.play();
                JOptionPane.showMessageDialog(null, "<html><font size=\"6\">"
                        + "Congratulations! You've got Internetz! ☺"
                        + "</font></html>");
                //TODO: Open up the Internet.
                //      More than the OK button
                //      Need Internet AND Replay Button
                //      Record Time to Answer all Questions
            }
            // else
            // {
                // GAME_PANEL.entry.setText("");
                // GAME_PANEL.entry.requestFocus();
                
                // Create new problem
                // GAME_PANEL.MODEL.generateProb();
                // GAME_PANEL.problem.setText(GAME_PANEL.MODEL.prb);
            // }
        }
        else
        {
            // See if too many numbers in TextField
            if((Integer.toString(GAME_PANEL.MODEL.product)).length() <= GAME_PANEL.entry.getText().length())
            {
                // GAME_PANEL.MODEL.wrongSFX.play();
                // GAME_PANEL.msg.setText("<html><font color =\"RED\">"
                //         + "Your answer is wrong. Double check your math."
                //         + "</font></html>");
                GAME_PANEL.Update("wrong");
            }else
            	GAME_PANEL.msg.setText("");
        }
    } // check()
    
}
