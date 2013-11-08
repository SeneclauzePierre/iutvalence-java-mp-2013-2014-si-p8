package fr.iutvalence.java.mp.tictactoe;

public class PlayersChoice
{
    public Position inputPlayersChoice()
    {
        int column = (int) (Grid.DEFAULT_GRID_SIZE * Math.random());
        int line = (int) (Grid.DEFAULT_GRID_SIZE * Math.random());
        return new Position(column, line);
    }
}
