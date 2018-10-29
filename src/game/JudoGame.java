package game;

import enity.Player;
import enity.Score;

public class JudoGame
{
    private Player whitePlayer;
    private Player bluePlayer;
    private int secondOsaekomi;
    private int secondFight;
    private int minuteFight;
    private boolean stateFightTime;
    private boolean stateGoldenScore;

    public JudoGame()
    {
        this.whitePlayer = new Player();
        this.bluePlayer = new Player();
        this.secondOsaekomi = 0;
        this.secondFight = 0;
        this.minuteFight = 4;
        this.stateFightTime = false;
        this.stateGoldenScore = false;
    }

    public void addBlueScoreShido()
    {
        addScoreShido(bluePlayer);
    }

    public void removeBlueScoreShido()
    {
        removeScoreShido(bluePlayer);
    }

    public void addBlueScoreWazaari()
    {
        addScoreWazaari(bluePlayer);
    }

    public void removeBlueScoreWazaari()
    {
        removeScoreWazaari(bluePlayer);
    }

    public void addBlueScoreIppon()
    {
        addScoreIppon(bluePlayer);
    }

    public void removeBlueScoreIppon()
    {
        removeScoreIppon(bluePlayer);
    }

    public void addWhiteScoreShido()
    {
        addScoreShido(whitePlayer);
    }

    public void removeWhiteScoreShido()
    {
        removeScoreShido(whitePlayer);
    }

    public void addWhiteScoreWazaari()
    {
        addScoreWazaari(whitePlayer);
    }

    public void removeWhiteScoreWazaari()
    {
        removeScoreWazaari(whitePlayer);
    }

    public void addWhiteScoreIppon()
    {
        addScoreIppon(whitePlayer);
    }

    public void removeWhiteScoreIppon()
    {
        removeScoreIppon(whitePlayer);
    }

    private void addScoreShido(Player player)
    {
        final Score playerScore = player.getScore();
        final int scoreShido = playerScore.getScoreShido();

        switch (scoreShido)
        {
            case 0:
                playerScore.setScoreShido(1);
                break;
            case 1:
                playerScore.setScoreShido(2);
                break;
            case 2:
                playerScore.setScoreShido(3);
                playerScore.setScoreIppon(1);
                break;
        }
    }

    private void removeScoreShido(Player player)
    {
        final Score playerScore = player.getScore();
        final int scoreShido = playerScore.getScoreShido();

        switch (scoreShido)
        {
            case 1:
                playerScore.setScoreShido(0);
                break;
            case 2:
                playerScore.setScoreShido(1);
                break;
            case 3:
                playerScore.setScoreIppon(0);
                playerScore.setScoreShido(2);
                break;
        }
    }

    private void addScoreWazaari(Player player)
    {
        final Score playerScore = player.getScore();
        final int scoreWazaari = playerScore.getScoreWazaari();

        switch (scoreWazaari)
        {
            case 0:
                playerScore.setScoreWazaari(1);
                break;
            case 1:
                playerScore.setScoreWazaari(2);
                playerScore.setScoreIppon(1);
                break;
        }
    }

    private void removeScoreWazaari(Player player)
    {
        final Score playerScore = player.getScore();
        final int scoreWazaari = playerScore.getScoreWazaari();

        switch (scoreWazaari)
        {
            case 1:
                playerScore.setScoreWazaari(0);
                break;
            case 2:
                playerScore.setScoreWazaari(1);
                playerScore.setScoreIppon(0);
                break;
        }
    }

    private void addScoreIppon(Player player)
    {
        final Score playerScore = player.getScore();
        final int scoreIppon = playerScore.getScoreIppon();

        switch (scoreIppon)
        {
            case 0:
                playerScore.setScoreIppon(1);
                break;
        }
    }

    private void removeScoreIppon(Player player)
    {
        final Score playerScore = player.getScore();
        final int scoreIppon = playerScore.getScoreIppon();
        final int scoreWazaari = playerScore.getScoreWazaari();
        final int scoreShido = playerScore.getScoreShido();

        if(scoreIppon  == 1)
        {
            if(scoreWazaari == 2)
            {
                playerScore.setScoreWazaari(1);
                playerScore.setScoreIppon(0);
            }

            else if(scoreShido == 3)
            {
                playerScore.setScoreShido(2);
                playerScore.setScoreIppon(0);
            }

            else
            {
                playerScore.setScoreIppon(0);
            }
        }
    }

    public Player getWhitePlayer()
    {
        return whitePlayer;
    }

    public Player getBluePlayer()
    {
        return bluePlayer;
    }

    public int getMinuteFight()
    {
        return minuteFight;
    }

    public int incrementMinuteFight()
    {
        return this.minuteFight++;
    }

    public int decrementMinuteFight()
    {
        return this.minuteFight--;
    }

    public void setMinuteFight(int minuteFight)
    {
        this.minuteFight = minuteFight;
    }

    public int getSecondFight()
    {
        return secondFight;
    }

    public int incrementSecondFight()
    {
        return this.secondFight++;
    }

    public int decrementSecondFight()
    {
        return this.secondFight--;
    }

    public void setSecondFight(int secondFight)
    {
        this.secondFight = secondFight;
    }

    public int getSecondOsaekomi()
    {
        return secondOsaekomi;
    }

    public int incrementSecondOsaekomi()
    {
        return this.secondOsaekomi++;
    }

    public void setSecondOsaekomi(int secondOsaekomi)
    {
        this.secondOsaekomi = secondOsaekomi;
    }

    public boolean isStateFightTime()
    {
        return stateFightTime;
    }

    public void setStateFightTime(boolean stateFightTime)
    {
        this.stateFightTime = stateFightTime;
    }

    public boolean isStateGoldenScore()
    {
        return stateGoldenScore;
    }

    public void setStateGoldenScore(boolean stateGoldenScore)
    {
        this.stateGoldenScore = stateGoldenScore;
    }
}