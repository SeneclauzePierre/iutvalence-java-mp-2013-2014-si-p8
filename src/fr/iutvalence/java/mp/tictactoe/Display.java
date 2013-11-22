package fr.iutvalence.java.mp.tictactoe;

/**
 * Output interface
 */
public interface Display
{

    /**
     * Displays who just played, where he played, and on which turn he played
     * @param player the player who just played
     * @param position the position where the player played
     * @param turn the current turn
     */
    public void displayConsole(PlayerInfo player, Position position, int turn);

    /**
     * Informs the user that the mark couldn't be placed, because an exception was raised
     */
    public void markHasNotBeenPlacedDueToAnException();

    /**
     * Displays the final score of each player
     * @param playersScores a table in which the scores are stored throughout the game 
     */
    public void displayScore(int[] playersScores);

}