package fr.iutvalence.java.mp.tictactoe;

/**
 * This is the main class, that contains the method that's executed when the
 * program is executed.
 * 
 * @author seneclap
 */
public class RandomPlayerFrameDisplayMain
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
        Display display = new FrameDisplay();
        new TicTacToe(player,display).play();
    }
}