package monopoly;

//=============================================================================
//File:             Main.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Implementation Lead (Keanu Cruz)
//=============================================================================

/**
 * Application used to run simulations.
 * @author Keanu Cruz
 */
public class Main {
    static void main(String[] args) {
        SimulationEngine engine = new SimulationEngine();
        engine.runAllSims();
    }
}
