package monopoly;

//=============================================================================
//File:             Player.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Implementation Lead (Keanu Cruz)
//=============================================================================

/**
 * Player is the interactable piece for our simulation.
 * @author Keanu Cruz
 */
public class Player {
    private int position;
    private boolean inJail = false;
    private int jailTurns = 0;
    private int doublesCount = 0;
    private int getOutOfJailCards = 0;

    /**
     * Returns player position on the board index 0-39
     * @return
     */
    public int getPosition() {
        return position;
    }

    /**
     * Player inJail is false by default until sent to jail.
     * @return
     */
    public boolean isInJail() {
        return inJail;
    }

    /**
     * Returns number of turns in jail
     * @return
     */
    public int getJailTurns() {
        return jailTurns;
    }

    /**
     * Setter for number of jailTurns
     * @param jailTurns
     */
    public void setJailTurns(int jailTurns) {
        this.jailTurns = jailTurns;
    }

    /**
     * Changes status of player whether they are in jail or not.
     * @return
     */
    public void setIsInJail(boolean inJail) {
        this.inJail = inJail;
    }

    /**
     * Returns how many doubles a player has rolled.
     * @return
     */
    public int getDoublesCount() {
        return doublesCount;
    }

    /**
     * Returns number of get out of jail cards a player has
     * @return
     */
    public int getGetOutOfJailCards() {
            return getOutOfJailCards;
    }

    /**
     * Decreases GetOutOfJailCards count by 1.
     * @return
     */
    public void useGetOutOfJailCard() {
        if (getOutOfJailCards > 0) {
            getOutOfJailCards--;
        }
    }

    /**
     * Set players position on board.
     * @param position
     */
    public void setPosition(int position) {
        this.position = (position + 40) % 40;
    }

    /**
     * Increments how many turns a player has been in jail.
     */
    public void incrementJailTurns() {
        jailTurns++;
    }

    /**
     * Increments number of rolled doubles a player has
     */
    public void incrementDoublesCount() {
        doublesCount++;
    }

    /**
     * Increments number of get out of jail free cards a player has.
     */
    public void incrementGetOutOfJailCard() {
        getOutOfJailCards++;
    }

    /**
     * Resets number of doubles rolled by a player.
     */
    public void resetDoubles(){
        doublesCount = 0;
    }
}
