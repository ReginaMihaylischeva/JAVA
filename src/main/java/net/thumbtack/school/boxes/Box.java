package net.thumbtack.school.boxes;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.figures.v3.Figure;

public class Box<T extends Figure> implements HasArea {
    private T object;

    private static final double EPS = 1E-6;

    Box(T object) {
        this.object = object;
    }

    public T getContent() {
        return object;
    }

    public void setContent(T object) {
        this.object = object;
    }

    @Override
    public double getArea() {

        return object.getArea();
    }

    public boolean isAreaEqual(Box<? extends Figure> another) {
        return Math.abs(getArea() - another.getArea()) < EPS;
    }

    public static boolean isAreaEqual(Box<? extends Figure> another, Box<? extends Figure> another1) {
        return Math.abs(another.getArea() - another1.getArea()) < EPS;
    }

}
