package com.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// UC9: Weight Measurement with WeightUnit enum
public class UC9WeightMeasurementTest {

    // WeightUnit enum tests
    @Test
    public void testWeightUnit_KilogramConversionFactor() {
        assertEquals(1.0, WeightUnit.KILOGRAM.getConversionFactor(), 1e-9);
    }

    @Test
    public void testWeightUnit_GramConversionFactor() {
        assertEquals(0.001, WeightUnit.GRAM.getConversionFactor(), 1e-9);
    }

    @Test
    public void testWeightUnit_PoundConversionFactor() {
        assertEquals(0.453592, WeightUnit.POUND.getConversionFactor(), 1e-6);
    }

    // convertToBaseUnit tests
    @Test
    public void testConvertToBase_KilogramToKilogram() {
        assertEquals(1.0, WeightUnit.KILOGRAM.convertToBaseUnit(1.0), 1e-9);
    }

    @Test
    public void testConvertToBase_GramToKilogram() {
        assertEquals(0.001, WeightUnit.GRAM.convertToBaseUnit(1.0), 1e-9);
    }

    @Test
    public void testConvertToBase_PoundToKilogram() {
        assertEquals(0.453592, WeightUnit.POUND.convertToBaseUnit(1.0), 1e-6);
    }

    // convertFromBaseUnit tests
    @Test
    public void testConvertFromBase_KilogramToGram() {
        assertEquals(1000.0, WeightUnit.GRAM.convertFromBaseUnit(1.0), 1e-9);
    }

    @Test
    public void testConvertFromBase_KilogramToPound() {
        assertEquals(2.20462, WeightUnit.POUND.convertFromBaseUnit(1.0), 0.001);
    }

    // QuantityWeight equality tests
    @Test
    public void testQuantityWeight_SameValues() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void testQuantityWeight_KilogramAndGram() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void testQuantityWeight_KilogramAndPound() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0 / 453.592, WeightUnit.POUND);
        assertEquals(w1, w2);
    }

    @Test
    public void testQuantityWeight_NotEqual() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1.0, WeightUnit.GRAM);
        assertNotEquals(w1, w2);
    }

    // Conversion tests
    @Test
    public void testConvertTo_KilogramToGram() {
        QuantityWeight w = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight result = w.convertTo(WeightUnit.GRAM);
        assertEquals(1000.0, result.getValue(), 0.001);
        assertEquals(WeightUnit.GRAM, result.getUnit());
    }

    @Test
    public void testConvertTo_GramToKilogram() {
        QuantityWeight w = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight result = w.convertTo(WeightUnit.KILOGRAM);
        assertEquals(1.0, result.getValue(), 0.001);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void testConvertTo_KilogramToPound() {
        QuantityWeight w = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight result = w.convertTo(WeightUnit.POUND);
        assertEquals(2.205, result.getValue(), 0.01);
        assertEquals(WeightUnit.POUND, result.getUnit());
    }

    // Addition tests
    @Test
    public void testAdd_KilogramPlusKilogram() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight result = w1.add(w2);
        assertEquals(2.0, result.getValue(), 1e-9);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void testAdd_KilogramPlusGram() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight result = w1.add(w2);
        assertEquals(2.0, result.getValue(), 0.001);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    // Addition with target unit
    @Test
    public void testAddWithTarget_KilogramPlusGramToGram() {
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(500.0, WeightUnit.GRAM);
        QuantityWeight result = w1.add(w2, WeightUnit.GRAM);
        assertEquals(1500.0, result.getValue(), 0.001);
        assertEquals(WeightUnit.GRAM, result.getUnit());
    }

    // Null unit validation
    @Test
    public void testQuantityWeight_NullUnitThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new QuantityWeight(1.0, null));
    }

    // WeightUnit is top-level (not nested in QuantityWeight)
    @Test
    public void testWeightUnitIsTopLevelClass() {
        assertNotNull(WeightUnit.class.getPackage());
        assertNull(WeightUnit.class.getEnclosingClass());
    }
}
