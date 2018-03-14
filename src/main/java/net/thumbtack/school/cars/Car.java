package net.thumbtack.school.cars;


import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorErrorCode;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.colors.Colored;

import static net.thumbtack.school.colors.Color.colorFromString;

public class Car implements Colored {
    private String model;
    private int weight;
    private int maxSpeed;
    private Color color;


    public void setColor(Color color) throws ColorException {
        if (color == null) throw new ColorException(ColorErrorCode.NULL_COLOR);
        this.color = color;
    }

    public void setColor(String colorString) throws ColorException {
        this.color = Color.colorFromString(colorString);
    }


    public Color getColor() {
        return color;
    }

    public Car(String model, int weight, int maxSpeed, Color color) throws ColorException {
        setMaxSpeed(maxSpeed);
        setModel(model);
        setWeight(weight);
        setColor(color);

    }


    public Car(String model, int weight, int maxSpeed, String color) throws ColorException {
        setMaxSpeed(maxSpeed);
        setModel(model);
        setWeight(weight);

        setColor(color);

    }

    public int getWeight() {
        return weight;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
