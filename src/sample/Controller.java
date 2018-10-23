package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller //implements ActionListener
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
    /*private static int blueScoreWazaari = 0;
    private static int blueScoreIppon = 0;
    private static int blueScoreShido = 0;*/

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
        whiteOsaekomi.setTextFill(Color.WHITE);
        whiteIppon.setText("" + whiteScoreIppon);
        whiteIppon.setTextFill(Color.WHITE);
        whiteWazaari.setText("" + whiteScoreWazaari);
        fightTime.setText("" + minuteFight + " : 0" + secondFight);
        fightTime.setTextFill(Color.RED);
    }

    /*@Override
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
                            whiteIppon.setTextFill(Color.BLACK);
                            stateWhiteOsaekomi = false;
                            timer.stop();
                            secondOsaekomi = 0;
                            whiteOsaekomi.setTextFill(Color.WHITE);
                        }
                    }

                    if(secondOsaekomi == 21)
                    {
                        whiteScoreIppon++;
                        whiteIppon.setText("1");
                        whiteIppon.setTextFill(Color.BLACK);
                        stateWhiteOsaekomi = false;
                        timer.stop();
                        secondOsaekomi = 0;
                        whiteOsaekomi.setTextFill(Color.WHITE);
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
    }*/

    @FXML
    public void mouseClickedWhiteShido(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(whiteScoreShido == 0)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("yellowCard.png"))));
                whiteScoreShido++;
            }

            else if(whiteScoreShido == 1)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("YellowCards.png"))));
                whiteScoreShido++;
            }

            else if(whiteScoreShido == 2)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("redCard.png"))));
                whiteScoreIppon = 1;
                whiteIppon.setTextFill(Color.BLACK);
                whiteIppon.setText("1");
                whiteScoreShido++;
            }
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(whiteScoreShido == 3)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("YellowCards.png"))));
                whiteIppon.setTextFill(Color.WHITE);
                whiteScoreIppon = 0;
                whiteScoreShido--;
            }

            else if(whiteScoreShido == 2)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("yellowCard.png"))));
                whiteScoreShido--;
            }

            else if(whiteScoreShido == 1)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("whiteCard.png"))));
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
                whiteIppon.setTextFill(Color.BLACK);
                whiteScoreIppon = 1;
                whiteScoreWazaari++;
            }
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(whiteScoreWazaari == 2)
            {
                whiteIppon.setTextFill(Color.WHITE);
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
                whiteIppon.setTextFill(Color.BLACK);
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
                    whiteIppon.setTextFill(Color.WHITE);
                    whiteScoreIppon--;
                }

                else if(whiteScoreShido == 3)
                {
                    whiteScoreShido = 2;
                    whiteIppon.setTextFill(Color.WHITE);
                    whiteShido.setText("2");
                    whiteScoreIppon--;
                }

                else
                {
                    whiteIppon.setTextFill(Color.WHITE);
                    whiteScoreIppon--;
                }
            }
        }
    }

    @FXML
    public void mouseClickedWhiteOsaekomi(MouseEvent event) throws InterruptedException // cos takiego chyba !!!!
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            stateWhiteOsaekomi = true;
            whiteOsaekomi.setTextFill(Color.RED);

            timer = new Timer(1000, e ->
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
                                    whiteIppon.setTextFill(Color.BLACK);
                                    stateWhiteOsaekomi = false;
                                    timer.stop();
                                    secondOsaekomi = 0;
                                    whiteOsaekomi.setTextFill(Color.WHITE);
                                }
                            }

                            if(secondOsaekomi == 21)
                            {
                                whiteScoreIppon++;
                                whiteIppon.setText("1");
                                whiteIppon.setTextFill(Color.BLACK);
                                stateWhiteOsaekomi = false;
                                timer.stop();
                                secondOsaekomi = 0;
                                whiteOsaekomi.setTextFill(Color.WHITE);
                            }
                        }
                    });

                    System.out.println("Second = " + secondOsaekomi);
                }
            });


            timer.setInitialDelay(0);
            timer.start();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            stateWhiteOsaekomi = false;
            timer.stop();
            secondOsaekomi = 0;
            whiteOsaekomi.setTextFill(Color.WHITE);
        }
    }

    @FXML
    public void mouseClickedFightTime(MouseEvent event) throws InterruptedException
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            stateFightTime = true;
            fightTime.setTextFill(Color.GREEN);

            timer2 = new Timer(1000, e ->
            {
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
            });

            timer2.setInitialDelay(0);
            timer2.start();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            stateFightTime = false;
            stateGoldenScore = false;
            fightTime.setTextFill(Color.RED);

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