import java.util.ArrayList;

public class Question {

    private String description;
    private int choicesAvailable = 0;
    private ArrayList<Boolean> answers;
    private ArrayList<String> choices = new ArrayList<>();

    Question (String description) {
        this.description = description;
    }

    public void modifyDescription (String newDescription) {
        description = newDescription;
    }

    public void addAnswers (ArrayList<Boolean> correctAnswers) {
        answers = correctAnswers;
    }

    public void addChoices (String newChoice) {
        choices.add(newChoice);
        choicesAvailable++;
    }

    public void deleteChoices (String deleteChoice) {
        for (var choice : choices) if (choice.equals(deleteChoice)) {
            choicesAvailable--;
            choices.remove(choice);
        }
    }

    public int getChoicesAvailable () {
        return choicesAvailable;
    }

    public ArrayList<Boolean> getAnswers () {
        return answers;
    }

    public ArrayList<Boolean> isCorrect (ArrayList<Boolean> userAnswers) {
        boolean partiallyCorrect = false;
        boolean allCorrect = true;
        for (int i = 0; i < choicesAvailable; i++) {
            if (userAnswers.get(i) && answers.get(i)) partiallyCorrect = true;
            if (userAnswers.get(i) != answers.get(i)) allCorrect = false;
        }
        ArrayList<Boolean> checkResult = new ArrayList<>();
        checkResult.add(partiallyCorrect);
        checkResult.add(allCorrect);
        return checkResult;
    }


    @Override
    public String toString () {
        String fullString = description + "\n";
        for (int i = 0; i < choicesAvailable; i++) fullString += (char)(97 + i) + " . " + choices.get(i) + "\n";
        return fullString;
    }

}
