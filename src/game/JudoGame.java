package game;

import enity.Player;
import javafx.application.Platform;
import javax.swing.*;

public class JudoGame
{
    private Timer timerOsaekomi;
    private Timer timerFight;
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
        if(whiteScoreIppon == 1)
        {
            if(whiteScoreWazaari == 2)
            {
                whiteScoreWazaari = 1;
                whiteScoreIppon--;
            }

            else if(whiteScoreShido == 3)
            {
                whiteScoreShido = 2;
                whiteScoreIppon--;
            }

            else
            {
                whiteScoreIppon--;
            }
        }
    }

    public int getSecondOsaekomi()
    {
        return secondOsaekomi;
    }

    public void startWhiteOsaekomi()
    {
        stateWhiteOsaekomi = true;

        timerOsaekomi = new Timer(1000, e ->
        {
            if(stateWhiteOsaekomi)
            {
                Platform.runLater(() ->
                {
                    {
                        secondOsaekomi++;

                        if(secondOsaekomi == 11)
                        {
                            whiteScoreWazaari++;

                            if(whiteScoreWazaari == 2)
                            {
                                whiteScoreIppon++;
                                stateWhiteOsaekomi = false;
                                timerOsaekomi.stop();
                                secondOsaekomi = 0;
                            }
                        }

                        if(secondOsaekomi == 21)
                        {
                            whiteScoreIppon++;
                            stateWhiteOsaekomi = false;
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

    public void stopWhiteOsaekomi()
    {
        stateWhiteOsaekomi = false;
        timerOsaekomi.stop();
        secondOsaekomi = 0;
    }

    public int getBlueScoreShido()
    {
        return blueScoreShido;
    }

    public void addBlueScoreShido()
    {
        if(blueScoreShido == 0)
        {
            blueScoreShido++;
        }

        else if(blueScoreShido == 1)
        {
            blueScoreShido++;
        }

        else if(blueScoreShido == 2)
        {
            blueScoreIppon = 1;
            blueScoreShido++;
        }
    }

    public void removeBlueScoreShido()
    {
        if(blueScoreShido == 3)
        {
            blueScoreIppon = 0;
            blueScoreShido--;
        }

        else if(blueScoreShido == 2)
        {
            blueScoreShido--;
        }

        else if(blueScoreShido == 1)
        {
            blueScoreShido--;
        }
    }

    public int getBlueScoreWazaari()
    {
        return blueScoreWazaari;
    }

    public void addBlueScoreWazaari()
    {
        if(blueScoreWazaari == 0)
        {
            blueScoreWazaari++;
        }

        else if(blueScoreWazaari == 1 )
        {
            blueScoreIppon = 1;
            blueScoreWazaari++;
        }
    }

    public void removeBlueScoreWazaari()
    {
        if(blueScoreWazaari == 2)
        {
            blueScoreIppon = 0;
            blueScoreWazaari--;
        }

        else if(blueScoreWazaari == 1)
        {
            blueScoreWazaari--;
        }
    }

    public int getBlueScoreIppon()
    {
        return blueScoreIppon;
    }

    public void addBlueScoreIppon()
    {
        if(blueScoreIppon == 0)
        {
            blueScoreIppon++;
        }
    }

    public void removeBlueScoreIppon()
    {
        if(blueScoreIppon == 1)
        {
            if(blueScoreWazaari == 2)
            {
                blueScoreWazaari = 1;
                blueScoreIppon--;
            }

            else if(blueScoreShido == 3)
            {
                blueScoreShido = 2;
                blueScoreIppon--;
            }

            else
            {
                blueScoreIppon--;
            }
        }
    }

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

    public int getSecondFight()
    {
        return secondFight;
    }

    public int getMinuteFight()
    {
        return minuteFight;
    }

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
}
