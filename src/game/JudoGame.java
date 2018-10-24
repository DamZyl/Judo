package game;

import player.BluePlayer;
import player.WhitePlayer;
import java.util.Timer;

public class JudoGame
{
    private Timer timerOsaekomi;
    private Timer timerFight;
    private WhitePlayer whitePlayer;
    private BluePlayer bluePlayer;
    private int secondOsaekomi;
    private int secondFight;
    private int minuteFight;
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
        this.stateWhiteOsaekomi = false;
        this.stateBlueOsaekomi = false;
        this.stateFightTime = false;
        this.stateGoldenScore = false;
    }
}
