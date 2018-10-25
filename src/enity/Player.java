package enity;

public class Player
{
    private Score score;
    private boolean stateOsaekomi;

    public Player()
    {
        this.score = new Score();
        this.stateOsaekomi = false;
    }

    public Score getScore()
    {
        return score;
    }

    public boolean isStateOsaekomi()
    {
        return stateOsaekomi;
    }

    public void setStateOsaekomi(boolean stateOsaekomi)
    {
        this.stateOsaekomi = stateOsaekomi;
    }
}
