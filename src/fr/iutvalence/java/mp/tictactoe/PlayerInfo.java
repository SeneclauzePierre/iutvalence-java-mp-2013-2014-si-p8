package fr.iutvalence.java.mp.tictactoe;

// TODO (fix) write comment
public class PlayerInfo
{
    // TODO (fix) write comment
    private final static PlayerInfo PLAYER_1 = new PlayerInfo(1, Mark.PLAYER1);
    
    // TODO (fix) write comment
    private final static PlayerInfo PLAYER_2 = new PlayerInfo(2, Mark.PLAYER2);
    
    // TODO (fix) write comment
    private final int number;
    
    // TODO (fix) write comment
    private final Mark mark;

    // TODO (fix) write comment
    private PlayerInfo(int number, Mark mark)
    {
        super();
        this.number = number;
        this.mark = mark;
    }

    // TODO (fix) write comment
    public int getNumber()
    {
        return number;
    }

    // TODO (fix) write comment
    public Mark getMark()
    {
        return mark;
    }
    
    // TODO (fix) write comment
    public static PlayerInfo getPlayerInfoForGivenTurn(int turn)
    {
        if (turn % 2 == 1) return PLAYER_1;
        return PLAYER_2;
    }
}
