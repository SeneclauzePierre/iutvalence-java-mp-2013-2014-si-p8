package fr.iutvalence.java.mp.tictactoe;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonGridPanel extends JPanel
{
    private JButton[][] buttons;

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
                this.add(button);
            }
    }
    
    public void updateButton(Position position)
    {
        
    }
}
