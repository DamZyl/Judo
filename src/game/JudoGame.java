package game;

import javafx.application.Platform;
import player.BluePlayer;
import player.WhitePlayer;
import javax.swing.*;

public class JudoGame
{
    private Timer timerOsaekomi;
    private Timer timerFight;
    private WhitePlayer whitePlayer;
    private BluePlayer bluePlayer;
    private int secondOsaekomi;
    private int secondFight;
    private int minuteFight;
    private int whiteScoreShido;
    private int whiteScoreWazaari;
    private int whiteScoreIppon;
    private int blueScoreShido;
    private int blueScoreWazaari;
    private int blueScoreIppon;
    private boolean stateWhiteOsaekomi;
    private boolean stateBlueOsaekomi;
    private boolean stateFightTime;
    private boolean stateGoldenScore;

    public JudoGame()
    {
        this.whitePlayer = new WhitePlayer();
        this.bluePlayer = new BluePlayer();
        this.secondOsaekomi = 0;
        this.secondFight = 0;
        this.minuteFight = 4;
        this.whiteScoreShido = whitePlayer.getWhiteScoreShido();
        this.whiteScoreWazaari = whitePlayer.getWhiteScoreWazaari();
        this.whiteScoreIppon = whitePlayer.getWhiteScoreIppon();
        this.blueScoreShido = bluePlayer.getBlueScoreShido();
        this.blueScoreWazaari = bluePlayer.getBlueScoreWazaari();
        this.blueScoreIppon = bluePlayer.getBlueScoreIppon();
        this.stateWhiteOsaekomi = false;
        this.stateBlueOsaekomi = false;
        this.stateFightTime = false;
        this.stateGoldenScore = false;
    }

    public int getWhiteScoreShido()
    {
        return whiteScoreShido;
    }

    public void addWhiteScoreShido()
    {
        if(whiteScoreShido == 0)
        {
            whiteScoreShido++;
        }

        else if(whiteScoreShido == 1)
        {
            whiteScoreShido++;
        }

        else if(whiteScoreShido == 2)
        {
            whiteScoreIppon = 1;
            whiteScoreShido++;
        }
    }

    public void removeWhiteScoreShido()
    {
        if(whiteScoreShido == 3)
        {
            whiteScoreIppon = 0;
            whiteScoreShido--;
        }

        else if(whiteScoreShido == 2)
        {
            whiteScoreShido--;
        }

        else if(whiteScoreShido == 1)
        {
            whiteScoreShido--;
        }
    }

    public int getWhiteScoreWazaari()
    {
        return whiteScoreWazaari;
    }

    public void addWhiteScoreWazaari()
    {
        if(whiteScoreWazaari == 0)
        {
            whiteScoreWazaari++;
        }

        else if(whiteScoreWazaari == 1 )
        {
            whiteScoreIppon = 1;
            whiteScoreWazaari++;
        }
    }

    public void removeWhiteScoreWazaari()
    {
        if(whiteScoreWazaari == 2)
        {
            whiteScoreIppon = 0;
            whiteScoreWazaari--;
        }

        else if(whiteScoreWazaari == 1)
        {
            whiteScoreWazaari--;
        }
    }

    public int getWhiteScoreIppon()
    {
        return whiteScoreIppon;
    }

    public void addWhiteScoreIppon()
    {
        if(whiteScoreIppon == 0)
        {
            whiteScoreIppon++;
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
