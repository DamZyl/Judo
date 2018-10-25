package sample;

import game.JudoGame;
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
    /*
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
    */
    private JudoGame judoGame = new JudoGame();

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
        whiteOsaekomi.setText("" + judoGame.getSecondOsaekomi());
        whiteOsaekomi.setTextFill(Color.WHITE);
        whiteIppon.setText("" + judoGame.getWhiteScoreIppon());
        whiteIppon.setTextFill(Color.WHITE);
        whiteWazaari.setText("" + judoGame.getWhiteScoreWazaari());
        //fightTime.setText("" + minuteFight + " : 0" + secondFight);
        fightTime.setTextFill(Color.RED);
    }

    public Label getWhiteOsaekomi()
    {
        return whiteOsaekomi;
    }

    public Label getWhiteIppon()
    {
        return whiteIppon;
    }

    public Label getWhiteWazaari()
    {
        return whiteWazaari;
    }

    public Label getFightTime()
    {
        return fightTime;
    }

    public Label getWhiteShido()
    {
        return whiteShido;
    }

    /*
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
    }
    */

    @FXML
    public void mouseClickedWhiteShido(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(judoGame.getWhiteScoreShido() == 0)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("yellowCard.png"))));
            }

            else if(judoGame.getWhiteScoreShido() == 1)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("YellowCards.png"))));
            }

            else if(judoGame.getWhiteScoreShido() == 2)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("redCard.png"))));
                whiteIppon.setTextFill(Color.BLACK);
                whiteIppon.setText("1");
            }

            judoGame.addWhiteScoreShido();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(judoGame.getWhiteScoreShido() == 3)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("YellowCards.png"))));
                whiteIppon.setTextFill(Color.WHITE);
            }

            else if(judoGame.getWhiteScoreShido() == 2)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("yellowCard.png"))));
            }

            else if(judoGame.getWhiteScoreShido() == 1)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("whiteCard.png"))));
            }

            judoGame.removeWhiteScoreShido();
        }
    }

    @FXML
    public void mouseClickedWhiteWazaari(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(judoGame.getWhiteScoreWazaari() == 0)
            {
                whiteWazaari.setText("1");
            }

            else if(judoGame.getWhiteScoreWazaari() == 1 )
            {
                whiteIppon.setText("1");
                whiteIppon.setTextFill(Color.BLACK);
            }

            judoGame.addWhiteScoreWazaari();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(judoGame.getWhiteScoreWazaari() == 2)
            {
                whiteIppon.setTextFill(Color.WHITE);
            }

            else if(judoGame.getWhiteScoreWazaari() == 1)
            {
                whiteWazaari.setText("0");
            }

            judoGame.removeWhiteScoreWazaari();
        }
    }

    @FXML
    public void mouseClickedWhiteIppon(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(judoGame.getWhiteScoreIppon() == 0)
            {
                whiteIppon.setText("1");
                whiteIppon.setTextFill(Color.BLACK);
            }

            judoGame.addWhiteScoreIppon();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(judoGame.getWhiteScoreIppon() == 1)
            {
                if(judoGame.getWhiteScoreWazaari() == 2)
                {
                    whiteIppon.setTextFill(Color.WHITE);
                }

                else if(judoGame.getWhiteScoreShido() == 3)
                {
                    whiteIppon.setTextFill(Color.WHITE);
                    whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("YellowCards.png"))));
                }

                else
                {
                    whiteIppon.setTextFill(Color.WHITE);
                }
            }

            judoGame.removeWhiteScoreIppon();
        }
    }

    @FXML
    public void mouseClickedWhiteOsaekomi(MouseEvent event) throws InterruptedException // cos takiego chyba !!!!
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            /*
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
            */
            judoGame.startOsaekomi();
            whiteOsaekomi.setTextFill(Color.RED);
            whiteOsaekomi.setText("" + judoGame.getSecondOsaekomi());

            if(judoGame.getSecondOsaekomi() == 11)
            {
                whiteWazaari.setText("1");

                if(judoGame.getWhiteScoreWazaari() == 2)
                {
                    whiteIppon.setText("1");
                    whiteIppon.setTextFill(Color.BLACK);
                    whiteOsaekomi.setTextFill(Color.WHITE);
                }
            }
            if(judoGame.getSecondOsaekomi() == 21)
            {
                whiteIppon.setText("1");
                whiteIppon.setTextFill(Color.BLACK);
                whiteOsaekomi.setTextFill(Color.WHITE);
            }
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            /*
            stateWhiteOsaekomi = false;
            timer.stop();
            secondOsaekomi = 0;
            whiteOsaekomi.setTextFill(Color.WHITE);
            */
            whiteOsaekomi.setTextFill(Color.WHITE);
            judoGame.stopOsaekomi();
        }
    }

    @FXML
    public void mouseClickedFightTime(MouseEvent event) throws InterruptedException
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            /*
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
            */
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            /*
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
            }*/
        }
    }
}