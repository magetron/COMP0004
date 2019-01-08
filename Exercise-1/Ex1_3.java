public class Ex1_3 {
	
	private boolean inRange (int x) {
		if ( (x >= 2) && (x <= 12) ) return true;
		else return false;
	}

	private int getInput () {
		Input in = new Input ();
		int x = in.nextInt();
		return x;
	}
	
	private void displayTable (final int n) {
		int t = 1;
		while (t < 13) 	System.out.println(t++ * n);
	}

	public void ioController () {
		int userInput = getInput();
		if (inRange(userInput)) displayTable(userInput);
		else System.out.println("ERROR : user input not in range [2, 12]");
	}

	public static void main (final String[] args) {
		new Ex1_3().ioController();
	}
}

	

