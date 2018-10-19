package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.application.Platform;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener
{
    private Timer timer;
    private Timer timer2;
    private static boolean stateWhiteOsaekomi = false;
    private static boolean stateFightTime = false;
    private static boolean stateGoldenScore = false;
    private static int secondOsaekomi = 0;
    private static int secondFight = 0;
    private static int minuteFight = 4;
    private static int whiteScoreWazaari = 0;
    private static int whiteScoreIppon = 0;
    private static int whiteScoreShido = 0;
    private static int blueScoreWazaari = 0;
    private static int blueScoreIppon = 0;
    private static int blueScoreShido = 0;

    @FXML private Label whiteOsaekomi;
    @FXML private Label whiteIppon;
    @FXML private Label whiteWazaari;
    @FXML private Label whiteShido;
    @FXML private Label blueOsaekomi;
    @FXML private Label blueIppon;
    @FXML private Label blueWazaari;
    @FXML private Label blueShido;
    @FXML private Label fightTime;

    @FXML
    public void initialize()
    {
        whiteOsaekomi.setText("" + secondOsaekomi);
        whiteIppon.setText("" + whiteScoreIppon);
        whiteWazaari.setText("" + whiteScoreWazaari);
        whiteShido.setText("" + whiteScoreShido);
        fightTime.setText("" + minuteFight + " : 0" + secondFight);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(stateWhiteOsaekomi)
        {
            Platform.runLater(() ->
            {
                {
                    whiteOsaekomi.setText("" + secondOsaekomi);
                    secondOsaekomi++;

                    if(secondOsaekomi == 11)
                    {
                        whiteScoreWazaari++;
                        whiteWazaari.setText("1");

                        if(whiteScoreWazaari == 2)
                        {
                            whiteScoreIppon++;
                            whiteIppon.setText("1");
                            stateWhiteOsaekomi = false;
                            timer.stop();
                            secondOsaekomi = 0;
                            whiteOsaekomi.setText("0");
                        }
                    }

                    if(secondOsaekomi == 21)
                    {
                        whiteScoreIppon++;
                        whiteIppon.setText("1");
                        stateWhiteOsaekomi = false;
                        timer.stop();
                        secondOsaekomi = 0;
                        whiteOsaekomi.setText("0");
                    }
                }
            });

            System.out.println("Second = " + secondOsaekomi);

        }

        if(stateFightTime)
        {
            Platform.runLater(() ->
            {
                if(secondFight < 10)
                {
                    fightTime.setText("" + minuteFight + " : 0" + secondFight);
                    secondFight--;
                }

                else
                {
                    fightTime.setText("" + minuteFight + " : " + secondFight);
                    secondFight--;
                }

                if(minuteFight == 0 && secondFight < 0)
                {
                    stateFightTime = false;
                    stateGoldenScore = true;
                    minuteFight = 0;
                    secondFight = 0;
                    fightTime.setText("" + minuteFight + " : 0" + secondFight);
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
                    fightTime.setText("" + minuteFight + " : 0" + secondFight);
                    secondFight++;
                }

                else
                {
                    fightTime.setText("" + minuteFight + " : " + secondFight);
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
    }

    @FXML
    public void mouseClickedWhiteShido(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(whiteScoreShido == 0)
            {
                whiteShido.setText("1");
                whiteScoreShido++;
            }

            else if(whiteScoreShido == 1)
            {
                whiteShido.setText("2");
                whiteScoreShido++;
            }

            else if(whiteScoreShido == 2)
            {
                whiteShido.setText("3");
                whiteScoreIppon = 1;
                whiteIppon.setText("1");
                whiteScoreShido++;
            }
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(whiteScoreShido == 3)
            {
                whiteShido.setText("2");
                whiteIppon.setText("0");
                whiteScoreIppon = 0;
                whiteScoreShido--;
            }

            else if(whiteScoreShido == 2)
            {
                whiteShido.setText("1");
                whiteScoreShido--;
            }

            else if(whiteScoreShido == 1)
            {
                whiteShido.setText("0");
                whiteScoreShido--;
            }
        }
    }

    @FXML
    public void mouseClickedWhiteWazaari(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(whiteScoreWazaari == 0)
            {
                whiteWazaari.setText("1");
                whiteScoreWazaari++;
            }

            else if(whiteScoreWazaari == 1 )
            {
                whiteIppon.setText("1");
                whiteScoreIppon = 1;
                whiteScoreWazaari++;
            }
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(whiteScoreWazaari == 2)
            {
                whiteIppon.setText("0");
                whiteScoreIppon = 0;
                whiteScoreWazaari--;
            }

            else if(whiteScoreWazaari == 1)
            {
                whiteWazaari.setText("0");
                whiteScoreWazaari--;
            }
        }
    }

    @FXML
    public void mouseClickedWhiteIppon(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(whiteScoreIppon == 0)
            {
                whiteIppon.setText("1");
                whiteScoreIppon++;
            }
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(whiteScoreIppon == 1)
            {
                if(whiteScoreWazaari == 2)
                {
                    whiteScoreWazaari = 1;
                    whiteIppon.setText("0");
                    whiteScoreIppon--;
                }

                else if(whiteScoreShido == 3)
                {
                    whiteScoreShido = 2;
                    whiteIppon.setText("0");
                    whiteShido.setText("2");
                    whiteScoreIppon--;
                }

                else
                {
                    whiteIppon.setText("0");
                    whiteScoreIppon--;
                }
            }
        }
    }

    @FXML
    public void mouseClickedWhiteOsaekomi(MouseEvent event) throws InterruptedException
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            stateWhiteOsaekomi = true;

            timer = new Timer(1000, this);
            timer.setInitialDelay(0);
            timer.start();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            stateWhiteOsaekomi = false;
            timer.stop();
            secondOsaekomi = 0;
            whiteOsaekomi.setText("0");
        }
    }

    @FXML
    public void mouseClickedFightTime(MouseEvent event) throws InterruptedException
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            stateFightTime = true;

            timer2 = new Timer(1000, this);
            timer2.setInitialDelay(0);
            timer2.start();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            stateFightTime = false;
            stateGoldenScore = false;

            timer2.stop();

            if(secondFight < 10)
            {
                fightTime.setText("" + minuteFight + " : 0" + secondFight);
            }

            else
            {
                fightTime.setText("" + minuteFight + " : " + secondFight);
            }
        }
    }
}