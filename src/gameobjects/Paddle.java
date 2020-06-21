package gameobjects;
/**
 * i.d.: 205949258
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import gameinterfaces.Collidable;
import gameinterfaces.Sprite;
import gaming.GameLevel;
import geometric.Point;
import geometric.Rectangle;

import java.awt.Color;

/**
 * gameobjects.Paddle class. represent the player in the game - a rectangle controlled by the arrow keys.
 */
public class Paddle implements Sprite, Collidable {
    //fields
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private int speed;
    //boundaries for the left x
    private double rightBound;
    public static final double LEFT_BOUND = 25;

    /**
     * constructor method. receives a rectangle, color and a keyboard sensor and implements them to be our.
     *
     * @param rectangle1 - a rectangle object.
     * @param keyboard1  - a KeyboardSensor object.
     *                   <p>
     *                   the method receives a rectangle, color and a keyboard sensor objects and set's each field
     *                   to the right one.
     *                   </p>
     */
    public Paddle(Rectangle rectangle1, KeyboardSensor keyboard1) {
        this.rectangle = rectangle1;
        this.keyboard = keyboard1;
        this.rightBound = 780 - this.rectangle.getWidth();
    }

    /**
     * constructor method. receives a rectangle, color, speed and a keyboard sensor and implements them to be our.
     *
     * @param rec    - a rectangle object.
     * @param kBoard - a KeyboardSensor object.
     * @param moveDistance  - an int variable
     *               <p>
     *               the method receives a rectangle, color, speed and a keyboard sensor objects
     *               and set's each field to the right one.
     *               </p>
     */
    public Paddle(Rectangle rec, KeyboardSensor kBoard, int moveDistance) {
        this.rectangle = rec;
        this.keyboard = kBoard;
        this.rightBound = 775 - this.rectangle.getWidth();
        this.speed = moveDistance;
    }

    /**
     * moveLeft method. moves the paddle to the left, if it isn't out of bounds
     * <p>
     * the method moves our paddle to the left, if it isn't out of bounds
     * </p>
     */


    public void moveLeft() {
        if ((this.rectangle.getUpperLeft().getX() - speed) >= LEFT_BOUND) {
            Point upperLeftNew = new Point(this.rectangle.getUpperLeft().getX() - speed
                    , this.rectangle.getUpperLeft().getY());
            this.rectangle = new Rectangle(upperLeftNew, this.rectangle.getWidth(), this.rectangle.getHeight());
        } else {
            this.rectangle = new Rectangle(new Point(LEFT_BOUND, this.rectangle.getUpperLeft().getY()),
                    this.rectangle.getWidth(), this.rectangle.getHeight());
        }
    }

    /**
     * moveRight method. moves the paddle to the right, if it isn't out of bounds
     * <p>
     * the method moves our paddle to the right, if it isn't out of bounds
     * </p>
     */
    public void moveRight() {
        if ((this.rectangle.getUpperLeft().getX() + speed) <= rightBound) {
            Point upperLeftNew = new Point(this.rectangle.getUpperLeft().getX() + speed
                    , this.rectangle.getUpperLeft().getY());
            this.rectangle = new Rectangle(upperLeftNew, this.rectangle.getWidth(), this.rectangle.getHeight());
        } else {
            this.rectangle = new Rectangle(new Point(rightBound, this.rectangle.getUpperLeft().getY()),
                    this.rectangle.getWidth(), this.rectangle.getHeight());
        }
    }

    // listeners.Sprite
    @Override
    public void timePassed() {
        //left key is pressed
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        //right key is pressed
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }

    }

    @Override
    public void drawOn(DrawSurface d) {
        this.rectangle.drawRectangle(d, Color.ORANGE);
    }

    // listeners.Collidable
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }


    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double partitionLength = this.rectangle.getWidth() / 5;
        //collision at first part
        if (this.rectangle.getUpperLeft().getX() <= collisionPoint.getX()
                && collisionPoint.getX() < this.rectangle.getUpperLeft().getX() + partitionLength) {
            return Velocity.fromAngleAndSpeed(-60, currentVelocity.getTheSpeed());
        }
        //collision at second part
        if ((this.rectangle.getUpperLeft().getX() + partitionLength) <= collisionPoint.getX()
                && collisionPoint.getX() < (this.rectangle.getUpperLeft().getX() + 2 * partitionLength)) {
            return Velocity.fromAngleAndSpeed(-30, currentVelocity.getTheSpeed());
        }
        //collision at the middle
        if ((this.rectangle.getUpperLeft().getX() + 2 * partitionLength) <= collisionPoint.getX()
                && collisionPoint.getX() < (this.rectangle.getUpperLeft().getX() + 3 * partitionLength)) {
            return new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }
        //collision at the fourth part
        if ((this.rectangle.getUpperLeft().getX() + 3 * partitionLength) <= collisionPoint.getX()
                && collisionPoint.getX() < (this.rectangle.getUpperLeft().getX() + 4 * partitionLength)) {
            return Velocity.fromAngleAndSpeed(30, currentVelocity.getTheSpeed());
        }
        //collision at the fifth part
        if ((this.rectangle.getUpperLeft().getX() + 4 * partitionLength) <= collisionPoint.getX()
                && collisionPoint.getX() <= (this.rectangle.getUpperLeft().getX() + 5 * partitionLength)) {
            return Velocity.fromAngleAndSpeed(60, currentVelocity.getTheSpeed());
        }
        /*collision at the edges*/
        if (this.rectangle.getRightSide().isContaining(collisionPoint)
                || this.rectangle.getLeftSide().isContaining(collisionPoint)) {
            return new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        }
        return currentVelocity;

    }


    /**
     * addToGame method. receives a game object that add's our gameobjects.Paddle
     * (as a sprite and as a listeners.Collidable)
     * to his sprite's and Collidables list
     *
     * @param g - a game object
     *          <p>
     *          the method receives a game object and adds our gameobjects.Paddle
     *          (which is both a sprite and a listeners.Collidable object)
     *          to his listeners.Sprite's and listeners.Collidable's list
     *          </p>
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}