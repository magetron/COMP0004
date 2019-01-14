import java.util.ArrayList;

public class TemperatureRange {
	
	private int lower;
	private int upper;
	private String tableHeader = "";
	private String celciusColumnHeader = "C";
	private String fahrenheitColumnHeader = "F";
	private int numberOfColumns;
	private int numberOfSpacesBetween;
	private ArrayList<String> temperatureTable = new ArrayList<>();

	TemperatureRange (int lower, int upper) throws Exception {
		if (lower > upper) throw new Exception ("ERROR : invalid TemperatureRange.");
		this.lower = lower;
		this.upper = upper;
	}

	public void setHeader (String inputHeader) {
		this.tableHeader = inputHeader;
	}

	public void setCelciusColumnHeader (String celciusHeader) {
		this.celciusColumnHeader = celciusHeader;
	}

	public void setFahrenheitColumnHeader (String fahrenheitHeader) {
		this.fahrenheitColumnHeader = fahrenheitHeader;
	}

	public void setNumberOfColumns (int inputNumber) throws Exception {
		if (inputNumber < 1) throw new Exception ("ERROR : invalid numberOfColumns.");
		this.numberOfColumns = inputNumber;
	}

	public void setNumberOfSpacesBetween (int inputNumber) throws Exception {
		if (inputNumber < 0) throw new Exception ("ERROR : invalid numberOfSpacesBetween.");
		this.numberOfSpacesBetween = inputNumber;
	}

	private int toFahrenheit (int celcius) {
		return Math.toIntExact(Math.round(celcius * 9.0 / 5 - 32));
	}

	public void generateTable () {
		temperatureTable.add(this.tableHeader);
		String lineString = "";
		for (int i = 0; i < this.tableHeader.length(); i++) lineString += "-";
		temperatureTable.add(lineString);
		temperatureTable.add(String.format("%4s%4s",celciusColumnHeader, fahrenheitColumnHeader));
		for (int i = lower; i <= upper; i++)
			temperatureTable.add(String.format("%4d%4d", i, toFahrenheit(i)));
	}

	public ArrayList<String> getTable () {
		return this.temperatureTable;
	}
}




	









