package fr.iutvalence.java.mp.tictactoe;

/**
 * Specifies in which axis a certain Square is used to complete a line
 */
public class LinesInfo
{
    /**
     * Each boolean of isPartOfLineByAxis indicates whether or not the Square is used to complete a line in a certain axis
     */
    private boolean[] isPartOfLineByAxis;

    /**
     * When LinesInfo is created, the Square is not used to complete a line in any axis yet
     */
    public LinesInfo()
    {
        this.isPartOfLineByAxis = new boolean[Axis.values().length];
        this.isPartOfLineByAxis[0] = false;
        this.isPartOfLineByAxis[1] = false;
        this.isPartOfLineByAxis[2] = false;
        this.isPartOfLineByAxis[3] = false;
    }

    /**
     * Indicates if the square completes a line in a given axis
     * @param axis The checked axis
     * @return A boolean from the IsPartOfLineAxis table
     */
    public boolean isPartOfLineByAxis(Axis axis)
    {
        switch (axis)
        {
        case UP_DOWN:
            return this.isPartOfLineByAxis[0];
        case LEFT_RIGHT:
            return this.isPartOfLineByAxis[1];
        case UP_LEFT_DOWN_RIGHT:
            return this.isPartOfLineByAxis[2];
        default:
            return this.isPartOfLineByAxis[3];
        }
    }
    
    /**
     * Set as the square completes a line in the given axis 
     * @param axis the set axis
     */
    public void setIsPartOfLineByAxis(Axis axis)
    {
        switch (axis)
        {
        case UP_DOWN:
            this.isPartOfLineByAxis[0] = true;
        case LEFT_RIGHT:
            this.isPartOfLineByAxis[1] = true;
        case UP_LEFT_DOWN_RIGHT:
            this.isPartOfLineByAxis[2] = true;
        default:
            this.isPartOfLineByAxis[3] = true;
        }
    }
}
