package com.quantitymeasurement;

import java.util.Objects;

public class Inches {
    private final double value;

    public Inches(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inches inches = (Inches) o;
        return Double.compare(inches.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public double getValue() {
        return value;
    }
}
