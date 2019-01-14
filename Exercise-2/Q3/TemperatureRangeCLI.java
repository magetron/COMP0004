import java.util.ArrayList;

public class TemperatureRangeCLI {

	TemperatureRange temperatureRange;

	private int getInt () {
		Input in = new Input();
		return in.nextInt();
	}

	private void printInstructions () {
		System.out.println("1. Set Temperature Range");
		System.out.println("2. Set Table Header");
		System.out.println("3. Set Celcius Column Header (Default C)");
		System.out.println("4. Set Fahrenheit Column Header (Default F)");
		System.out.println("5. Set Number of Columns");
		System.out.println("6. Set Number of Spaces Between Columns");
		System.out.println("7. Output Temperature Table");
	}

	private TemperatureRange setNewTemperatureRange (int lower, int upper) {
		try {
			return new TemperatureRange(lower, upper);
		} catch (Exception invalidTemperatureRange) {
			System.out.println("ERROR : invalid Temperature Range.");
		}
	}

}



