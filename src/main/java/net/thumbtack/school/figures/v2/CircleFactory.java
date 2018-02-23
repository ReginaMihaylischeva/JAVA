package net.thumbtack.school.figures.v2;

public class CircleFactory {
    private static int circlecount;

    public static Circle createCircle(Point2D center, int radius, int color) {
        circlecount++;
        return new Circle(center, radius, color);
    }

    public static int getCircleCount() {
        return circlecount;
    }

    public static void reset() {
        circlecount = 0;
    }
}
