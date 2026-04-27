package monopoly;

//=============================================================================
//File:             Square.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Implementation Lead (Keanu Cruz)
//=============================================================================

/**
 * Represents a square in the game Monopoly.
 * <p>A Square contains a name, index, and type. Holds landing counts as player
 * traverses the board.</p>
 * @author Keanu Cruz
 */
public class Square {
    private String name;
    private String type;
    private int visitCount;

    /**
     * Initializes fields name, index, and type.
     * @param name
     * @param index
     * @param type
     */
    public Square(String name, int index, String type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Handles logic behind GOTOJAIL square and CHANCE and CHEST Draw functions.
     * @param player
     * @param engine
     */
    public boolean land(Player player, SimulationEngine engine){

        if (type.equals("GOTOJAIL")){
            engine.sendToJail(player);
            return true;
        }

        if (type.equals("CHANCE")){
            Card c = engine.getChanceDeck().drawCard();
            return c.applyCard(player, engine);
        }

        if (type.equals("CHEST")){
            Card c = engine.getChestDeck().drawCard();
            return c.applyCard(player, engine);
        }

        return false;
    }

    /**
     * Returns name of a Square
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns type of a Square.
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Returns how many times a square is visited.
     * @return
     */
    public int getCount(){
        return visitCount;
    }

    /**
     * Increases square visit count by 1
     */
    public void incrementVisit(){
        visitCount++;
    }

    /**
     * Resets square visit count to 0
     */
    public void resetCount(){
        visitCount = 0;
    }
}
