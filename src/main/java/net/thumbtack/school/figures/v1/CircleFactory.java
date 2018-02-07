package net.thumbtack.school.figures.v1;

public class CircleFactory {
private static int CircleCount;

    public static Circle createCircle(Point2D center, int radius){
        CircleCount++;
       return  new   Circle(center,radius);
    }
    public static int getCircleCount(){return CircleCount;}
    public static void reset(){CircleCount=0;}
}
