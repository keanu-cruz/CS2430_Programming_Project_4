package monopoly;

//=============================================================================
//File:             PlayerTest.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Verification Lead (Johnathan McElprang)
//=============================================================================

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Suite for Player.java
 * Verifies movement, jail state, and card tracking logic.
 * @author Johnathan McElprang
 */
public class PlayerTest {


    // Position Tests

    @Test
    void initialPositionIsZero() {
        Player p = new Player();

        assertEquals(0, p.getPosition());
    }

    @Test
    void positionWrapsCorrectlyForward() {
        Player p = new Player();

        p.setPosition(45);

        assertEquals(5, p.getPosition());
    }

    @Test
    void positionWrapsCorrectlyBackward() {
        Player p = new Player();

        p.setPosition(-3);

        assertEquals(37, p.getPosition());
    }


    // Jail State Tests

    @Test
    void jailStateCanBeSetAndRead() {
        Player p = new Player();

        p.setIsInJail(true);

        assertTrue(p.isInJail());
    }

    @Test
    void jailTurnsIncrementCorrectly() {
        Player p = new Player();

        p.incrementJailTurns();
        p.incrementJailTurns();

        assertEquals(2, p.getJailTurns());
    }

    @Test
    void jailTurnsCanBeSetDirectly() {
        Player p = new Player();

        p.setJailTurns(3);

        assertEquals(3, p.getJailTurns());
    }

    
    // Doubles Tests

    @Test
    void doublesIncrementAndReset() {
        Player p = new Player();

        p.incrementDoublesCount();
        p.incrementDoublesCount();

        assertEquals(2, p.getDoublesCount());

        p.resetDoubles();

        assertEquals(0, p.getDoublesCount());
    }


    // Get Out of Jail Card Tests

    @Test
    void getOutOfJailCardIncrement() {
        Player p = new Player();

        p.incrementGetOutOfJailCard();

        assertEquals(1, p.getGetOutOfJailCards());
    }

    @Test
    void useGetOutOfJailCardDecreasesCount() {
        Player p = new Player();

        p.incrementGetOutOfJailCard();
        p.incrementGetOutOfJailCard();

        p.useGetOutOfJailCard();

        assertEquals(1, p.getGetOutOfJailCards());
    }

    @Test
    void useGetOutOfJailCardDoesNotGoNegative() {
        Player p = new Player();

        p.useGetOutOfJailCard();

        assertEquals(0, p.getGetOutOfJailCards());
    }


    // Combined State Safety
    
    @Test
    void stateChangesDoNotInterfere() {
        Player p = new Player();

        p.setPosition(10);
        p.incrementDoublesCount();
        p.incrementGetOutOfJailCard();
        p.setIsInJail(true);

        assertEquals(10, p.getPosition());
        assertEquals(1, p.getDoublesCount());
        assertEquals(1, p.getGetOutOfJailCards());
        assertTrue(p.isInJail());
    }
}
