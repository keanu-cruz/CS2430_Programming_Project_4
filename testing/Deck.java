package team1;

//=============================================================================
//File:             DeckTest.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Verification Lead (Johnathan McElprang)
//=============================================================================

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Suite for Deck.java
 * Verifies correct card handling, reshuffling, and discard rules.
 * @author Johnathan McElprang
 */
public class DeckTest {


    // Creation Tests

    @Test
    void chestDeckHasCorrectSize() {
        List<Card> chest = Deck.createChest();

        assertEquals(16, chest.size());
    }

    @Test
    void chanceDeckHasCorrectSize() {
        List<Card> chance = Deck.createChance();

        assertEquals(16, chance.size());
    }

    @Test
    void decksContainExpectedSpecialCards() {
        List<Card> chance = Deck.createChance();
        List<Card> chest = Deck.createChest();

        assertTrue(chance.stream().anyMatch(c -> c.getType().equals("GETOUTOFJAIL")));
        assertTrue(chest.stream().anyMatch(c -> c.getType().equals("GETOUTOFJAIL")));

        assertTrue(chance.stream().anyMatch(c -> c.getType().equals("GOTOJAIL")));
        assertTrue(chest.stream().anyMatch(c -> c.getType().equals("GOTOJAIL")));
    }

  
    // Draw Behavior Tests

    @Test
    void drawCardReturnsCard() {
        Deck deck = new Deck(Deck.createChance());

        Card c = deck.drawCard();

        assertNotNull(c);
    }

    @Test
    void drawCardHandlesMultipleDraws() {
        Deck deck = new Deck(Deck.createChance());

        for (int i = 0; i < 20; i++) {
            assertNotNull(deck.drawCard());
        }
    }


    // GETOUTOFJAIL discard rule test

    @Test
    void getOutOfJailNotDiscarded() {
        List<Card> cards = List.of(
                new Card("GETOUTOFJAIL", 0),
                new Card("MOVE", 5),
                new Card("MOVE", 10)
        );

        Deck deck = new Deck(cards);

        boolean foundGetOut = false;

        for (int i = 0; i < 10; i++) {
            Card c = deck.drawCard();

            if (c.getType().equals("GETOUTOFJAIL")) {
                foundGetOut = true;
            }
        }

        assertTrue(foundGetOut);
    }

    // Reshuffle Tests

    @Test
    void reshuffleDoesNotCrash() {
        Deck deck = new Deck(Deck.createChance());

        for (int i = 0; i < 50; i++) {
            deck.drawCard();
        }

        assertDoesNotThrow(deck::reshuffle);
    }

    @Test
    void reshuffleRestoresCards() {
        Deck deck = new Deck(Deck.createChance());

        for (int i = 0; i < 16; i++) {
            deck.drawCard();
        }

        deck.drawCard(); // forces reshuffle

        assertNotNull(deck.drawCard());
    }
    

    // Structural Safety Test

    @Test
    void repeatedDrawDoesNotBreakDeck() {
        Deck deck = new Deck(Deck.createChance());

        for (int i = 0; i < 200; i++) {
            assertDoesNotThrow(deck::drawCard);
        }
    }
}
