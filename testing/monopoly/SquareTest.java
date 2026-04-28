package monopoly;

//=============================================================================
//File:             SquareTest.java
//Team Name:        Team 1
//Team Members:     Keanu Cruz, Johnathan McElprang, Michael McCleary , Pong Vodmongkol
//Course/Section:   CS 2430
//Project:          Programming Project 4 – Capstone (Spring 2026)
//Primary Author:   Verification Lead (Johnathan McElprang)
//=============================================================================

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
* Test Suite for Square.java
* @author Johnathan McElprang
*/
public class SquareTest {

	
  // Basic Getter Tests

  @Test
  void getNameReturnsCorrectValue() {
      Square s = new Square("Boardwalk", 39, "PROPERTY");
      assertEquals("Boardwalk", s.getName());
  }

  @Test
  void getTypeReturnsCorrectValue() {
      Square s = new Square("Chance", 7, "CHANCE");
      assertEquals("CHANCE", s.getType());
  }

  @Test
  void visitCountStartsAtZero() {
      Square s = new Square("GO", 0, "GO");
      assertEquals(0, s.getCount());
  }

  @Test
  void incrementVisitWorks() {
      Square s = new Square("GO", 0, "GO");

      s.incrementVisit();
      s.incrementVisit();

      assertEquals(2, s.getCount());
  }

  @Test
  void resetCountWorks() {
      Square s = new Square("GO", 0, "GO");

      s.incrementVisit();
      s.incrementVisit();
      s.resetCount();

      assertEquals(0, s.getCount());
  }


  // Land() Logic Tests

  @Test
  void gotoJailReturnsTrue() {
      Square s = new Square("Go To Jail", 30, "GOTOJAIL");

      FakeEngine engine = new FakeEngine();
      Player player = new Player();

      boolean result = s.land(player, engine);

      assertTrue(result);
      assertEquals(10, player.getPosition());
  }

  @Test
  void propertyReturnsFalse() {
      Square s = new Square("Boardwalk", 39, "PROPERTY");

      FakeEngine engine = new FakeEngine();
      Player player = new Player();

      boolean result = s.land(player, engine);

      assertFalse(result);
  }

  @Test
  void chanceCallsCardAndReturnsResult() {
      Square s = new Square("Chance", 7, "CHANCE");

      FakeEngine engine = new FakeEngine();
      engine.setCardResult(true); 

      Player player = new Player();

      boolean result = s.land(player, engine);

      assertTrue(result);
  }

  @Test
  void chestCallsCardAndReturnsResult() {
      Square s = new Square("Chest", 2, "CHEST");

      FakeEngine engine = new FakeEngine();
      engine.setCardResult(false); 

      Player player = new Player();

      boolean result = s.land(player, engine);

      assertFalse(result);
  }


  // Fake Engine for Unit Testing

  private static class FakeEngine extends SimulationEngine {

      private boolean cardResult = false;

      public void setCardResult(boolean value) {
          this.cardResult = value;
      }

      @Override
      public void sendToJail(Player player) {
          player.setPosition(10);
          player.setIsInJail(true);
      }

      @Override
      public Deck getChanceDeck() {
          return new FakeDeck(cardResult);
      }

      @Override
      public Deck getChestDeck() {
          return new FakeDeck(cardResult);
      }

      private static class FakeDeck extends Deck {
          private final boolean result;

          public FakeDeck(boolean result) {
              super(java.util.List.of());
              this.result = result;
          }

          @Override
          public Card drawCard() {
              return new Card("TEST", 0) {
                  @Override
                  public boolean applyCard(Player player, SimulationEngine engine) {
                      return result;
                  }
              };
          }
      }
  }
}
