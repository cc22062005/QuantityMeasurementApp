package com.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// UC8: Refactoring LengthUnit to Standalone with Conversion Responsibility
public class UC8RefactorEnumTest {

    // Test standalone enum accessibility
    @Test
    public void testLengthUnitEnum_FeetConstant() {
        assertEquals(1.0, LengthUnit.FEET.getConversionFactor(), 1e-9);
    }

    @Test
    public void testLengthUnitEnum_InchesConstant() {
        assertEquals(1.0 / 12.0, LengthUnit.INCHES.getConversionFactor(), 1e-9);
    }

    @Test
    public void testLengthUnitEnum_YardsConstant() {
        assertEquals(3.0, LengthUnit.YARDS.getConversionFactor(), 1e-9);
    }

    @Test
    public void testLengthUnitEnum_CentimetersConstant() {
        assertEquals(1.0 / 30.48, LengthUnit.CENTIMETERS.getConversionFactor(), 1e-9);
    }

    // Test convertToBaseUnit
    @Test
    public void testConvertToBaseUnit_FeetToFeet() {
        assertEquals(5.0, LengthUnit.FEET.convertToBaseUnit(5.0), 1e-9);
    }

    @Test
    public void testConvertToBaseUnit_InchesToFeet() {
        assertEquals(1.0, LengthUnit.INCHES.convertToBaseUnit(12.0), 1e-9);
    }

    @Test
    public void testConvertToBaseUnit_YardsToFeet() {
        assertEquals(3.0, LengthUnit.YARDS.convertToBaseUnit(1.0), 1e-9);
    }

    @Test
    public void testConvertToBaseUnit_CentimetersToFeet() {
        assertEquals(1.0, LengthUnit.CENTIMETERS.convertToBaseUnit(30.48), 1e-6);
    }

    // Test convertFromBaseUnit
    @Test
    public void testConvertFromBaseUnit_FeetToFeet() {
        assertEquals(2.0, LengthUnit.FEET.convertFromBaseUnit(2.0), 1e-9);
    }

    @Test
    public void testConvertFromBaseUnit_FeetToInches() {
        assertEquals(12.0, LengthUnit.INCHES.convertFromBaseUnit(1.0), 1e-9);
    }

    @Test
    public void testConvertFromBaseUnit_FeetToYards() {
        assertEquals(1.0, LengthUnit.YARDS.convertFromBaseUnit(3.0), 1e-9);
    }

    @Test
    public void testConvertFromBaseUnit_FeetToCentimeters() {
        assertEquals(30.48, LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0), 1e-6);
    }

    // Test QuantityLength still works with standalone LengthUnit (backward compatibility)
    @Test
    public void testBackwardCompatibility_Equality() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        assertEquals(q1, q2);
    }

    @Test
    public void testBackwardCompatibility_ConvertTo() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q.convertTo(LengthUnit.INCHES);
        assertEquals(12.0, result.getValue(), 0.01);
    }

    @Test
    public void testBackwardCompatibility_Addition() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2);
        assertEquals(2.0, result.getValue(), 0.01);
    }

    @Test
    public void testBackwardCompatibility_AdditionWithTarget() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = q1.add(q2, LengthUnit.YARDS);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    // Enum is a top-level class (not nested)
    @Test
    public void testLengthUnitIsTopLevelClass() {
        assertNotNull(LengthUnit.class.getPackage());
        assertEquals("com.quantitymeasurement", LengthUnit.class.getPackage().getName());
        assertNull(LengthUnit.class.getEnclosingClass()); // Not nested
    }
}
