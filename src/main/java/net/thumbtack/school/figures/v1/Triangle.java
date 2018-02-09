package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Triangle {
    private Point2D point1;
    private Point2D point2;
    private Point2D point3;

    public Triangle(Point2D point1, Point2D point2, Point2D point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public Point2D getPoint1() {
        return point1;
    }

    public Point2D getPoint2() {
        return point2;
    }

    public Point2D getPoint3() {
        return point3;
    }

    public void setPoint1(Point2D point) {
        this.point1 = point;
    }

    public void setPoint2(Point2D point) {
        this.point2 = point;
    }

    public void setPoint3(Point2D point) {
        this.point3 = point;
    }

    public double getSide12() {
        return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) + Math.pow(point2.getY() - point1.getY(), 2));
    }

    public double getSide13() {
        return Math.sqrt(Math.pow(point3.getX() - point1.getX(), 2) + Math.pow(point3.getY() - point1.getY(), 2));
    }

    public double getSide23() {
        return Math.sqrt(Math.pow(point3.getX() - point2.getX(), 2) + Math.pow(point3.getY() - point2.getY(), 2));
    }

    public void moveRel(int dx, int dy) {
        point1.moveRel(dx, dy);
        point2.moveRel(dx, dy);
        point3.moveRel(dx, dy);
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - getSide23()) * (p - getSide13()) * (p - getSide12()));
    }

    public double getPerimeter() {
        return getSide12() + getSide13() + getSide23();
    }

    public boolean isInside(int x, int y) {
        return ((((point1.getX() <= x && x <= point2.getX())
                || (point1.getX() <= x && x <= point3.getX())
                || (point2.getX() <= x && x <= point3.getX()))
                &&
                ((point1.getY() <= y && y <= point2.getY()) ||
                        (point1.getY() <= y && y <= point3.getY()) ||
                        (point2.getY() <= y && y <= point3.getY()))));

    }

    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(point1, triangle.point1) &&
                Objects.equals(point2, triangle.point2) &&
                Objects.equals(point3, triangle.point3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(point1, point2, point3);
    }
}
