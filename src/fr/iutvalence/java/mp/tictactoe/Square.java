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
     * value Is equal to one of the aforedefined constants ; determines the
     * symbol present in the square
     */
    private Mark mark;

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
        this.mark = Mark.EMPTY;

        this.linesInfo = new LinesInfo();
    }

    /**
     * isEmpty Checks the value of the Square
     * 
     * @return true if the value is EMPTY, false otherwise
     */
    public boolean isUnmarked()
    {
        return (this.mark == Mark.EMPTY);
    }

    // TODO (fix) write comment
    /**
     * Puts the mark of the player's who played in the square inside of it
     * @param mark said mark
     * @throws AlreadyMarkedException if the square is already marked
     */
    public void mark(Mark mark) throws AlreadyMarkedException
    {
        if (!this.isUnmarked()) throw new AlreadyMarkedException();
        
        this.mark = mark;
    }

    /**
     * checkValue Used to return the square's value
     * 
     * @return : the square's value (duh!)
     */
    public Mark getMark()
    {
        return this.mark;
    }

    // TODO (FIXED) rewrite comment
    /**
     * Checks if a square is used to complete a line in the "axis" axis
     * @param axis the checked axis
     * @return true if the square completes a line in the "axis" axis, else false
     */
    public boolean isPartOfLineByDirection(Axis axis)
    {
        return this.linesInfo.isPartOfLineByAxis(axis);
    }

    // TODO (FIXED) rewrite comment
    /**
     * States that a square is used to complete a line in the "axis" axis
     * @param axis said axis
     */
    public void setPartOfLineByAxis(Axis axis)
    {
        this.linesInfo.setIsPartOfLineByAxis(axis);
    }
}
