package fr.iutvalence.java.mp.tictactoe;

import java.util.ArrayList;
import java.util.List;

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
    public final static int NUMBER_OF_MARKS_PER_LINE = 5;

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
        for (int turn = 1; turn <= DEFAULT_NUMBER_OF_TURNS; turn++)
        {
            PlayerInfo playerInfo = PlayerInfo.getPlayerInfoForGivenTurn(turn);

            while (true)
            {
                // TODO (next step) externalize player's choice retrieval, and do not depend on a specific behaviour (random, keyboard, ...)
                int column = (int) (Grid.DEFAULT_GRID_SIZE * Math.random());
                int line = (int) (Grid.DEFAULT_GRID_SIZE * Math.random());
                Position position = new Position(column, line);

                // TODO (next step) externalize in-game display, and do not depend on a specific behaviour (console, gui, ...)
                System.out.println("Joueur " + playerInfo.getNumber() + " pose sa marque en " + position + " -- Tour : "
                        + (turn + 1));

                try
                {
                    this.computeTurn(playerInfo.getMark(), position);
                }
                catch (InvalidPositionException e)
                {
                    System.out.println("... mais est un gros boulet !");
                    continue;
                }
                break;
            }
        }

        for (int player = 0; player < DEFAULT_NUMBER_OF_PLAYERS; player++)
            System.out.println("Score Joueur " + player + " : " + this.playersScores[player]);
    }

    /**
     * Plays a turn of the game, trying to put a given mark at a given position and searching (if
     * it succeeds) if a new line has been scored
     * 
     *      
     * @param mark
     *            the mark to place
     * @param position the position where to put the mark
     * @throws InvalidPositionException if the mark could not be put on the specified position 
     * (because the position is out of bounds or already marked)
     */
    private void computeTurn(Mark mark, Position position) throws InvalidPositionException
    {
        try
        {
            this.grid.getSquareAt(position).mark(mark);
        }
        // Here, catching Exception instead of catching PositionOutOfBounds and
        // AlreadyMarkedException
        // separately allows to simplify code because exception processing is
        // the same in both cases
        catch (Exception e)
        {
            throw new InvalidPositionException();
        }

        this.findAndMarkNewLine(position);
    }

    /**
     * finding and marking (if it exists) a new line, according to a given position
     * 
     * @param position a position, where a mark has been placed, and from which a new line may be scored
     */
    private void findAndMarkNewLine(Position position)
    {

        if (findAndMarkNewLineOnAxis(position, Axis.UP_DOWN))
            return;
        if (findAndMarkNewLineOnAxis(position, Axis.LEFT_RIGHT))
            return;
        if (findAndMarkNewLineOnAxis(position, Axis.UP_LEFT_DOWN_RIGHT))
            return;
        findAndMarkNewLineOnAxis(position, Axis.UP_RIGHT_DOWN_LEFT);
    }

    /**
     * finding and marking (if it exists) a new line, according to a given position and a given axis
     * @param position a position, where a mark has been placed, and from which a new line may be scored
     * @param axis the axis where to check if a new line has been scored
     * @return true if a new line has been scored from the specified position and along the specified axis
     */
    private boolean findAndMarkNewLineOnAxis(Position position, Axis axis)
    {
        try
        {
            List<Square> unusedSimilarSquaresOnPrimaryDirection = this.getUnusedSimilarSquaresFromPositionByDirection(
                    position, axis.getPrimaryDirection());
            List<Square> unusedSimilarSquaresOnSecondaryDirection = this
                    .getUnusedSimilarSquaresFromPositionByDirection(position, axis.getSecondaryDirection());

            if (unusedSimilarSquaresOnPrimaryDirection.size() + unusedSimilarSquaresOnSecondaryDirection.size() + 1 >= NUMBER_OF_MARKS_PER_LINE)
            {
                List<Square> squaresToMark = new ArrayList<Square>();
                squaresToMark.add(this.grid.getSquareAt(position));
                squaresToMark.addAll(unusedSimilarSquaresOnPrimaryDirection);
                squaresToMark.addAll(unusedSimilarSquaresOnSecondaryDirection);

                for (int squareNumber = 1; squareNumber <= NUMBER_OF_MARKS_PER_LINE; squareNumber++)
                    squaresToMark.get(squareNumber - 1).setPartOfLineByAxis(axis);

                return true;
            }
            return false;

        }
        catch (InvalidPositionException e)
        {
            return false;
        }
    }

    /**
     * Returns the list of neighbour squares that share the same mark as the one of a given position, and that can be aligned 
     * with this position according to a given direction
     * @param position the position from where to start searching
     * @param direction the direction along which searching
     * @return the the list of neighbour squares that share the same mark as the one being at the given position, 
     * and that can be aligned with this one according to the given direction
     * @throws InvalidPositionException if the starting position is invalid (no mark or out of bounds)
     */
    private List<Square> getUnusedSimilarSquaresFromPositionByDirection(Position position, Direction direction)
            throws InvalidPositionException
    {
        List<Square> result = new ArrayList<Square>();

        Square squareMarked = null;
        try
        {
            squareMarked = this.grid.getSquareAt(position);
            if (squareMarked.isUnmarked())
                throw new InvalidPositionException();
        }
        catch (PositionOutOfBoundsException e)
        {
            throw new InvalidPositionException();
        }

        Mark mark = squareMarked.getMark();

        Position origin = position;
        while (true)
        {
            Position nextNeighbour = null;
            try
            {
                nextNeighbour = this.grid.getNeighbourPosition(origin, direction);
                Square neighbourSquare = this.grid.getSquareAt(nextNeighbour);
                if (neighbourSquare.getMark() != mark)
                    break;
                if (neighbourSquare.isPartOfLineByDirection(direction.getAxis()))
                    break;
                result.add(neighbourSquare);
                origin = nextNeighbour;
            }
            catch (PositionOutOfBoundsException e)
            {
                break;
            }
        }
        return result;
    }

}