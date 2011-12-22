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
    protected JButton clear;
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

        // add everything for this JPanel to show // moved
        // setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new GridLayout(5,1)); // changed
        add(problem);
        add(HBox);
        add(score);
        add(msg);
        add(timeLab);
    }

}
