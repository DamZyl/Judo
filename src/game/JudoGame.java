package game;

import enity.Player;
import javafx.application.Platform;
import javax.swing.*;

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

    public void addWhiteScoreShido()
    {
        if(whitePlayer.getScore().getScoreShido() == 0)
        {
            whitePlayer.getScore().setScoreShido(1);
        }

        else if(whitePlayer.getScore().getScoreShido() == 1)
        {
            whitePlayer.getScore().setScoreShido(2);
        }

        else if(whitePlayer.getScore().getScoreShido() == 2)
        {
            whitePlayer.getScore().setScoreIppon(1);
            whitePlayer.getScore().setScoreShido(3);
        }
    }

    public void removeWhiteScoreShido()
    {
        if(whitePlayer.getScore().getScoreShido() == 3)
        {
            whitePlayer.getScore().setScoreIppon(0);
            whitePlayer.getScore().setScoreShido(2);
        }

        else if(whitePlayer.getScore().getScoreShido() == 2)
        {
            whitePlayer.getScore().setScoreShido(1);
        }

        else if(whitePlayer.getScore().getScoreShido() == 1)
        {
            whitePlayer.getScore().setScoreShido(0);
        }
    }

    public void addWhiteScoreWazaari()
    {
        if(whitePlayer.getScore().getScoreWazaari() == 0)
        {
            whitePlayer.getScore().setScoreWazaari(1);
        }

        else if(whitePlayer.getScore().getScoreWazaari() == 1 )
        {
            whitePlayer.getScore().setScoreIppon(1);
            whitePlayer.getScore().setScoreWazaari(2);
        }
    }

    public void removeWhiteScoreWazaari()
    {
        if(whitePlayer.getScore().getScoreWazaari() == 2)
        {
            whitePlayer.getScore().setScoreIppon(0);
            whitePlayer.getScore().setScoreWazaari(1);
        }

        else if(whitePlayer.getScore().getScoreWazaari() == 1)
        {
            whitePlayer.getScore().setScoreWazaari(0);
        }
    }

    public void addWhiteScoreIppon()
    {
        if(whitePlayer.getScore().getScoreIppon() == 0)
        {
            whitePlayer.getScore().setScoreIppon(1);
        }
    }

    public void removeWhiteScoreIppon()
    {
        if(whitePlayer.getScore().getScoreIppon() == 1)
        {
            if(whitePlayer.getScore().getScoreWazaari() == 2)
            {
                whitePlayer.getScore().setScoreWazaari(1);
                whitePlayer.getScore().setScoreIppon(0);
            }

            else if(whitePlayer.getScore().getScoreShido() == 3)
            {
                whitePlayer.getScore().setScoreShido(2);
                whitePlayer.getScore().setScoreIppon(0);
            }

            else
            {
                whitePlayer.getScore().setScoreIppon(0);
            }
        }
    }

    public void startWhiteOsaekomi()
    {
        Platform.runLater(() ->
        {
            {
                secondOsaekomi++;

                if(secondOsaekomi == 11)
                {
                    whitePlayer.getScore().setScoreWazaari(1);

                    if(whitePlayer.getScore().getScoreWazaari() == 2)
                    {
                        whitePlayer.getScore().setScoreIppon(1);
                        secondOsaekomi = 0;
                    }
                }
                if(secondOsaekomi == 21)
                {
                    whitePlayer.getScore().setScoreIppon(1);
                    secondOsaekomi = 0;

                }
            }
        });
    }

    public void stopWhiteOsaekomi()
    {
        secondOsaekomi = 0;
    }


    public void addBlueScoreShido()
    {
        if(bluePlayer.getScore().getScoreShido() == 0)
        {
            bluePlayer.getScore().setScoreShido(1);
        }

        else if(bluePlayer.getScore().getScoreShido() == 1)
        {
            bluePlayer.getScore().setScoreShido(2);
        }

        else if(bluePlayer.getScore().getScoreShido() == 2)
        {
            bluePlayer.getScore().setScoreIppon(1);
            bluePlayer.getScore().setScoreShido(3);
        }
    }

    public void removeBlueScoreShido()
    {
        if(bluePlayer.getScore().getScoreShido() == 3)
        {
            bluePlayer.getScore().setScoreIppon(0);
            bluePlayer.getScore().setScoreShido(2);
        }

        else if(bluePlayer.getScore().getScoreShido() == 2)
        {
            bluePlayer.getScore().setScoreShido(1);
        }

        else if(bluePlayer.getScore().getScoreShido() == 1)
        {
            bluePlayer.getScore().setScoreShido(0);
        }
    }

    public void addBlueScoreWazaari()
    {
        if(bluePlayer.getScore().getScoreWazaari() == 0)
        {
            whitePlayer.getScore().setScoreWazaari(1);
        }

        else if(bluePlayer.getScore().getScoreWazaari() == 1 )
        {
            bluePlayer.getScore().setScoreIppon(1);
            bluePlayer.getScore().setScoreWazaari(2);
        }
    }

    public void removeBlueScoreWazaari()
    {
        if(bluePlayer.getScore().getScoreWazaari() == 2)
        {
            bluePlayer.getScore().setScoreIppon(0);
            bluePlayer.getScore().setScoreWazaari(1);
        }

        else if(bluePlayer.getScore().getScoreWazaari() == 1)
        {
            bluePlayer.getScore().setScoreWazaari(0);
        }
    }

    public void addBlueScoreIppon()
    {
        if(bluePlayer.getScore().getScoreIppon() == 0)
        {
            bluePlayer.getScore().setScoreIppon(1);
        }
    }

    public void removeBlueScoreIppon()
    {
        if(bluePlayer.getScore().getScoreIppon() == 1)
        {
            if(bluePlayer.getScore().getScoreWazaari() == 2)
            {
                bluePlayer.getScore().setScoreWazaari(1);
                bluePlayer.getScore().setScoreIppon(0);
            }

            else if(bluePlayer.getScore().getScoreShido() == 3)
            {
                bluePlayer.getScore().setScoreShido(2);
                bluePlayer.getScore().setScoreIppon(0);
            }

            else
            {
                bluePlayer.getScore().setScoreIppon(0);
            }
        }
    }

    /*
    public void startBlueOsaekomi()
    {
        stateBlueOsaekomi = true;

        timerOsaekomi = new Timer(1000, e ->
        {
            if(stateBlueOsaekomi)
            {
                Platform.runLater(() ->
                {
                    {
                        secondOsaekomi++;

                        if(secondOsaekomi == 11)
                        {
                            blueScoreWazaari++;

                            if(blueScoreWazaari == 2)
                            {
                                blueScoreIppon++;
                                stateBlueOsaekomi = false;
                                timerOsaekomi.stop();
                                secondOsaekomi = 0;
                            }
                        }

                        if(secondOsaekomi == 21)
                        {
                            blueScoreIppon++;
                            stateBlueOsaekomi = false;
                            timerOsaekomi.stop();
                            secondOsaekomi = 0;
                        }
                    }
                });

                System.out.println("Second = " + this.getSecondOsaekomi());
            }
        });

        timerOsaekomi.setInitialDelay(0);
        timerOsaekomi.start();
    }

    public void stopBlueOsaekomi()
    {
        stateBlueOsaekomi = false;
        timerOsaekomi.stop();
        secondOsaekomi = 0;
    }
    */

    /*
    public void startFightTime()
    {
        stateFightTime = true;

        timerFight = new Timer(1000, e ->
        {
            if(stateFightTime)
            {
                Platform.runLater(() ->
                {
                    if(secondFight < 10)
                    {
                        secondFight--;
                    }

                    else
                    {
                        secondFight--;
                    }

                    if(minuteFight == 0 && secondFight < 0)
                    {
                        stateFightTime = false;
                        stateGoldenScore = true;
                        minuteFight = 0;
                        secondFight = 0;
                    }

                    if(secondFight < 0)
                    {
                        secondFight = 59;
                        minuteFight--;

                    }
                });

                System.out.println("Minute = " + minuteFight + " Second = " + secondFight);
            }

            if(stateGoldenScore)
            {
                Platform.runLater(() ->
                {
                    if(secondFight < 10)
                    {
                        secondFight++;
                    }

                    else
                    {
                        secondFight++;
                    }

                    if(secondFight > 59)
                    {
                        secondFight = 0;
                        minuteFight++;
                    }
                });

                System.out.println("Minute = " + minuteFight + " Second = " + secondFight);
            }
        });

        timerFight.setInitialDelay(0);
        timerFight.start();
    }

    public void stopFightTime()
    {
        stateFightTime = false;
        stateGoldenScore = false;

        timerFight.stop();
    }
    */

    public void startGoldenScore()
    {

    }

    public void stopGoldenScore()
    {

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

    public int getSecondFight()
    {
        return secondFight;
    }

    public int getSecondOsaekomi()
    {
        return secondOsaekomi;
    }
}
