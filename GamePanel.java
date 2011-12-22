/*** Jordan Nguyen ***/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.applet.AudioClip;
import java.net.URL;

@SuppressWarnings("serial")
public class GamePanel extends JPanel
{
    protected JLabel problem, answerPrompt, score, msg, timeLab;
    protected JTextField entry;
    protected JButton clear;
    protected int product;
    protected int numNeeded = 20;
    protected String str;
    protected AudioClip correctSFX, accessSFX; // wrongSFX
    protected StopWatch watch;
    protected Timer timer;

    GamePanel()
    {
        // create a problem
        problem = new JLabel("");
        problem.setHorizontalAlignment(JLabel.CENTER);
        generateProb();

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
        str = "You need to get " + numNeeded + " problems right to get internet.";
        score = new JLabel(str);
        score.setHorizontalAlignment(JLabel.CENTER);
        msg = new JLabel("");
        msg.setHorizontalAlignment(JLabel.CENTER);
        timeLab = new JLabel("Elapsed Time: 0 Seconds"); // changed
        timeLab.setHorizontalAlignment(JLabel.CENTER);

        // search for music files
        try {
            URL url = new URL("file", "localhost", "\\Users\\planettop92\\MathGame\\MathGame\\answerCorrect.wav");
            correctSFX = JApplet.newAudioClip(url);
            // url = new URL("file", "localhost", "\\Users\\planettop92\\Desktop\\music.wav");
            // wrongSFX = JApplet.newAudioClip(url);
            url = new URL("file", "localhost", "\\Users\\planettop92\\MathGame\\MathGame\\winInternet.wav");
            accessSFX = JApplet.newAudioClip(url);
        }
        catch(Exception ex)
        {
            System.out.println("Music Not Found.");
        }

        // start timer & watch
        watch = new StopWatch();
        timer = new Timer(1000, new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        str = "Elapsed Time: " + watch.getElapsedTimeSecs() + " Seconds";
                        timeLab.setText(str);
                    }
                });
        watch.start();
        timer.start();

        // add everything for this JPanel to show // moved
        // setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new GridLayout(5,1)); // changed
        add(problem);
        add(HBox);
        add(score);
        add(msg);
        add(timeLab);
    }

    // function to generate a new problem
    protected void generateProb()
    {
        Random rnd = new Random();
        int num1 = rnd.nextInt(11); // numbers 0 to 10
        int num2 = rnd.nextInt(11); // numbers 0 to 10
        product = num1*num2;
        String prb = "<html><font face=\"Comic Sans MS\" color =\"BLUE\" size=\"6\"><b>"
                + "What is " + num1 + " x " + num2 + "?"
                + "</b></font></html>";
        problem.setText(prb);
    }
}
