package gaming;
/**
 * i.d.: 205949258
 */

import gameobjects.Ball;
import gameobjects.Block;
import gameinterfaces.HitListener;

/**
 * gaming.BallRemover class. in charge of removing balls, and updating an available-balls counter
 */
public class BallRemover implements HitListener {
    //fields
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor method.
     *
     * @param game1           - a game object
     * @param ballsRemaining - a counter object
     *                        <p>
     *                        the method receives both a game and a counter object, and set's them to be our fields
     *                        </p>
     */
    public BallRemover(GameLevel game1, Counter ballsRemaining) {
        this.game = game1;
        this.remainingBalls = ballsRemaining;
    }


    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        //remove it from the game
        hitter.removeFromGame(this.game);
        //decrease the number of Balls in the game
        this.remainingBalls.decrease(1);

    }
}
