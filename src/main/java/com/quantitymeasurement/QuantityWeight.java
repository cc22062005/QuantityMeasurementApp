package com.quantitymeasurement;

import java.util.Objects;

public class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Value must be a valid number");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    public QuantityWeight convertTo(WeightUnit targetUnit) {
        double baseValue = unit.convertToBaseUnit(value);
        double targetValue = targetUnit.convertFromBaseUnit(baseValue);
        return new QuantityWeight(Math.round(targetValue * 1000.0) / 1000.0, targetUnit);
    }

    public QuantityWeight add(QuantityWeight other) {
        double sumInBase = this.toBaseUnit() + other.toBaseUnit();
        double resultValue = unit.convertFromBaseUnit(sumInBase);
        return new QuantityWeight(Math.round(resultValue * 1000.0) / 1000.0, unit);
    }

    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        double sumInBase = this.toBaseUnit() + other.toBaseUnit();
        double resultValue = targetUnit.convertFromBaseUnit(sumInBase);
        return new QuantityWeight(Math.round(resultValue * 1000.0) / 1000.0, targetUnit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityWeight that = (QuantityWeight) o;
        double epsilon = 1e-9;
        return Math.abs(this.toBaseUnit() - that.toBaseUnit()) < epsilon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(toBaseUnit() * 1e9));
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}
