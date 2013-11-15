package fr.iutvalence.java.mp.tictactoe;

/**
 * Enumerates all different directions
 *
 */
public enum Direction
{
    // TODO (FIXED) write comment
    /**
     * Represents the upward direction
     */
    UP, 
    /**
     * Represents the downward direction
     */
    DOWN, 
    /**
     * Represents the left direction
     */
    LEFT,
    /**
     * Represents the right direction
     */
    RIGHT, 
    /**
     * Represents the diagonal up-left direction
     */
    UP_LEFT, 
    /**
     * Represents the diagonal up-right direction
     */
    UP_RIGHT, 
    /**
     * Represents the diagonal down-left direction
     */
    DOWN_LEFT, 
    /**
     * Represents the diagonal down-right direction
     */
    DOWN_RIGHT;

    // TODO (FIXED) write comment
    /**
     * Returns the axis that corresponds to each direction 
     * @return said axis
     */
    public Axis getAxis()
    {
        switch (this)
        {
        case UP:
        case DOWN:
            return Axis.UP_DOWN;
        case LEFT:
        case RIGHT:
            return Axis.LEFT_RIGHT;
        case UP_LEFT:
        case DOWN_RIGHT:
            return Axis.UP_LEFT_DOWN_RIGHT;
        default:
            return Axis.UP_RIGHT_DOWN_LEFT;
        }
    }
}
