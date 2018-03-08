package net.thumbtack.school.figures.v3;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorErrorCode;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.colors.Colored;


public abstract class Figure implements Colored, HasArea {
    private Color color;

    public abstract void moveRel(int dx, int dy);

    @Override
    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract boolean isInside(int x, int y);

    public abstract boolean isInside(Point2D point);

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) throw new ColorException(ColorErrorCode.NULL_COLOR);
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        this.color = Color.colorFromString(colorString);
    }

}
