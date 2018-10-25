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

    public void startOsaekomi()
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

    public void stopOsaekomi()
    {
        stateWhiteOsaekomi = false;
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
}
