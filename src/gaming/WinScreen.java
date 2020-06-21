package gaming;

/**
 * i.d.: 205949258
 */

import biuoop.DrawSurface;
import gameinterfaces.Animation;

/**
 * EndScreen class. displays the end screen for the win conditions
 */
public class WinScreen implements Animation {
    //fields
    private int score;
    private boolean stop;

    /**
     * constructor method.
     *
     * @param result - an int variable
     *               <p>
     *               the method initializes our fields according to the given parameters
     *               </p>
     */
    public WinScreen(int result) {
        this.score = result;
        this.stop = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + this.score, 32);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
