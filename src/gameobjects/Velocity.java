package gameobjects;
/**
 * i.d.: 205949258
 */

import geometric.Point;

/**
 * gameobjects.Velocity class. gameobjects.Velocity specifies the change in position on the `x` and the `y` axes.
 */

public class Velocity {
    //the fields of the class
    private double dx;
    private double dy;

    /**
     * constructor method for gameobjects.Velocity.
     *
     * @param dx - double variable
     * @param dy - double variable
     *           <p>
     *           the method receives two double variables and set's them to be the dx, dy
     *           </p>
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * getDx method. returns the dx component of the velocity
     *
     * @return the dx component of the velocity
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * getDy method. returns the dy component of the velocity
     *
     * @return the dy component of the velocity
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * getVelocity method. returns the velocity
     *
     * @return - our velocity
     */
    public Velocity getVelocity() {
        return this;
    }

    /**
     * setDx method. receives a double variable and set's it to be the dx component of the velocity
     *
     * @param vx - a double variable
     *           <p>
     *           the method receives a double variable and sets it to be the dx component
     *           </p>
     */
    public void setDx(double vx) {
        this.dx = vx;
    }

    /**
     * setDy method. receives a double variable and set's it to be the dy component of the velocity
     *
     * @param vy - a double variable
     *           <p>
     *           the method receives a double variable and sets it to be the dy component
     *           </p>
     */
    public void setDy(double vy) {
        this.dy = vy;
    }

    /**
     * applyToPoint method. Take a point with position (x,y), and return a new point with position (x+dx, y+dy)
     *
     * @param p - a point variable
     *          <p>
     *          the method receives a point, add's to it components the dx, dy respectively and returns the
     *          updated point
     *          </p>
     * @return an updated point
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * fromAngleAndSpeed method. receives a degree and speed, returns the dx, dy components for the velocity
     *
     * @param angle - double variable
     * @param speed - double variable
     *              <p>
     *              the method receives angle and speed. and calculates according to Trigonometric qualities
     *              of the right-angles triangle - it's dx and dy components and returns them
     *              </p>
     * @return velocity object
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, -1 * dy);
    }

    /**
     * getTheSpeed method. returns the speed of the velocity.
     *
     * <p>
     * the method calculates the speed of the velocity( based on dx, dy) and returns it.
     * </p>
     *
     * @return - the speed of the velocity
     */
    public double getTheSpeed() {
        return Math.sqrt(Math.pow(this.dx, 2) + Math.pow(this.dy, 2));
    }

}
