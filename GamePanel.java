//Jordan Nguyen

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener, ActionListener
{
    private JLabel problem, answerPrompt, score, msg;
    private JTextField entry;
    private JButton clear;
    @SuppressWarnings("unused")
	private int product;
    private int numNeeded = 10;
    // private AudioClip correctSFX, wrongSFX, accessSFX;

    GamePanel()
    {
        problem = new JLabel("");
        problem.setHorizontalAlignment(JLabel.CENTER);
        generateProb();
        
        answerPrompt = new JLabel("Answer: ");
        answerPrompt.setHorizontalAlignment(JLabel.RIGHT);
        entry = new JTextField("Type...");
        entry.setHorizontalAlignment(JTextField.CENTER);
        entry.addKeyListener(this);
        clear = new JButton("Clear");
        clear.addActionListener(new ButtonListener());

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

    private void generateProb()
    {
        Random rnd = new Random();
        int num1 = rnd.nextInt(16); // numbers 0 to 15
        int num2 = rnd.nextInt(16); // numbers 0 to 15
        product = num1*num2;
        String str = "<html><font face=\"Comic Sans MS\" color =\"BLUE\" size=\"6\"><b>"
                + "What is " + num1 + " x " + num2 + "?"
                + "</b></font></html>";
        problem.setText(str);
    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String str = "";
            
            /*
            if(Integer.parseInt(entry.getText()) == product)
            {
                // correctSFX.play();
                numNeeded--;
                str = "You need to get " + numNeeded + " more right before you get internet.";
                score.setText(str);
                str = "Correct!";
                if(numNeeded == 0)
                {
                    JOptionPane.showMessageDialog(null, "<html><font size=\"6\">"
                            + "Congratulations! You've got Internetz! ☺"
                            + "</font></html>");
                    //
                }
                if(numNeeded <= 0)
                    str = "Congratulations! You've got Internetz! ☺";
            }
            else
            {
                // wrongSFX.play();
                str = "Sorry, the correct answer was " + product;
            }
            generateProb();
            */
            entry.setText("");
            entry.requestFocus();
            
            msg.setText(str);
        }
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
