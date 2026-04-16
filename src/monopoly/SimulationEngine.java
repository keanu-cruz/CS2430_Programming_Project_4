package monopoly;

//=============================================================================
//File:             SimulationEngine.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Implementation Lead (Keanu Cruz)
//=============================================================================

/**
 * SimulationEngine represents the game flow for our Monopoly game.
 * @author Keanu Cruz
 */
public class SimulationEngine {
    private Board board;
    private Deck chance;
    private Deck chest;
    private Dice dice;
    private int totalMoves;

    public Board getBoard() {
        return board;
    }

    public Deck getChanceDeck() {
        return chance;
    }

    public Deck getChestDeck() {
        return chest;
    }

    public Dice getDice() {
        return dice;
    }

    public int getTotalMoves() {
        return totalMoves;
    }

    public void runAllSims(){
        //TODO: write function that runs all simulations
    }

    public void runSimulation(Strategy strategy, int sim){
        //TODO: write function that runs a simulation
    }

    public void takeTurn(Player player, Strategy strategy){
        //TODO: write function handles turn taking
    }

    public void move(Player player, int steps){
        //TODO: write function that handles player movement
    }

    public void resolve(Player player){
        //TODO: write function that handles what happens after a player moves
    }

    public void sendToJail(Player player){
        //TODO: write function that sends player to jail
    }

    public void handleJail(Player player, Strategy strategy){
        //TODO: write function that uses one of two get out of jail strategies.
    }
}
