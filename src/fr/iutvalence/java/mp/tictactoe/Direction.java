package fr.iutvalence.java.mp.tictactoe;

public enum Direction
{
    // TODO (fix) write comment
    UP, DOWN, LEFT, RIGHT, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT;

    // TODO (fix) write comment
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
