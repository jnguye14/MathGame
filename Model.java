/*** Chris Jeffery ***/

import java.applet.AudioClip;
import java.net.URL;
import java.util.Random;

import javax.swing.JApplet;

public class Model {

    protected int product;
    protected int numNeeded = 20;
    protected String str, prb;
    protected AudioClip correctSFX, accessSFX, wrongSFX;
    
    Model()
    {
        str = "You need to get " + numNeeded + " problems right to get internet.";
        
        /*
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
        */

    }

    // Generate Random Problems
    protected void generateProb()
    {
        Random rnd = new Random();
        int num1 = rnd.nextInt(11); // numbers 0 to 10
        int num2 = rnd.nextInt(11); // numbers 0 to 10
        product = num1*num2;
        prb = "<html><font face=\"Comic Sans MS\" color =\"BLUE\" size=\"6\"><b>"
                + "What is " + num1 + " x " + num2 + "?"
                + "</b></font></html>";
    }
}
