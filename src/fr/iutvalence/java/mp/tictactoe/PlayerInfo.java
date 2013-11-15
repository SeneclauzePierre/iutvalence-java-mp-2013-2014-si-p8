package fr.iutvalence.java.mp.tictactoe;

// TODO (FIXED) write comment
/**
 * This class identifies both of the game's players
 *
 */
public class PlayerInfo
{
    // TODO (FIXED) write comment
    /**
     * Generates the first player
     */
    private final static PlayerInfo PLAYER_1 = new PlayerInfo(1, Mark.PLAYER1);
    
    // TODO (FIXED) write comment
    /**
     * Generates the second player
     */
    private final static PlayerInfo PLAYER_2 = new PlayerInfo(2, Mark.PLAYER2);
    
    // TODO (FIXED) write comment
    /**
     * The player's number
     */
    private final int number;
    
    // TODO (FIXED) write comment
    /**
     * The player's mark
     */
    private final Mark mark;

    // TODO (FIXED) write comment
    /**
     * Generates a new player
     * @param number the new player's number
     * @param mark the new player's mark
     */
    private PlayerInfo(int number, Mark mark)
    {
        super();
        this.number = number;
        this.mark = mark;
    }

    // TODO (FIXED) write comment
    /**
     * Returns the player's number
     * @return said number
     */
    public int getNumber()
    {
        return this.number;
    }

    // TODO (FIXED) write comment
    /**
     * Returns the player's mark
     * @return said mark
     */
    public Mark getMark()
    {
        return this.mark;
    }
    
    // TODO (FIXED) write comment
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
