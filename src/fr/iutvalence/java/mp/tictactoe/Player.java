package fr.iutvalence.java.mp.tictactoe;

//TODO (FIXED) write comment
/**
 * This class represents the actions of the game's players
 *
 */
public class Player
{
    // TODO (FIXED) write comment
    /**
     * Gets the position in which the player has decided to put his mark
     * @return said position
     */
    public Position getChoice()
    {
        int column = (int) (Grid.DEFAULT_GRID_SIZE * Math.random());
        int line = (int) (Grid.DEFAULT_GRID_SIZE * Math.random());
        return new Position(column, line);
    }
}
