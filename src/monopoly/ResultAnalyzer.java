package monopoly;

//=============================================================================
//File:             ResultAnalyzer.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Implementation Lead (Keanu Cruz)
//=============================================================================

import java.util.ArrayList;
import java.util.List;

/**
 * Reporting and Analyzing Suite
 * @author Keanu Cruz
 */
public class ResultAnalyzer {

    private List<String> strategyAResults = new ArrayList<>();
    private List<String> strategyBResults = new ArrayList<>();
    List<Double> strategyAComparison;
    List<Double> strategyBComparison;

    /**
     * Returns Strategy A percentage for Top 5 Squares
     * @return
     */
    public List<Double> getStrategyAComparison() {
        return strategyAComparison;
    }

    /**
     * Returns Strategy B percentage for Top 5 Squares
     * @return
     */
    public List<Double> getStrategyBComparison() {
        return strategyBComparison;
    }

    /**
     * Returns turn 100000 top five square results for Strategy A
     * @return
     */
    public List<String> getStrategyAResults() {
        return strategyAResults;
    }

    /**
     * Returns turn 100000 top five square results for Strategy B
     * @return
     */
    public List<String> getStrategyBResults() {
        return strategyBResults;
    }

    /**
     * Produces top 5 most landed squares.
     * @param squares
     * @return
     */
    public List<Square> analyzeTopSquares(List<Square> squares){
        squares.sort((a,b) -> b.getCount() - a.getCount());
        return new ArrayList<>(squares.subList(0, 5));
    }

    /**
     * Prints Square name with visit count.
     * @param squares
     */
    public void printResults(List<Square> squares, int turns){
        System.out.printf("%-25s %-15s %12s %10s%n", "NAME", "TYPE", "LAND COUNT", "PERCENT");
        for (Square s : squares){
            double percent = (double) s.getCount() / turns;
            System.out.printf("%-25s %-17s %-9d %9.2f%%%n", s.getName(), s.getType(), s.getCount(),
                    percent * 100);
        }
    }

    /**
     * Prints all data for Turns and Simulations for each Strategy as well as top
     * 5 landed spots per sim at each turn check.
     * @param board
     * @param strategy
     * @param sim
     * @param turns
     */
    public void save(Board board, Strategy strategy, int sim, int turns){
        System.out.println("\nStrategy " + strategy + " | Sim " + sim + " | Turns " + turns);
        System.out.println();

        System.out.printf("%-25s %-15s %12s %10s%n", "NAME", "TYPE", "LAND COUNT", "PERCENT");

        // Print All Squares
        for (Square s : board.getAllSquares()){
            double percent = (double) s.getCount() / turns;
            System.out.printf("%-25s %-17s %-9d %9.2f%%%n", s.getName(), s.getType(), s.getCount(), percent * 100);
        }

        // Print Top 5 Most Visited Squares
        System.out.println("\nTop 5 Most Visited Squares");
        System.out.println();

        List<Square> boardCopy = new ArrayList<>(board.getAllSquares());
        List<Square> topFiveSquares = new ArrayList<>(analyzeTopSquares(boardCopy));

        printResults(topFiveSquares, turns);

        if (sim == 10 && turns == 1000000){

            List<String> storedResults = new ArrayList<>();
            List<Double> percentResults = new ArrayList<>();

            for (Square s : topFiveSquares){
                double percent = (double) s.getCount() / turns;
                storedResults.add(String.format("%-25s %-17s %-9d %9.2f%%", s.getName(), s.getType(), s.getCount(),
                        percent * 100));
                percentResults.add(percent * 100);
            }

            if (strategy == Strategy.A){
                strategyAResults = storedResults;
                strategyAComparison = percentResults;

            } else {
                strategyBResults = storedResults;
                strategyBComparison = percentResults;
            }
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");

    }
}
