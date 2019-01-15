import java.util.ArrayList;

public class TemperatureRangeCLI {

	TemperatureRange temperatureRange;

	private int getInt () {
		Input in = new Input();
		return in.nextInt();
	}

	private String getString () {
		Input in = new Input();
		return in.nextLine();
	}

	private void printInstructions () {
		System.out.println("1. Set Temperature Range");
		System.out.println("2. Set Table Header");
		System.out.println("3. Set Celcius Column Header (Default C)");
		System.out.println("4. Set Fahrenheit Column Header (Default F)");
		System.out.println("5. Set Number of Columns");
		System.out.println("6. Set Number of Spaces Between Columns");
		System.out.println("7. Output Temperature Table");
		System.out.println("8. Quit");
	}

	private void setNewTemperatureRange (int lower, int upper) {
		try {
			temperatureRange = new TemperatureRange(lower, upper);
		} catch (Exception invalidTemperatureRange) {
			System.out.println("ERROR : invalid Temperature Range.");
		}
	}

	private void setTableHeader (String newTableHeader) {
		temperatureRange.setHeader(newTableHeader);
	}

	private void setTableCelciusColumnHeader (String newCelciusColumnHeader) {
		temperatureRange.setCelciusColumnHeader(newCelciusColumnHeader);
	}

	private void setTableFahrenheitColumnHeader (String newFahrenheitColumnHeader) {
		temperatureRange.setFahrenheitColumnHeader(newFahrenheitColumnHeader);
	}

	private void setNumberOfColumns (int newNumberOfColumns) {
		try {
			temperatureRange.setNumberOfColumns(newNumberOfColumns);
		} catch (Exception invalidNumberOfColumns) {
			System.out.println("ERROR : invalid Number Of Columns.");
		}
	}

	private void setNumberOfSpacesBetween (int newNumberOfSpacesBetween) {
		try {
			temperatureRange.setNumberOfSpacesBetween(newNumberOfSpacesBetween);
		} catch (Exception invalidNumberOfSapcesBetween) {
			System.out.println("ERROR : invalid Number of Spaces Between");
		}
	}

	private void outputTemperatureTable ( ArrayList< ArrayList<String> > table ) {
		//System.out.println(table);
		ArrayList<String> header = table.get(0);
		ArrayList<String> columns = table.get(1);
		ArrayList<String> contents = table.get(2);
		int columnWidth = temperatureRange.getColumnWidth();
		int numberOfSpacesBetweenColumns = temperatureRange.getNumberOfSpacesBetweenColumns();
		int numberOfColumns = temperatureRange.getNumberOfColumns();
		int lineWidth = numberOfColumns * columnWidth * 2 + numberOfSpacesBetweenColumns * (numberOfColumns - 1);
		int headerOffset = (lineWidth - temperatureRange.getTableHeader().length()) / 2;
		for (int i = 0; i < header.size(); i++) {
			for (int j = 0; j < headerOffset; j++) System.out.print(" ");
			System.out.println(header.get(i));
		}
		for (int i = 0; i < columns.size(); i++) {
			System.out.print(columns.get(i));
			for (int j = 0; j < numberOfSpacesBetweenColumns; j++)
				System.out.print(" ");
		}
		System.out.println();
		int currentColumn = 0;
		for (int i = 0; i < contents.size(); i++) {
			System.out.print(contents.get(i));
			for (int j = 0; j < numberOfSpacesBetweenColumns; j++)
				System.out.print(" ");
			currentColumn++;
			if (currentColumn == numberOfColumns) {
				System.out.println();
				currentColumn = 0;
			}
		}
		System.out.println();
	}

	public void ioController () {
		int op = -1;
		while (op != 8) {
			printInstructions();
			op = getInt();
			switch (op) {
				case 1 : setNewTemperatureRange(getInt(), getInt());
					 break;
				case 2 : setTableHeader(getString());
					 break;
				case 3 : setTableCelciusColumnHeader(getString());
					 break;
				case 4 : setTableFahrenheitColumnHeader(getString());
					 break;
				case 5 : setNumberOfColumns(getInt());
					 break;
				case 6 : setNumberOfSpacesBetween(getInt());
					 break;
				case 7 : temperatureRange.generateTable();
					 outputTemperatureTable(temperatureRange.getTable());
					 break;
			}
		}
	}

	public static void main (String args[]) {
		new TemperatureRangeCLI().ioController();
	}
}



