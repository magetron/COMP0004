import java.util.ArrayList;

public class Q1_12 {
	private ArrayList<String> file = new ArrayList<>();

	private String getFileName () {
		Input in = new Input();
		String fileName = in.nextLine();
		return fileName;
	}

	private void readFile (String fileName) {
		FileInput fileIn = new FileInput(fileName);
		while (fileIn.hasNextLine()) {
			String line = fileIn.nextLine();
			file.add(line);
		}
	}

	private String reverse(String str) {
		if ( (str == null) || str.isEmpty()) return str;
		String rvs = "";
		int len = str.length();
		for (int i = len - 1; i >= 0; i--) rvs += str.charAt(i);
		return rvs;
	}

	private void reverseLines () {
		int size = file.size();
		for (int i = 0; i < size; i++) file.set(i, reverse(file.get(i)));
	}

	private void reverseOutput (String fileName) {
		FileOutput fileOut = new FileOutput(fileName);
		int size = file.size();
		for (int i = size - 1; i >= 0; i--) {
			fileOut.writeString(file.get(i));
			fileOut.writeEndOfLine();
		}
		fileOut.close();
	}

	public void ioController () {
		readFile(getFileName());
		reverseLines();
		reverseOutput("Q1_12_reversedText.txt");
	}

	public static void main (String args[]) {
		new Q1_12().ioController();
	}
}
		

