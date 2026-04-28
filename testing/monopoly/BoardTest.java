package monopoly;

//=============================================================================
//File:             BoardTest.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Verification Lead (Johnathan McElprang)
//=============================================================================

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Test Suite for Board.java
 * Verifies construction, naming, square types, and movement helpers.
 * @author Johnathan McElprang
 */
public class BoardTest {

  // Construction Tests

    @Test
    void boardHas40Squares() {
        Board board = new Board();

        assertEquals(40, board.getAllSquares().size());
    }

    @Test
    void boardNamesMatchArray() {
        Board board = new Board();
        List<Square> squares = board.getAllSquares();

        assertEquals("GO", squares.get(0).getName());
        assertEquals("Jail", squares.get(10).getName());
        assertEquals("Free Parking", squares.get(20).getName());
        assertEquals("Go To Jail", squares.get(30).getName());
        assertEquals("Boardwalk", squares.get(39).getName());
    }

  
    // Square Type Tests

    @Test
    void specialSquaresCorrect() {
        Board board = new Board();

        assertEquals("GO", board.getSquare(0).getType());
        assertEquals("JAIL", board.getSquare(10).getType());
        assertEquals("FREE PARKING", board.getSquare(20).getType());
        assertEquals("GOTOJAIL", board.getSquare(30).getType());
    }

    @Test
    void chanceAndChestSquaresCorrect() {
        Board board = new Board();

        assertEquals("CHEST", board.getSquare(2).getType());
        assertEquals("CHEST", board.getSquare(17).getType());
        assertEquals("CHEST", board.getSquare(33).getType());

        assertEquals("CHANCE", board.getSquare(7).getType());
        assertEquals("CHANCE", board.getSquare(22).getType());
        assertEquals("CHANCE", board.getSquare(36).getType());
    }

    @Test
    void railroadAndUtilityCorrect() {
        Board board = new Board();

        assertEquals("RAILROAD", board.getSquare(5).getType());
        assertEquals("RAILROAD", board.getSquare(15).getType());
        assertEquals("RAILROAD", board.getSquare(25).getType());
        assertEquals("RAILROAD", board.getSquare(35).getType());

        assertEquals("UTILITY", board.getSquare(12).getType());
        assertEquals("UTILITY", board.getSquare(28).getType());
    }

    @Test
    void taxSquaresCorrect() {
        Board board = new Board();

        assertEquals("TAX", board.getSquare(4).getType());
        assertEquals("TAX", board.getSquare(38).getType());
    }

   
    // getSquare() Tests
  

    @Test
    void getSquareWrapsCorrectly() {
        Board board = new Board();

        assertEquals(board.getSquare(0).getName(), board.getSquare(40).getName());
        assertEquals(board.getSquare(1).getName(), board.getSquare(41).getName());
    }

    @Test
    void getSquareDoesNotCrash() {
        Board board = new Board();

        assertDoesNotThrow(() -> board.getSquare(100));
    }

    
    // Reset Test
    

    @Test
    void resetCountsWorks() {
        Board board = new Board();

        board.getSquare(0).incrementVisit();
        board.getSquare(1).incrementVisit();

        board.resetCounts();

        for (Square s : board.getAllSquares()) {
            assertEquals(0, s.getCount());
        }
    }


    // Railroad Logic
  

    @Test
    void nearestRailroadForward() {
        Board board = new Board();

        assertEquals(15, board.nearestRailroad(6));
        assertEquals(25, board.nearestRailroad(16));
    }

    @Test
    void nearestRailroadWrap() {
        Board board = new Board();

        assertEquals(5, board.nearestRailroad(36));
        assertEquals(5, board.nearestRailroad(39));
    }

   
    // Utility Logic
  

    @Test
    void nearestUtilityLogic() {
        Board board = new Board();

        assertEquals(12, board.nearestUtility(0));
        assertEquals(12, board.nearestUtility(11));

        assertEquals(28, board.nearestUtility(13));
        assertEquals(28, board.nearestUtility(27));
    }
}
