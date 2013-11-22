package fr.iutvalence.java.mp.tictactoe;

/**
 * Input interface
 */
public interface Player
{
    /**
     * Gets the position in which the player has decided to put his mark
     * @return the position in which the player has decided to put his mark
     */
    public Position getChoice();
}
