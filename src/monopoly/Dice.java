package monopoly;

//=============================================================================
//File:             Dice.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Implementation Lead (Keanu Cruz)
//=============================================================================

import java.util.random.RandomGenerator;

/**
 * Dice are a six sided cube used to move player forward.
 * @author Keanu Cruz
 */
public class Dice {
    private RandomGenerator rand = RandomGenerator.getDefault();

    private int die1;
    private int die2;

    /**
     * Rolls two 6 sided die and adds their totals for player movement.
     * @return
     */
    public int roll(){
        die1 = rand.nextInt(1, 7);
        die2 = rand.nextInt(1, 7);
        return die1 + die2;
    }

    /**
     * Checks whether die1's total matches die2's
     * @return
     */
    public boolean isDouble(){
        return die1 == die2;
    }
}
