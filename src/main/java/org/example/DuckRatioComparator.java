package org.example;

import java.util.Comparator;

class DuckRatioComparator implements Comparator<Duck> {
    @Override
    public int compare(final Duck duck1, final Duck duck2) {
        return Double.compare(duck2.getRatio(), duck1.getRatio());
    }
}
