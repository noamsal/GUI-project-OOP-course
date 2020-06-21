package gaming;
/**
 * i.d.: 205949258
 */

import biuoop.DrawSurface;
import biuoop.GUI;
import gameinterfaces.Animation;

import static gaming.GameLevel.SCREEN_H;
import static gaming.GameLevel.SCREEN_W;

/**
 * AnimationRunner class. in charge of the gaming loop.
 */
public class AnimationRunner {
    //fields
    private GUI gui;
    private int framesPerSecond;
    private biuoop.Sleeper sleeper;

    /**
     * constructor method.
     *
     * <p>
     * the method initialize our fields
     * </p>
     */
    public AnimationRunner() {
        this.gui = new GUI("Arkanoid", SCREEN_W, SCREEN_H);
        this.framesPerSecond = 60;
        this.sleeper = new biuoop.Sleeper();
    }

    /**
     * run method. runs the animation loop
     *
     * @param animation - an animation object
     *                  <p>
     *                  the method runs the given animation, and stops according to the animation's stopping condition
     *                  </p>
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * getGui method. returns our gui member
     * <p>
     * the method returns our gui member
     * </p>
     *
     * @return - a gui object
     */
    public GUI getGui() {
        return this.gui;
    }
}