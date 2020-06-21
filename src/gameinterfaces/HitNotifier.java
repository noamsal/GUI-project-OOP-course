package gameinterfaces;
/**
 * i.d.: 205949258
 */

/**
 * listeners.HitNotifier class. all who implements it will be considered as listeners of a collision
 */
public interface HitNotifier {

    /**
     * addHitListener method. adds a listener to him to be updated about collision
     *
     * @param hl - a listeners.HitListener object
     *           <p>
     *           the method receives a listeners.HitListener object, and adds him to be one of his listeners
     *           </p>
     */
    void addHitListener(HitListener hl);
    // Remove hl from the list of listeners to hit events.

    /**
     * removeHitListener method. receives a listeners.HitListener object to be removed from his listeners list
     *
     * @param hl - a listeners.HitListener object
     *           <p>
     *           the method receives a listeners.HitListener, and removes it from our list of listeners
     *           </p>
     */
    void removeHitListener(HitListener hl);
}
