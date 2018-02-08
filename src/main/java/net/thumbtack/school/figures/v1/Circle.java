package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Circle {
    private Point2D center = new Point2D();
    private int raduis;

    public Circle(Point2D center, int raduis) {
        this(center.getX(), center.getY(), raduis);
    }

    public Circle(int xCenter, int yCenter, int radius) {
        this.center.setX(xCenter);
        this.center.setY(yCenter);
        this.raduis = radius;
    }

    public Circle(int radius) {
        this(0, 0, radius);
    }

    public Circle() {
        this(1);
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
        this.center = center;
        raduis = raduis * n;
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
                Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {

        return Objects.hash(center, raduis);
    }


}
