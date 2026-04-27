package monopoly;

//=============================================================================
//File:             Card.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Implementation Lead (Keanu Cruz)
//=============================================================================

/**
 * A Card represents a card drawn when landing on Community or Chest squares.
 * @author Keanu Cruz
 */
public class Card {
    private String type;
    private int value;

    /**
     * Initializes the fields type and value for a card.
     * @param type
     * @param value
     */
    public Card(String type, int value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Returns a Card's Type
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Returns a Card's Value
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * Applies card effect to a player.
     * <ul>
     *     <li>MOVETOGO: Moves player to GO</li>
     *     <li>MOVE: Moves player to position value on card.</li>
     *     <li>MOVEBACK: Moves player position back by value on card.</li>
     *     <li>GOTOJAIL: Sends player to jail.</li>
     *     <li>GETOUTOFJAIL: Card Held by player to get out of jail immediately on their next playable turn</li>
     *     <li>NEXTRR: Advance to next nearest Railroad.</li>
     *     <li>NEXTUTIL: Advance to next nearest Utility.</li>
     *     <li>MONEY: Cards that don't affect movement. Not Measured for this simulation.</li>
     * </ul>
     * @param player
     * @param engine
     * @return
     */
    public  boolean applyCard(Player player, SimulationEngine engine){

        switch (type){
            case "MOVETOGO":
                player.setPosition(0);
                return true;

            case "MOVE":
                player.setPosition(value);
                return true;

            case "MOVEBACK":
                player.setPosition((player.getPosition() - value + 40) % 40);
                return true;

            case "GOTOJAIL":
                engine.sendToJail(player);
                return true;

            case "GETOUTOFJAIL":
                player.incrementGetOutOfJailCard();
                return false;

            case "NEXTRR":
                player.setPosition(engine.getBoard().nearestRailroad(player.getPosition()));
                return true;

            case "NEXTUTIL":
                player.setPosition(engine.getBoard().nearestUtility(player.getPosition()));
                return true;

            default:
                return false;
        }
    }
}
