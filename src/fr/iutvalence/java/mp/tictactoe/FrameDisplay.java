package fr.iutvalence.java.mp.tictactoe;

import java.awt.*;
import java.awt.event.*;
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

    public void initDisplay()
    {
        JLabel emptyLabel = new JLabel();
        emptyLabel.setOpaque(true);
        emptyLabel.setPreferredSize(new Dimension(200, 180));
        this.frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        this.frame.pack();
        this.frame.setVisible(true);    
    }
    
    public void displayConsole(PlayerInfo player, Position position, int turn)
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
        
    }
}
