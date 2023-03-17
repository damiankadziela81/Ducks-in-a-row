package org.example;

public class Duck implements Comparable<Duck> {

    private final int width;
    private final int height;
    private final double ratio;

    public Duck(final int height, final int width) {
        this.width = width;
        this.height = height;
        this.ratio = (double)height / (double)width;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    double getRatio() {
        return ratio;
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
