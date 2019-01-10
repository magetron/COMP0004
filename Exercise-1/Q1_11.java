import java.util.ArrayList;

import java.util.Collections;

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

	private void outputFreq () {
		for (int i = 0; i < 256; i++) if (freq[i] > 0) 
			System.out.println(Character.toString((char) i) + " " + freq[i]);
	}

	public void ioController () {
		initFreq();
		analyseFile(getFileName());
		outputFreq();
	}

	public static void main (String args[]) {
		new Q1_11().ioController();
	}
}



