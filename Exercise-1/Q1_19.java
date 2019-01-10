import java.util.ArrayList;

public class Q1_19 {
	private String getSrcFileName () {
		Input in = new Input();
		String fileName = in.nextLine();
		return fileName;
	}

	private boolean matchSrc (String srcFileName) {
		FileInput srcIn = new FileInput(srcFileName);
		int match = 0;
		while (srcIn.hasNextLine()) {
			String srcLine = srcIn.nextLine();
			int lineLen = srcLine.length();
			for (int i = 0; i < lineLen; i++) 
				if ( (srcLine.charAt(i) == '/') && (srcLine.charAt(i + 1) == '/') ) break;
					if (srcLine.charAt(i) == '{') match++;
					else if (srcLine.charAt(i) == '}') match--;
		}
		if (match == 0) return true;
		else return false;
	}

	public void ioController () {
		System.out.println(matchSrc(getSrcFileName()));
	}

	public static void main (String args[]) {
		new Q1_19().ioController();
	}
}
