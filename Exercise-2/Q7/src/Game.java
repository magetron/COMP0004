import java.util.ArrayList;

public class Game {

    private NameGenerator nameGenerator = new NameGenerator();
    private ArrayList<Player> players = new ArrayList<>();

    private int getInt () {
        Input in = new Input();
        if (in.hasNextInt()) return in.nextInt();
        else return -1;
    }

    private String getString () {
        Input in = new Input();
        if (in.hasNextLine()) return in.nextLine();
        else return "";
    }

    private void printWelcomeMessage () {
        System.out.println("Thank you for playing the Game of Greed.");
        System.out.println("Let's get you started.");
    }

    private void initPlayers () {
        System.out.println("First of all, how many players are there?");
        int humanPlayerCount = getInt();
        System.out.println("Nice, what are their names then? (Type one name per line)");
        for (int i = 0; i < humanPlayerCount; i++) {
            String humanPlayerName = getString();
            players.add(new Player(humanPlayerName, false));
        }
        System.out.println("Good, would you like AI to join this game as well? If not, type 0.");
        int aiPlayerCount = getInt();
        for (int i = 0; i < aiPlayerCount; i++) players.add(new Player(nameGenerator.getRandomName(), true));
    }

    private void startGame () {
        for (var player : players) {
            Scorer scorer = new Scorer(player.roll());
            if (player.getPlayerState().equals("bust")) {
                int score = scorer.getScore();
                if (score > 300) {
                    player.setPlayerState("playing");
                    Scorer scorer1 = new Scorer(player.roll());
                    player.setPlayerScore(player.getPlayerScore() + scorer1.getScore());
                }
            } else
                player.setPlayerScore(player.getPlayerScore() + scorer.getScore());
        }
    }

    public void playGame () {
        printWelcomeMessage();
        initPlayers();
        startGame();
    }



}
