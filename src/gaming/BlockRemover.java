package gaming;
/**
 * i.d.: 205949258
 */

import gameobjects.Ball;
import gameobjects.Block;
import gameinterfaces.HitListener;

/**
 * gaming.BlockRemover class. a gaming.BlockRemover is in charge of removing blocks from the game,
 * as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    //fields
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor method.
     *
     * @param game1           - a game object
     * @param blocksRemaining - a counter object
     *                        <p>
     *                        the method receives both a game and a counter object, and set's them to be our fields
     *                        </p>
     */
    public BlockRemover(GameLevel game1, Counter blocksRemaining) {
        this.game = game1;
        this.remainingBlocks = blocksRemaining;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        //first, remove from the upcoming deleted block - this listener
        beingHit.removeHitListener(this);
        //remove it from the game
        beingHit.removeFromGame(this.game);
        //decrease the number of blocks in the game
        this.remainingBlocks.decrease(1);
    }

}
