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

    private void deleteQuestionChoices (int QuestionID, String questionChoice) {
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

    private void displayAllQuestions (int mode) {
        for (int i = 0; i < problemSet.size(); i++) {
            System.out.println("ID : " + i);
            System.out.println(problemSet.get(i).toString());
            if (mode == 1) System.out.println(problemSet.get(i).getAnswers());
        }
    }

    private ArrayList<Boolean> getAnswers () {
        ArrayList<Boolean> answers = new ArrayList<>();
        for (int i = 0; i < 26; i++) answers.add(false);
        System.out.println("Number of Answers?");
        int numberOfAnswers = getInt();
        System.out.println("Type Question Answers. Seperate by Line.");
        for (int i = 0; i < numberOfAnswers; i++) {
            String answer = getString();
            answers.set((int) answer.charAt(0) - 97, true);
        }
        return answers;
    }

    private void getInitProblemSet () {
        FileInput fileIn = new FileInput("src/InitProblemSet.txt");
        int countCycle = 0;
        int QuestionID = -1;
        while (fileIn.hasNextLine()) {
            String newFileString = fileIn.nextLine();
            switch(countCycle % 3) {
                case 0 :
                    addNewQuestion(newFileString); QuestionID++; break;
                case 1 :
                    int choicesToAdd = Integer.parseInt(newFileString);
                    for (int i = 0; i < choicesToAdd; i++) {
                        String choice = fileIn.nextLine();
                        addQuestionChoice(QuestionID, choice);
                    }
                    break;
                case 2 :
                    ArrayList<Boolean> answers = new ArrayList<>();
                    for (int i = 0; i < 26; i++) answers.add(false);
                    int numberOfAnswers = Integer.parseInt(newFileString);
                    for (int i = 0; i < numberOfAnswers; i++) {
                        String answer = fileIn.nextLine();
                        answers.set((int) answer.charAt(0) - 97, true);
                    }
                    addQuestionAnswers(QuestionID, answers);
                    break;
            }
            countCycle++;
        }
    }


    private void printInstructions () {
        System.out.println("1. Add New Question");
        System.out.println("2. Modify a existing Question");
        System.out.println("3. Display all Questions");
        System.out.println("4. Launch Test Mode");
        System.out.println("5. Quit");
    }

    private void printModifyInstructions () {
        System.out.println("1. Modify Question Description");
        System.out.println("2. Add Question Choice");
        System.out.println("3. Delete Question Choice");
        System.out.println("4. Modify Question Answers");
    }

    private int getInt() {
        Input in = new Input ();
        if (in.hasNextInt()) return in.nextInt();
        else return -1;
    }

    private String getString () {
        Input in = new Input ();
        if (in.hasNextLine()) return in.nextLine();
        else return "";
    }

    private void modifyIOController () {
        System.out.println("Question ID ?");
        int questionID = getInt();
        printModifyInstructions();
        int opCode = getInt();
        switch (opCode) {
            case 1 : modifyQuestionDescription(questionID, getString()); break;
            case 2 : addQuestionChoice(questionID, getString()); break;
            case 3 : deleteQuestionChoices(questionID, getString()); break;
            case 4 : addQuestionAnswers(questionID, getAnswers());
        }
    }

    public void launchTestMode() {
        for (int i = 0; i < problemSet.size(); i++) {
            System.out.println(problemSet.get(i).toString());
            ArrayList<Boolean> userAnswers = getAnswers();
            ArrayList<Boolean> checkStatus = problemSet.get(i).isCorrect(userAnswers);
            System.out.println(userAnswers);
            System.out.println(problemSet.get(i).getAnswers());
            if (!checkStatus.get(0) && !checkStatus.get(1)) System.out.println("Wrong!");
            else if (checkStatus.get(0) && !checkStatus.get(1)) System.out.println("Partially Correct !");
            else if (checkStatus.get(0) && checkStatus.get(1)) System.out.println("Correct !");
        }
    }

    private void ioController () {
        getInitProblemSet();
        int opCode = -1;
        while (opCode != 5) {
            printInstructions();
            opCode = getInt();
            switch (opCode) {
                case 1 : System.out.println("New Question Description?"); addNewQuestion(getString()); break;
                case 2 : modifyIOController(); break;
                case 3 : displayAllQuestions(1); break;
                case 4 : launchTestMode(); break;
            }
        }
    }

    public static void main(String[] args) {
        new Main().ioController();
    }
}
