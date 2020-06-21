package geometric;
/**
 * i.d.: 205949258
 */


import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * geometric.Rectangle class. defines the geometric.Rectangle object, and it's methods.
 */
public class Rectangle {
    /*fields*/
    private double width;
    private double height;
    //points
    private Point upperLeft;
    private Point upperRight;
    //sides
    private Line upperSide;
    private Line rightSide;
    private Line lowerSide;
    private Line leftSide;
    public static final int NUMBER_OF_SIDES = 4;

    /**
     * constructor method. updates the rectangle with location and width/height.
     *
     * @param upperLeft - a point object
     * @param width     - double variable
     * @param height    - double variable
     *                  <p>
     *                  the method receives an upper-left point, width and height and set's them on
     *                  our rectangle, and calculates according to them - the rest of the fields.
     *                  </p>
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        //points
        this.upperRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        Point lowerLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Point lowerRight = new Point(upperRight.getX(), lowerLeft.getY());
        //lines
        this.upperSide = new Line(upperLeft, upperRight);
        this.rightSide = new Line(upperRight, lowerRight);
        this.lowerSide = new Line(lowerRight, lowerLeft);
        this.leftSide = new Line(lowerLeft, upperLeft);
    }


    /**
     * intersectionPoints method. receives a line and Return a (possibly empty) List of intersection points
     * with the specified line.
     *
     * @param line - a line object
     *             <p>
     *             the method receives a line. it creates an array of lines for each one of the four lines
     *             of the rectangle and check's each if he's intersecting with the given line.
     *             if so, it saves the intersection point in a List and returns it
     *             </p>
     * @return geometric.Line - a line filled with the intersection points
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        //create a list of Points
        List<Point> pointList = new ArrayList<Point>();
        /*insert the lines of the rectangle into an array*/
        Line[] lines = new Line[NUMBER_OF_SIDES];
        //upperSide of the rectangle
        lines[0] = this.upperSide;
        //rightSide of the rectangle
        lines[1] = this.rightSide;
        //lowerSide of the rectangle
        lines[2] = this.lowerSide;
        //leftSide of the rectangle
        lines[3] = this.leftSide;
        /*check intersection for each and save the points in the list*/
        for (Line x : lines) {
            if (x.isIntersecting(line)) {
                pointList.add(x.intersectionWith(line));
            }
        }
        return pointList;
    }

    /**
     * convention method.
     *
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * convention method.
     *
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * convention method.
     *
     * @return the upperLeft point of the rectangle
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * convention method.
     *
     * @return the upperRight point of the rectangle
     */
    public Point getUpperRight() {
        return this.upperRight;


    }

    /**
     * convention method.
     *
     * @return - the upperSide of the rectangle
     */
    public Line getUpperSide() {
        return this.upperSide;
    }

    /**
     * convention method.
     *
     * @return - the rightSide of the rectangle
     */
    public Line getRightSide() {
        return this.rightSide;
    }

    /**
     * convention method.
     *
     * @return - the lowerSide of the rectangle
     */
    public Line getLowerSide() {
        return this.lowerSide;
    }

    /**
     * convention method.
     *
     * @return - the leftSide of the rectangle
     */
    public Line getLeftSide() {
        return this.leftSide;
    }

    /**
     * drawRectangle method. draws the rectangle
     *
     * @param d - a DrawSurface object
     * @param color - a java.awt.Color
     *          <p>
     *          the method receives a DrawSurface object and a color, and draws our rectangle according
     *          to the given color
     *          </p>
     */
    public void drawRectangle(DrawSurface d, java.awt.Color color) {
        d.setColor(color);
        d.fillRectangle((int) this.getUpperLeft().getX(), (int) this.getUpperLeft().getY()
                , (int) this.getWidth(), (int) this.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.getUpperLeft().getX(), (int) this.getUpperLeft().getY()
                , (int) this.getWidth(), (int) this.getHeight());
    }

}
