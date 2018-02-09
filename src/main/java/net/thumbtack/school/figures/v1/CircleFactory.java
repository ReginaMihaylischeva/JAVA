package net.thumbtack.school.figures.v1;

public class CircleFactory {
private static int circlecount;

    public static Circle createCircle(Point2D center, int radius){
        circlecount++;
       return  new   Circle(center,radius);
    }
    public static int getCircleCount(){return circlecount;}
    public static void reset(){circlecount=0;}
}
