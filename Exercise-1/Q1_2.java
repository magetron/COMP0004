import java.util.ArrayList;

public class Q1_2 {
	private ArrayList<Double> a = new ArrayList<>();

	private void readArray () {
		Input in = new Input();
		for (int i = 0; i < 10; i++) {
			double tmp = in.nextDouble();
		 	a.add(tmp);
		}
	}

	private double averageArray () {
		double avg = 0;
		for (int i = 0; i < 10; i++) avg += a.get(i);
		avg /= 10;
		return avg;
	}

	public void controller () {
		readArray();
		System.out.println("Avg = " + averageArray());
	}

	public static void main (String[] args) {
		new Q1_2().controller();
	}
}

		
