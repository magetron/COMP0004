import java.util.ArrayList;

public class Main {

    private ArrayList<Question> problemSet = new ArrayList<>();

    private void addNewQuestion (String questionDescription) {
        Question newQuestion = new Question(questionDescription);
        problemSet.add(newQuestion);
    }

    private void addQuestionChoice (int QuestionID, String questionChoice) {
        Question modifiedQuestion = problemSet.get(QuestionID);
        modifiedQuestion.addChoices(questionChoice);
        problemSet.set(QuestionID, modifiedQuestion);
    }

    private void deleteQuestionChocies (int QuestionID, String questionChoice) {
        Question modifiedQuestion = problemSet.get(QuestionID);
        modifiedQuestion.deleteChoices(questionChoice);
        problemSet.set(QuestionID, modifiedQuestion);
    }

    private void modifyQuestionDescription (int QuestionID, String newDescription) {
        Question modifiedQuestion = problemSet.get(QuestionID);
        modifiedQuestion.modifyDescription(newDescription);
        problemSet.set(QuestionID, modifiedQuestion);
    }

    private void addQuestionAnswers (int QuestionID, ArrayList<Boolean> correctAnswers) {
        Question modifiedQuestion = problemSet.get(QuestionID);
        modifiedQuestion.addAnswers(correctAnswers);
        problemSet.set(QuestionID, modifiedQuestion);
    }

    private void displayallQuestions () {
        for (int i = 0; i < problemSet.size(); i++) {
            System.out.println("ID : " + i);
            System.out.println(problemSet.get(i).toString());
        }
    }

    private ArrayList<Boolean> getAnswers () {
        Input in = new Input ();
        ArrayList<Boolean> answers = new ArrayList<>();
        for (int i = 0; i < 26; i++) answers.add(false);
        while(in.hasNextChar()) {
            char newChar = in.nextChar();
            answers.set((int) newChar - 97, true);
        }
        return answers;
    }

    private void printInstructions () {
        System.out.println("1. Add New Question");
        System.out.println("2. Modify a existing Question");
        System.out.println("3. Display all Questions");
    }




    public static void main(String[] args) {

    }
}
