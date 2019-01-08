public class Q1_1 {
	private String readString () {
		Input in = new Input();
		String tmpStr = in.nextLine();
		return tmpStr;
	}

	private boolean isStop (final String usrInput) {
		if ( usrInput.equals("stop") ) return true;
		else return false;
	}

	public void controller () {
		while ( !isStop(readString()) ) continue;
	}

	public static void main (String[] args) {
		new Q1_1().controller();
	}
}
