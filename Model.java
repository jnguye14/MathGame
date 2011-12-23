/*** Chris Jeffery ***/

import java.applet.AudioClip;
import java.util.Random;

public class Model {

    protected int product;
    protected int numNeeded = 3;
    Random rnd;
    // Each String corresponds to one of GamePanel's JLabels
    protected String str, prb, time, msg;
    protected AudioClip correctSFX, accessSFX, wrongSFX;
    
    Model()
    {
    	rnd = new Random();
    	
        generateProb();
        
        str = "You need to get " + numNeeded + " problems right to get internet.";
        msg = "";
        time = "Elapsed Time: 0 Seconds";
    }

    // Generate Random Problems
    protected void generateProb()
    {
        int num1 = rnd.nextInt(11); // numbers 0 to 10
        int num2 = rnd.nextInt(11); // numbers 0 to 10
        product = num1*num2;
        prb = "<html><font face=\"Comic Sans MS\" color =\"BLUE\" size=\"6\"><b>"
                + "What is " + num1 + " x " + num2 + "?"
                + "</b></font></html>";
    }

    protected void answerCorrect()
    {
        correctSFX.play();
        numNeeded--;
        str = "You need to get " + numNeeded + " more right before you get internet.";
        msg = "Correct!";
        generateProb();
    }

    protected void answerWrong()
    {
        wrongSFX.play();
        msg = "<html><font color =\"RED\">"
                + "Your answer is wrong. Double check your math."
                + "</font></html>";
    }

    protected void answerInvalid()
    {
        wrongSFX.play();
        msg = "<html><font color =\"RED\">Please enter only digits.</font></html>";
    }

    protected void gameReplay()
    {
    	str = "You need to get " + numNeeded + " more right before you get internet.";
        msg = "";
        time = "Elapsed Time: 0 Seconds";
    }
}
