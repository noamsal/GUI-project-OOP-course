package collections;
/**
 * i.d.: 205949258
 */

import geometric.Point;
import gameinterfaces.Collidable;

/**
 * collections.CollisionInfo class. holds information of the collision:
 * the point of collision and the listeners.Collidable
 * object.
 */
public class CollisionInfo {
    //fields
    private Point collisionPoint;
    private Collidable obstacle;

    /**
     * constructor method.
     * <p>
     * receives a collision point and a listeners.Collidable obstacle and implements them
     * * to be the Collision info's one
     * </p>
     *
     * @param collisionPoint - a geometric.Point of collision
     * @param obstacle       - a listeners.Collidable object.
     */
    public CollisionInfo(Point collisionPoint, Collidable obstacle) {
        this.collisionPoint = collisionPoint;
        this.obstacle = obstacle;
    }

    /**
     * constructor method. receives two doubles for a point,
     * and an listeners.Collidable object and implements them to be
     * our collision info
     *
     * @param x         - a double variable
     * @param y         - a double variable
     * @param obstacle1 - a collidable object
     *                  <p>
     *                  the method receives 2 doubles and set's them to be the point of the info,
     *                  and a collidable object, to be the info's collidable object
     *                  </p>
     */
    public CollisionInfo(double x, double y, Collidable obstacle1) {
        this.collisionPoint = new Point(x, y);
        this.obstacle = obstacle1;

    }

    /**
     * collisionPoint method. returns the collision point
     * <p>
     * the method returns the collision point
     * </p>
     *
     * @return - the collision point
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * collisionObject method. the method returns the collidable object involved in the collision.
     * <p>
     * the method returns the collidable object of the impact
     * </p>
     *
     * @return - a collidable object
     */
    public Collidable collisionObject() {
        return this.obstacle;
    }

    /**
     * setInfo method. receives parameters and set's them to be the info's one
     *
     * @param p1   - a point object
     * @param coll - a collidable object
     *             <p>
     *             the method receives a point and a collidable and set's them to be the info's one
     *             </p>
     */
    public void setInfo(Point p1, Collidable coll) {
        this.collisionPoint = p1;
        this.obstacle = coll;
    }
}
