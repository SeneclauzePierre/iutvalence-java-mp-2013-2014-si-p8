package fr.iutvalence.java.mp.tictactoe;

import java.awt.*;

import javax.swing.*;

/**
 * Displays in a frame any information the user might need to know.
 */
public class FrameDisplay implements Display
{

    
    /**
     * frame is a frame
     */
    JFrame frame = new JFrame("TicTacToe : Le monde est plus beau !");

    /**
     * A panel of buttons
     */
    ButtonGridPanel panel = new ButtonGridPanel(Grid.DEFAULT_GRID_SIZE);

    public void initDisplay()
    {
        JLabel emptyLabel = new JLabel();
        emptyLabel.setOpaque(true);
        emptyLabel.setPreferredSize(new Dimension(300, 300));
        emptyLabel.setBackground(new Color(255, 245, 200));
        this.frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        this.frame.getContentPane().add(this.panel);
        this.frame.pack();
        this.frame.setVisible(true);  
    }
    
    public void displayPlay(PlayerInfo player, Position position, int turn)
    {
        
    }

    public void markHasNotBeenPlacedDueToAnException()
    {
        
    }

    public void displayScore(int[] playersScores)
    {
        
    }
    
    public void displayGrid(Grid grid)
    {
        for (int line = 0; line < Grid.DEFAULT_GRID_SIZE; line++)
        {
            for (int column = 0; column < Grid.DEFAULT_GRID_SIZE; column++)
            {
                Position pos = new Position (column,line);
                try
                {
                    this.panel.updateButton(pos,grid.getSquareAt(pos));
                }
                catch (PositionOutOfBoundsException e)
                {
                    //ignored
                }
            }
        }
    }
}
