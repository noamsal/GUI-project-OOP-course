package gaming;
/**
 * i.d.: 205949258
 */

import biuoop.DrawSurface;
import collections.SpriteCollection;
import gameinterfaces.Animation;

import java.awt.Color;

/**
 * CountdownAnimation class. in charge of displaying the pre-game countdown clock
 */
public class CountdownAnimation implements Animation {
    //fields
    private double seconds;
    private int startFrom;
    private double counter = 0;
    private SpriteCollection collection;
    private boolean stop;
    private biuoop.Sleeper sleeper = new biuoop.Sleeper();

    /**
     * constructor method.
     *
     * @param numOfSeconds - a double var
     * @param countFrom    - an int var
     * @param gameScreen   - a SpriteCollection object
     *                     <p>
     *                     the method receives the number of second for the countdown, from which number,
     *                     and the game's list of sprites and set's our fields according to them
     *                     </p>
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.seconds = numOfSeconds;
        this.startFrom = countFrom;
        this.collection = gameScreen;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.counter == 3) {
            this.stop = true;
        }
        double x = this.seconds / this.startFrom;
        this.collection.drawAllOn(d);
        d.setColor(Color.RED);
        d.drawText(375, 400, (int) (this.startFrom - this.counter) + "...", 50);
        this.sleeper.sleepFor((long) (x * 1000));
        ++this.counter;
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
