package fr.iutvalence.java.mp.tictactoe;

/**
 * This is the main class, that contains the method that's executed when the
 * program is executed.
 * 
 * @author seneclap
 */
public class Main
{

    /**
     * This is the method that's executed when the program is executed.
     * 
     * @param args
     *            No parameters
     */
    public static void main(String[] args)
    {
        Player player = new Player();
        Display display = new Display();
        new TicTacToe(player,display).play();
    }
}