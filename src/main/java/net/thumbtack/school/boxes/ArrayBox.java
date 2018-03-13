package net.thumbtack.school.boxes;

import net.thumbtack.school.figures.v3.Figure;

public class ArrayBox<T extends Figure> {
    private T[] nums;
    private static final double EPS = 1E-6;

    ArrayBox(T[] nums) {
        this.nums = nums;
    }

    public T[] getContent() {
        return nums;
    }

    public void setContent(T[] nums) {
        this.nums = nums;
    }

    public T getElement(int i) {
        return nums[i];
    }

    public void setElement(T[] obj) {
        T nums[] = obj;
    }

    public boolean isSameSize(ArrayBox<? extends Figure> another) {
        return nums.length == another.nums.length;
    }
}
