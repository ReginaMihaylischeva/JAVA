package net.thumbtack.school.colors;

public interface Colored {
    Color getColor();

    void setColor(Color color) throws ColorException;

    void setColor(String colorString) throws ColorException;
}
