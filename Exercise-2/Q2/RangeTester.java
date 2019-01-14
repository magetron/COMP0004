import java.util.ArrayList;

public class RangeTester {
	
	private Range range;

	private int getInt () {
		Input in = new Input ();
		if (in.hasNextInt()) return in.nextInt();
		return -1;
	}

	private void printInstructions () {
		System.out.println("1. Set Upper and Lower Bounds");
		System.out.println("2. Check if Number is in Range");
		System.out.println("3. Print all number of Range");
		System.out.println("4. Quit");
	}

	private void newRangeFromInput () {
		System.out.println("Lower Bound ?");
		int lower = getInt();
		System.out.println("Upper Bound ?");
		int upper = getInt();
		try {
			range = new Range(lower, upper);
			System.out.println("Set Successful.");
		} catch (Exception invalidRange) {
			System.out.println("ERROR : range invalid");
		}
	}

	public void ioController () {
		int op = 0;
		while (op != 4) {
			printInstructions();
			op = getInt();
			switch (op) {
				case 1 : newRangeFromInput();
					 break;
				case 2 : System.out.println("Number ?");
					 System.out.println(range.contains(getInt())); 
					 break;
				case 3 : System.out.println(range.getValues());
					 break;
				case 4 : break;
				default : System.out.println("ERROR : operation invalid.");
			}
		}
	}

	public static void main (String args[]) {
		new RangeTester().ioController();
	}
}

