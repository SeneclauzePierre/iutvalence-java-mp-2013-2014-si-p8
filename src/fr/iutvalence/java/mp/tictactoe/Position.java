package fr.iutvalence.java.mp.tictactoe;

/**
 * Position
 * This class represent a position in the grid's game
 * 
 */
public class Position
{
    /**
     * the column(abscissa)'s position
     */
    private final int column;
    
    /**
     * the line(ordinate)'s position
     */
    private final int line;

    /**
     * Create a position with given coordinate
     * @param column column(abscissa)'s position
     * @param line line(ordinate)'s position
     */
    public Position(int column, int line)
    {
        super();
        this.column = column;
        this.line = line;
    }
    
    /**
     * Create a position with a translate of the current position
     * @param delatColumn the column translate
     * @param deltaLine the line translate
     * @return The new position
     */
    public Position translate(int delatColumn, int deltaLine)
    {
        return new Position(this.column + delatColumn, this.line + deltaLine);
    }

    /**
     * @return the column's position
     */
    public int getColumn()
    {
        return this.column;
    }

    /**
     * @return the line's position
     */
    public int getLine()
    {
        return this.line;
    }

    /**
     * Returns an ASCII representation of the position as (x,y)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "(" + this.column + "," + this.line + ")";
    }
    
    
    
}
