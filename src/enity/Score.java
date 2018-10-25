package enity;

public class Score
{
    private int scoreWazaari;
    private int scoreIppon;
    private int scoreShido;

    public Score()
    {
        this.scoreWazaari = 0;
        this.scoreIppon = 0;
        this.scoreShido = 0;
    }

    public int getScoreWazaari()
    {
        return scoreWazaari;
    }

    public void setScoreWazaari(int scoreWazaari)
    {
        this.scoreWazaari = scoreWazaari;
    }

    public int getScoreIppon()
    {
        return scoreIppon;
    }

    public void setScoreIppon(int scoreIppon)
    {
        this.scoreIppon = scoreIppon;
    }

    public int getScoreShido()
    {
        return scoreShido;
    }

    public void setScoreShido(int scoreShido)
    {
        this.scoreShido = scoreShido;
    }
}
