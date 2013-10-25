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

    
    private Grid grid;

    /**
     * score[ID's player] Keeps track of each player's score
     */
    private int[] playersScores;

    /**
     * 
     * Creates a new TicTacToe game, with a grid whose size is
     * <tt>DEFAULT_GRID_SIZE</tt>*
     * 
     */
    public TicTacToe()
    {
        this.grid = new Grid();
        
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
     * play Handles the whole game from beginning to end, according to the
     * rules. Makes the players play one after another.
     */
    public void play()
    {
        boolean verif = false;

        for (int turn = 0; turn < DEFAULT_NUMBER_OF_TURNS; turn++)
        /*
         * Victory or end of game conditions (to be modified)
         */
        {
            for (int player = 0; player < DEFAULT_NUMBER_OF_PLAYERS; player++)
            {
                while (true)
                {
                    int abs = (int) (Grid.DEFAULT_GRID_SIZE * Math.random());
                    int ord = (int) (Grid.DEFAULT_GRID_SIZE * Math.random());
                    if (this.gameTurn(player, new Position(abs, ord)))
                    {
                        System.out.println("Joueur " + player + " a posé sa marque en [" + abs + "," + ord
                                + "] -- Tour : " + (turn + 1));
                        break;
                    }
                    System.out.println("...mais est un gros boulet !");
                }
            }
        }
        for (int player = 0; player < DEFAULT_NUMBER_OF_PLAYERS; player++)
            System.out.println("Score Joueur " + player + " : " + this.playersScores[player]);
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
     * @param position 
     * @return A boolean stating if the symbol was successfully place
     */
    private boolean gameTurn(int player, Position position)
    {
        Square square = null;
        try
        {
            square = this.grid.getSquareAt(position);
        }
        catch (PositionOutOfBoundsException e)
        {
         return false;
        }
        
        /* If the player chose an empty square... */
        square.udpateMark(player);
        this.checkLine(player, position);
        return true;

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
    // TODO (fix) make this method more readable
    private void checkLine(int player, Position position)
    {
        
        checkUpDown(player, position);

        numberOfSimilarSymbolsConnectedOnSameLine = 1;
        numberofsymbolsbelow = 1;
        // Check LEFT_RIGHT --------
        while ((abs - numberOfSimilarSymbolsConnectedOnSameLine) >= 0
                && this.grid[abs - numberOfSimilarSymbolsConnectedOnSameLine][ord].getValue() == this.grid[abs][ord].getValue()
                && numberOfSimilarSymbolsConnectedOnSameLine < NUMBER_OF_MARKS_NEEDED_TO_SCORE
                && !this.grid[abs - numberOfSimilarSymbolsConnectedOnSameLine][ord].seeLine(Square.LEFT_RIGHT))
        {
            numberOfSimilarSymbolsConnectedOnSameLine++;
        }
        while ((abs + numberofsymbolsbelow) < DEFAULT_GRID_SIZE
                && this.grid[abs + numberofsymbolsbelow][ord].getValue() == this.grid[abs][ord].getValue()
                && numberOfSimilarSymbolsConnectedOnSameLine < NUMBER_OF_MARKS_NEEDED_TO_SCORE
                && !this.grid[abs + numberofsymbolsbelow][ord].seeLine(Square.LEFT_RIGHT))
        {
            numberOfSimilarSymbolsConnectedOnSameLine++;
            numberofsymbolsbelow++;
        }
        numberofsymbolsbelow--;
        if (numberOfSimilarSymbolsConnectedOnSameLine == NUMBER_OF_MARKS_NEEDED_TO_SCORE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en LEFT_RIGHT");
            this.playersScores[player]++;
            for (numberOfSimilarSymbolsConnectedOnSameLine = NUMBER_OF_MARKS_NEEDED_TO_SCORE - 1; numberOfSimilarSymbolsConnectedOnSameLine >= 0; numberOfSimilarSymbolsConnectedOnSameLine--)
            {
                this.grid[abs + numberofsymbolsbelow - numberOfSimilarSymbolsConnectedOnSameLine][ord].useLine(Square.LEFT_RIGHT);
            }
        }

        numberOfSimilarSymbolsConnectedOnSameLine = 1;
        numberofsymbolsbelow = 1;
        // Check UPLEFT_DOWNRIGHT -------
        while ((ord - numberOfSimilarSymbolsConnectedOnSameLine) >= 0
                && (abs - numberOfSimilarSymbolsConnectedOnSameLine) >= 0
                && this.grid[abs - numberOfSimilarSymbolsConnectedOnSameLine][ord - numberOfSimilarSymbolsConnectedOnSameLine].getValue() == this.grid[abs][ord]
                        .getValue()
                && numberOfSimilarSymbolsConnectedOnSameLine < NUMBER_OF_MARKS_NEEDED_TO_SCORE
                && !this.grid[abs - numberOfSimilarSymbolsConnectedOnSameLine][ord - numberOfSimilarSymbolsConnectedOnSameLine]
                        .seeLine(Square.UPLEFT_DOWNRIGHT))
        {
            numberOfSimilarSymbolsConnectedOnSameLine++;
        }
        while ((ord + numberofsymbolsbelow) < DEFAULT_GRID_SIZE
                && (abs + numberofsymbolsbelow) < DEFAULT_GRID_SIZE
                && this.grid[abs + numberofsymbolsbelow][ord + numberofsymbolsbelow].getValue() == this.grid[abs][ord]
                        .getValue() && numberOfSimilarSymbolsConnectedOnSameLine < NUMBER_OF_MARKS_NEEDED_TO_SCORE
                && !this.grid[abs + numberofsymbolsbelow][ord + numberofsymbolsbelow].seeLine(Square.UPLEFT_DOWNRIGHT))
        {
            numberOfSimilarSymbolsConnectedOnSameLine++;
            numberofsymbolsbelow++;
        }
        numberofsymbolsbelow--;
        if (numberOfSimilarSymbolsConnectedOnSameLine == NUMBER_OF_MARKS_NEEDED_TO_SCORE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en UPLEFT_DOWNRIGHT");
            this.playersScores[player]++;
            for (numberOfSimilarSymbolsConnectedOnSameLine = NUMBER_OF_MARKS_NEEDED_TO_SCORE - 1; numberOfSimilarSymbolsConnectedOnSameLine >= 0; numberOfSimilarSymbolsConnectedOnSameLine--)
            {
                this.grid[abs + numberofsymbolsbelow - numberOfSimilarSymbolsConnectedOnSameLine][ord + numberofsymbolsbelow
                        - numberOfSimilarSymbolsConnectedOnSameLine].useLine(Square.UPLEFT_DOWNRIGHT);
            }
        }

        numberOfSimilarSymbolsConnectedOnSameLine = 1;
        numberofsymbolsbelow = 1;
        // Check UPRIGHT_DOWNLEFT -------
        while ((ord - numberOfSimilarSymbolsConnectedOnSameLine) >= 0
                && (abs + numberOfSimilarSymbolsConnectedOnSameLine) < DEFAULT_GRID_SIZE
                && this.grid[abs + numberOfSimilarSymbolsConnectedOnSameLine][ord - numberOfSimilarSymbolsConnectedOnSameLine].getValue() == this.grid[abs][ord]
                        .getValue()
                && numberOfSimilarSymbolsConnectedOnSameLine < NUMBER_OF_MARKS_NEEDED_TO_SCORE
                && !this.grid[abs + numberOfSimilarSymbolsConnectedOnSameLine][ord - numberOfSimilarSymbolsConnectedOnSameLine]
                        .seeLine(Square.UPRIGHT_DOWNLEFT))
        {
            numberOfSimilarSymbolsConnectedOnSameLine++;
        }
        while ((ord + numberofsymbolsbelow) < DEFAULT_GRID_SIZE
                && (abs - numberofsymbolsbelow) >= 0
                && this.grid[abs - numberofsymbolsbelow][ord + numberofsymbolsbelow].getValue() == this.grid[abs][ord]
                        .getValue() && numberOfSimilarSymbolsConnectedOnSameLine < NUMBER_OF_MARKS_NEEDED_TO_SCORE
                && !this.grid[abs - numberofsymbolsbelow][ord + numberofsymbolsbelow].seeLine(Square.UPRIGHT_DOWNLEFT))
        {
            numberOfSimilarSymbolsConnectedOnSameLine++;
            numberofsymbolsbelow++;
        }
        numberofsymbolsbelow--;
        if (numberOfSimilarSymbolsConnectedOnSameLine == NUMBER_OF_MARKS_NEEDED_TO_SCORE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en UPRIGHT_DOWNLEFT");
            this.playersScores[player]++;
            for (numberOfSimilarSymbolsConnectedOnSameLine = NUMBER_OF_MARKS_NEEDED_TO_SCORE - 1; numberOfSimilarSymbolsConnectedOnSameLine >= 0; numberOfSimilarSymbolsConnectedOnSameLine--)
            {
                this.grid[abs - numberofsymbolsbelow + numberOfSimilarSymbolsConnectedOnSameLine][ord + numberofsymbolsbelow
                        - numberOfSimilarSymbolsConnectedOnSameLine].useLine(Square.UPRIGHT_DOWNLEFT);
            }
        }
    }

    /**
     * @param player
     */
    private void checkUpDown(int player, Position position)
    {
        int numberOfSimilarSymbolsConnectedOnSameLine = 1;
        int numberofsymbolsbelow = 1;
        // Check UP_DOWN --------
        while ((position.getLine() - numberOfSimilarSymbolsConnectedOnSameLine) >= 0
                && this.grid.getSquareAt(position.translate(0,(-numberOfSimilarSymbolsConnectedOnSameLine))).getValue() == this.grid.getSquareAt(position).getValue()
                && numberOfSimilarSymbolsConnectedOnSameLine < NUMBER_OF_MARKS_NEEDED_TO_SCORE
                && !this.grid.getSquareAt(position.translate(0,(-numberOfSimilarSymbolsConnectedOnSameLine))).seeLine(Square.UP_DOWN))
        {
            numberOfSimilarSymbolsConnectedOnSameLine++;
        }
        while ((position.getLine() + numberofsymbolsbelow) < grid.DEFAULT_GRID_SIZE
                && this.grid.getSquareAt(position.translate(0,numberOfSimilarSymbolsConnectedOnSameLine)).getValue() == this.grid.getSquareAt(position).getValue()
                && numberOfSimilarSymbolsConnectedOnSameLine < NUMBER_OF_MARKS_NEEDED_TO_SCORE
                && !this.grid.getSquareAt(position.translate(0,numberOfSimilarSymbolsConnectedOnSameLine)).seeLine(Square.UP_DOWN))
        {
            numberOfSimilarSymbolsConnectedOnSameLine++;
            numberofsymbolsbelow++;
        }
        numberofsymbolsbelow--;
        if (numberOfSimilarSymbolsConnectedOnSameLine == NUMBER_OF_MARKS_NEEDED_TO_SCORE)
        {
            // TODO (FIXED) Add an attribute score and add one point here
            System.out.println("-- Joueur " + player + " a complété une ligne en UP_DOWN");
            this.playersScores[player]++;
            for (numberOfSimilarSymbolsConnectedOnSameLine = NUMBER_OF_MARKS_NEEDED_TO_SCORE - 1; numberOfSimilarSymbolsConnectedOnSameLine >= 0; numberOfSimilarSymbolsConnectedOnSameLine--)
            {
                this.grid.getSquareAt(position.translate(0, numberofsymbolsbelow - numberOfSimilarSymbolsConnectedOnSameLine)).seeLine(Square.UP_DOWN);
            }
        }
    }

}