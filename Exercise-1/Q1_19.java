public class Q1_19 {
	private String getSrcFileName () {
		Input in = new Input();
		String fileName = in.nextLine();
		return fileName;
	}

	private boolean matchSrc (String srcFileName) {
		FileInput srcIn = new FileInput(srcFileName);
		int match = 0;
		boolean commentBlock = false;
		while (srcIn.hasNextLine()) {
			String srcLine = srcIn.nextLine();
			int lineLen = srcLine.length();
			boolean stringBlock = false;
			for (int i = 0; i < lineLen; i++)
				if ( (i < lineLen - 1) && 
						(srcLine.charAt(i) == '/') && (srcLine.charAt(i + 1) == '*') ) commentBlock = true;
				else if ( (i < lineLen - 1) && 
						(srcLine.charAt(i) == '*') && (srcLine.charAt(i + 1) == '/') ) commentBlock = false;
				else if (!commentBlock) {
					if ( (i < lineLen - 1) 
							&& (srcLine.charAt(i) == '/') && (srcLine.charAt(i + 1) == '/') ) break;
					else if (srcLine.charAt(i) == '"') while (srcLine.charAt(++i) != '"') continue;
					else if (srcLine.charAt(i) == '{') match++;
					else if (srcLine.charAt(i) == '}') match--;
				}
		}
		if (match == 0) return true;
		else return false;
	}

	public void ioController () {
		System.out.println(matchSrc("Q1_19.in"));
	}

	public static void main (String args[]) {
		new Q1_19().ioController();
	}
}
