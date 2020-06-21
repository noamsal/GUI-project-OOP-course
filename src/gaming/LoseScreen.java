package gaming;

/**
 * i.d.: 205949258
 */

import biuoop.DrawSurface;
import gameinterfaces.Animation;

/**
 * LoseScreen class. displays the end screen for the lost conditions
 */

public class LoseScreen implements Animation {
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
    public LoseScreen(int result) {
        this.score = result;
        this.stop = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + this.score, 32);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}

