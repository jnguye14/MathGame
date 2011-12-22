/*** Jordan Nguyen ***/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GamePanel extends JPanel
{
    protected Model MODEL;
    protected JLabel problem, answerPrompt, score, msg, timeLab;
    protected JTextField entry;
    protected JButton clear; // replay
    protected JButton[] buttons;
    protected StopWatch watch;
    protected Timer timer;

    GamePanel()
    {
    	MODEL = new Model();
    	
        // create a problem
        problem = new JLabel("");
        problem.setHorizontalAlignment(JLabel.CENTER);
        MODEL.generateProb();

        // create area where user types in answer
        answerPrompt = new JLabel("Answer: ");
        answerPrompt.setHorizontalAlignment(JLabel.RIGHT);
        entry = new JTextField("Type...");
        entry.setSelectionStart(0);
        entry.setSelectionEnd(7);
        entry.setHorizontalAlignment(JTextField.CENTER);
        clear = new JButton("Clear");

        // answer area contained in an HBox
        JPanel HBox = new JPanel();
        HBox.setLayout(new GridLayout(1,3));
        HBox.add(answerPrompt);
        HBox.add(entry);
        HBox.add(clear);
        HBox.setDoubleBuffered(true);

        // messages under answer area
        score = new JLabel(MODEL.str);
        score.setHorizontalAlignment(JLabel.CENTER);
        msg = new JLabel("");
        msg.setHorizontalAlignment(JLabel.CENTER);
        timeLab = new JLabel("Elapsed Time: 0 Seconds"); // changed
        timeLab.setHorizontalAlignment(JLabel.CENTER);
        problem.setText(MODEL.prb);

        // start timer & watch
        watch = new StopWatch();
        timer = new Timer(1000, new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        MODEL.str = "Elapsed Time: " + watch.getElapsedTimeSecs() + " Seconds";
                        timeLab.setText(MODEL.str);
                    }
                });

        /*
        // add everything for this JPanel to show // moved
        // setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new GridLayout(5,1)); // changed
        add(problem);
        add(HBox);
        add(score);
        add(msg);
        add(timeLab);
        */

        JPanel VBox = new JPanel();
        VBox.setLayout(new GridLayout(5,1));
        VBox.setDoubleBuffered(true);
        VBox.add(problem);
        VBox.add(HBox);
        VBox.add(score);
        VBox.add(msg);
        VBox.add(timeLab);

        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new GridLayout(4,3));
        ButtonPanel.setDoubleBuffered(true);

        buttons = new JButton[10];
        for(int i = 1; i < buttons.length; i++)
        {
            buttons[i] = new JButton(Integer.toString(i));
            ButtonPanel.add(buttons[i]);
        }
        JLabel filler = new JLabel(" ");
        ButtonPanel.add(filler);
        buttons[0] = new JButton("0");
        ButtonPanel.add(buttons[0]);
        
        add(VBox);
        add(ButtonPanel);
    } // end of GamePanel() constructor

} // end of GamePanel class
