package fr.iutvalence.java.mp.tictactoe;

/**
 * TicTacToe
 * 
 * This class is used to start and handle a new game.
 * 
 * @version 0.0
 * 
 *          2013-09-20
 * 
 * @author seneclap
 * 
 */
public class TicTacToe
{
    // TODO (FIXED) these constants are already defined in Square
    
    // TODO (FIXED) detail comment
    /**
     * SIZE The maximum size of the grid
     * A maximum of SIZE symbols can be placed on a grid's line or column
     * After that, the grid's line/column is full
     */
    public final static int SIZE = 16;

    // TODO (FIXED) detail comment
    /**
     * SIZE_LINE The number of symbols that need to be lined up to score
     * When SIZE_LINE symbols are lined up, the player playing these symbols scores
     */
    public final static int SIZE_LINE = 5;
    
    /**
     * MAX_TURN
     * The number of turns played before the end of the game
     */
    public final static int MAX_TURN = 100;
    
    /**
     * N_PLAYERS
     * The number of players (these comments are getting more and more obvious, aren't they ?)
     */
    public final static int N_PLAYERS = 2;

    /**
     * grid[Ordinate][Abscissa] Game's grid
     */
    private Square[][] grid;
    
    /**
     * score[ID's player] Keeps track of each player's score
     */
    private int[] score;
    

    /**
     * TicTacToe Constructor This method generates a 16x16 grid and allows for a
     * new game to start
     */
    public TicTacToe()
    {
        this.grid = new Square[SIZE][SIZE];
        int i, j; // Point respectively on an ordinate and an abscissa
        for (i = 0; i < SIZE; i++)
        {
            for (j = 0; j < SIZE; j++)
            {
                this.grid[i][j] = new Square();
            }
        }
        this.score = new int[N_PLAYERS + 1];
        int player;
        for (player = 1; player <= N_PLAYERS; player++)
        {
            this.score[player] = 0; 
        }
    }
    
    /**
     * play Handles the whole game from beginning to end, according to the
     * rules. Makes the players play one after another.
     */
    public void play()
    {
        int t = 0;
        boolean verif = false;
        // TODO (FIXED) declare hard-coded values as constants
        
        while (t < MAX_TURN) /* Victory or end of game conditions (to be modified) */
        {
            for (int i = 1; i <= N_PLAYERS; i++)
            {
                while (!verif)
                {
                    int x = (int) (SIZE * Math.random());
                    int y = (int) (SIZE * Math.random());
                    verif = this.gameTurn(i, x, y);
                    System.out.println("Joueur " + i + " a posé sa marque en [" + x + "," + y + "] -- Tour : "
                            + (t + 1));
                    if (!verif)
                    {
                        System.out.println("...mais est un gros boulet !");
                    }
                    x++;
                }
                verif = false;
            }
            t++;
        }
        int i;
        for (i = 1; i <= N_PLAYERS; i++)
            System.out.println("Score Joueur " + i + " : "+ this.score[i]);
    }

    /**
     * gameTurn Puts the player's symbol in the square located in (x,y)
     * 
     * @param player
     *            The number of the player playing this turn
     * @param x
     *            Ordinate of the square in which the player places his symbol
     * @param y
     *            Abscissa of the square in which the player places his symbol
     * @return A boolean stating if the symbol was successfully place
     */
    private boolean gameTurn(int player, int x, int y)
    {
        if (this.grid[x][y].isEmpty())
        {
            /* If the player chose an empty square... */
            this.grid[x][y].newValue(player);
            this.checkLine(player, x, y);
            return true;
        }
        else
            return false;
    }

