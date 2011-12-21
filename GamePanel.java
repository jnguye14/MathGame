/*** Jordan Nguyen ***/

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@SuppressWarnings("serial")
public class GamePanel extends JPanel
{
    protected JLabel problem, answerPrompt, score, msg;
    protected JTextField entry;
    protected JButton clear;
	protected int product;
    protected int numNeeded = 20;
    // private AudioClip correctSFX, wrongSFX, accessSFX;

    GamePanel()
    {
        problem = new JLabel("");
        problem.setHorizontalAlignment(JLabel.CENTER);
        generateProb();
        
        answerPrompt = new JLabel("Answer: ");
        answerPrompt.setHorizontalAlignment(JLabel.RIGHT);
        entry = new JTextField("Type...");
        entry.setSelectionStart(0);
        entry.setSelectionEnd(7);
        entry.setHorizontalAlignment(JTextField.CENTER);
        clear = new JButton("Clear");

        JPanel HBox = new JPanel();
        HBox.setLayout(new GridLayout(1,3));
        HBox.add(answerPrompt);
        HBox.add(entry);
        HBox.add(clear);
        HBox.setDoubleBuffered(true);

        String str = "You need to get " + numNeeded + " problems right to get internet.";
        score = new JLabel(str);
        score.setHorizontalAlignment(JLabel.CENTER);
        msg = new JLabel("");
        msg.setHorizontalAlignment(JLabel.CENTER);

        // setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new GridLayout(4,1));
        add(problem);
        add(HBox);
        add(score);
        add(msg);
        
        /*
         try {
            URL url = new URL("file", "localhost", "\\Users\\planettop92\\Desktop\\music.wav");
            correctSFX = JApplet.newAudioClip(url);
            url = new URL("file", "localhost", "\\Users\\planettop92\\Desktop\\music.wav");
            wrongSFX = JApplet.newAudioClip(url);
            url = new URL("file", "localhost", "\\Users\\planettop92\\Desktop\\music.wav");
            accessSFX = new JApplet.newAudioClip(url);
         }
         catch(Exception ex)
         {
            System.out.println("Music Not Found.");
         }
         */
    }

    protected void generateProb()
    {
        Random rnd = new Random();
        int num1 = rnd.nextInt(10); // numbers 0 to 10
        int num2 = rnd.nextInt(10); // numbers 0 to 10
        product = num1*num2;
        String str = "<html><font face=\"Comic Sans MS\" color =\"BLUE\" size=\"6\"><b>"
                + "What is " + num1 + " x " + num2 + "?"
                + "</b></font></html>";
        problem.setText(str);
    }

}
