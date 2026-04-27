package com.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// UC5: Unit-to-Unit Conversion
public class UC5ConversionTest {

    @Test
    public void testConvert_FeetToInches() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q.convertTo(LengthUnit.INCHES);
        assertEquals(12.0, result.getValue(), 1e-9);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testConvert_InchesToFeet() {
        QuantityLength q = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q.convertTo(LengthUnit.FEET);
        assertEquals(1.0, result.getValue(), 1e-9);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testConvert_FeetToYards() {
        QuantityLength q = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength result = q.convertTo(LengthUnit.YARDS);
        assertEquals(1.0, result.getValue(), 1e-9);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    @Test
    public void testConvert_YardsToFeet() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength result = q.convertTo(LengthUnit.FEET);
        assertEquals(3.0, result.getValue(), 1e-9);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testConvert_InchesToCentimeters() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength result = q.convertTo(LengthUnit.CENTIMETERS);
        assertEquals(2.54, result.getValue(), 0.01);
        assertEquals(LengthUnit.CENTIMETERS, result.getUnit());
    }

    @Test
    public void testConvert_CentimetersToInches() {
        QuantityLength q = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength result = q.convertTo(LengthUnit.INCHES);
        assertEquals(1.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testConvert_SameUnit() {
        QuantityLength q = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength result = q.convertTo(LengthUnit.FEET);
        assertEquals(5.0, result.getValue(), 1e-9);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testRoundTrip_FeetToInchesAndBack() {
        QuantityLength original = new QuantityLength(2.5, LengthUnit.FEET);
        QuantityLength converted = original.convertTo(LengthUnit.INCHES).convertTo(LengthUnit.FEET);
        assertEquals(original.getValue(), converted.getValue(), 0.01);
    }
}
