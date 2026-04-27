package com.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// UC7: Addition with Explicit Target Unit
public class UC7TargetUnitAdditionTest {

    @Test
    public void testAddWithTarget_FeetPlusInchesToFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2, LengthUnit.FEET);
        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddWithTarget_FeetPlusInchesToInches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2, LengthUnit.INCHES);
        assertEquals(24.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAddWithTarget_FeetPlusInchesToYards() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2, LengthUnit.YARDS);
        assertEquals(0.667, result.getValue(), 0.001);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    @Test
    public void testAddWithTarget_YardsPlusFeetToInches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2, LengthUnit.INCHES);
        assertEquals(72.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAddWithTarget_TargetUnitDifferentFromOperands() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2, LengthUnit.CENTIMETERS);
        assertEquals(LengthUnit.CENTIMETERS, result.getUnit());
        assertEquals(60.96, result.getValue(), 0.01);
    }
}
