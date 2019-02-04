import java.util.ArrayList;
import java.util.Random;

public class NameGenerator {

    private ArrayList<String> randomNames = new ArrayList<>();

    private void setRandomNames () {
        randomNames.add("John");
        randomNames.add("Kevin");
        randomNames.add("James");
        randomNames.add("Peter");
        randomNames.add("Joe");
        randomNames.add("Felix");
        randomNames.add("Patrick");
        randomNames.add("Henry");
        randomNames.add("Monica");
        randomNames.add("Lisa");
        randomNames.add("Joanne");
        randomNames.add("Anna");
        randomNames.add("Sophie");
        randomNames.add("Davies");
    }

    public String getRandomName () {
        setRandomNames();
        Random randName = new Random();
        return randomNames.get(randName.nextInt(randomNames.size()));
    }
}

