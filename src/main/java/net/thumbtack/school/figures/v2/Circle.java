package net.thumbtack.school.figures.v2;

import java.util.Objects;

public class Circle extends Figure {
    private Point2D center;
    private int raduis;

    public Circle(Point2D center, int raduis, int color) {
        this(center.getX(), center.getY(), raduis, color);
    }

    public Circle(int xCenter, int yCenter, int radius, int color) {
        center = new Point2D(xCenter, yCenter);
        this.raduis = radius;
        setColor(color);
    }

    public Circle(int radius, int color) {
        this(0, 0, radius, color);
    }

    public Circle(int color) {
        this(1, color);
    }

    public Point2D getCenter() {
        return center;
    }

    public int getRadius() {
        return raduis;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public void setRadius(int radius) {
        this.raduis = radius;
    }

    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }

    public void enlarge(int n) {
        raduis *= n;
    }

    public double getArea() {
        return Math.PI * Math.pow(raduis, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * raduis;
    }

    public boolean isInside(int x, int y) {
        return (Math.pow(x - center.getX(), 2) + Math.pow(y - center.getY(), 2) <= raduis * raduis);
    }

    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return raduis == circle.raduis &&
                getColor() == circle.getColor() &&
                Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {

        return Objects.hash(center, raduis, getColor());
    }


}
