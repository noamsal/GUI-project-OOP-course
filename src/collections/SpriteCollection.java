package collections;
/**
 * i.d.: 205949258
 */

import biuoop.DrawSurface;
import gameinterfaces.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * collections.SpriteCollection class. holds a list of Sprites, and can call both drawOn method and timePassed method
 * for all of the sprites in his list
 */
public class SpriteCollection {

    //the list of sprites
    private List<Sprite> sprites;

    /**
     * Constructor method. initialize the sprites list
     * <p>
     * the method initialize the sprites list
     * </p>
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * addSprite method. receives a listeners.Sprite object and add's it into the list.
     *
     * @param sprite - a listeners.Sprite object
     *               <p>
     *               the method receives a listeners.Sprite object and add's it to the sprites list.
     *               </p>
     */
    public void addSprite(Sprite sprite) {
        this.sprites.add(sprite);
    }

    /**
     * removeSprite method. receives a listeners.Sprite object to be removed from the list.
     *
     * @param s - a sprite object
     *          <p>
     *          the method receives a listeners.Sprite object, to be removed from the list
     *          </p>
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * notifyAllTimePassed method. call timePassed() on all the sprites in the list.
     * <p>
     * the method call the timePassed method on all sprites.
     * </p>
     */

    public void notifyAllTimePassed() {
        //create a copy and iterate over it
        List<Sprite> copies = new ArrayList<Sprite>(this.sprites);
        for (Sprite s : copies) {
            s.timePassed();
        }
    }

    /**
     * drawAllOn method. call drawOn method to all the sprites in the list.
     *
     * @param d - a DrawSurface object
     *          <p>
     *          the method receives a DrawSurface object and for each sprite in the list, it call's the
     *          drawOn method, using the d.
     *          </p>
     */
    public void drawAllOn(DrawSurface d) {
        //create a copy and iterate over it
        List<Sprite> copies = new ArrayList<Sprite>(this.sprites);
        for (Sprite s : copies) {
            s.drawOn(d);
        }
    }
}
