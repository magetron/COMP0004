import java.util.ArrayList;

public class Player {
    private String playerName;
    private Integer playerScore;
    private Integer playerDefaultDiceCount;
    private String playerState;
    private Boolean needAutoPlay;
    private ArrayList<Dice> playerDices = new ArrayList<>();

    public Player (String playerName, boolean needAutoPlay) {
        this.playerName = playerName;
        this.needAutoPlay = needAutoPlay;
        playerDefaultDiceCount = 5;
        playerState = "busted";
    }

    public String getPlayerName () {
        return playerName;
    }

    public Boolean doNeedAutoPlay () {
        return needAutoPlay;
    }

    public Integer getPlayerScore () {
        return playerScore;
    }

    public String getPlayerState () {
        return playerState;
    }

    public void setPlayerState (String playerState) {
        this.playerState = playerState;
    }

    public void setPlayerScore (Integer playerScore) {
        this.playerScore = playerScore;
    }

    public ArrayList<Integer> roll () {
        ArrayList<Integer> rollResult = new ArrayList<>();
        for (var dice : playerDices)
            rollResult.add(dice.roll());
        return rollResult;
    }

    public void newRound () {
        playerDices.clear();
        for (int i = 0; i < playerDefaultDiceCount; i++) playerDices.add(new Dice());
    }

}
