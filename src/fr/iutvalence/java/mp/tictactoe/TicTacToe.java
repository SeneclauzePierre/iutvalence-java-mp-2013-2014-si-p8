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
 */
public class TicTacToe
{    
    /**
     * EMPTY
     * This constant means there is no symbol in a square
     */
    public final static int EMPTY = 0;
    /**
     * CROSS
     * This constant means the square contains a cross
     */
    public final static int CROSS = 1;
    /**
     * CIRCLE
     * This constant means the square contains a circle
     */
    public final static int CIRCLE = 2;
    /**
     * SIZE
     * This constant defines the size of an edge the grid 
     * in terms of squares
     */
    
    /**
     * UP_DOWN
     * This constant represents the direction Up to Down
     */
    public final static int UP_DOWN = 0;
    /**
     * LEFT_RIGHT
     * This constant represents the direction Left to Right
     */
    public final static int LEFT_RIGHT = 1;
    /**
     * UPLEFT_DOWNRIGHT
     * This constant represents the direction UpLeft to DownRight
     */
    public final static int UPLEFT_DOWNRIGHT = 2;
    /**
     * UPRIGHT_DOWNLEFT
     * This constant represents the direction UpRight to DownLeft
     */
    public final static int UPRIGHT_DOWNLEFT = 3;
    
    /**
     * SIZE
     * The size max of the grid
     */
    public final static int SIZE = 16;

    /**
     * grid[Ordinate][Abscissa]
     * Game's grid
     */
    private Square[][] grid;
    
    /**
     *  newGame
     *  This method generates a 16x16 grid 
     *  and allows for a new game to start
     */
    // TODO (fix) declare constructors as constructors
    public void newGame()
    {
        int i, j; // Point respectively on an ordinate and an abscissa
        for (i=1;i<=TicTacToe.SIZE;i++)
        {
            for (j=1;j<=TicTacToe.SIZE;j++)
            {
                this.grid[i][j] = new Square();
            }
        }
    }
    
    // TODO (fix) this class should only have one public metho called "play" that plays the entire
    // game when called (not a single turn)
    /**
     * gameTurn
     * Puts the player's symbol in the square located in (x,y)
     * @param player The number of the player playing this turn
     * @param x Ordinate of the square in which the player places his symbol
     * @param y Abscissa of the square in which the player places his symbol
     * @return A boolean stating if the symbol was succesfully place
     */
    public boolean gameTurn(int player, int x, int y)
    {
        if (this.grid[x][y].isEmpty())
        {
            /* If the player chose an empty square...  */
            this.grid[x][y].newValue(player);
            this.checkLine(player, x, y);
            return true;
        }
        else
            return false;
    }
    
    /**
     * checkLine
     * Checks if one or more lines are completed
     * @param player The number of the player who played this turn
     * @param x Ordinate of the square in which the symbol has been placed
     * @param y Abscissa of the square in which the symbol has been placed
     */
    public void checkLine(int player, int x, int y)
    {
      int n, m;
      n = 1; m = 1;
          // Check UP_DOWN --------
      while ((y-n)>= 0 && this.grid[x][y-n].checkValue() == this.grid[x][y].checkValue()
              && n<5 && !this.grid[x][y-n].seeLine(UP_DOWN))
      {
          n++;
      }
      while ((y+m)<= TicTacToe.SIZE && this.grid[x][y+m].checkValue() == this.grid[x][y].checkValue()
              && n<5 && !this.grid[x][y+m].seeLine(UP_DOWN))
      {
          n++; m++;
      }
      m--;
      if (n == 5)
      {
          //TODO (fix) Add an attribute score and add one point here
          for (n=4;n>=0;n--)
          {
              this.grid[x][y+m-n].seeLine(UP_DOWN);
          }
      }
      
      n = 1; m = 1;
          // Check LEFT_RIGHT --------
      while ((x-n)>= 0 && this.grid[x-n][y].checkValue() == this.grid[x][y].checkValue()
              && n<5 && !this.grid[x-n][y].seeLine(LEFT_RIGHT))
      {
          n++;
      }
      while ((x+m)<= TicTacToe.SIZE && this.grid[x+m][y].checkValue() == this.grid[x][y].checkValue()
              && n<5 && !this.grid[x+m][y].seeLine(LEFT_RIGHT))
      {
          n++; m++;
      }
      m--;
      if (n == 5)
      {
          //TODO (fix) Add an attribute score and add one point here
          for (n=4;n>=0;n--)
          {
              this.grid[x+m-n][y].useLine(LEFT_RIGHT);
          }
      }
      
      n = 1; m = 1;
          // Check UPLEFT_DOWNRIGHT -------
      while ((y-n)>= 0 && (x-n)>= 0 && this.grid[x-n][y-n].checkValue() == this.grid[x][y].checkValue()
              && n<5 && !this.grid[x-n][y-n].seeLine(UPLEFT_DOWNRIGHT))
      {
          n++;
      }
      while ((y+m)<= TicTacToe.SIZE && (x+m)<= TicTacToe.SIZE && this.grid[x+m][y+m].checkValue() == this.grid[x][y].checkValue()
              && n<5 && !this.grid[x+m][y+m].seeLine(UPLEFT_DOWNRIGHT))
      {
          n++; m++;
      }
      m--;
      if (n == 5)
      {
          //TODO (fix) Add an attribute score and add one point here
          for (n=4;n>=0;n--)
          {
              this.grid[x+m-n][y+m-n].useLine(UPLEFT_DOWNRIGHT);
          }
      }
      
      n = 1; m = 1;
          // Check UPRIGHT_DOWNLEFT -------
      while ((y-n)>= 0 && (x+m)<= TicTacToe.SIZE && this.grid[x+n][y-n].checkValue() == this.grid[x][y].checkValue()
              && n<5 && !this.grid[x+n][y-n].seeLine(UPRIGHT_DOWNLEFT))
      {
          n++;
      }
      while ((y+m)<= TicTacToe.SIZE && (x-m)>= 0 && this.grid[x-m][y+m].checkValue() == this.grid[x][y].checkValue()
              && n<5 && !this.grid[x-m][y+m].seeLine(UPRIGHT_DOWNLEFT))
      {
          n++; m++;
      }
      m--;
      if (n == 5)
      {
          //TODO (fix) Add an attribute score and add one point here
          for (n=4;n>=0;n--)
          {
              this.grid[x-m+n][y+m-n].useLine(UPRIGHT_DOWNLEFT);
          }
      }
    }
    
}