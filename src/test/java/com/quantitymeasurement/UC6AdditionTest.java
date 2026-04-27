package com.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// UC6: Addition of Two Lengths - result in first operand's unit
public class UC6AdditionTest {

    @Test
    public void testAdd_FeetPlusFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(2.0, result.getValue(), 1e-9);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAdd_FeetPlusInches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2);
        assertEquals(2.0, result.getValue(), 1e-9);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAdd_InchesPlusInches() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2);
        assertEquals(24.0, result.getValue(), 1e-9);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAdd_FeetPlusYards() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength result = q1.add(q2);
        assertEquals(4.0, result.getValue(), 1e-9);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAdd_ZeroLength() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2);
        assertEquals(5.0, result.getValue(), 1e-9);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAdd_ResultUnitIsFirstOperandUnit() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(36.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2);
        assertEquals(LengthUnit.YARDS, result.getUnit());
        assertEquals(2.0, result.getValue(), 1e-9);
    }
}
