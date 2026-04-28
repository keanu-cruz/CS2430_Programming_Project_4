package monopoly;

//=============================================================================
//File:             CardTest.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Verification Lead (Johnathan McElprang)
//=============================================================================

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Suite for Card.java
 * Verifies card properties and movement effects.
 * @author Johnathan McElprang
 */
public class CardTest {

    
    // Getter Tests
    

    @Test
    void getTypeReturnsCorrectValue() {
        Card card = new Card("MOVE", 10);

        assertEquals("MOVE", card.getType());
    }

    @Test
    void getValueReturnsCorrectValue() {
        Card card = new Card("MOVE", 15);

        assertEquals(15, card.getValue());
    }

    
    // Movement Logic Tests 

    @Test
    void moveToPositionWorks() {
        Player player = new Player();
        SimulationEngine engine = new SimulationEngine();

        Card card = new Card("MOVE", 10);

        card.applyCard(player, engine);

        assertEquals(10, player.getPosition());
    }

    @Test
    void moveBackWorks() {
        Player player = new Player();
        SimulationEngine engine = new SimulationEngine();

        player.setPosition(10);

        Card card = new Card("MOVEBACK", 3);

        card.applyCard(player, engine);

        assertEquals(7, player.getPosition());
    }

    @Test
    void moveToGoWorks() {
        Player player = new Player();
        SimulationEngine engine = new SimulationEngine();

        player.setPosition(20);

        Card card = new Card("MOVETOGO", 0);

        card.applyCard(player, engine);

        assertEquals(0, player.getPosition());
    }


    // Jail & Special Logic

    @Test
    void getOutOfJailIncrementsCard() {
        Player player = new Player();
        SimulationEngine engine = new SimulationEngine();

        Card card = new Card("GETOUTOFJAIL", 0);

        boolean result = card.applyCard(player, engine);

        assertFalse(result);
        assertEquals(1, player.getGetOutOfJailCards());
    }

    @Test
    void goToJailDoesNotCrash() {
        Player player = new Player();
        SimulationEngine engine = new SimulationEngine();

        Card card = new Card("GOTOJAIL", 0);

        Assertions.assertDoesNotThrow(() -> card.applyCard(player, engine));
    }

    
    // Railroad / Utility Tests

    @Test
    void nextRailroadMovesCorrectly() {
        Player player = new Player();
        player.setPosition(6);

        SimulationEngine engine = new SimulationEngine();

        Card card = new Card("NEXTRR", 0);

        card.applyCard(player, engine);

        assertTrue(
                player.getPosition() == 15 ||
                player.getPosition() == 25 ||
                player.getPosition() == 35 ||
                player.getPosition() == 5
        );
    }

    @Test
    void nextUtilityMovesCorrectly() {
        Player player = new Player();
        player.setPosition(13);

        SimulationEngine engine = new SimulationEngine();

        Card card = new Card("NEXTUTIL", 0);

        card.applyCard(player, engine);

        assertTrue(
                player.getPosition() == 12 ||
                player.getPosition() == 28
        );
    }

    
    // Default Case

    @Test
    void unknownCardDoesNothing() {
        Player player = new Player();
        SimulationEngine engine = new SimulationEngine();

        Card card = new Card("INVALID", 100);

        boolean result = card.applyCard(player, engine);

        assertFalse(result);
    }
}
