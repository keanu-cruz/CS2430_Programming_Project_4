package monopoly;

//=============================================================================
//File:             Strategy.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Implementation Lead (Keanu Cruz)
//=============================================================================

/**
 * Represents two different Get Out of Jail strategies for the game Monopoly.
 * <ul>
 *     <li>Strategy A (Immediate Exit) = Use get out of jail card immediately. Otherwise,
 *     pay $50 and exit on next turn.</li>
 *     <li>Strategy B (Roll for Doubles) = Use get out of jail card immediately. Otherwise,
 *     attempt to roll doubles for up to 3 turns; if unsuccessful after 3 attempts,
 *     assume you paid $50 and leave Jail on 4th turn.</li>
 * </ul>
 * @author Keanu Cruz
 */
public enum Strategy {
    A, B
}
