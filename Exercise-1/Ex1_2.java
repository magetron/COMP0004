public class Ex1_2 {
	
	private String getFileName () {
		Input in = new Input();
		String fileName = in.nextLine();
		return fileName;
	}
		
	private void displayFileContent (String fileName) {
		FileInput fileIn = new FileInput(fileName);
		while (fileIn.hasNextLine()) {
			String s = fileIn.nextLine();
			System.out.println(s);
		}
		fileIn.close();
	}
	
	public void catFile () {
		String fileName = getFileName();
		System.out.println("Display " + fileName + " : ");
		displayFileContent(fileName);
	}

	public static void main (String[] args) {
		new Ex1_2().catFile();
	}
}
