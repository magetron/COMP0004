public class Q1_8 {

	private double mmToft (double mm) {
		return 0.0032808399 * mm;
	}

	private double mToIn (double m) {
		return 39.37007874 * m;
	}

	private double kmToYd (double km) {
		return 1093.6132983 * km;
	}

	private void printResult (int mode, double org) {
		switch (mode) {
			case 1: System.out.println(org + " (mm) = " + mmToft(org) + " (ft)");
				break;
			case 2: System.out.println(org + " (m) = " + mToIn(org) + " (in)");
				break;
			case 3: System.out.println(org + " (km) = " + kmToYd(org) + " (yd)");
				break;
		}
	}

	private void printMenu () {
		System.out.println("1. Convert millimetres to feet.");
		System.out.println("2. Convert meters to inches.");
		System.out.println("3. Convert kilometres to yards.");
		System.out.println("4. Quit");
	}

	private void printHelpInstr (int mode) {
		switch (mode) {
			case 0: System.out.println("ERROR : invalid mode selection");
				break;
			case 1: System.out.println("Please input millimetres to convert");
				break;
			case 2: System.out.println("Please input meters to convert");
				break;
			case 3: System.out.println("Please input kilometres to convert");
				break;
			}
	}

	private boolean isValid (int userMode) {
		if ( (userMode >= 1) && (userMode <= 4) ) return true;
		else return false;
	}

	public void controller () {
		Input in = new Input();
		int userMode = 0;
		while (userMode != 4) {
			printMenu();
			userMode = in.nextInt();
			if (!isValid(userMode)) printHelpInstr(0);
			else if (userMode == 4) return;
			else {
				printHelpInstr(userMode);
				double org = in.nextDouble();
				printResult(userMode, org);
			}
		}
	}

	public static void main (String args[]) {
		new Q1_8().controller();
	}
}
