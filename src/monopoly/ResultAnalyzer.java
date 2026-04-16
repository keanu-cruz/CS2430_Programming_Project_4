package monopoly;

//=============================================================================
//File:             ResultAnalyzer.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Implementation Lead (Keanu Cruz)
//=============================================================================

import java.util.List;

/**
 * Reporting and Analyzing Suite
 * @author Keanu Cruz
 */
public class ResultAnalyzer {

    /**
     * Produces top 5 most landed squares.
     * @param squares
     * @return
     */
    public List<Square> analyzeTopSquares(List<Square> squares){
        squares.sort((a,b) -> b.getCount() - a.getCount());
        return squares.subList(0, 5);
    }

    /**
     * Prints Square name with visit count.
     * @param squares
     */
    public void printResults(List<Square> squares){
        for (Square s : squares){
            System.out.println(s.getName() + ": " + s.getCount());
        }
    }

    /**
     * Prints all data for a given strategy over a particular simulation and specified number of turns.
     * @param board
     * @param strategy
     * @param sim
     * @param turns
     */
    public void save(Board board, Strategy strategy, int sim, int turns){
        System.out.println("\nStrategy" + strategy + " | Sim" + sim + " | Turns " + turns);

        for (Square s : board.getAllSquares()){
            double percent = (double) s.getCount() / turns;
            System.out.printf("%-20s %8d (%.4f%%)\n", s.getName(), s.getCount(), percent * 100);
        }

    }
}
