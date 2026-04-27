package monopoly;

//=============================================================================
//File:             Main.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Implementation Lead (Keanu Cruz)
//=============================================================================

import java.io.*;
import java.util.List;

/**
 * Application used to run simulations.
 * @author Keanu Cruz
 */
public class Main {
    public static void main(String[] args) {

        SimulationEngine engine = new SimulationEngine();
        engine.runAllSims();

        ResultAnalyzer analyzer = engine.getAnalyzer();

        System.out.println();
        System.out.println("FINISHED");
        System.out.println();

        System.out.println("\n================ FINAL REPORT ================\n");

        System.out.println("Strategy A (1,000,000 turns)");
        System.out.println("TOP 5 SQUARES:");
        for (String s : analyzer.getStrategyAResults()) {
            System.out.println(s);
        }

        System.out.println("\nStrategy B (1,000,000 turns)");
        System.out.println("TOP 5 SQUARES:");
        for (String s : analyzer.getStrategyBResults()) {
            System.out.println(s);
        }

        double tolerance = 0.9;
        boolean same = true;

        for (int i = 0; i < analyzer.getStrategyAComparison().size(); i++) {
            double a = analyzer.getStrategyAComparison().get(i);
            double b = analyzer.getStrategyBComparison().get(i);

            if (Math.abs(a - b) > tolerance) {
                same = false;
                break;
            }
        }

        System.out.println("\nConvergence: " + (same ? "YES" : "NO") + " - Based on a .9% tolerance");

        System.out.println("\nOBSERVATIONS: ");
        System.out.println("Jail is visited at a high frequency. This is due to game logic and mechanics.");
        System.out.println("Landings tend to happen in grouped locations due to game flow and card mechanics.");
        System.out.println("Go To Jail space is always zero because you immediately go to jail and counts the land there.");


        System.out.println("\n=============================================");
    }
}
