import java.util.ArrayList;

public class Scorer {
    private ArrayList<Integer> diceResult;

    public Scorer (ArrayList<Integer> diceResult) {
        this.diceResult = diceResult;
    }

    private int threeInARow (ArrayList<Integer> diceResult) {
        for (int i = 1; i <= 6; i++) {
            int repetitionCount = 0;
            for (int j = 0; j <= diceResult.size(); j++) {
                if (diceResult.get(j) == i) repetitionCount++;
                if (repetitionCount >= 3) {
                    int removeCount = 0;
                    for (var k : diceResult) if ((k == i) && (removeCount < 3)) {
                        diceResult.remove(k);
                        removeCount++;
                    }
                    if (i != 1) return i * 100;
                    else return 1000;
                }
            }
        }
        return 0;
    }

    private int scoreOnesAndFives (ArrayList<Integer> diceResult) {
        int countOnes = 0;
        int countFives = 0;
        for (int i = 0; i < diceResult.size(); i++)
            if (diceResult.get(i) == 1) countOnes++;
            else if (diceResult.get(i) == 5) countFives++;
        return 100 * countOnes + 50 * countFives;
    }

    public int getScore () {
        return scoreOnesAndFives(diceResult) + threeInARow(diceResult);
    }
}
