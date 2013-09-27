package fr.iutvalence.java.mp.tictactoe;

/**
 * TicTacToe
 * 
 * This class is used to start and handle a new game.
 * 
 * @version 0.0
 * 
 * 2013-09-20
 * 
 * @author seneclap
 *
 * //TODO (FIXED) misplaced comment (class comment should be placed before any other tag)
 */
public class TicTacToe
{
    
    /**
     * grid[Ordinate][Abscissa]
     * Game's grid
     */
    private Square grid[][];
    
    /**
     *  NewGame
     *  This method generates a 16x16 grid 
     *  and allows for a new game to start
     */
    public void NewGame()
    {
        int i, j; // Point respectively on an ordinate and an abscissa
        for (i=1;i<17;i++)
        {
            for (j=1;j<17;j++)
            {
                this.grid[i][j] = new Square();
            }
        }
    }
}