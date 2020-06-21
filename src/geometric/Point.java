package geometric;
/**
 * i.d.: 205949258
 */


/**
 * geometric.Point class. defines the point: it's fields and it's methods
 */
public class Point {
    //the fields of the point
    private double x;
    private double y;

    /**
     * constructor method for a point.
     *
     * @param x a double variable - coordinate of the point
     * @param y a double variable - coordinate of the point
     *          <p>
     *          the constructor receives 2 double variables, and implement them into the point.
     *          </p>
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     * distance method. returns the distance of this point to the other point
     *
     * @param other - another point
     *              <p>
     *              The method receives a different point, calculates the
     *              distance between that point to our point - according to the
     *              formula of the distance between two points, and returns it.
     *              </p>
     * @return the distance between the two points
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.getX() - other.getX(), 2) + Math.pow(this.getY() - other.getY(), 2));
    }

    /**
     * equal method. return true if the points are equal, false otherwise
     *
     * @param other - another point
     *              <p>
     *              the method receives another point, and checks if it's the same point as our-
     *              by comparing it's components with our point.
     *              returns true if equal, false if not.
     *              </p>
     * @return true if equal, false if not
     */
    public boolean equals(Point other) {
        boolean result = true;
        if (this.x != other.getX() || this.y != other.getY()) {
            result = false;
        }
        return result;
    }

    /**
     * convention function.
     *
     * @return the x component of the point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * convention function.
     *
     * @return the y component of the point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * setX method. receives a double component and sets it to be the x component of the point
     *
     * @param x2 - a double variable
     *           <p>
     *           the method receives a double component and sets it to be the x component of the point
     *           </p>
     */
    void setX(double x2) {
        this.x = x2;
    }

    /**
     * setY method. receives a double component and sets it to be the y component of the point
     *
     * @param y2 - a double variable
     *           <p>
     *           the method receives a double component and sets it to be the y component of the point
     *           </p>
     */
    void setY(double y2) {
        this.y = y2;
    }
}
