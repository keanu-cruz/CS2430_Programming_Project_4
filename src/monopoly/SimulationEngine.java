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
    private ResultAnalyzer analyzer = new ResultAnalyzer();

    /**
     * Initializes the fields Board, Chance (Deck), Chest (Deck), Dice, and TotalMoves.
     * @param board
     * @param chance
     * @param chest
     * @param dice
     * @param totalMoves
     */
    public SimulationEngine() {
        board = new Board();
        chance = new Deck(Deck.createChance());
        chest = new Deck(Deck.createChest());
        dice = new Dice();
        totalMoves = 0;
    }

    /**
     * Returns Board with all Squares Initialized
     * @return
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Returns a Deck with all Chance cards initialized
     * @return
     */
    public Deck getChanceDeck() {
        return chance;
    }

    /**
     * Returns a Deck with all Chest cards initialized
     * @return
     */
    public Deck getChestDeck() {
        return chest;
    }

    /**
     * Returns Result Analyzer used by engine.
     * @return
     */
    public ResultAnalyzer getAnalyzer() {
        return analyzer;
    }

    /**
     * Runs 10 simulations for 1000, 10,000, 100,000 and 1,000,000 turns.
     * <p>Prints results using ResultAnalyzer save method.</p>
     */
    public void runAllSims(){
        int[] turnsCheck = {1000, 10000, 100000, 1000000};
        analyzer = this.analyzer;

        for (Strategy strategy : Strategy.values()){
            for (int sim = 1; sim <= 10; sim++){

                for (int turns : turnsCheck){
                    board.resetCounts();
                    chance = new Deck(Deck.createChance());
                    chest = new Deck(Deck.createChest());
                    Player player = new Player();

                    for (int t = 0; t < turns; t++){
                        takeTurn(player, strategy);
                    }

                    analyzer.save(board, strategy, sim, turns);
                }
            }
        }
    }

    /**
     * Handles Player turn game mechanics.
     * <ul>
     *     <li>Standard Move:
     *     Dice is rolled and increments doublesCount if a double is rolled. Then player turn is resolved.</li>
     *     <li>If in jail: uses handleJail method to control game flow.</li>
     *     <li>Doubles: If double roll again. If double is >= 3 then send player to jail.</li>
     * </ul>
     * @param player
     * @param strategy
     */
    public void takeTurn(Player player, Strategy strategy){

        if (player.isInJail()) {
            handleJail(player, strategy);
            return;
        }

        int steps = dice.roll();
        boolean isDouble = dice.isDouble();

        if (isDouble) {
            player.incrementDoublesCount();
        } else {
            player.resetDoubles();
        }

        if (player.getDoublesCount() >= 3) {
            sendToJail(player);
            return;
        }

        move(player, steps);
        resolve(player);

        if (isDouble && !player.isInJail()) {
            takeTurn(player, strategy);
        }
    }

    /**
     * Moves Player position based on dice roll.
     * @param player
     * @param steps
     */
    public void move(Player player, int steps){
        int newPosition = (player.getPosition() + steps) % 40;
        player.setPosition(newPosition);
        totalMoves++;
    }

    /**
     * Resolves a players turn.
     * <p>If player has multiple mechanics, such as multiple cards, to resolve keeps resolving until resolve
     * returns false.</p>
     * @param player
     */
    public void resolve(Player player){
        while (true) {
            Square square = board.getSquare((player.getPosition()));

            boolean moved = square.land(player, this);

            if(!moved){
                square.incrementVisit();
                break;
            }
        }
    }

    /**
     * Sends a player to jail and resets doubles in case that's the reason for going to jail.
     * @param player
     */
    public void sendToJail(Player player){
        player.setPosition(10);
        player.setIsInJail(true);
        player.setJailTurns(0);
        player.resetDoubles();
    }

    /**
     * Handles game flow mechanics for Strategy A and Strategy B for inJail.
     * <ul>
     *     <li>Both Strategies: if Get Out of Jail Card available, uses a card to immediately be free.</li>
     *     <li>Strategy A: Assumed you paid fine and moves on next turn.</li>
     *     <li>Strategy B: Rolls Doubles to try to get out. If player hasn't gotten out by turn 3, player
     *     is able to leave on turn 4.</li>
     * </ul>
     * @param player
     * @param strategy
     */
    public void handleJail(Player player, Strategy strategy){
        if (player.getGetOutOfJailCards() > 0 ){
            player.useGetOutOfJailCard();
            player.setIsInJail(false);

            int steps = dice.roll();
            move(player, steps);
            resolve(player);
            return;
        }

        if (strategy == Strategy.A){
            player.setIsInJail(false);

            int steps = dice.roll();
            move(player, steps);
            resolve(player);
            return;
        }

        player.incrementJailTurns();

        if (player.getJailTurns() <= 3) {

            int steps = dice.roll();
            boolean isDouble = dice.isDouble();

            if (isDouble) {
                player.setIsInJail(false);
                player.setJailTurns(0);
                move(player, steps);
                resolve(player);
            }
            return;
        }
            player.setIsInJail(false);
            player.setJailTurns(0);

            int steps = dice.roll();
            move(player, steps);
            resolve(player);
        }
    }
