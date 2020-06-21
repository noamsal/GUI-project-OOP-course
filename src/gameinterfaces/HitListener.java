package gameinterfaces;
/**
 * i.d.: 205949258
 */

import gameobjects.Ball;
import gameobjects.Block;

/**
 * listeners.HitListener class. all who implements this interface are willing to hear about a collision
 * and so - need to be registered at the notifier
 */
public interface HitListener {

    // This method
    // The hitter parameter is the gameobjects.Ball that's doing the hitting.

    /**
     * hitEvent method. is called whenever the beingHit object is hit.
     *
     * @param beingHit - a gameobjects.Block object
     * @param hitter - a gameobjects.Ball object
     *               <p>
     *               the method receives the gameobjects.Block was hit, and also receives the hitting ball
     *               as a parameter
     *               </p>
     */
    void hitEvent(Block beingHit, Ball hitter);
}
