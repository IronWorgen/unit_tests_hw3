package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Even or odd number check")
    void evenOddNumber() {
        assertEquals(true,Main.evenOddNumber(2));
        assertEquals(true,Main.evenOddNumber(-2));
        assertEquals(false,Main.evenOddNumber(3));
        assertEquals(false,Main.evenOddNumber(-3));
        assertEquals(true,Main.evenOddNumber(0));

    }
    @Test
    @DisplayName("Number in range (25,100)?")
    void numInRange(){
        assertEquals(false, Main.numInRange(25));
        assertEquals(false, Main.numInRange(100));
        assertEquals(true, Main.numInRange(30));
        assertEquals(false, Main.numInRange(10));
        assertEquals(false, Main.numInRange(-30));

    }
}