package gameobjects;
/**
 * i.d.: 205949258
 */

import biuoop.DrawSurface;
import gameinterfaces.Collidable;
import gameinterfaces.Sprite;
import gaming.GameLevel;
import geometric.Point;
import geometric.Rectangle;
import gameinterfaces.HitListener;
import gameinterfaces.HitNotifier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * gameobjects.Block class. implements listeners.Collidable interface.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    //fields
    private Rectangle rectangle;
    private Color color1;
    private List<HitListener> hitListeners;

    /**
     * constructor method. receives a rectangle and a color and set's our fields to be like them
     *
     * @param rectangle1 - a rectangle object
     * @param paint      - a point object
     *                   <p>
     *                   the method receives a rectangle and a color and set's our fields to be synchronize with them
     *                   </p>
     */
    public Block(Rectangle rectangle1, Color paint) {
        this.rectangle = rectangle1;
        this.color1 = paint;
        this.hitListeners = new ArrayList<HitListener>();
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity v = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        /*hit on the right/left side*/
        if (this.rectangle.getRightSide().isContaining(collisionPoint)
                || this.rectangle.getLeftSide().isContaining(collisionPoint)) {
            v.setDx(-1 * v.getDx());
        }
        /*hit on the upper/lower side*/
        if (this.rectangle.getUpperSide().isContaining(collisionPoint)
                || this.rectangle.getLowerSide().isContaining(collisionPoint)) {
            v.setDy(-1 * v.getDy());
        }
        this.notifyHit(hitter);
        return v;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        this.rectangle.drawRectangle(surface, this.color1);
    }

    @Override
    public void timePassed() {

    }

    /**
     * addToGame method. receives a game object that add's our gameobjects.Block
     * (as a sprite and as a listeners.Collidable)
     * to his sprite's and Collidables list
     *
     * @param g - a game object
     *          <p>
     *          the method receives a game object and adds our gameobjects.Block
     *          (which is both a sprite and a listeners.Collidable object)
     *          to his listeners.Sprite's and listeners.Collidable's list
     *          </p>
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * getColor method. returns the block's color
     *
     * <p>
     * the method returns the color of the block
     * </p>
     *
     * @return - a color object
     */
    public Color getColor() {
        return this.color1;
    }

    /**
     * removeFromGame method. removes our block from the game that was given
     *
     * @param game - a game object
     *             <p>
     *             the method receives a game object, and through it, it removes our block from the given game
     *             </p>
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * notifyHit method. the method tells all our listeners if there is a collision
     *
     * @param hitter - a ball object
     *               <p>
     *               the method is been called via the hit method. it receives the collision ball from it,
     *               and then, going on each one of his listeners and calls their hitEvent method.
     *               </p>
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
