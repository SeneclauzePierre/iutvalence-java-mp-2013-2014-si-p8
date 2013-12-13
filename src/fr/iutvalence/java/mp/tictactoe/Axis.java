package fr.iutvalence.java.mp.tictactoe;

/**
 * Enumerate all different axis
 * 
 */
public enum Axis
{ 
    /**
     * represents the up-down axis
     */
    UP_DOWN,
    /**
     * represents the left-right axis
     */
    LEFT_RIGHT,
    /**
     * represents the up_right-down_left axis
     */
    UP_RIGHT_DOWN_LEFT,
    /**
     * represents the up_left-down_right axis
     */
    UP_LEFT_DOWN_RIGHT;

    /**
     * Returns the first direction checked depending on the axis checked 
     * @return primary direction
     */
    public Direction getPrimaryDirection()
    {
        switch (this)
        {
        case UP_DOWN:
            return Direction.UP;
        case LEFT_RIGHT:
            return Direction.RIGHT;
        case UP_LEFT_DOWN_RIGHT:
            return Direction.UP_LEFT;
        default:
            return Direction.UP_RIGHT;
        }
    }

    /**
     * Returns the second direction checked depending on the axis checked
     * @return secondary direction
     */
    public Direction getSecondaryDirection()
    {
        switch (this)
        {
        case UP_DOWN:
            return Direction.DOWN;
        case LEFT_RIGHT:
            return Direction.LEFT;
        case UP_LEFT_DOWN_RIGHT:
            return Direction.DOWN_RIGHT;
        default:
            return Direction.DOWN_LEFT;
        }
    }
}
