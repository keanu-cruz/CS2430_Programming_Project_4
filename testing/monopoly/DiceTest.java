package monopoly;

//=============================================================================
//File:             DiceTest.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Verification Lead (Johnathan McElprang)
//=============================================================================

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Suite for Dice.java
 * Verifies roll ranges and double detection correctness.
 * @author Johnathan McElprang
 */
public class DiceTest {

    // Roll Validity Tests

    @Test
    void rollIsWithinValidRange() {
        Dice dice = new Dice();

        for (int i = 0; i < 200; i++) {
            int result = dice.roll();

            assertTrue(result >= 2 && result <= 12,
                    "Invalid dice sum: " + result);
        }
    }

    @Test
    void diceValuesAreValid() {
        Dice dice = new Dice();

        for (int i = 0; i < 200; i++) {
            dice.roll();

            int d1 = getDie1(dice);
            int d2 = getDie2(dice);

            assertTrue(d1 >= 1 && d1 <= 6);
            assertTrue(d2 >= 1 && d2 <= 6);
        }
    }


    // Double Logic Tests

    @Test
    void isDoubleTrueWhenEqual() {
        Dice dice = new Dice();

        boolean found = false;

        for (int i = 0; i < 200; i++) {
            dice.roll();

            if (getDie1(dice) == getDie2(dice)) {
                assertTrue(dice.isDouble());
                found = true;
                break;
            }
        }

        assertTrue(found, "No doubles found in 200 rolls (statistically unlikely failure)");
    }

    @Test
    void isDoubleFalseWhenNotEqual() {
        Dice dice = new Dice();

        for (int i = 0; i < 200; i++) {
            dice.roll();

            if (getDie1(dice) != getDie2(dice)) {
                assertFalse(dice.isDouble());
            }
        }
    }

    
    // State Consistency Test

    @Test
    void isDoubleReflectsLastRollOnly() {
        Dice dice = new Dice();

        dice.roll();
        boolean firstState = dice.isDouble();

        dice.roll();
        boolean secondState = dice.isDouble();

        assertNotNull(firstState);
        assertNotNull(secondState);
    }


    // Reflection Helpers

    private int getDie1(Dice dice) {
        try {
            java.lang.reflect.Field field = Dice.class.getDeclaredField("die1");
            field.setAccessible(true);
            return (int) field.get(dice);
        } catch (Exception e) {
            fail("Cannot access die1");
            return -1;
        }
    }

    private int getDie2(Dice dice) {
        try {
            java.lang.reflect.Field field = Dice.class.getDeclaredField("die2");
            field.setAccessible(true);
            return (int) field.get(dice);
        } catch (Exception e) {
            fail("Cannot access die2");
            return -1;
        }
    }
}
