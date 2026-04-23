package team1;

//=============================================================================
//File:             MainTest.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Verification Lead (Johnathan McElprang)
//=============================================================================

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration Test for Main.java
 * Ensures simulation runs without crashing and produces output.
 * @author Johnathan McElprang
 */
public class MainTest {

   
    // Smoke Test: Full Program Execution

    @Test
    void mainRunsWithoutCrashing() {
        assertDoesNotThrow(() -> {
            Main.main(new String[]{});
        });
    }

    // Engine Creation Test

    @Test
    void engineCreatesSuccessfully() {
        SimulationEngine engine = new SimulationEngine();

        assertNotNull(engine);
        assertNotNull(engine.getAnalyzer());
    }

    // Analyzer Output Exists Test

    @Test
    void analyzerReturnsResults() {
        SimulationEngine engine = new SimulationEngine();
        engine.runAllSims();

        ResultAnalyzer analyzer = engine.getAnalyzer();

        assertNotNull(analyzer.getStrategyAResults());
        assertNotNull(analyzer.getStrategyBResults());
        assertFalse(analyzer.getStrategyAResults().isEmpty());
        assertFalse(analyzer.getStrategyBResults().isEmpty());
    }

    // Basic Stability Test (lightweight run)

    @Test
    void simulationProducesStableOutput() {
        SimulationEngine engine = new SimulationEngine();

        assertDoesNotThrow(() -> {
            engine.runAllSims();
        });
    }
}
