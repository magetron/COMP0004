public class Q1_11 {
	private int[] freq = new int [256];

	private void initFreq () {
		for (int i = 0; i < 256; i++) freq[i] = 0;
	}

	private String getFileName () {
		Input in = new Input ();
		String fileName = in.nextLine();
		return fileName;
	}

	private void analyseFile (String fileName) {
		FileInput fileIn = new FileInput(fileName);
		while (fileIn.hasNextLine()) {
			String line = fileIn.nextLine();
			int len = line.length();
			for (int i = 0; i < len; i++) freq[(int)(line.charAt(i))]++;
		}
	}

	private void outputFreq (String fileName) {
		FileOutput fileOut = new FileOutput(fileName);
		for (int i = 0; i < 256; i++) if (freq[i] > 0) { 
			fileOut.writeString(Character.toString((char) i) + " " + freq[i]);
			fileOut.writeEndOfLine();
		}
		fileOut.close();
	}

	public void ioController () {
		initFreq();
		analyseFile(getFileName());
		outputFreq("Q1_11_freqAnalysis.txt");
	}

	public static void main (String args[]) {
		new Q1_11().ioController();
	}
}



