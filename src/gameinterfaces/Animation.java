package gameinterfaces;
/**
 * i.d.: 205949258
 */

import biuoop.DrawSurface;

/**
 * Animation interface. all who implies it are capable of setting it's game-logic, and the rules of stopping
 * the game.
 */
public interface Animation {

    /**
     * doOneFrame method. is in charge of the game logic: drawing + moving the objects, and for setting the
     * halting conditions for th game
     *
     * @param d - a DrawSurface object
     *          <p>
     *          the method receives a DrawSurface object, and uses it to draw all of my objects on the screen,
     *          and also to notify all that time has passed. in addition it set's the game's halting conditions
     *          and checks if they appear
     *          </p>
     */
    void doOneFrame(DrawSurface d);

    /**
     * shouldStop method. a self- indicator that tells me whether should we stop or not stop the game
     * <p>
     * the method returns true if we need to stop the game, or false otherwise
     * </p>
     *
     * @return - true if we need to stop, false otherwise
     */
    boolean shouldStop();
}
