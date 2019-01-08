public class Ex1_5 {
	private String readString () {
		Input in = new Input ();
		String usrString = in.nextLine();
		return usrString;
	}

	private boolean isPalindrome (final String str) {
		int len = str.length();
		int i = 0;
		int j = len - 1;
		while (i < j) 
			if (str.charAt(i++) != str.charAt(j--)) return false;
		return true;
	}

	public void doWork () {
		if ( isPalindrome(readString()) ) System.out.println("True");
		else System.out.println("False");
	}

	public static void main (String[] args) {
		new Ex1_5().doWork();		
	}

}

		
		
