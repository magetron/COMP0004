import java.util.Random;

public class Dice {
    Random dice = new Random();

    public Integer roll () {
        return dice.nextInt(6) + 1;
    }

}
