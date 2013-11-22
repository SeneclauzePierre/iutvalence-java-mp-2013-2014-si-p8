package fr.iutvalence.java.mp.tictactoe;

/**
 * This is the main class, that contains the method that's executed when the
 * program is executed.
 * 
 * @author seneclap
 */
public class RandomPlayerConsoleDisplayMain
{

    /**
     * This is the method that's executed when the program is executed.
     * 
     * @param args
     *            No parameters
     */
    public static void main(String[] args)
    {
        RandomPlayer player = new RandomPlayer();
        Display display = new ConsoleDisplay();
        new TicTacToe(player,display).play();
    }
}