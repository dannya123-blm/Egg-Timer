package sound;
//Author, Version

/**
 * Date: 16/04/2024
 * Date: ass
 *
 * @author Daniel Aigbe
 * @version 1
 */
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundManager {
    public static void playSound(String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
