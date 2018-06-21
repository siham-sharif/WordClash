import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundClip {

    private File inGameSound = new File("resource/sound/main.wav");
    private File winSound = new File("resource/sound/win.wav");
    private File looseSound = new File("resource/sound/loose.wav");
    private File clickSound = new File("resource/sound/click.wav");

    private Clip clip;
    private Clip activeClip = null;

    public SoundClip(){

    }

    public void themeSongStatus(boolean soundStatus){

        if(activeClip != null)
            activeClip.stop();

        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(inGameSound));

            activeClip = clip;

            if(soundStatus == false){
                clip.stop();
            }
            if(soundStatus == true) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }

        }
        catch (Exception error){
            error.printStackTrace();
        }
    }

    public void winingSound(){

        if(activeClip != null) {
            activeClip.stop();
        }

        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(winSound));
            clip.start();

        }
        catch (Exception error){
            error.printStackTrace();
        }
    }

    public void losingSound(){

        if(activeClip != null) {
            activeClip.stop();
        }

        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(looseSound));
            clip.start();
        }
        catch (Exception error){
            error.printStackTrace();
        }
    }
}
