package net.thumbtack.school.colors;

public class ColorException extends Exception {
    public ColorErrorCode colorErrorCode;

    public ColorException(ColorErrorCode ColorErrorCode) {
        this.colorErrorCode = ColorErrorCode;
    }

    public ColorErrorCode getErrorCode() {
        return colorErrorCode;
    }
}
