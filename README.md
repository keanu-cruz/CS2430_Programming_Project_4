# Programming Project 4: Capstone   
**CS 2430 - Section 501 - Spring 2026**

**Team Members:**

* Johnathan McElprang  
* Keanu Cruz  
* Michael McCleary (Inactive)  
* Pong Vodmongkol (Inactive)  

---

## Overview of the Project
The purpose of this project is to simulate the movement mechanics of a monopoly game in order to analyze the landing probabilities of each square on the board. This simulation is designed to understand the most frequently landed on space and to analyze the best strategies. 

In our project we focus strictly on board movement, dice rolls, Chance and Community Chest card behavior, and Jail mechanics. We do not model any of the purchasing actions. The goal is to use multiple lare scale simulations to analyze probability data.

---

## The Implemented Operations

**Part 1 - Board and Data Structures**

#### Requirements:
* Define all 40 Monopoly board squares in correct order.  
* Track total number of moves made.  
* Store square type information (Property, Railroad, Utility, Chance, Community Chest, Jail, Go To Jail, etc.).  
* Track landing counts for each square.  
* Implement shuffled Chance and Community Chest decks with discard and reshuffle behavior.  
<br>

**Part 2 - Turn Engine and Movement Rules**

#### Requirements:
* Simulate rolling two six-sided dice.  
* Move player forward with board wrap-around logic.  
* Track consecutive doubles and send player to Jail on the third double.  
* Resolve Chance and Community Chest card movement effects.  
* Resolve the "Go To Jail" square.  
* Increment landing counts only after all movement effects are fully resolved.  
<br>

**Part 3 - Two Jail Exit Strategies**

#### Requirements:
* Strategy A – Immediate Exit:
  * Use Get Out of Jail Free card immediately if available.  
  * Otherwise assume payment and leave Jail on next turn.  

* Strategy B – Try for Doubles:
  * Use Get Out of Jail Free card immediately if available.  
  * Otherwise attempt to roll doubles for up to three turns.  
  * If unsuccessful, assume payment and leave on fourth turn.  
<br>

**Part 4 - Batch Simulation and Data Collection**

#### Requirements:
* Run 10 independent simulations per strategy.  
* Collect landing data at:
  * 1,000 turns  
  * 10,000 turns  
  * 100,000 turns  
  * 1,000,000 turns  
* Output:
  * Raw landing counts for all 40 squares.  
  * Percentage (count / n) for each square.  
<br>

**Part 5 - Comparative Output Summary**

#### Requirements:
* Identify top 3–5 most landed-on squares per strategy.  
* Compare Strategy A and Strategy B distributions at 1,000,000 turns.  
* Highlight convergence behavior and any noticeable anomalies.  
<br>

---

## How to Build & Run
1. Import the project into Eclipse IDE.  
2. Make sure that you have Java SE 22 or a newer edition installed.  
3. Run the `Main` class to execute the simulation.  
4. The program will automatically run both jail strategies and output landing counts and percentages for all required turn values.  

---

## Folder Structure
* `Project4` > Eclipse Project  
  * `Project4/src/...` > Implementation  
    * `Board.java`  
    * `Card.java`  
    * `Deck.java`  
    * `Dice.java`  
    * `Main.java`  
    * `Player.java`  
    * `ResultAnalyzer.java`  
    * `SimulationEngine.java`  
    * `Square.java`  
    * `Strategy.java`  
* `docs/...` > Planning Artifacts  
* `README.md` < You Are Here.  

---

## Team Roles
Reference `docs/CONTRIBUTIONS.md`.
