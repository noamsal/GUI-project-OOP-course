package geometric;
/**
 * i.d.: 205949258
 */

import java.util.List;

/**
 * geometric.Line class. defines the line: it's fields and methods
 */


public class Line {
    //the fields of the line
    private Point start;
    private Point end;

    /**
     * .
     * constructor method for a line
     *
     * @param x1 - double variable: the x component of the starting point
     * @param y1 - double variable: the y component of the starting point
     * @param x2 - double variable: the x component of the end point
     * @param y2 - double variable: the y component of the end point
     *           <p>
     *           the constructor receives 2 pairs of points and defines them to be:
     *           first pair as the starting point, and the second pair as the end point of the line.
     *           </p>
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * .
     * constructor for a line
     *
     * @param start - a point object
     * @param end   - a point object
     *              <p>
     *              the constructor receives a starting point and set's it to be the line's starting point,
     *              as well as the end point for the end point of the line
     *              </p>
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * length method. returns the length of the line.
     * <p>
     * the method calculates the distance between the start and the end point of the line,
     * and that's the length of the line
     * </p>
     *
     * @return the length of the line
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * middle method. Returns the middle point of the line.
     * <p>
     * the method calculates the middle point between the start and the end point of the line
     * and returns it.
     * </p>
     *
     * @return the middle point between start and end
     */
    public Point middle() {
        double a = (this.start.getX() + this.end.getX()) / 2;
        double b = (this.start.getY() + this.end.getY()) / 2;
        return new Point(a, b);
    }

    /**
     * isIntersecting method. Returns true if the lines intersect, false otherwise
     *
     * @param other - a line object
     *              <p>
     *              the method creates equation for each of the line and checks if there's a mutual point
     *              if so - they are intersecting, else not
     *              </p>
     * @return true if intersecting, false if not.
     */
    public boolean isIntersecting(Line other) {
        double x;
        double y;
        double m1;
        double m2;
        double n1;
        double n2;
        //if both lines are vertical to the x- axis, they're not intersecting
        if (this.start.getX() == this.end.getX() && other.start.getX() == other.end.getX()) {
            return false;
        }
        //if both lines are vertical to the y- axis, they're not intersecting
        if (this.start.getY() == this.end.getY() && other.start.getY() == other.end.getY()) {
            return false;
        }
        //*****our line is vertical to the x- axis and other line's slope isn't*****
        if (this.start.getX() == this.end.getX() && other.start.getX() != other.end.getX()) {
            m2 = ((other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX()));
            x = this.start.getX();
            //if the max x of other is shorter than this's x/min x is bigger than this's x: not intersecting
            if (Math.max(other.start.getX(), other.end.getX()) < x
                    || Math.min(other.start.getX(), other.end.getX()) > x) {
                return false;
            }
            //y of the intersection point of the functions, (not the line's one)
            y = m2 * (x - other.start.getX()) + other.start.getY();
            //if y is bigger than the max y component of two points of our line/other one or smaller than the
            // min y component of our/other line, it's not intersecting
            return !(y > Math.max(this.start.getY(), this.end.getY()))
                    && !(y < Math.min(this.start.getY(), this.end.getY()))
                    && !(y > Math.max(other.start.getY(), other.end.getY()))
                    && !(y < Math.min(other.start.getY(), other.end.getY()));
        }

        //*****other line is vertical to the x- axis and our line's slope isn't*****
        if (other.start.getX() == other.end.getX() && this.start.getX() != this.end.getX()) {
            m1 = ((this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX()));
            x = other.start.getX();
            //if the max x of this is shorter than other's x/min x is bigger than other's x: not intersecting
            if (Math.max(this.start.getX(), this.end.getX()) < x
                    || Math.min(this.start.getX(), this.end.getX()) > x) {
                return false;
            }
            //if y is bigger than the max y component of two points of our line/other one or smaller than the
            // min y component of our/other line, it's not intersecting
            y = m1 * (x - this.start.getX()) + this.start.getY();
            //if y is bigger than the max of two points of our line or smaller, it's not intersecting
            return !(y > Math.max(other.start.getY(), other.end.getY()))
                    && !(y > Math.max(this.start.getY(), this.end.getY()))
                    && !(y < Math.min(other.start.getY(), other.end.getY()))
                    && !(y < Math.min(this.start.getY(), this.end.getY()));
        }

        //*****after none of them is vertical to the x axis*****
        m1 = ((this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX()));
        m2 = ((other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX()));
        n1 = this.end.getY() - m1 * this.end.getX();
        n2 = other.end.getY() - m2 * other.end.getX();
        //coordinates of the intersection point(of the functions) now check if the two lines are intersecting
        x = (n2 - n1) / (m1 - m2);
        y = m1 * x + n1;
        if (y < Math.min(this.start.getY(), this.end.getY())
                || y < Math.min(other.start.getY(), other.end.getY())
                || y > Math.max(this.start.getY(), this.end.getY())
                || y > Math.max(other.start.getY(), other.end.getY())) {
            return false;
        }
        return !(x < Math.min(this.start.getX(), this.end.getX()))
                && !(x < Math.min(other.start.getX(), other.end.getX()))
                && !(x > Math.max(this.start.getX(), this.end.getX()))
                && !(x > Math.max(other.start.getX(), other.end.getX()));
    }

