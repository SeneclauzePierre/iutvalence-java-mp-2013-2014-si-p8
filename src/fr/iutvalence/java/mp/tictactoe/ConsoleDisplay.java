package fr.iutvalence.java.mp.tictactoe;

/**
 * Displays on screen any information the user might need to know.
 * @author seneclap
 *
 */
public class ConsoleDisplay implements Display
{
    // TODO (fix) Abstract Display (interface)
    
    /* (non-Javadoc)
     * @see fr.iutvalence.java.mp.tictactoe.Output#displayConsole(fr.iutvalence.java.mp.tictactoe.PlayerInfo, fr.iutvalence.java.mp.tictactoe.Position, int)
     */
    @Override
    public void displayConsole(PlayerInfo player,Position position ,int turn)
    {
        System.out.println("Joueur " + player.getNumber() + " pose sa marque en " + position + " -- Tour : "
                + turn);
    }
    
    /* (non-Javadoc)
     * @see fr.iutvalence.java.mp.tictactoe.Output#markHasNotBeenPlacedDueToAnException()
     */
    @Override
    public void markHasNotBeenPlacedDueToAnException()
    {
        System.out.println("... mais est un gros boulet !");
    }
    
    /* (non-Javadoc)
     * @see fr.iutvalence.java.mp.tictactoe.Output#displayScore(int[])
     */
    @Override
    public void displayScore(int[] playersScores)
    {
        for (int player = 0; player < TicTacToe.DEFAULT_NUMBER_OF_PLAYERS; player++)
            System.out.println("Score Joueur " + (player+1) + " : " + playersScores[player]);
    }
    
    
}
