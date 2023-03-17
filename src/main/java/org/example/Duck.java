package org.example;

public class Duck implements Comparable<Duck> {

    private int width;
    private int height;
    private double ratio;

    public Duck(final int height, final int width) {
        this.width = width;
        this.height = height;
        this.ratio = (double)height / (double)width;
    }

    int getWidth() {
        return width;
    }

    void setWidth(final int width) {
        this.width = width;
    }

    int getHeight() {
        return height;
    }

    void setHeight(final int height) {
        this.height = height;
    }

    double getRatio() {
        return ratio;
    }

    void setRatio(final double ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "width=" + width +
                ", height=" + height +
                ", ratio=" + ratio +
                '}';
    }

    @Override
    public int compareTo(Duck otherDuck) {
        return Double.compare(getRatio(), otherDuck.getRatio());
    }


}
