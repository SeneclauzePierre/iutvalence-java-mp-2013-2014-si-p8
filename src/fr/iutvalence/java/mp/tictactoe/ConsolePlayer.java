package fr.iutvalence.java.mp.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * This class represents the actions of the game's players
 */
public class ConsolePlayer implements Player
{

    public Position getChoice()
    {
        InputStreamReader isr = null;
        try
        {
            isr = new InputStreamReader(System.in, "US-ASCII");
        }
        catch (UnsupportedEncodingException e1)
        {
            // ignore this, it can not occur
        }
        BufferedReader br = new BufferedReader(isr);
        String sT[] = null;
        String s = null;
        
        try
        {
            s = br.readLine();
            sT = s.split(" ");
            int column = Integer.parseInt(sT[0]);
            int line = Integer.parseInt(sT[1]);
            return new Position(column, line);
        }
        catch (IOException e)
        {
            return new Position(-1, -1);
        }
    }
    
}
