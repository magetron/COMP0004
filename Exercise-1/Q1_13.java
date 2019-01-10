public class Q1_13 {
	
	private boolean isPalin (String str) {
		int len = str.length();
		int i = 0;
		int j = len - 1;
		while (i < j) 
			if (str.charAt(i++) != str.charAt(j--)) return false;
		return true;
	}
	
	private String getFileName () {
		Input in = new Input();
		String fileName = in.nextLine();
		return fileName;
	}

	public void ioController () {
		FileInput fileIn = new FileInput(getFileName());
		FileOutput fileOut = new FileOutput("Q1_13_palins.txt");
		while (fileIn.hasNextLine()) {
			String curLine = fileIn.nextLine();
			if (isPalin(curLine)) {
				fileOut.writeString(curLine);
				fileOut.writeEndOfLine();
			}
		}
		fileOut.close();
	}

	public static void main (String[] args) {
		new Q1_13().ioController();
	}
}

