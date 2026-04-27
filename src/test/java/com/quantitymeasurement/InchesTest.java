package com.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InchesTest {

    @Test
    public void testInchesEquality_SameValue() {
        Inches inches1 = new Inches(1.0);
        Inches inches2 = new Inches(1.0);
        assertEquals(inches1, inches2);
    }

    @Test
    public void testInchesEquality_DifferentValues() {
        Inches inches1 = new Inches(1.0);
        Inches inches2 = new Inches(2.0);
        assertNotEquals(inches1, inches2);
    }

    @Test
    public void testInchesEquality_WithNull() {
        Inches inches1 = new Inches(1.0);
        assertNotEquals(null, inches1);
    }

    @Test
    public void testInchesEquality_SameObject() {
        Inches inches1 = new Inches(1.0);
        assertEquals(inches1, inches1);
    }

    @Test
    public void testInchesEquality_ZeroValue() {
        Inches inches1 = new Inches(0.0);
        Inches inches2 = new Inches(0.0);
        assertEquals(inches1, inches2);
    }
}
