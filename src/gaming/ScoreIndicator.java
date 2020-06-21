package gaming;
/**
 * i.d.:205949258
 */

import biuoop.DrawSurface;
import gameinterfaces.Sprite;

import java.awt.Color;

/**
 * ScoreIndicator class. in charge of displaying the current score
 */
public class ScoreIndicator implements Sprite {
    //fields
    private Counter currentScore;
    private String levelName;

    /**
     * constructor method.
     *
     * @param scoreCounter - a Counter object
     * @param levelName    - a String object
     *                     <p>
     *                     the method receives a counter and a string of the current level,
     *                     and set's it's fields according to it
     *                     </p>
     */
    public ScoreIndicator(Counter scoreCounter, String levelName) {
        this.currentScore = scoreCounter;
        this.levelName = levelName;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(375, 15, "score: " + this.currentScore.getValue(), 20);
        d.drawText(550, 15, "Level Name: " + this.levelName, 20); //level name
    }

    @Override
    public void timePassed() {

    }
    /**
     * addToGame method. receives a game object that add's our ScoreIndicator(as a sprite) to his sprite's list
     *
     * @param g - a game object
     *          <p>
     *          the method receives a game object and adds our ScoreIndicator(which is also a sprite object)
     *          to his listeners.Sprite's list
     *          </p>
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

}
