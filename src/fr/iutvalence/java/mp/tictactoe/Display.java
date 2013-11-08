package fr.iutvalence.java.mp.tictactoe;

public class Display
{
    public void displayMarking(PlayerInfo player,Position position ,int turn)
    {
        System.out.println("Joueur " + player.getNumber() + " pose sa marque en " + position + " -- Tour : "
                + turn);
    }
    
    public void markHasNotBeenPlacedDueToAnException()
    {
        System.out.println("... mais est un gros boulet !");
    }
    
    public void displayScore(int[] playersScores)
    {
        for (int player = 0; player < TicTacToe.DEFAULT_NUMBER_OF_PLAYERS; player++)
            System.out.println("Score Joueur " + player + " : " + playersScores[player]);
    }
}
