public class Q1_14 {
	private String getMsg () {
		Input in = new Input ();
		String msg = in.nextLine();
		return msg;
	}

	private void formatStr (String msg) {
		int len = msg.length();
		int blankSpaces = (80 - len) / 2;
		for (int i = 0; i < blankSpaces; i++) System.out.print(" ");
		System.out.println(msg);
	}

	public void ioController () {
		formatStr(getMsg());
	}

	public static void main (String args[]) {
		new Q1_14().ioController();
	}
}
