package com.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// UC4: Extended Unit Support - YARDS and CENTIMETERS
public class UC4ExtendedUnitsTest {

    @Test
    public void testYards_EqualToFeet() {
        QuantityLength yards = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        assertEquals(yards, feet);
    }

    @Test
    public void testYards_EqualToInches() {
        QuantityLength yards = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength inches = new QuantityLength(36.0, LengthUnit.INCHES);
        assertEquals(yards, inches);
    }

    @Test
    public void testCentimeters_EqualToInches() {
        QuantityLength cm = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength inches = new QuantityLength(1.0, LengthUnit.INCHES);
        assertEquals(cm, inches);
    }

    @Test
    public void testCentimeters_EqualToFeet() {
        QuantityLength cm = new QuantityLength(30.48, LengthUnit.CENTIMETERS);
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        assertEquals(cm, feet);
    }

    @Test
    public void testYards_ConversionFactor() {
        assertEquals(3.0, LengthUnit.YARDS.getConversionFactor(), 1e-9);
    }

    @Test
    public void testCentimeters_ConversionFactor() {
        assertEquals(1.0 / 30.48, LengthUnit.CENTIMETERS.getConversionFactor(), 1e-9);
    }

    @Test
    public void testOneYardNotEqualToOneFoot() {
        QuantityLength yards = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        assertNotEquals(yards, feet);
    }
}
