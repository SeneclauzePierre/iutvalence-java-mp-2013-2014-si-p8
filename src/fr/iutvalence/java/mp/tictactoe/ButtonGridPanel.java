package fr.iutvalence.java.mp.tictactoe;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Handles the displaying of a frame contaning the game's grid, in which each Square is a button. 
 */
@SuppressWarnings("serial")
public class ButtonGridPanel extends JPanel
{
    /**
     * A button's grid
     */
    private JButton[][] buttons;

    /**
     * Displays the buttons' grid
     * @param size the size of the grid
     */
    public ButtonGridPanel(int size)
    {
        super();
        this.buttons = new JButton[size][size];

        this.setLayout(new GridLayout(size, size));
        
        for (int line = 0; line < size; line++)
            for (int column = 0; column < size; column++)
            {
                JButton button = new JButton(" ");
                this.buttons[line][column] = button;
                this.buttons[line][column].setPreferredSize(new Dimension(50, 50));
                this.add(button);
            }
    }

    /**
     * Updates what's written on the button depending on which player played on it (if any), and if it is part of a line 
     * @param position the position of the square
     * @param square the square
     */
    public void updateButton(Position position, Square square)
    {
        switch (square.getMark()) {
        
        case PLAYER1 : 
            if (square.isPartOfLine())
                this.buttons[position.getLine()][position.getColumn()].setBackground(new Color(200, 50, 50));
            this.buttons[position.getLine()][position.getColumn()].setText("x");
            break;
                     
        case PLAYER2 : 
            if (square.isPartOfLine())
                this.buttons[position.getLine()][position.getColumn()].setBackground(new Color(50, 200, 50));
            this.buttons[position.getLine()][position.getColumn()].setText("o");
            break;
        
        default : 
            this.buttons[position.getLine()][position.getColumn()].setText(" ");
            break;
        }
    }
}
