package net.thumbtack.school.base;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberOperations {
    public static Integer find(int[] array, int value) {

        Integer i;
        for (i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return i;
            }
        }
        i = null;
        return i;
    }

    public static Integer find(double[] array, double value, double eps) {
        Integer i;
        for (i = 0; i < array.length; i++) {
            if (Math.abs(array[i] - value) <= eps) {
                return i;
            }
        }
        i = null;
        return i;
    }

    public static Double calculateDensity(double weight, double volume, double min, double max) {
        if ((weight / volume) <= max && (weight / volume) >= min) {
            return weight / volume;
        } else {
            return null;
        }
    }

    public static Integer find(BigInteger[] array, BigInteger value) {
        Integer i;
        for (i = 0; i < array.length; i++) {
            if (value.equals(array[i])) {
                return i;
            }
        }
        i = null;
        return i;

    }

    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min, BigDecimal max) {
        if (weight.divide(volume).compareTo(min) + weight.divide(volume).compareTo(max) == 0) {
            return weight.divide(volume);
        } else {
            return null;
        }
    }
}
