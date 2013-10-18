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
    
    // TODO (FIXED) detail comment
    /**
     * Default grid size (grid is supposed to have the same height and width)
     */
    public final static int DEFAULT_GRID_SIZE = 16;

    // TODO (FIXED) detail comment
    /**
     * Number of marks that need to be aligned in order to score
     */
    public final static int NUMBER_OF_MARKS_NEEDED_TO_SCORE = 5;
    
    /**
     * 
     * The default duration of the game in number of turns
     */
    public final static int DEFAULT_NUMBER_OF_TURNS = 100;
    
    /**
     * 
     * The default number of players 
     */
    public final static int DEFAULT_NUMBER_OF_PLAYERS = 2;

    /**
     * grid[line][column] Game's grid
     */
    private Square[][] grid;
    
    /**
     * score[ID's player] Keeps track of each player's score
     */
    private int[] playersScores;
    

    /**
     *  
     * Creates a new TicTacToe game, with a grid whose size is <tt>DEFAULT_GRID_SIZE</tt>*
     *
     */
    public TicTacToe()
    {
        initGrid();
        
        initPlayersScores();
    }

    /**
     * 
     */
    private void initPlayersScores()
    {
        this.playersScores = new int[DEFAULT_NUMBER_OF_PLAYERS];

        for (int playerNumber = 0; playerNumber < DEFAULT_NUMBER_OF_PLAYERS; playerNumber++)
        {
            this.playersScores[playerNumber] = 0; 
        }
    }

    /**
     * 
     */
    private void initGrid()
    {
        this.grid = new Square[DEFAULT_GRID_SIZE][DEFAULT_GRID_SIZE];
        
        for (int lineNumber = 0; lineNumber < DEFAULT_GRID_SIZE; lineNumber++)
        {
            for (int columnNumber = 0; columnNumber < DEFAULT_GRID_SIZE; columnNumber++)
            {
                this.grid[columnNumber][lineNumber] = new Square();
            }
        }
    }
    
    /**
     * play Handles the whole game from beginning to end, according to the
     * rules. Makes the players play one after another.
     */
    public void play()
    {
        boolean verif = false;
        // TODO (FIXED) declare hard-coded values as constants
        
 
        for (int turn=0; turn < DEFAULT_NUMBER_OF_TURNS; turn++) /* Victory or end of game conditions (to be modified) */
        {
            for (int player = 0; player < DEFAULT_NUMBER_OF_PLAYERS; player++)
            {
                while (true)
                {
                    int abs = (int) (DEFAULT_GRID_SIZE * Math.random());
                    int ord = (int) (DEFAULT_GRID_SIZE * Math.random());
                    if (this.gameTurn(player, abs, ord))
                    {
                        System.out.println("Joueur " + player + " a posé sa marque en [" + abs + "," + ord + "] -- Tour : "
                            + (turn + 1));
                        break;
                    }
                    System.out.println("...mais est un gros boulet !");
                }
            }
        }
        for (int player = 0; player < DEFAULT_NUMBER_OF_PLAYERS; player++)
            System.out.println("Score Joueur " + player + " : "+ this.playersScores[player]);
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
                && numberofsurroundingsymbols < NUMBER_OF_MARKS_NEEDED_TO_SCORE && !this.grid[abs][ord - numberofsurroundingsymbols].seeLine(Square.UP_DOWN))
        {
            numberofsurroundingsymbols++;
        }
        while ((ord + numberofsymbolsbelow) < DEFAULT_GRID_SIZE && this.grid[abs][ord + numberofsymbolsbelow].checkValue() == this.grid[abs][ord].checkValue()
                && numberofsurroundingsymbols < NUMBER_OF_MARKS_NEEDED_TO_SCORE && !this.grid[abs][ord + numberofsymbolsbelow].seeLine(Square.UP_DOWN))
        {
            numberofsurroundingsymbols++;
            numberofsymbolsbelow++;
        }
        numberofsymbolsbelow--;
        if (numberofsurroundingsymbols == NUMBER_OF_MARKS_NEEDED_TO_SCORE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en UP_DOWN");
            this.playersScores[player]++;
            for (numberofsurroundingsymbols = NUMBER_OF_MARKS_NEEDED_TO_SCORE - 1; numberofsurroundingsymbols >= 0; numberofsurroundingsymbols--)
            {
                this.grid[abs][ord + numberofsymbolsbelow - numberofsurroundingsymbols].seeLine(Square.UP_DOWN);
            }
        }

        numberofsurroundingsymbols = 1;
        numberofsymbolsbelow = 1;
        // Check LEFT_RIGHT --------
        while ((abs - numberofsurroundingsymbols) >= 0 && this.grid[abs - numberofsurroundingsymbols][ord].checkValue() == this.grid[abs][ord].checkValue()
                && numberofsurroundingsymbols < NUMBER_OF_MARKS_NEEDED_TO_SCORE && !this.grid[abs - numberofsurroundingsymbols][ord].seeLine(Square.LEFT_RIGHT))
        {
            numberofsurroundingsymbols++;
        }
        while ((abs + numberofsymbolsbelow) < DEFAULT_GRID_SIZE && this.grid[abs + numberofsymbolsbelow][ord].checkValue() == this.grid[abs][ord].checkValue()
                && numberofsurroundingsymbols < NUMBER_OF_MARKS_NEEDED_TO_SCORE && !this.grid[abs + numberofsymbolsbelow][ord].seeLine(Square.LEFT_RIGHT))
        {
            numberofsurroundingsymbols++;
            numberofsymbolsbelow++;
        }
        numberofsymbolsbelow--;
        if (numberofsurroundingsymbols == NUMBER_OF_MARKS_NEEDED_TO_SCORE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en LEFT_RIGHT");
            this.playersScores[player]++;
            for (numberofsurroundingsymbols = NUMBER_OF_MARKS_NEEDED_TO_SCORE - 1; numberofsurroundingsymbols >= 0; numberofsurroundingsymbols--)
            {
                this.grid[abs + numberofsymbolsbelow - numberofsurroundingsymbols][ord].useLine(Square.LEFT_RIGHT);
            }
        }

        numberofsurroundingsymbols = 1;
        numberofsymbolsbelow = 1;
        // Check UPLEFT_DOWNRIGHT -------
        while ((ord - numberofsurroundingsymbols) >= 0 && (abs - numberofsurroundingsymbols) >= 0 && this.grid[abs - numberofsurroundingsymbols][ord - numberofsurroundingsymbols].checkValue() == this.grid[abs][ord].checkValue()
                && numberofsurroundingsymbols < NUMBER_OF_MARKS_NEEDED_TO_SCORE && !this.grid[abs - numberofsurroundingsymbols][ord - numberofsurroundingsymbols].seeLine(Square.UPLEFT_DOWNRIGHT))
        {
            numberofsurroundingsymbols++;
        }
        while ((ord + numberofsymbolsbelow) < DEFAULT_GRID_SIZE && (abs + numberofsymbolsbelow) < DEFAULT_GRID_SIZE
                && this.grid[abs + numberofsymbolsbelow][ord + numberofsymbolsbelow].checkValue() == this.grid[abs][ord].checkValue() && numberofsurroundingsymbols < NUMBER_OF_MARKS_NEEDED_TO_SCORE
                && !this.grid[abs + numberofsymbolsbelow][ord + numberofsymbolsbelow].seeLine(Square.UPLEFT_DOWNRIGHT))
        {
            numberofsurroundingsymbols++;
            numberofsymbolsbelow++;
        }
        numberofsymbolsbelow--;
        if (numberofsurroundingsymbols == NUMBER_OF_MARKS_NEEDED_TO_SCORE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en UPLEFT_DOWNRIGHT");
            this.playersScores[player]++;
            for (numberofsurroundingsymbols = NUMBER_OF_MARKS_NEEDED_TO_SCORE - 1; numberofsurroundingsymbols >= 0; numberofsurroundingsymbols--)
            {
                this.grid[abs + numberofsymbolsbelow - numberofsurroundingsymbols][ord + numberofsymbolsbelow - numberofsurroundingsymbols].useLine(Square.UPLEFT_DOWNRIGHT);
            }
        }

        numberofsurroundingsymbols = 1;
        numberofsymbolsbelow = 1;
        // Check UPRIGHT_DOWNLEFT -------
        while ((ord - numberofsurroundingsymbols) >= 0 && (abs + numberofsurroundingsymbols) < DEFAULT_GRID_SIZE
                && this.grid[abs + numberofsurroundingsymbols][ord - numberofsurroundingsymbols].checkValue() == this.grid[abs][ord].checkValue() && numberofsurroundingsymbols < NUMBER_OF_MARKS_NEEDED_TO_SCORE
                && !this.grid[abs + numberofsurroundingsymbols][ord - numberofsurroundingsymbols].seeLine(Square.UPRIGHT_DOWNLEFT))
        {
            numberofsurroundingsymbols++;
        }
        while ((ord + numberofsymbolsbelow) < DEFAULT_GRID_SIZE && (abs - numberofsymbolsbelow) >= 0
                && this.grid[abs - numberofsymbolsbelow][ord + numberofsymbolsbelow].checkValue() == this.grid[abs][ord].checkValue() && numberofsurroundingsymbols < NUMBER_OF_MARKS_NEEDED_TO_SCORE
                && !this.grid[abs - numberofsymbolsbelow][ord + numberofsymbolsbelow].seeLine(Square.UPRIGHT_DOWNLEFT))
        {
            numberofsurroundingsymbols++;
            numberofsymbolsbelow++;
        }
        numberofsymbolsbelow--;
        if (numberofsurroundingsymbols == NUMBER_OF_MARKS_NEEDED_TO_SCORE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en UPRIGHT_DOWNLEFT");
            this.playersScores[player]++;
            for (numberofsurroundingsymbols = NUMBER_OF_MARKS_NEEDED_TO_SCORE - 1; numberofsurroundingsymbols >= 0; numberofsurroundingsymbols--)
            {
                this.grid[abs - numberofsymbolsbelow + numberofsurroundingsymbols][ord + numberofsymbolsbelow - numberofsurroundingsymbols].useLine(Square.UPRIGHT_DOWNLEFT);
            }
        }
    }

}