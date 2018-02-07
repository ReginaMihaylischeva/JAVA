package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Circle {
    private Point2D center=new Point2D();
    private  int raduis;
    public Circle(Point2D center, int raduis){
        this.center.setX(center.getX());
        this.center.setY(center.getY());
        this.raduis=raduis;
    }
    public Circle(int xCenter, int yCenter, int radius){
        this.center.setX(xCenter);
        this.center.setY(yCenter);
        this.raduis=radius;
    }
    public Circle(int radius){
        this.center.setX(0);
        this.center.setY(0);
        this.raduis=radius;
    }
    public Circle(){
        center.setX(0);
        center.setY(0);
        raduis=1;
    }
    public Point2D getCenter(){
        return center;
    }
    public int getRadius(){
        return raduis;
    }
    public void setCenter(Point2D center){
      this.center=center;
    }
    public void setRadius(int radius){
        this.raduis=radius;
    }
    public void moveRel(int dx, int dy){
        center.moveRel(dx,dy);
    }
    public void enlarge(int n){
        this.center=center;
        raduis=raduis*n;
    }
    public double getArea(){
        return Math.PI*raduis*raduis;
    }
    public double getPerimeter(){
        return 2*Math.PI*raduis;
    }
    public boolean isInside(int x, int y){

       if ((center.getX()-raduis<=x)&&(x<=center.getX()+raduis)&&(center.getY()-raduis<=y)&&(y<=center.getY()+raduis)){
           return true;
       }else {
           return false;
       }
    }
    public boolean isInside(Point2D point){
        if ((center.getX()-raduis<=point.getX())&&(point.getX()<=center.getX()+raduis)&&(center.getY()-raduis<=point.getY())&&(point.getY()<=center.getY()+raduis)){
            return true;
        }else {
            return false;
        }
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
