package team1;

//=============================================================================
//File:             ResultAnalyzerTest.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Verification Lead (Johnathan McElprang)
//=============================================================================

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Suite for ResultAnalyzer.java
 * Verifies sorting, top 5 selection, and result storage.
 * @author Johnathan McElprang
 */
public class ResultAnalyzerTest {


    // Top 5 Sorting Logic

    @Test
    void analyzeTopSquaresReturnsFive() {
        ResultAnalyzer analyzer = new ResultAnalyzer();

        List<Square> squares = createFakeSquares(10);

        List<Square> top = analyzer.analyzeTopSquares(squares);

        assertEquals(5, top.size());
    }

    @Test
    void analyzeTopSquaresSortsCorrectly() {
        ResultAnalyzer analyzer = new ResultAnalyzer();

        List<Square> squares = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Square s = new Square("S" + i, i, "TEST");

            for (int j = 0; j < i; j++) {
                s.incrementVisit();
            }

            squares.add(s);
        }

        List<Square> top = analyzer.analyzeTopSquares(squares);

        assertEquals(9, top.get(0).getCount());
        assertEquals(8, top.get(1).getCount());
        assertEquals(7, top.get(2).getCount());
    }

    
    // Storage Logic Tests

    @Test
    void strategyAStorageStartsEmpty() {
        ResultAnalyzer analyzer = new ResultAnalyzer();

        assertTrue(analyzer.getStrategyAResults().isEmpty());
        assertTrue(analyzer.getStrategyBResults().isEmpty());
    }


    // Save Trigger Test (critical simulation condition)

    @Test
    void saveStoresResultsAtCorrectCondition() {
        ResultAnalyzer analyzer = new ResultAnalyzer();
        Board board = new Board();

        Strategy strategy = Strategy.A;

        int i = 0;
        for (Square s : board.getAllSquares()) {
            for (int j = 0; j < i; j++) {
                s.incrementVisit();
            }
            i++;
        }

        analyzer.save(board, strategy, 10, 1000000);

        assertFalse(analyzer.getStrategyAResults().isEmpty());
        assertEquals(5, analyzer.getStrategyAResults().size());

        assertNotNull(analyzer.getStrategyAComparison());
        assertEquals(5, analyzer.getStrategyAComparison().size());
    }


    // Helper

    private List<Square> createFakeSquares(int n) {
        List<Square> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Square s = new Square("S" + i, i, "TEST");

            for (int j = 0; j < i; j++) {
                s.incrementVisit();
            }

            list.add(s);
        }

        return list;
    }
}
