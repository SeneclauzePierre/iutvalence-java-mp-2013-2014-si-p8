package fr.iutvalence.java.mp.tictactoe;

//TODO (fix) write comment
public class Player
{
    // TODO (fix) write comment
    public Position getChoice()
    {
        int column = (int) (Grid.DEFAULT_GRID_SIZE * Math.random());
        int line = (int) (Grid.DEFAULT_GRID_SIZE * Math.random());
        return new Position(column, line);
    }
}
