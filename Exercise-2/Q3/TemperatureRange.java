import java.util.ArrayList;

public class TemperatureRange {
	
	private int lower;
	private int upper;
	private String tableHeader = "Default Table Header";
	private String celciusColumnHeader = "C";
	private String fahrenheitColumnHeader = "F";
	private int columnWidth = 4;
	private int numberOfColumns = 4;
	private int numberOfSpacesBetween = 5;
	private ArrayList< ArrayList<String> > temperatureTable = new ArrayList< ArrayList<String> >();

	TemperatureRange (int lower, int upper) throws Exception {
		if (lower > upper) throw new Exception ("ERROR : invalid TemperatureRange.");
		this.lower = lower;
		this.upper = upper;
	}

	public String getTableHeader () {
		return tableHeader;
	}

	public int getColumnWidth () {
		return columnWidth;
	}

	public int getNumberOfSpacesBetweenColumns () {
		return numberOfSpacesBetween;
	}

	public int getNumberOfColumns () {
		return numberOfColumns;
	}
	
	public void setHeader (String inputHeader) {
		tableHeader = inputHeader;
	}

	public void setCelciusColumnHeader (String celciusHeader) {
		celciusColumnHeader = celciusHeader;
	}

	public void setFahrenheitColumnHeader (String fahrenheitHeader) {
		fahrenheitColumnHeader = fahrenheitHeader;
	}

	public void setNumberOfColumns (int inputNumber) throws Exception {
		if (inputNumber < 1) throw new Exception ("ERROR : invalid numberOfColumns.");
		numberOfColumns = inputNumber;
	}

	public void setNumberOfSpacesBetween (int inputNumber) throws Exception {
		if (inputNumber < 0) throw new Exception ("ERROR : invalid numberOfSpacesBetween.");
		numberOfSpacesBetween = inputNumber;
	}

	private int toFahrenheit (int celcius) {
		return Math.toIntExact(Math.round(celcius * 9.0 / 5 + 32));
	}

	private ArrayList<String> generateTableHeader () {
		ArrayList<String> tableHeaderArray = new ArrayList<String>();
		tableHeaderArray.add(tableHeader);
		String lineString = "";
		for (int i = 0; i < tableHeader.length(); i++) lineString += "-";
		tableHeaderArray.add(lineString);
		return tableHeaderArray;
	}

	private ArrayList<String> generateTableColumns () {
		ArrayList<String> tableColumnArray = new ArrayList<String>();
		String singleColumnString = "";
		singleColumnString += celciusColumnHeader;
		for (int i = 0; i < columnWidth - celciusColumnHeader.length(); i++) 
			singleColumnString += " ";
		singleColumnString += fahrenheitColumnHeader;
		for (int i = 0; i < columnWidth - fahrenheitColumnHeader.length(); i++)
			singleColumnString += " ";
		for (int i = 0; i < numberOfColumns; i++) tableColumnArray.add(singleColumnString);
		return tableColumnArray;
	}

	private ArrayList<String> generateTableContents() {
		ArrayList<String> tableContentArray = new ArrayList<String>();
		for (int i = lower; i <= upper; i++) {
			String temperatureString = "";
			String celciusString = Integer.toString(i);
			temperatureString += celciusString;
			for (int j = 0; j < columnWidth - celciusString.length(); j++)
				temperatureString += " ";
			String fahrenheitString = Integer.toString(toFahrenheit(i));
			temperatureString += fahrenheitString;
			for (int j = 0; j < columnWidth - fahrenheitString.length(); j++) 
				temperatureString += " ";
			tableContentArray.add(temperatureString);
		}
		return tableContentArray;
	}

	public void generateTable () {
		temperatureTable.add(generateTableHeader());
		temperatureTable.add(generateTableColumns());
		temperatureTable.add(generateTableContents());
	}

	public ArrayList< ArrayList<String> > getTable () {
		return temperatureTable;
	}
}




	









