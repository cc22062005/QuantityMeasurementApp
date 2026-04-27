package com.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FeetTest {

    @Test
    public void testFeetEquality_SameValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        assertEquals(feet1, feet2);
    }

    @Test
    public void testFeetEquality_DifferentValues() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);
        assertNotEquals(feet1, feet2);
    }

    @Test
    public void testFeetEquality_WithNull() {
        Feet feet1 = new Feet(1.0);
        assertNotEquals(null, feet1);
    }

    @Test
    public void testFeetEquality_SameObject() {
        Feet feet1 = new Feet(1.0);
        assertEquals(feet1, feet1);
    }

    @Test
    public void testFeetEquality_ZeroValue() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(0.0);
        assertEquals(feet1, feet2);
    }

    @Test
    public void testFeetEquality_NegativeValue() {
        Feet feet1 = new Feet(-1.0);
        Feet feet2 = new Feet(-1.0);
        assertEquals(feet1, feet2);
    }
}
