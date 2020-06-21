package gaming;
/**
 * i.d.: 205949258
 */

import biuoop.DrawSurface;
import gameinterfaces.Animation;

/**
 * PauseScreen class. an object that is in charge of pausing and resuming the game
 */
public class PauseScreen implements Animation {
    //fields
    private boolean stop;

    /**
     * constructor method.
     *
     * <p>
     * the method initializes the boolean field
     * </p>
     */
    public PauseScreen() {
        this.stop = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
