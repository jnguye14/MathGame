/*** Jordan Nguyen ***/

import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JApplet
{
    public void init()
    {
       	Controller panel = new Controller();

        AudioClip correctSFX = getAudioClip(getCodeBase(), "answerCorrect.wav");
        // correctSFX.play();
        panel.GAME_PANEL.MODEL.correctSFX = correctSFX;
        AudioClip accessSFX = getAudioClip(getCodeBase(), "winInternet.wav");
        // accessSFX.play();
        panel.GAME_PANEL.MODEL.accessSFX = accessSFX;
    	AudioClip wrongSFX = getAudioClip(getCodeBase(), "answerWrong.wav");
        // wrongSFX.play();
        panel.GAME_PANEL.MODEL.wrongSFX = wrongSFX;
        // System.out.println(getCodeBase());
        // System.out.println(getDocumentBase());

        getContentPane().add(panel.GAME_PANEL);
        setSize(350, 300); // Should the Button Panel be placed underneath
        //setSize(500, 200); // or to the side?
		
    } // init()
} // Game class
