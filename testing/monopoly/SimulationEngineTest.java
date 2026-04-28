package monopoly;

//=============================================================================
//File:             SimulationEngineTest.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Verification Lead (Johnathan McElprang)
//=============================================================================

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for SimulationEngine.java
 * Focuses on stability and correctness of core simulation flow.
 * @author Johnathan McElprang
 */
public class SimulationEngineTest {


    // Initialization Tests

    @Test
    void engineInitializesCorrectly() {
        SimulationEngine engine = new SimulationEngine();

        assertNotNull(engine.getBoard());
        assertNotNull(engine.getChanceDeck());
        assertNotNull(engine.getChestDeck());
        assertNotNull(engine.getAnalyzer());
    }


    // Movement + Jail Tests

    @Test
    void sendToJailWorksCorrectly() {
        SimulationEngine engine = new SimulationEngine();
        Player p = new Player();

        engine.sendToJail(p);

        assertEquals(10, p.getPosition());
        assertTrue(p.isInJail());
        assertEquals(0, p.getDoublesCount());
    }

    @Test
    void moveWrapsCorrectly() {
        SimulationEngine engine = new SimulationEngine();
        Player p = new Player();

        p.setPosition(38);

        engine.move(p, 5);

        assertEquals(3, p.getPosition());
    }


    // Resolve Safety Test

    @Test
    void resolveDoesNotCrash() {
        SimulationEngine engine = new SimulationEngine();
        Player p = new Player();

        assertDoesNotThrow(() -> {
            engine.resolve(p);
        });
    }


    // Turn Execution Safety

    @Test
    void takeTurnDoesNotCrash() {
        SimulationEngine engine = new SimulationEngine();
        Player p = new Player();

        assertDoesNotThrow(() -> {
            engine.takeTurn(p, Strategy.A);
        });
    }

    @Test
    void takeTurnWithStrategyBDoesNotCrash() {
        SimulationEngine engine = new SimulationEngine();
        Player p = new Player();

        assertDoesNotThrow(() -> {
            engine.takeTurn(p, Strategy.B);
        });
    }


    // Full Simulation Safety 

    @Test
    void runAllSimsCompletesWithoutError() {
        SimulationEngine engine = new SimulationEngine();

        assertDoesNotThrow(() -> {
            engine.runAllSims();
        });
    }
}
