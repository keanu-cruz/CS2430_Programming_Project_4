package monopoly;

//=============================================================================
//File:             Deck.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Implementation Lead (Keanu Cruz)
//=============================================================================

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A Deck is a list of Cards creating list of cards from Community and Chance cards.
 * @author Keanu Cruz
 */
public class Deck {

    private List<Card> draw;
    private List<Card> discard;

    /**
     * Initializes deck of cards with a Draw and Discard field
     * @param cards
     */
    public Deck(List<Card> cards) {
        draw = new ArrayList<>(cards);
        discard = new ArrayList<>();
        Collections.shuffle(draw);
    }

    /**
     * Takes first card from deck, reads it, then adds it to discard pile.
     * @return
     */
    public Card drawCard(){
        if (draw.isEmpty()){
            reshuffle();
        }

        Card card = draw.remove(0);
        discard.add(card);
        return card;
    }

    /**
     * Mixes in discard deck back into draw deck and shuffles cards.
     */
    public void reshuffle(){
        draw.addAll(discard);
        discard.clear();
        Collections.shuffle(draw);
    }

    /**
     * Creates Deck of Community Chest Cards.
     * <ul>
     *     <li>MOVE: Any card that advances you to a postion on the board.</li>
     *     <li>MONEY: Cards that don't affect movement. Not Measured for this simulation.</li>
     *     <li>GETOUTOFJAIL: Card Held by player to get out of jail immediately on their next playable turn</li>
     *     <li>GOTOJAIL: Sends player to jail.</li>
     * </ul>
     * @return
     */
    public static List<Card> createChest(){
        return List.of(
                new Card("MOVE", 0),
                new Card("MONEY", 0),
                new Card("MONEY", 0),
                new Card("MONEY", 0),
                new Card("GETOUTOFJAIL", 0),
                new Card("GOTOJAIL", 0),
                new Card("MONEY", 0),
                new Card("MONEY", 0),
                new Card("MONEY", 0),
                new Card("MONEY", 0),
                new Card("MONEY", 0),
                new Card("MONEY", 0),
                new Card("MONEY", 0),
                new Card("MONEY", 0),
                new Card("MONEY", 0),
                new Card("MONEY", 0)
        );
    }

    /**
     * Creates Deck of Chance Cards.
     * <ul>
     *     <li>MOVE: Any card that advances you to a postion on the board.</li>
     *     <li>MOVEBACK: Moves player position back by value on card.</li>
     *     <li>MONEY: Cards that don't affect movement. Not Measured for this simulation.</li>
     *     <li>GETOUTOFJAIL: Card Held by player to get out of jail immediately on their next playable turn</li>
     *     <li>GOTOJAIL: Sends player to jail.</li>
     *     <li>NEXTRR: Advance to next nearest Railroad.</li>
     *     <li>NEXTUTIL: Advance to next nearest Utility.</li>
     * </ul>
     * @return
     */
    public static List<Card> createChance(){
        return List.of(
                new Card("MOVE", 39),
                new Card("MOVE", 0),
                new Card("MOVE", 24),
                new Card("MOVE", 11),
                new Card("NEXTRR", 0),
                new Card("NEXTRR", 0),
                new Card("NEXTUTIL", 0),
                new Card("MONEY", 0),
                new Card("GETOUTOFJAIL", 0),
                new Card("MOVEBACK", 3),
                new Card("GOTOJAIL", 0),
                new Card("MONEY", 0),
                new Card("MONEY", 0),
                new Card("MOVE", 5),
                new Card("MONEY", 0),
                new Card("MONEY", 0)
        );
    }
}
