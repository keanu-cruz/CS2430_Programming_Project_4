package monopoly;

//=============================================================================
//File:             Board.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Implementation Lead (Keanu Cruz)
//=============================================================================

import java.util.ArrayList;
import java.util.List;

/**
 * Represent and initializes the physical game board for Monopoly.
 * @author Keanu Cruz
 */
public class Board {
    private List<Square> squares;

    /**
     * Initializes the field squares and builds game board.
     * @param squares
     */
    public Board(List<Square> squares) {
        this.squares = new ArrayList<>();
        buildBoard();
    }

    /**
     * Creates 40 Squares and gives appropriate name, index and type of
     * squares from the game Monopoly.
     */
    public void buildBoard(){
        for(int i = 0; i < 40; i++){
            String type = "PROPERTY";

            if (i == 0){
                type = "GO";
            }
            else if (i == 10){
                type = "JAIL";
            }
            else if (i ==20){
                type = "FREE PARKING";
            }
            else if (i == 30){
                type = "GOTOJAIL";
            }
            else if (i == 2 || i == 17 || i == 33){
                type = "CHEST";
            }
            else if (i == 7 || i == 22 || i == 36){
                type = "CHANCE";
            }
            else if (i == 4 || i == 38){
                type = "TAX";
            }
            else if (i == 5 || i == 15 || i == 25 || i == 35){
                type = "RAILROAD";
            }
            else if (i == 12 || i == 28){
                type = "UTILITY";
            }

            squares.add(new Square("Square: " + i, i, type));
        }
    }

    /**
     * Returns square from specified index.
     * @param pos
     * @return
     */
    public Square getPosition(int pos){
        return squares.get(pos);
    }

    /**
     * Returns total list of squares.
     * @return
     */
    public List<Square> getAllSquares(){
        return squares;
    }

    /**
     * Resets visit count to 0 for square.
     */
    public void resetCounts(){
        for(Square square: squares){
            square.resetCount();
        }
    }

    /**
     * Determines nearest railroad to the player when Chance card is drawn.
     * @param pos
     * @return
     */
    public int nearestRailroad(int pos){
        int [] rr = {5, 15, 25, 35};
        for (int r : rr){
            if (r > pos){
                return r;
            }
        }
        return 5;
    }

    /**
     * Returns nearest utility to the player when Chance card is drawn.
     * @param pos
     * @return
     */
    public int nearestUtility(int pos){
        if (pos < 12 || pos >= 28){
            return 12;
        }
        return 28;
    }
}
