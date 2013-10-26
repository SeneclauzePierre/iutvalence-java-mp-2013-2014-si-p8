package fr.iutvalence.java.mp.tictactoe;

/**
 * Square
 * 
 * This class represents one square, which is part of the grid defined in the
 * TicTacToe class. It is mostly used to check if a square has already been used
 * to complete a line in one or several directions, so that several lines don't
 * overlap themselves.
 * 
 * @author seneclap
 * 
 */
public class Square
{
    /**
     * EMPTY This constant means there is no symbol in a square
     */
    public final static int EMPTY = 0;

    /**
     * value Is equal to one of the aforedefined constants ; determines the
     * symbol present in the square
     */
    private int mark;

    /**
     * direction A table of 4 boolean Each boolean represents one of the
     * aforementioned directions If it is true, then this square has been used
     * to complete a line in the corresponding direction Otherwise, it has not
     */
    private LinesInfo linesInfo;

    /**
     * Square Class builder ; generates a new square, with no symbol in it, and
     * is not used to form a line in any direction yet
     */
    public Square()
    {
        this.mark = Square.EMPTY;

        this.linesInfo = new LinesInfo();
    }

    /**
     * isEmpty Checks the value of the Square
     * 
     * @return true if the value is EMPTY, false otherwise
     */
    public boolean isEmpty()
    {
        return (this.mark == Square.EMPTY);
    }

    /**
     * newValue Changes the square's value
     * 
     * @param value
     *            : the new value
     */
    public void udpateMark(int value)
    {
        this.mark = value;
    }

    /**
     * checkValue Used to return the square's value
     * 
     * @return : the square's value (duh!)
     */
    public int getMark()
    {
        return this.mark;
    }

    /**
     * seeLine Checks if a square is used in the "dir" direction
     * 
     * @param dir
     *            : The checked direction
     * @return true if the square is used in the direction dir, else it returns
     *         false
     */
    public boolean isPartOfLineByDirection(Axis axis)
    {
        return this.linesInfo.isPartOfLineByAxis(axis);
    }

    /**
     * useLine States that a square is used to complete a line in the "dir"
     * direction
     * 
     * @param dir
     *            Indicates the direction in which the line has been completed
     */
    public void setPartOfLineByDirection(Axis axis)
    {
        this.linesInfo.setIsPartOfLineByAxis(axis);
    }
}
