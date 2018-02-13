package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Rectangle {
    private Point2D leftTop;
    private Point2D rightBottom;

    public Rectangle(Point2D leftTop, Point2D rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
      this( new Point2D(xLeft, yTop), new Point2D(xRight, yBottom));
    }

    public Rectangle(int length, int width) {
        this(0, -width, length, 0);
    }

    public Rectangle() {
        this(1, 1);
    }

    public Point2D getTopLeft() {
        return leftTop;
    }

    public Point2D getBottomRight() {
        return rightBottom;
    }

    public void setTopLeft(Point2D topLeft) {
        this.leftTop = topLeft;
    }

    public void setBottomRight(Point2D bottomRight) {
        this.rightBottom = bottomRight;
    }

    public int getLength() {
        return (rightBottom.getX() - leftTop.getX());
    }

    public int getWidth() {
        return rightBottom.getY() - leftTop.getY();
    }

    public void moveRel(int dx, int dy) {
        leftTop.moveRel(dx, dy);
        rightBottom.moveRel(dx, dy);
    }

    public void enlarge(int nx, int ny) {
        rightBottom.moveRel(getLength() * (nx - 1), getWidth() * (ny - 1));
    }

    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    public boolean isInside(int x, int y) {
        return ((leftTop.getX() <= x) && (x <= rightBottom.getX()) && (leftTop.getY() <= y) && (y <= rightBottom.getY()));
    }

    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Rectangle rectangle) {
        return (isInside(rectangle.getTopLeft())
                || isInside(rectangle.getBottomRight())
                || (rectangle.isInside(leftTop)) || (rectangle.isInside(rightBottom))
        );

    }

    public boolean isInside(Rectangle rectangle) {
        return ((isInside(rectangle.leftTop) && isInside(rectangle.rightBottom)));

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(leftTop, rectangle.leftTop) &&
                Objects.equals(rightBottom, rectangle.rightBottom);
    }

    @Override
    public int hashCode() {

        return Objects.hash(leftTop, rightBottom);
    }
}
