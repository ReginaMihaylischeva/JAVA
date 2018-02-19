package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Rectangle3D extends Rectangle {
    private int height;

    public Rectangle3D(Point2D leftTop, Point2D rightBottom, int height) {
        super(leftTop, rightBottom);
        this.height = height;
    }

    public Rectangle3D(int xLeft, int yTop, int xRight, int yBottom, int height) {
        this( new Point2D(xLeft, yTop), new Point2D(xRight, yBottom),height);
    }

    public Rectangle3D(int length, int width, int height) {
       this( 0, -width, length, 0,height);
    }

    public Rectangle3D() {
        this(1, 1, 1);
    }

    public int getHeight() {
        return height;
    }


    public void setHeight(int height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea() * getHeight();
    }

    public boolean isInside(int x, int y, int z) {
        return (isInside(x, y) && z <= getHeight() && z >= 0);
    }

    public boolean isInside(Point3D point) {
        return isInside(point.getX(), point.getY(), point.getZ());
    }

    public boolean isInside(Rectangle3D rectangle) {
        return ((height >= rectangle.getHeight() && super.isInside(rectangle)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle3D that = (Rectangle3D) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), height);
    }
}
