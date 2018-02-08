package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Triangle {
    private Point2D point1 = new Point2D();
    private Point2D point2 = new Point2D();
    private Point2D point3 = new Point2D();

    public Triangle(Point2D point1, Point2D point2, Point2D point3) {
        this.point1.setX(point1.getX());
        this.point1.setY(point1.getY());
        this.point2.setX(point2.getX());
        this.point2.setY(point2.getY());
        this.point3.setX(point3.getX());
        this.point3.setY(point3.getY());
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
        return Math.sqrt((getPerimeter() / 2) * (getPerimeter() / 2 - getSide23()) * (getPerimeter() / 2 - getSide13()) * (getPerimeter() / 2 - getSide12()));
    }

    public double getPerimeter() {
        return getSide12() + getSide13() + getSide23();
    }

    public boolean isInside(int x, int y) {
        return (((x - point1.getX()) * (point1.getY() - point2.getY()) - (point1.getX() - point2.getX()) * (y - point1.getY()) > 0 &
                (x - point2.getX()) * (point2.getY() - point3.getY()) - (point2.getX() - point3.getX()) * (y - point2.getY()) > 0 &
                (x - point3.getX()) * (point3.getY() - point1.getY()) - (point3.getX() - point1.getX()) * (y - point3.getY()) > 0)
                ||
                ((x - point1.getX()) * (point1.getY() - point2.getY()) - (point1.getX() - point2.getX()) * (y - point1.getY()) <= 0 &
                        (x - point2.getX()) * (point2.getY() - point3.getY()) - (point2.getX() - point3.getX()) * (y - point2.getY()) <= 0 &
                        (x - point3.getX()) * (point3.getY() - point1.getY()) - (point3.getX() - point1.getX()) * (y - point3.getY()) <= 0)
        );
    }

    public boolean isInside(Point2D point) {
        return (((point.getX() - point1.getX()) * (point1.getY() - point2.getY()) - (point1.getX() - point2.getX()) * (point.getY() - point1.getY()) > 0 &
                (point.getX() - point2.getX()) * (point2.getY() - point3.getY()) - (point2.getX() - point3.getX()) * (point.getY() - point2.getY()) > 0 &
                (point.getX() - point3.getX()) * (point3.getY() - point1.getY()) - (point3.getX() - point1.getX()) * (point.getY() - point3.getY()) > 0)
                ||
                ((point.getX() - point1.getX()) * (point1.getY() - point2.getY()) - (point1.getX() - point2.getX()) * (point.getY() - point1.getY()) <= 0 &
                        (point.getX() - point2.getX()) * (point2.getY() - point3.getY()) - (point2.getX() - point3.getX()) * (point.getY() - point2.getY()) <= 0 &
                        (point.getX() - point3.getX()) * (point3.getY() - point1.getY()) - (point3.getX() - point1.getX()) * (point.getY() - point3.getY()) <= 0)
        );
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
