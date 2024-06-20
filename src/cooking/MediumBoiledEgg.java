package cooking;

import util.TimeUtil;

/**
 * Represents a medium-boiled egg.
 * This class extends Egg to provide details specific to a medium-boiled egg.
 *
 * @author Daniel Aigbe
 * @version 1.0
 * @date 16/04/2024
 */
public class MediumBoiledEgg extends Egg {
    public MediumBoiledEgg() {
        super("medium", "C:\\Users\\danny\\OneDrive - Technological University Dublin\\Year 2\\Semester 2\\Advanced Programming\\ass\\src\\resources\\images\\medium-boiled-egg.jpg", TimeUtil.MEDIUM_BOIL_TIME, "C:\\Users\\danny\\OneDrive - Technological University Dublin\\Year 2\\Semester 2\\Advanced Programming\\ass\\src\\resources\\sounds\\CHIME2.WAV");
    }
}
