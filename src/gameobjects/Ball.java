package gameobjects;
/**
 * i.d.: 205949258
 */

import biuoop.DrawSurface;
import gameinterfaces.Collidable;
import collections.GameEnvironment;
import gameinterfaces.Sprite;
import gaming.GameLevel;
import geometric.Line;
import geometric.Point;

import java.awt.Color;

/**
 * gameobjects.Ball class. define the ball: it's fields and methods
 */
public class Ball implements Sprite {
    //the fields of the class
    private Velocity v;
    private Point center;
    private int r;
    private java.awt.Color color;
    private GameEnvironment gameEnvironment;

    /**
     * .
     * constructor method for a ball
     *
     * @param center - a point object
     * @param r      - an int variable, the radius of the ball
     * @param color  - a java.awt.Color object, the color of the ball
     *               <p>
     *               the constructor receives a point, and makes it the center of the ball,
     *               r, the radius of the ball, and a color variable - the color of the ball.
     *               </p>
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * .
     * constructor method for a ball
     *
     * @param center           - a point object
     * @param r                - an int variable, the radius of the ball
     * @param color            - a java.awt.Color object, the color of the ball
     * @param gameEnvironment1 - a game environment object
     *                         <p>
     *                         the constructor receives a point, and makes it the center of the ball,
     *                         r, the radius of the ball, color variable - the color of the ball and
     *                         a game environment to be the ball's one
     *                         </p>
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment1) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment1;
    }

    /**
     * .
     * constructor method for the ball
     *
     * @param x     - x component of the center
     * @param y     - y component of the center
     * @param r     - the size of the ball
     * @param color - the color of the ball
     *              <p>
     *              the constructor receives 2 values and makes them to be the x and y components of the center,
     *              the radius to be the ball's size, and the color to be the ball's color.
     *              </p>
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.v = new Velocity(0, 0);
    }

    /**
     * .
     * convention method
     *
     * @return the x component of the center
     */

    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * .
     * convention method
     *
     * @return the y component of the center
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * .
     * convention method
     *
     * @return the size of the ball
     */
    public int getSize() {
        return this.r;

    }

    /**
     * setCenter method. updates the ball's location
     *
     * @param x1 - a double variable
     * @param y1 - a double variable
     *           <p>
     *           the method receives two doubles and set's them to be the ball's new center
     *           </p>
     */
    public void setCenter(double x1, double y1) {
        this.center = new Point(x1, y1);
    }

    /**
     * setGameEnvironment method. set's our game environment with the given one
     *
     * @param environment - a game environment object
     *                    <p>
     *                    the method receives a game environment object and set's it to be our game environment
     *                    </p>
     */
    public void setGameEnvironment(GameEnvironment environment) {
        this.gameEnvironment = environment;
    }

    /**
     * getGameEnvironment method. returns our game environment object
     *
     * <p>
     * the method returns our game environment object
     * </p>
     *
     * @return - our game environment
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * .
     * convention method
     *
     * @return the color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
        surface.setColor(Color.BLACK);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * setVelocity method. receives a new velocity and set's it to be the velocity of the ball
     *
     * @param v2 - a velocity object
     *           <p>
     *           the method receives a velocity, and set's it to be the ball's velocity.
     *           </p>
     */
    public void setVelocity(Velocity v2) {
        this.v = v2;
    }

    /**
     * setVelocity method. receives two values and set's them to be the ball's velocity's x , y components.
     *
     * @param dx - a double variable.
     * @param dy - a double variable.
     *           <p>
     *           the method receives two double variables and set's them to be the ball's velocity's components.
     *           </p>
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * getVelocity method. returns the velocity of the ball.
     *
     * @return the velocity field of the ball
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * removeFromGame method. removes our ball from the game that was given
     *
     * @param g - a game object
     *             <p>
     *             the method receives a game object, and through it, it removes our ball from the given game
     *             </p>
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
    /**
     * .
     * moveOneStep method. updates the ball's center and it's velocity
     *
     * <p>
     * the method check's for a collision between our ball and the collidables. if there's a collision
     * it set's the ball's center according to it's velocity, and updates the velocity to be after the hit.
     * if there isn't a collision - it moves the ball according to his velocity.
     * </p>
     */
    public void moveOneStep() {
        Point pStart = this.center;
        Point pEnd = this.getVelocity().applyToPoint(this.center);
        Line trajectory = new Line(pStart, pEnd);
        //if there is a collision
        if (this.gameEnvironment.getClosestCollision(trajectory) != null) {
            //refer to the collidable object of the impact
            Collidable block = this.gameEnvironment.getClosestCollision(trajectory).collisionObject();
            /*move the ball to almost the collision point*/
            //refer to the collision point
            Point collision = this.gameEnvironment.getClosestCollision(trajectory).collisionPoint();
            //coming from right
            if (this.getVelocity().getDx() < 0) {
                double y = this.getY();
                this.setCenter(collision.getX() + 1, y);
            }
            //coming from left
            if (this.getVelocity().getDx() > 0) {
                double y = this.getY();
                this.setCenter(collision.getX() - 1, y);
            }
            //coming from beneath
            if (this.getVelocity().getDy() < 0) {
                double x = this.getX();
                this.setCenter(x, collision.getY() + 1);
            }
            //coming from above
            if (this.getVelocity().getDy() > 0) {
                double x = this.getX();
                this.setCenter(x, collision.getY() - 1);
            }
            /*set my velocity based on what's the hit should decide (after getting the current velocity and the
             * collision point*/
            this.setVelocity(block.hit(this, collision, this.getVelocity()));
        } else {
            this.center = this.getVelocity().applyToPoint(this.center);
        }
        //else, if there's not a collision - move it to the end of the trajectory

    }

    /**
     * addToGame method. receives a game object that add's our ball(as a sprite) to his sprite's list
     *
     * @param g - a game object
     *          <p>
     *          the method receives a game object and adds our ball(which is also a sprite object)
     *          to his listeners.Sprite's list
     *          </p>
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }


    /**
     * .
     * moveOneStep method. updates the ball's center with it's velocity
     *
     * @param rightBound - int variable
     * @param leftBound  - int variable
     * @param upperBound - int variable
     * @param lowerBound - int variable
     *                   <p>
     *                   the method set's it's center coordinates with it's velocity's components.
     *                   it also deals with the situation that the ball is out of bounds - with the given parameters:
     *                   the width and height of the screen/frame.
     *                   </p>
     */
    public void moveOneStep(int rightBound, int leftBound, int upperBound, int lowerBound) {
        /*stepping out of bounds of the x axis*/
        //too right
        if (this.getX() + this.r >= rightBound && this.getVelocity().getDx() > 0) {
            this.v.setDx(-1 * this.v.getDx());
            return;
        }
        //too left
        if (this.getX() - this.r <= leftBound && this.getVelocity().getDx() < 0) {
            this.v.setDx(-1 * this.v.getDx());
            return;
        }
        /*stepping out of bounds of the y axis*/
        //too high
        if (this.getY() + this.r >= upperBound && this.getVelocity().getDy() > 0) {
            this.v.setDy(-1 * this.v.getDy());
            return;
        }
        //too low
        if (this.getY() - this.r < lowerBound && this.getVelocity().getDy() < 0) {
            this.v.setDy(-1 * this.v.getDy());
            return;
        }
        this.center = this.getVelocity().applyToPoint(this.center);

    }


}
