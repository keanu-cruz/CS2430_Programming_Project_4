# Monopoly Simulation

## Overview
This project simulates the board game Monopoly (2018 edition) in order to analyze the probability distribution of landing on different squares. In this project we will
focus on using two varying get out of jail strategies to verify how they affect long-run landing probabilities.

## Core Design Decisions
### 1. Simulation Engine:
The main application that will control the entire flow of the game will be handled by the `Simulation Engine`. It will be in charge of running multiple simulations for
output results, executing the player turns, and enforcing our game rules and logic.

The purpose of this design choice is to keep all game logic in one place to simplify debugging and testing structures.

### 2.Board/Square
The `Square` class is used to represent a landing space on the overall larger board. Its purpose is to provide an abstract representation of board spaces later to be 
initialized within the `Board` class. It also stores landing counts to track how many time the player has visited a space.

The `Board` class is what initializes each of the spaces and properties. It's purpose is to be the actual board mat that the player is to traverse and handles all position
related calculations in order to keep related code together.


### 3. Card/Deck
`Card` is used to define a cards name and its type. Though this class is primarily used for it's constructor it also provides the logic of whether a card is applied or not with
a simple boolean. 

The `Deck` class uses `Card` to initialize the Chance and Community Chest decks. All deck related activities like shuffle and draw live within this class. By having all 
deck related function in one location it makes it easy to add or adjust deck logic or card types.

### 4. Player
The `Player` class stores all gameplay related states. This is important as it separates the player's state from the actual simulation logic making it easier to identify
the players location, jail status, position, get out of jail cards and numbers of doubles rolled. 

### 5. Dice
The `Dice` class handles randomness for position related moves for the `roll()` method. The main purpose of this class is to keep our random generation all in one place
instead of spreading that code throughout other classes.

### 6. ResultAnalyzer
The `ResultAnalyzer` is responsible for analyzing square visit frequency, printing and organizing our simulation data to files. This class mainly exists to keep our
data contained and readable.

## Conclusion
The overall design is to help prioritize clarity and modularity. By seperating our responsibility into these classes we are able to have easier debugging and allow
for quick modularity if information is not coded correctly. It also allows for our team to run smaller scale testing as we build our logic to ensure each component works
as intended.
