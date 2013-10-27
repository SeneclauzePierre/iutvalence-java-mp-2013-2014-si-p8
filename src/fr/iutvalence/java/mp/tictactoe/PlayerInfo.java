package fr.iutvalence.java.mp.tictactoe;

public class PlayerInfo
{
    private final static PlayerInfo PLAYER_1 = new PlayerInfo(1, Mark.PLAYER1);
    
    private final static PlayerInfo PLAYER_2 = new PlayerInfo(2, Mark.PLAYER2);
    
    private final int number;
    
    private final Mark mark;

    private PlayerInfo(int number, Mark mark)
    {
        super();
        this.number = number;
        this.mark = mark;
    }

    public int getNumber()
    {
        return number;
    }

    public Mark getMark()
    {
        return mark;
    }
    
    public static PlayerInfo getPlayerInfoForGivenTurn(int turn)
    {
        if (turn % 2 == 1) return PLAYER_1;
        return PLAYER_2;
    }
}
