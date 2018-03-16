package net.thumbtack.school.boxes;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.figures.v3.Figure;

public class PairBox<T extends Figure, V extends Figure> implements HasArea {
    private T objT;
    private V objV;
    private static final double EPS = 1E-6;

    public PairBox(T objT, V objV) {
        this.objT = objT;
        this.objV = objV;
    }

    public T getContentFirst() {
        return objT;
    }

    public void setContentFirst(T objT) {
        this.objT = objT;
    }

    public V getContentSecond() {
        return objV;
    }

    public void setContentSecond(V objV) {
        this.objV = objV;
    }

    @Override
    public double getArea() {
        return objV.getArea() + objT.getArea();
    }

    public boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> another) {
        return Math.abs(getArea() - another.getArea()) < EPS;

    }

    public static boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> another, PairBox<? extends Figure, ? extends Figure> another1) {
       return another.isAreaEqual(another1);
    }
}
