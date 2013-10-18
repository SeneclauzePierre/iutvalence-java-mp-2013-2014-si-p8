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
        int ord, abs; // Point respectively on an ordinate and an abscissa
        for (ord = 0; ord < SIZE; ord++)
        {
            for (abs = 0; abs < SIZE; abs++)
            {
                this.grid[abs][ord] = new Square();
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
        int turn = 0;
        int player;
        boolean verif = false;
        // TODO (FIXED) declare hard-coded values as constants
        
        while (turn < MAX_TURN) /* Victory or end of game conditions (to be modified) */
        {
            for (player = 1; player <= N_PLAYERS; player++)
            {
                while (!verif)
                {
                    int abs = (int) (SIZE * Math.random());
                    int ord = (int) (SIZE * Math.random());
                    verif = this.gameTurn(player, abs, ord);
                    System.out.println("Joueur " + player + " a posé sa marque en [" + abs + "," + ord + "] -- Tour : "
                            + (turn + 1));
                    if (!verif)
                    {
                        System.out.println("...mais est un gros boulet !");
                    }
                    abs++;
                }
                verif = false;
            }
            turn++;
        }
        for (player = 1; player <= N_PLAYERS; player++)
            System.out.println("Score Joueur " + player + " : "+ this.score[player]);
    }

    /**
     * gameTurn Puts the player's symbol in the square located in (x,y)
     * 
     * @param player
     *            The number of the player playing this turn
     * @param abs
     *            Ordinate of the square in which the player places his symbol
     * @param ord
     *            Abscissa of the square in which the player places his symbol
     * @return A boolean stating if the symbol was successfully place
     */
    private boolean gameTurn(int player, int abs, int ord)
    {
        if (this.grid[abs][ord].isEmpty())
        {
            /* If the player chose an empty square... */
            this.grid[abs][ord].newValue(player);
            this.checkLine(player, abs, ord);
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
     * @param abs
     *            Ordinate of the square in which the symbol has been placed
     * @param ord
     *            Abscissa of the square in which the symbol has been placed
     */
    private void checkLine(int player, int abs, int ord)
    {
        int numberofsurroundingsymbols = 1; 
        int numberofsymbolsbelow = 1;
        // Check UP_DOWN --------
        while ((ord - numberofsurroundingsymbols) >= 0 && this.grid[abs][ord - numberofsurroundingsymbols].checkValue() == this.grid[abs][ord].checkValue()
                && numberofsurroundingsymbols < SIZE_LINE && !this.grid[abs][ord - numberofsurroundingsymbols].seeLine(Square.UP_DOWN))
        {
            numberofsurroundingsymbols++;
        }
        while ((ord + numberofsymbolsbelow) < SIZE && this.grid[abs][ord + numberofsymbolsbelow].checkValue() == this.grid[abs][ord].checkValue()
                && numberofsurroundingsymbols < SIZE_LINE && !this.grid[abs][ord + numberofsymbolsbelow].seeLine(Square.UP_DOWN))
        {
            numberofsurroundingsymbols++;
            numberofsymbolsbelow++;
        }
        numberofsymbolsbelow--;
        if (numberofsurroundingsymbols == SIZE_LINE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en UP_DOWN");
            this.score[player]++;
            for (numberofsurroundingsymbols = SIZE_LINE - 1; numberofsurroundingsymbols >= 0; numberofsurroundingsymbols--)
            {
                this.grid[abs][ord + numberofsymbolsbelow - numberofsurroundingsymbols].seeLine(Square.UP_DOWN);
            }
        }

        numberofsurroundingsymbols = 1;
        numberofsymbolsbelow = 1;
        // Check LEFT_RIGHT --------
        while ((abs - numberofsurroundingsymbols) >= 0 && this.grid[abs - numberofsurroundingsymbols][ord].checkValue() == this.grid[abs][ord].checkValue()
                && numberofsurroundingsymbols < SIZE_LINE && !this.grid[abs - numberofsurroundingsymbols][ord].seeLine(Square.LEFT_RIGHT))
        {
            numberofsurroundingsymbols++;
        }
        while ((abs + numberofsymbolsbelow) < SIZE && this.grid[abs + numberofsymbolsbelow][ord].checkValue() == this.grid[abs][ord].checkValue()
                && numberofsurroundingsymbols < SIZE_LINE && !this.grid[abs + numberofsymbolsbelow][ord].seeLine(Square.LEFT_RIGHT))
        {
            numberofsurroundingsymbols++;
            numberofsymbolsbelow++;
        }
        numberofsymbolsbelow--;
        if (numberofsurroundingsymbols == SIZE_LINE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en LEFT_RIGHT");
            this.score[player]++;
            for (numberofsurroundingsymbols = SIZE_LINE - 1; numberofsurroundingsymbols >= 0; numberofsurroundingsymbols--)
            {
                this.grid[abs + numberofsymbolsbelow - numberofsurroundingsymbols][ord].useLine(Square.LEFT_RIGHT);
            }
        }

        numberofsurroundingsymbols = 1;
        numberofsymbolsbelow = 1;
        // Check UPLEFT_DOWNRIGHT -------
        while ((ord - numberofsurroundingsymbols) >= 0 && (abs - numberofsurroundingsymbols) >= 0 && this.grid[abs - numberofsurroundingsymbols][ord - numberofsurroundingsymbols].checkValue() == this.grid[abs][ord].checkValue()
                && numberofsurroundingsymbols < SIZE_LINE && !this.grid[abs - numberofsurroundingsymbols][ord - numberofsurroundingsymbols].seeLine(Square.UPLEFT_DOWNRIGHT))
        {
            numberofsurroundingsymbols++;
        }
        while ((ord + numberofsymbolsbelow) < SIZE && (abs + numberofsymbolsbelow) < SIZE
                && this.grid[abs + numberofsymbolsbelow][ord + numberofsymbolsbelow].checkValue() == this.grid[abs][ord].checkValue() && numberofsurroundingsymbols < SIZE_LINE
                && !this.grid[abs + numberofsymbolsbelow][ord + numberofsymbolsbelow].seeLine(Square.UPLEFT_DOWNRIGHT))
        {
            numberofsurroundingsymbols++;
            numberofsymbolsbelow++;
        }
        numberofsymbolsbelow--;
        if (numberofsurroundingsymbols == SIZE_LINE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en UPLEFT_DOWNRIGHT");
            this.score[player]++;
            for (numberofsurroundingsymbols = SIZE_LINE - 1; numberofsurroundingsymbols >= 0; numberofsurroundingsymbols--)
            {
                this.grid[abs + numberofsymbolsbelow - numberofsurroundingsymbols][ord + numberofsymbolsbelow - numberofsurroundingsymbols].useLine(Square.UPLEFT_DOWNRIGHT);
            }
        }

        numberofsurroundingsymbols = 1;
        numberofsymbolsbelow = 1;
        // Check UPRIGHT_DOWNLEFT -------
        while ((ord - numberofsurroundingsymbols) >= 0 && (abs + numberofsurroundingsymbols) < SIZE
                && this.grid[abs + numberofsurroundingsymbols][ord - numberofsurroundingsymbols].checkValue() == this.grid[abs][ord].checkValue() && numberofsurroundingsymbols < SIZE_LINE
                && !this.grid[abs + numberofsurroundingsymbols][ord - numberofsurroundingsymbols].seeLine(Square.UPRIGHT_DOWNLEFT))
        {
            numberofsurroundingsymbols++;
        }
        while ((ord + numberofsymbolsbelow) < SIZE && (abs - numberofsymbolsbelow) >= 0
                && this.grid[abs - numberofsymbolsbelow][ord + numberofsymbolsbelow].checkValue() == this.grid[abs][ord].checkValue() && numberofsurroundingsymbols < SIZE_LINE
                && !this.grid[abs - numberofsymbolsbelow][ord + numberofsymbolsbelow].seeLine(Square.UPRIGHT_DOWNLEFT))
        {
            numberofsurroundingsymbols++;
            numberofsymbolsbelow++;
        }
        numberofsymbolsbelow--;
        if (numberofsurroundingsymbols == SIZE_LINE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en UPRIGHT_DOWNLEFT");
            this.score[player]++;
            for (numberofsurroundingsymbols = SIZE_LINE - 1; numberofsurroundingsymbols >= 0; numberofsurroundingsymbols--)
            {
                this.grid[abs - numberofsymbolsbelow + numberofsurroundingsymbols][ord + numberofsymbolsbelow - numberofsurroundingsymbols].useLine(Square.UPRIGHT_DOWNLEFT);
            }
        }
    }

}