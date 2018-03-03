package net.thumbtack.school.colors;


import static net.thumbtack.school.colors.ColorErrorCode.NULL_COLOR;
import static net.thumbtack.school.colors.ColorErrorCode.WRONG_COLOR_STRING;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import net.thumbtack.school.cars.Car;
import net.thumbtack.school.figures.v3.Circle;
import net.thumbtack.school.figures.v3.Figure;
import net.thumbtack.school.figures.v3.Point2D;
import net.thumbtack.school.figures.v3.Rectangle;
import net.thumbtack.school.figures.v3.Triangle;

public class TestColor {


    @Test
    public void testGetErrorString(){
        assertEquals("Wrong color string", ColorErrorCode.WRONG_COLOR_STRING.getErrorString());

        assertEquals("Null color", ColorErrorCode.NULL_COLOR.getErrorString());
    }

    @Test
    public void testColorFromString() {

        try {
            String color = "YELLOW";
            Color.colorFromString(color);
            fail();
        } catch (ColorException ex) {
            assertEquals(WRONG_COLOR_STRING, ex.getErrorCode());
        }
        try {
            String color = null;
            Color.colorFromString(color);
            fail();
        } catch (ColorException ex) {
            assertEquals(NULL_COLOR , ex.getErrorCode());
        }

        try {
            String color = "RED";
            Color.colorFromString(color);
            assertEquals(Color.RED, Color.colorFromString(color));
        } catch (ColorException ex) {
            assertEquals(WRONG_COLOR_STRING, ex.getErrorCode());
        }


    }

    @Test
    public void testCompareColors() throws ColorException {
        Figure rect = new Rectangle(10, 20, 30, 40, Color.BLUE);
        Figure circle = new Circle(10, 20, 10, Color.BLUE);
        assertEquals(rect.getColor(), circle.getColor());
        circle.setColor(Color.GREEN);
        assertNotEquals(rect.getColor(), circle.getColor());
    }

    @Test
    public void testArrayOfColored() throws ColorException {
        Colored[] coloredObjects = new Colored[4];
        coloredObjects[0] = new Circle(10, 20, 10, Color.BLUE);
        coloredObjects[1] = new Rectangle(10, 20, 30, 40, Color.BLUE);
        coloredObjects[2] = new Triangle(new Point2D(2, 0), new Point2D(-1, 0), new Point2D(0, 2), Color.BLUE);
        coloredObjects[3] = new Car("Tesla", 1500, 400, Color.BLUE);

        for (Colored colored : coloredObjects)
            colored.setColor(Color.GREEN);
        for (Colored colored : coloredObjects)
            assertEquals(Color.GREEN, colored.getColor());
    }

    @Test
    public void testColors() {
        Color[] colors = Color.values();
        assertEquals(3, colors.length);
        assertEquals(0, Color.RED.ordinal());
        assertEquals(1, Color.GREEN.ordinal());
        assertEquals(2, Color.BLUE.ordinal());
    }

}
