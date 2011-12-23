/*** Jordan Nguyen ***/

import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JApplet
{
    public void init()
    {
       	Controller panel = new Controller();

        // Import Sounds
        AudioClip correctSFX = getAudioClip(getCodeBase(), "answerCorrect.wav");
        AudioClip accessSFX = getAudioClip(getCodeBase(), "winInternet.wav");
    	AudioClip wrongSFX = getAudioClip(getCodeBase(), "answerWrong.wav");
        panel.GAME_PANEL.MODEL.correctSFX = correctSFX;
        panel.GAME_PANEL.MODEL.accessSFX = accessSFX;
        panel.GAME_PANEL.MODEL.wrongSFX = wrongSFX;

        getContentPane().add(panel.GAME_PANEL);
        setSize(350, 300); // Should the Button Panel be placed underneath
        //setSize(500, 200); // or to the side?
		
    } // init()
} // Game class