    /**
     * intersectionWith method. Returns the intersection point if the lines intersect, and null otherwise.
     *
     * @param other - a line object
     *              <p>
     *              if there's an intersection point between the two line, it returns it.
     *              else, it returns null.
     *              </p>
     * @return the intersection point if there is, null if there isn't
     */
    public Point intersectionWith(Line other) {
        //if there's an intersection point:
        if (this.isIntersecting(other)) {
            double x;
            double y;
            double m1;
            double m2;
            double n1;
            double n2;
            //other line is vertical to the x axis
            if (other.start.getX() == other.end.getX()) {
                m1 = ((this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX()));
                x = other.start.getX();
                n1 = this.end.getY() - m1 * this.end.getX();
                y = m1 * x + n1;
                return new Point(x, y);
            }
            //if this line is vertical to the x axis
            if (this.start.getX() == this.end.getX()) {
                m2 = ((other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX()));
                x = this.start.getX();
                n2 = other.end.getY() - m2 * other.end.getX();
                y = m2 * x + n2;
                return new Point(x, y);
            }
            //none of them is vertical to the x axis
            m2 = ((other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX()));
            n2 = other.end.getY() - m2 * other.end.getX();
            m1 = ((this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX()));
            n1 = this.end.getY() - m1 * this.end.getX();
            x = (n2 - n1) / (m1 - m2);
            y = m1 * x + n1;
            return new Point(x, y);
        }
        return null;
    }

    /**
     * equals method. return true is the lines are equal, false otherwise
     *
     * @param other - a line object
     *              <p>
     *              the method receives a new line and checks if it's the exact same line as our line.
     *              returns true if so, false if otherwise.
     *              </p>
     * @return true if they're equal, false otherwise
     */
    public boolean equals(Line other) {
        return this.start.getX() == other.start.getX() && this.start.getY() == other.start.getY()
                && this.end.getX() == other.end.getX() && this.end.getY() == other.end.getY();

    }

    /**
     * convention method.
     *
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * convention method.
     *
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * closestIntersectionToStartOfLine method. return the closest intersection point to the start of the line.
     * or null if there aren't any.
     *
     * @param rect - a rectangle object
     *             <p>
     *             the method receives a rectangle. it checks if there are any intersections points
     *             between the line and the rectangle. if so, it returns the closest one to his starting point.
     *             if there aren't any, it returns null.
     *             </p>
     * @return geometric.Point - the closest one to the start point, or null if no intersection.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //create the list of intersection points
        List<Point> pointList = rect.intersectionPoints(this);
        //there's intersection points between our line and the rectangle
        if (!pointList.isEmpty()) {
            //if list holds one point
            if (pointList.size() == 1) {
                return pointList.get(0);
            } else {
                Point close = pointList.get(0); // the returned point
                for (int i = 1; i < pointList.size(); i++) {
                    if (pointList.get(i).distance(this.start) <= close.distance(this.start)) {
                        close = pointList.get(i);
                    }
                }
                return close;
            }
        }
        return null;
    }

    /**
     * isContaining method. checks if a given point is lying on the line.
     *
     * @param point - a point object
     *              <p>
     *              the method receives a point object, and checks if it lies on the line.
     *              return's true if so, false otherwise;
     *              </p>
     * @return - true if the point is on the line, false otherwise
     */
    public boolean isContaining(Point point) {
        double epsilon = 1E-6;
        //parallel to the y- axis
        if (this.start.getX() == this.end.getX()) {
            return Math.abs(point.getX() - this.start.getX()) <= epsilon;
        }
        //parallel to the x - axis
        if (this.start.getY() == this.end.getY()) {
            return Math.abs(point.getY() - this.start.getY()) <= epsilon;
        }
        double m;
        double n;
        m = ((this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX()));
        n = this.end.getY() - m * this.end.getX();
        return Math.abs(point.getY() - (m * point.getX() + n)) <= epsilon;
    }


}