    /**
     * checkLine Checks if one or more lines are completed
     * 
     * @param player
     *            The number of the player who played this turn
     * @param x
     *            Ordinate of the square in which the symbol has been placed
     * @param y
     *            Abscissa of the square in which the symbol has been placed
     */
    private void checkLine(int player, int x, int y)
    {
        int n, m;
        n = 1;
        m = 1;
        // Check UP_DOWN --------
        while ((y - n) >= 0 && this.grid[x][y - n].checkValue() == this.grid[x][y].checkValue()
                && n < SIZE_LINE && !this.grid[x][y - n].seeLine(Square.UP_DOWN))
        {
            n++;
        }
        while ((y + m) < SIZE && this.grid[x][y + m].checkValue() == this.grid[x][y].checkValue()
                && n < SIZE_LINE && !this.grid[x][y + m].seeLine(Square.UP_DOWN))
        {
            n++;
            m++;
        }
        m--;
        if (n == SIZE_LINE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en UP_DOWN");
            this.score[player]++;
            for (n = SIZE_LINE - 1; n >= 0; n--)
            {
                this.grid[x][y + m - n].seeLine(Square.UP_DOWN);
            }
        }

        n = 1;
        m = 1;
        // Check LEFT_RIGHT --------
        while ((x - n) >= 0 && this.grid[x - n][y].checkValue() == this.grid[x][y].checkValue()
                && n < SIZE_LINE && !this.grid[x - n][y].seeLine(Square.LEFT_RIGHT))
        {
            n++;
        }
        while ((x + m) < SIZE && this.grid[x + m][y].checkValue() == this.grid[x][y].checkValue()
                && n < SIZE_LINE && !this.grid[x + m][y].seeLine(Square.LEFT_RIGHT))
        {
            n++;
            m++;
        }
        m--;
        if (n == SIZE_LINE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en LEFT_RIGHT");
            this.score[player]++;
            for (n = SIZE_LINE - 1; n >= 0; n--)
            {
                this.grid[x + m - n][y].useLine(Square.LEFT_RIGHT);
            }
        }

        n = 1;
        m = 1;
        // Check UPLEFT_DOWNRIGHT -------
        while ((y - n) >= 0 && (x - n) >= 0 && this.grid[x - n][y - n].checkValue() == this.grid[x][y].checkValue()
                && n < SIZE_LINE && !this.grid[x - n][y - n].seeLine(Square.UPLEFT_DOWNRIGHT))
        {
            n++;
        }
        while ((y + m) < SIZE && (x + m) < SIZE
                && this.grid[x + m][y + m].checkValue() == this.grid[x][y].checkValue() && n < SIZE_LINE
                && !this.grid[x + m][y + m].seeLine(Square.UPLEFT_DOWNRIGHT))
        {
            n++;
            m++;
        }
        m--;
        if (n == SIZE_LINE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en UPLEFT_DOWNRIGHT");
            this.score[player]++;
            for (n = SIZE_LINE - 1; n >= 0; n--)
            {
                this.grid[x + m - n][y + m - n].useLine(Square.UPLEFT_DOWNRIGHT);
            }
        }

        n = 1;
        m = 1;
        // Check UPRIGHT_DOWNLEFT -------
        while ((y - n) >= 0 && (x + n) < SIZE
                && this.grid[x + n][y - n].checkValue() == this.grid[x][y].checkValue() && n < SIZE_LINE
                && !this.grid[x + n][y - n].seeLine(Square.UPRIGHT_DOWNLEFT))
        {
            n++;
        }
        while ((y + m) < SIZE && (x - m) >= 0
                && this.grid[x - m][y + m].checkValue() == this.grid[x][y].checkValue() && n < SIZE_LINE
                && !this.grid[x - m][y + m].seeLine(Square.UPRIGHT_DOWNLEFT))
        {
            n++;
            m++;
        }
        m--;
        if (n == SIZE_LINE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en UPRIGHT_DOWNLEFT");
            this.score[player]++;
            for (n = SIZE_LINE - 1; n >= 0; n--)
            {
                this.grid[x - m + n][y + m - n].useLine(Square.UPRIGHT_DOWNLEFT);
            }
        }
    }

}