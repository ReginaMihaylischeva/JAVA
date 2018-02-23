package net.thumbtack.school.figures.v2;

public abstract class Figure implements Colored {
    private int color;

    public abstract void moveRel(int dx, int dy);

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract boolean isInside(int x, int y);

    public abstract boolean isInside(Point2D point);

    public void setColor(int color) {
        this.color = color;
    }


    public int getColor() {
        return color;
    }

}
