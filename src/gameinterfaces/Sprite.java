package gameinterfaces;
/**
 * i.d.: 205949258
 */

import biuoop.DrawSurface;

/**
 * listeners.Sprite interface. implemented by objects that can be drawn to the screen,
 * and not just a background images.
 */
public interface Sprite {
    /**
     * drawOn method. receive an object of type DrawSurface and draw's with it the sprite to the screen
     *
     * @param d - a DrawSurface object
     *          <p>
     *          the method receives a DrawSurface object and draws with it the sprite into the screen
     *          </p>
     */
    void drawOn(DrawSurface d);


    /**
     * timePassed method. notifies the sprite that time has passed
     * <p>
     * the method notifies our sprite object that time had passed.
     * </p>
     */
    void timePassed();

}
