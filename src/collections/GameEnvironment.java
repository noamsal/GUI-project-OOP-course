package collections;
/**
 * i.d.: 205949258
 */

import gameobjects.Block;
import geometric.Line;
import geometric.Point;
import geometric.Rectangle;
import gameinterfaces.Collidable;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * collections.GameEnvironment class. hold's a collection of obstacles in the game, and returns
 * information about the next collision
 */
public class GameEnvironment {
    //the list of collidables
    private List<Collidable> collidables;

    /**
     * Constructor method. initialize the Collidables list
     * <p>
     * the method initialize the listeners.Collidable list
     * </p>
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();

    }

    /**
     * addCollidable method. receives a listeners.Collidable object and add's it into the list.
     *
     * @param c - a listeners.Collidable object
     *          <p>
     *          the method receives a listeners.Collidable object and add's it to the listeners.Collidable list
     *          </p>
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * removeCollidable method. receives a collidable object to be removed from the list
     *
     * @param c - a collidable object
     *          <p>
     *          the method receives a collidable object, and removes it from the list
     *          </p>
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * getClosestCollision method. receives a trajectory of the moving object and returns information about
     * the incoming impact.
     *
     * @param trajectory - a line object
     *                   <p>
     *                   Assume an object moving from line.start() to line.end().
     *                   If this object will not collide with any of the collidables
     *                   in this collection, return null. Else, return the information
     *                   about the closest collision that is going to occur.
     *                   </p>
     * @return - the collision information: point of intersection and the collidable object
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        //create a copy and iterate over it
        List<Collidable> copies = new ArrayList<Collidable>(this.collidables);
        int i = 0;
        /*go over the collidable list and refer to one of the collidables which is suppose to get hit -
         * in order to refer to it's closest intersection point with the trajectory - later on */
        Point closestPoint = new Point(0, 0);
        for (Collidable c : copies) {
            //the current collidable is on the way of the trajectory
            if (trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle()) != null) {
                closestPoint = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
                i++;
            }
        }
        if (i == 0) {
            return null;
        }
        //create a new Collision info object to be returned later on
        CollisionInfo info = new CollisionInfo(0, 0, new Block(new Rectangle(new Point(0, 0)
                , 0, 0), Color.BLACK));
        /*move on the collidable list, and check for each collidable that's actually colliding - whether
         * the distance between it's intersection point with trajectory and the trajectory's starting point
         * is closer then closePoint's one. if so, replace close point with the collidable one */
        for (Collidable c : copies) {
            //collision is about to happen
            if (trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle()) != null) {
                //the current collidable's closest point
                Point p1 = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
                //if that point's distance from start is shorter, set him at the new collision info
                if (p1.distance(trajectory.start()) <= closestPoint.distance(trajectory.start())) {
                    closestPoint = p1;
                    info.setInfo(closestPoint, c);
                }
            }
        }
        return info;
    }
}
