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
     * @param x column(abscissa)'s position
     * @param y line(ordinate)'s position
     */
    public Position(int x, int y)
    {
        super();
        this.column = x;
        this.line = y;
    }
    
    /**
     * Create a position with a translate of the current position
     * @param x the column translate
     * @param y the line translate
     * @return The new position
     */
    public Position translate(int x, int y)
    {
        return new Position(this.column + x, this.line + y);
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
