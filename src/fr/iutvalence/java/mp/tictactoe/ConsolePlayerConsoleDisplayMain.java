package fr.iutvalence.java.mp.tictactoe;

/**
 * This is the main class, that contains the method that's executed when the
 * program is executed.
 * 
 * @author seneclap
 */
public class ConsolePlayerConsoleDisplayMain
{

    /**
     * This is the method that's executed when the program is executed.
     * 
     * @param args
     *            No parameters
     */
    public static void main(String[] args)
    {
        ConsolePlayer player = new ConsolePlayer();
        Display display = new ConsoleDisplay();
        new TicTacToe(player,display).play();
    }
}