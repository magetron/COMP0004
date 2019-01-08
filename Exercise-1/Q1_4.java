import java.util.Random;

public class Q1_4 {

	private Random randomno = new Random();

	private double generateRandomVal () {
		double randVal = randomno.nextDouble();
		return randVal;
	}
	
	private int generateRandomSign () {
		boolean randSign = randomno.nextBoolean();
		if (randSign) return 1;
		else return -1;
	}

	private double generateRandomDouble () {
		double randomDouble = generateRandomSign() * generateRandomVal();
		return randomDouble;
	}
	
	private void printStats (double min, double max, double avg) {
		System.out.println("min = " + min);
		System.out.println("max = " + max);
		System.out.println("avg = " + avg);
	}

	public void controller () {
		double max = -1;
		double min = 1;
		double avg = 0;
		for (int i = 0; i < 10000; i++) {
			double rand = generateRandomDouble();
			if (rand > max) max = rand;
			else if (rand < min) min = rand;
			avg += rand;
		}
		avg /= 10000;
		printStats(min, max, avg);
	}

	public static void main (String[] args) {
		new Q1_4().controller();
	}
}


