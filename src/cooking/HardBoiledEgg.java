package cooking;

import util.TimeUtil;

/**
 * Represents a hard-boiled egg.
 * This class extends Egg to provide details specific to a hard-boiled egg.
 *
 * @author Daniel Aigbe
 * @version 1.0
 * @date 16/04/2024
 */
public class HardBoiledEgg extends Egg {
    public HardBoiledEgg() {
        super("hard", "C:\\Users\\danny\\OneDrive - Technological University Dublin\\Year 2\\Semester 2\\Advanced Programming\\ass\\src\\resources\\images\\hard-boiled-egg.jpg", TimeUtil.HARD_BOIL_TIME, "C:\\Users\\danny\\OneDrive - Technological University Dublin\\Year 2\\Semester 2\\Advanced Programming\\ass\\src\\resources\\sounds\\CHIME2.WAV");
    }
}
