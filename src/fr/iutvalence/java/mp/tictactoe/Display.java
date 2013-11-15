package fr.iutvalence.java.mp.tictactoe;

/**
 * Displays on screen any information the user might need to know.
 * @author seneclap
 *
 */
public class Display
{
    /**
     * Displays who just played, where he played, and on which turn he played
     * @param player the player who just played
     * @param position the position where the player played
     * @param turn the current turn
     */
    public void displayMarking(PlayerInfo player,Position position ,int turn)
    {
        System.out.println("Joueur " + player.getNumber() + " pose sa marque en " + position + " -- Tour : "
                + turn);
    }
    
    /**
     * Informs the user that the mark couldn't be placed, because an exception was raised
     */
    public void markHasNotBeenPlacedDueToAnException()
    {
        System.out.println("... mais est un gros boulet !");
    }
    
    /**
     * Displays the final score of each player
     * @param playersScores a table in which the scores are stored throughout the game 
     */
    public void displayScore(int[] playersScores)
    {
        for (int player = 0; player < TicTacToe.DEFAULT_NUMBER_OF_PLAYERS; player++)
            System.out.println("Score Joueur " + (player+1) + " : " + playersScores[player]);
    }
    
    
}
