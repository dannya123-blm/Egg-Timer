package cooking;

// Author, Version
/**
 * Date: 16/04/2024
 * @author Daniel Aigbe
 * @version 1.0
 */
public abstract class Egg {
    protected String imageName;  // Path to the image file
    protected int boilTime;      // Boiling time in seconds
    protected String type;       // Type of the egg
    protected String soundPath;  // Path to the sound file

    /**
     * Constructs an Egg instance with specified attributes.
     *
     * @param type The type of the egg.
     * @param imageName The path to the image representing the egg.
     * @param boilTime The boiling time of the egg in seconds.
     * @param soundPath The path to the sound to be played when the egg is done.
     */
    public Egg(String type, String imageName, int boilTime, String soundPath) {
        this.type = type;
        this.imageName = imageName;
        this.boilTime = boilTime;
        this.soundPath = soundPath;
    }

    /**
     * Returns the path to the image file.
     *
     * @return The path to the image file.
     */
    public String getImagePath() {
        return imageName;
    }

    /**
     * Returns the boiling time of the egg in seconds.
     *
     * @return The boiling time in seconds.
     */
    public int getBoilTime() {
        return boilTime;
    }

    /**
     * Returns the type of the egg.
     *
     * @return The type of the egg.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the path to the sound file to be played when the egg is done.
     *
     * @return The path to the sound file.
     */
    public String getSoundPath() {
        return soundPath;
    }
}
