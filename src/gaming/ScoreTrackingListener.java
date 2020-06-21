package gaming;
/**
 * i.d.:205949258
 */

import gameobjects.Ball;
import gameobjects.Block;
import gameinterfaces.HitListener;

/**
 * ScoreTrackingListener class. updates the score counter when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
    //fields
    private Counter currentScore;

    /**
     * constructor method.
     *
     * @param scoreCounter - a counter object
     *                     <p>
     *                     the method receives a counter object and set's our counter to be it
     *                     </p>
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}