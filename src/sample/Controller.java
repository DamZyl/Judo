package sample;

import game.JudoGame;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javax.swing.*;

public class Controller
{
    private JudoGame judoGame = new JudoGame();
    private Timer timerFightTime;
    private Timer timerOsaekomi;

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
        whiteIppon.setText("" + judoGame.getWhitePlayer().getScore().getScoreIppon());
        whiteIppon.setTextFill(Color.WHITE);
        whiteWazaari.setText("" + judoGame.getWhitePlayer().getScore().getScoreWazaari());
        blueOsaekomi.setText("" + judoGame.getSecondOsaekomi());
        blueOsaekomi.setTextFill(Color.BLUE);
        blueIppon.setText("" + judoGame.getBluePlayer().getScore().getScoreIppon());
        blueIppon.setTextFill(Color.BLUE);
        blueWazaari.setText("" + judoGame.getBluePlayer().getScore().getScoreWazaari());
        fightTime.setText("" + judoGame.getMinuteFight() + " : 0" + judoGame.getSecondFight());
        fightTime.setTextFill(Color.RED);
    }

    @FXML
    public void mouseClickedWhiteShido(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(judoGame.getWhitePlayer().getScore().getScoreShido() == 0)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/yellowCard.png"))));
            }

            else if(judoGame.getWhitePlayer().getScore().getScoreShido() == 1)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/YellowCards.png"))));
            }

            else if(judoGame.getWhitePlayer().getScore().getScoreShido() == 2)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/redCard.png"))));
                whiteIppon.setTextFill(Color.BLACK);
                whiteIppon.setText("1");
            }

            judoGame.addWhiteScoreShido();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(judoGame.getWhitePlayer().getScore().getScoreShido() == 3)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/YellowCards.png"))));
                whiteIppon.setTextFill(Color.WHITE);
            }

            else if(judoGame.getWhitePlayer().getScore().getScoreShido() == 2)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/yellowCard.png"))));
            }

            else if(judoGame.getWhitePlayer().getScore().getScoreShido() == 1)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/whiteCard.png"))));
            }

            judoGame.removeWhiteScoreShido();
        }
    }

    @FXML
    public void mouseClickedWhiteWazaari(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(judoGame.getWhitePlayer().getScore().getScoreWazaari() == 0)
            {
                whiteWazaari.setText("1");
            }

            else if(judoGame.getWhitePlayer().getScore().getScoreWazaari() == 1 )
            {
                whiteIppon.setText("1");
                whiteIppon.setTextFill(Color.BLACK);
            }

            judoGame.addWhiteScoreWazaari();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(judoGame.getWhitePlayer().getScore().getScoreWazaari() == 2)
            {
                whiteIppon.setTextFill(Color.WHITE);
            }

            else if(judoGame.getWhitePlayer().getScore().getScoreWazaari() == 1)
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
            if(judoGame.getWhitePlayer().getScore().getScoreIppon() == 0)
            {
                whiteIppon.setText("1");
                whiteIppon.setTextFill(Color.BLACK);
            }

            judoGame.addWhiteScoreIppon();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if (judoGame.getWhitePlayer().getScore().getScoreIppon() == 1)
            {
                if (judoGame.getWhitePlayer().getScore().getScoreWazaari() == 2)
                {
                    whiteIppon.setTextFill(Color.WHITE);
                }

                else if (judoGame.getWhitePlayer().getScore().getScoreShido() == 3)
                {
                    whiteIppon.setTextFill(Color.WHITE);
                    whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/YellowCards.png"))));
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
    public void mouseClickedWhiteOsaekomi(MouseEvent event) throws InterruptedException // sprobowac z f-kcja dodawania z JudoGame
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            judoGame.getWhitePlayer().setStateOsaekomi(true);
            whiteOsaekomi.setTextFill(Color.RED);

            timerOsaekomi = new Timer(1000, e ->
            {
                if(judoGame.getWhitePlayer().isStateOsaekomi())
                {
                    Platform.runLater(() ->
                    {
                        {
                            whiteOsaekomi.setText("" + judoGame.getSecondOsaekomi());
                            judoGame.incrementSecondOsaekomi();

                            if (judoGame.getSecondOsaekomi() == 11)
                            {
                                if(judoGame.getWhitePlayer().getScore().getScoreWazaari() == 0)
                                {
                                    judoGame.addWhiteScoreWazaari();
                                    whiteWazaari.setText("1");
                                }

                                //else if(judoGame.getWhitePlayer().getScore().getScoreWazaari() == 1)
                                else
                                {
                                    judoGame.addWhiteScoreWazaari();
                                    judoGame.addWhiteScoreIppon();
                                    whiteIppon.setText("1");
                                    whiteIppon.setTextFill(Color.BLACK);
                                    judoGame.getWhitePlayer().setStateOsaekomi(false);
                                    timerOsaekomi.stop();
                                    judoGame.setSecondOsaekomi(0);
                                    whiteOsaekomi.setText("0");
                                    whiteOsaekomi.setTextFill(Color.WHITE);
                                }
                            }

                            if (judoGame.getSecondOsaekomi() > 20)
                            {
                                judoGame.addWhiteScoreIppon();
                                whiteIppon.setText("1");
                                whiteIppon.setTextFill(Color.BLACK);
                                judoGame.getWhitePlayer().setStateOsaekomi(false);
                                timerOsaekomi.stop();
                                judoGame.setSecondOsaekomi(0);
                                whiteOsaekomi.setText("0");
                                whiteOsaekomi.setTextFill(Color.WHITE);
                            }
                        }
                    });

                    System.out.println("Second = " + judoGame.getSecondOsaekomi());
                }
            });

            timerOsaekomi.setInitialDelay(0);
            timerOsaekomi.start();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            judoGame.getWhitePlayer().setStateOsaekomi(false);
            timerOsaekomi.stop();
            judoGame.setSecondOsaekomi(0);
            whiteOsaekomi.setTextFill(Color.WHITE);
        }
    }

    @FXML
    public void mouseClickedBlueShido(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(judoGame.getBluePlayer().getScore().getScoreShido() == 0)
            {
                blueShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/yellowCard.png"))));
            }

            else if(judoGame.getBluePlayer().getScore().getScoreShido() == 1)
            {
                blueShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/YellowCards2.png"))));
            }

            else if(judoGame.getBluePlayer().getScore().getScoreShido() == 2)
            {
                blueShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/redCard.png"))));
                blueIppon.setTextFill(Color.WHITE);
                blueIppon.setText("1");
            }

            judoGame.addBlueScoreShido();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(judoGame.getBluePlayer().getScore().getScoreShido() == 3)
            {
                blueShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/YellowCards2.png"))));
                blueIppon.setTextFill(Color.BLUE);
            }

            else if(judoGame.getBluePlayer().getScore().getScoreShido() == 2)
            {
                blueShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/yellowCard.png"))));
            }

            else if(judoGame.getBluePlayer().getScore().getScoreShido() == 1)
            {
                blueShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/blueCard.png"))));
            }

            judoGame.removeBlueScoreShido();
        }
    }

    @FXML
    public void mouseClickedBlueWazaari(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(judoGame.getBluePlayer().getScore().getScoreWazaari() == 0)
            {
                blueWazaari.setText("1");
            }

            else if(judoGame.getBluePlayer().getScore().getScoreWazaari() == 1 )
            {
                blueIppon.setText("1");
                blueIppon.setTextFill(Color.WHITE);
            }

            judoGame.addBlueScoreWazaari();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(judoGame.getBluePlayer().getScore().getScoreWazaari() == 2)
            {
                blueIppon.setTextFill(Color.BLUE);
            }

            else if(judoGame.getBluePlayer().getScore().getScoreWazaari() == 1)
            {
                blueWazaari.setText("0");
            }

            judoGame.removeBlueScoreWazaari();
        }
    }

    @FXML
    public void mouseClickedBlueIppon(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(judoGame.getBluePlayer().getScore().getScoreIppon() == 0)
            {
                blueIppon.setText("1");
                blueIppon.setTextFill(Color.WHITE);
            }

            judoGame.addBlueScoreIppon();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(judoGame.getBluePlayer().getScore().getScoreIppon() == 1)
            {
                if(judoGame.getBluePlayer().getScore().getScoreWazaari() == 2)
                {
                    blueIppon.setTextFill(Color.BLUE);
                }

                else if(judoGame.getBluePlayer().getScore().getScoreShido() == 3)
                {
                    blueIppon.setTextFill(Color.BLUE);
                    blueShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/YellowCards2.png"))));
                }

                else
                {
                    blueIppon.setTextFill(Color.BLUE);
                }
            }

            judoGame.removeBlueScoreIppon();
        }
    }

    @FXML
    public void mouseClickedBlueOsaekomi(MouseEvent event) throws InterruptedException
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            judoGame.getBluePlayer().setStateOsaekomi(true);
            blueOsaekomi.setTextFill(Color.RED);

            timerOsaekomi = new Timer(1000, e ->
            {
                if(judoGame.getBluePlayer().isStateOsaekomi())
                {
                    Platform.runLater(() ->
                    {
                        {
                            blueOsaekomi.setText("" + judoGame.getSecondOsaekomi());
                            judoGame.incrementSecondOsaekomi();

                            if (judoGame.getSecondOsaekomi() == 11)
                            {
                                if(judoGame.getBluePlayer().getScore().getScoreWazaari() == 0)
                                {
                                    judoGame.addBlueScoreWazaari();
                                    blueWazaari.setText("1");
                                }

                                //else if(judoGame.getWhitePlayer().getScore().getScoreWazaari() == 1)
                                else
                                {
                                    judoGame.addBlueScoreIppon();
                                    judoGame.addBlueScoreIppon();
                                    blueIppon.setText("1");
                                    blueIppon.setTextFill(Color.WHITE);
                                    judoGame.getBluePlayer().setStateOsaekomi(false);
                                    timerOsaekomi.stop();
                                    judoGame.setSecondOsaekomi(0);
                                    blueOsaekomi.setText("0");
                                    blueOsaekomi.setTextFill(Color.BLUE);
                                }
                            }

                            if (judoGame.getSecondOsaekomi() > 20)
                            {
                                judoGame.addBlueScoreIppon();
                                blueIppon.setText("1");
                                blueIppon.setTextFill(Color.WHITE);
                                judoGame.getBluePlayer().setStateOsaekomi(false);
                                timerOsaekomi.stop();
                                judoGame.setSecondOsaekomi(0);
                                blueOsaekomi.setText("0");
                                blueOsaekomi.setTextFill(Color.BLUE);
                            }
                        }
                    });

                    System.out.println("Second = " + judoGame.getSecondOsaekomi());
                }
            });

            timerOsaekomi.setInitialDelay(0);
            timerOsaekomi.start();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            judoGame.getBluePlayer().setStateOsaekomi(false);
            timerOsaekomi.stop();
            judoGame.setSecondOsaekomi(0);
            blueOsaekomi.setTextFill(Color.BLUE);
        }
    }

    @FXML
    public void mouseClickedFightTime(MouseEvent event) throws InterruptedException
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            judoGame.setStateFightTime(true);
            fightTime.setTextFill(Color.GREEN);

            timerFightTime = new Timer(1000, e ->
            {
                if(judoGame.isStateFightTime())
                {
                    Platform.runLater(() ->
                    {
                        if(judoGame.getSecondFight() < 10)
                        {
                            fightTime.setText("" + judoGame.getMinuteFight() + " : 0" + judoGame.getSecondFight());
                            judoGame.decrementSecondFight();
                        }

                        else
                        {
                            fightTime.setText("" + judoGame.getMinuteFight() + " : " + judoGame.getSecondFight());
                            judoGame.decrementSecondFight();
                        }

                        if(judoGame.getMinuteFight() == 0 && judoGame.getSecondFight() < 0)
                        {
                            judoGame.setStateFightTime(false);
                            judoGame.setStateGoldenScore(true);
                            judoGame.setMinuteFight(0);
                            judoGame.setSecondFight(0);
                            fightTime.setText("" + judoGame.getMinuteFight() + " : 0" + judoGame.getSecondFight());
                        }

                        if(judoGame.getSecondFight() < 0)
                        {
                            judoGame.setSecondFight(59);
                            judoGame.decrementMinuteFight();
                        }
                    });

                    System.out.println("Minute = " + judoGame.getMinuteFight() + " Second = " + judoGame.getSecondFight());
                }

                if(judoGame.isStateGoldenScore())
                {
                    Platform.runLater(() ->
                    {
                        if(judoGame.getSecondFight() < 10)
                        {
                            fightTime.setText("" + judoGame.getMinuteFight() + " : 0" + judoGame.getSecondFight());
                            judoGame.incrementSecondFight();
                        }
                        else
                        {
                            fightTime.setText("" + judoGame.getMinuteFight() + " : " + judoGame.getSecondFight());
                            judoGame.incrementSecondFight();
                        }
                        if(judoGame.getSecondFight() > 59)
                        {
                            judoGame.setSecondFight(0);
                            judoGame.incrementMinuteFight();
                        }
                    });

                    System.out.println("Minute = " + judoGame.getMinuteFight() + " Second = " + judoGame.getSecondFight());
                }
            });

            timerFightTime.setInitialDelay(0);
            timerFightTime.start();
            fightTime.setTextFill(Color.GREEN);
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            judoGame.setStateFightTime(false);
            judoGame.setStateGoldenScore(false);
            fightTime.setTextFill(Color.RED);
            timerFightTime.stop();

            if(judoGame.getSecondFight() < 10)
            {
                fightTime.setText("" + judoGame.getMinuteFight() + " : 0" + judoGame.getSecondFight());
            }

            else
            {
                fightTime.setText("" + judoGame.getMinuteFight() + " : " + judoGame.getSecondFight());
            }

            fightTime.setTextFill(Color.RED);
        }
    }
}