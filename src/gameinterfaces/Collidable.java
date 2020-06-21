package gameinterfaces;
/**
 * i.d.: 205949258
 */

import gameobjects.Ball;
import gameobjects.Velocity;
import geometric.Point;
import geometric.Rectangle;

/**
 * listeners.Collidable interface. will be implemented by objects that can be collided with.
 * defines: 1) size and place
 * 2) what shall happen when hit
 */
public interface Collidable {
    /**
     * getCollisionRectangle method. returns the shape of the block - a rectangle
     * <p>
     * the method returns the block's shape
     * </p>
     *
     * @return - the block's shape
     */
    Rectangle getCollisionRectangle();

    /**
     * hit method. receives a collision point and a velocity and returns the new velocity
     * expected after the hit (based on
     * (the force the object inflicted on us).
     *
     * @param collisionPoint  - the collision point
     * @param currentVelocity - the velocity at impact
     * @param hitter - the hitting ball
     *                        <p>
     *                        the method receives the collision point, the impacting ball
     *                        and a current velocity at the time of the strike, and returns the velocity
     *                        to be set after the strike, and notifies all of his the listeners(if he has any)
     *                        </p>
     * @return - the velocity expected after the hit
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
