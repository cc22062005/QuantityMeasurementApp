package com.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityLengthTest {

    // UC3: Generic Quantity class - equality
    @Test
    public void testQuantityLength_FeetEquality() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertEquals(q1, q2);
    }

    @Test
    public void testQuantityLength_InchesEquality() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        assertEquals(q1, q2);
    }

    @Test
    public void testQuantityLength_FeetInchesEquality() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        assertEquals(q1, q2);
    }

    @Test
    public void testQuantityLength_NotEqual() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCHES);
        assertNotEquals(q1, q2);
    }

    // UC4: Extended Unit Support (YARDS, CENTIMETERS)
    @Test
    public void testQuantityLength_YardsEquality() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        assertEquals(q1, q2);
    }

    @Test
    public void testQuantityLength_YardsInchesEquality() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(36.0, LengthUnit.INCHES);
        assertEquals(q1, q2);
    }

    @Test
    public void testQuantityLength_CentimetersEquality() {
        QuantityLength q1 = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCHES);
        assertEquals(q1, q2);
    }

    // UC5: Unit-to-Unit Conversion
    @Test
    public void testConvertTo_FeetToInches() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q.convertTo(LengthUnit.INCHES);
        assertEquals(new QuantityLength(12.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testConvertTo_InchesToFeet() {
        QuantityLength q = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q.convertTo(LengthUnit.FEET);
        assertEquals(new QuantityLength(1.0, LengthUnit.FEET), result);
    }

    @Test
    public void testConvertTo_FeetToYards() {
        QuantityLength q = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength result = q.convertTo(LengthUnit.YARDS);
        assertEquals(new QuantityLength(1.0, LengthUnit.YARDS), result);
    }

    @Test
    public void testConvertTo_CentimetersToInches() {
        QuantityLength q = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength result = q.convertTo(LengthUnit.INCHES);
        assertEquals(new QuantityLength(1.0, LengthUnit.INCHES), result);
    }

    // UC6: Addition of Two Length Units
    @Test
    public void testAdd_FeetAndFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(new QuantityLength(2.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAdd_FeetAndInches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2);
        assertEquals(new QuantityLength(2.0, LengthUnit.FEET), result);
    }

    @Test
    public void testAdd_InchesAndInches() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2);
        assertEquals(new QuantityLength(24.0, LengthUnit.INCHES), result);
    }

    @Test
    public void testAdd_CentimetersAndInches() {
        QuantityLength q1 = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2);
        assertEquals(new QuantityLength(2.0, LengthUnit.INCHES), result.convertTo(LengthUnit.INCHES));
    }

    // UC7: Addition with Target Unit
    @Test
    public void testAddWithTarget_FeetAndInchesToYards() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2, LengthUnit.YARDS);
        assertEquals(LengthUnit.YARDS, result.getUnit());
        assertTrue(Math.abs(result.getValue() - 0.667) < 0.001);
    }

    @Test
    public void testAddWithTarget_FeetAndFeetToInches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2, LengthUnit.INCHES);
        assertEquals(new QuantityLength(24.0, LengthUnit.INCHES), result);
    }

    // UC8: Backward Compatibility Tests (using standalone LengthUnit)
    @Test
    public void testLengthUnit_ConvertToBaseUnit() {
        assertEquals(1.0, LengthUnit.FEET.convertToBaseUnit(1.0), 1e-9);
        assertEquals(1.0, LengthUnit.INCHES.convertToBaseUnit(12.0), 1e-9);
        assertEquals(3.0, LengthUnit.YARDS.convertToBaseUnit(1.0), 1e-9);
        assertEquals(1.0, LengthUnit.CENTIMETERS.convertToBaseUnit(30.48), 1e-6);
    }

    @Test
    public void testLengthUnit_ConvertFromBaseUnit() {
        assertEquals(1.0, LengthUnit.FEET.convertFromBaseUnit(1.0), 1e-9);
        assertEquals(12.0, LengthUnit.INCHES.convertFromBaseUnit(1.0), 1e-9);
        assertEquals(1.0, LengthUnit.YARDS.convertFromBaseUnit(3.0), 1e-9);
        assertEquals(30.48, LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0), 1e-6);
    }

    @Test
    public void testQuantityLength_NullUnitThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new QuantityLength(1.0, null));
    }

    @Test
    public void testQuantityLength_NaNValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new QuantityLength(Double.NaN, LengthUnit.FEET));
    }
}
