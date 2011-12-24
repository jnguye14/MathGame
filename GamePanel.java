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

    GamePanel()
    {
    	MODEL = new Model();
    	
        // Set JLabel messages from MODEL & center align
        problem = new JLabel(MODEL.prb);
        score = new JLabel(MODEL.str);
        msg = new JLabel(MODEL.msg);
        timeLab = new JLabel(MODEL.time);
        problem.setHorizontalAlignment(JLabel.CENTER);
        score.setHorizontalAlignment(JLabel.CENTER);
        msg.setHorizontalAlignment(JLabel.CENTER);
        timeLab.setHorizontalAlignment(JLabel.CENTER);

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
        
        // Timer
        MODEL.timer = new Timer(1000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            { Update("time"); }
        });

        // Entire Game Area in VBox (messages & answer area)
        JPanel VBox = new JPanel();
        VBox.setLayout(new GridLayout(5,1));
        VBox.setDoubleBuffered(true);
        VBox.add(problem);
        VBox.add(HBox);
        VBox.add(score);
        VBox.add(msg);
        VBox.add(timeLab);

        // Create KeyPad
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

    public void Update(String event)
    {
        if(event.equals("time"))
        {
            MODEL.time = "<html>Elapsed Time: <font color =\"GREEN\">"
                    + MODEL.watch.getElapsedTimeSecs()
                    + "</font> Seconds</html>"; /** added color **/
            timeLab.setText(MODEL.time);
        }
        else if(event.equals("invalid"))
        {
            MODEL.answerInvalid();
            msg.setText(MODEL.msg);
        }
        else if(event.equals("correct"))
        {
            MODEL.answerCorrect();
            
            score.setText(MODEL.str);
            msg.setText(MODEL.msg);
            problem.setText(MODEL.prb);
            entry.setText("");
            entry.requestFocus();
        }
        else if(event.equals("wrong"))
        {
            MODEL.answerWrong();
            msg.setText(MODEL.msg);
        }
        else if(event.equals("replay"))
        {     
        	MODEL.gameReplay();
        	
        	problem.setText(MODEL.prb);
        	score.setText(MODEL.str);
        	msg.setText(MODEL.msg);
        	timeLab.setText(MODEL.time);
        }
        else
            System.out.println("Invalid Update Command");
    }

} // end of GamePanel class
