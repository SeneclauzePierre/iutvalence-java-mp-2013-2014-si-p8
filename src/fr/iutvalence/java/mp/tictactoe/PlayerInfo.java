package fr.iutvalence.java.mp.tictactoe;

/**
 * This class identifies both of the game's players
 *
 */
public enum PlayerInfo
{
    /**
     * Generates the first player
     */
    PLAYER_1 (1, Mark.PLAYER1),
    
    /**
     * Generates the second player
     */
    PLAYER_2 (2, Mark.PLAYER2);
    
    /**
     * The player's number
     */
    private final int number;
    
    /**
     * The player's mark
     */
    private final Mark mark;

    /**
     * Generates a new player
     * @param number the new player's number
     * @param mark the new player's mark
     */
    private PlayerInfo(int number, Mark mark)
    {
        this.number = number;
        this.mark = mark;
    }

    /**
     * Returns the player's number
     * @return said number
     */
    public int getNumber()
    {
        return this.number;
    }

    /**
     * Returns the player's mark
     * @return said mark
     */
    public Mark getMark()
    {
        return this.mark;
    }
    
    /**
     * Gets the info of the player that's playing during the current turn
     * @param turn said turn
     * @return the player's playing this turn
     */
    public static PlayerInfo getPlayerInfoForGivenTurn(int turn)
    {
        if (turn % 2 == 1) return PLAYER_1;
        return PLAYER_2;
    }
}
