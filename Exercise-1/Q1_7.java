public class Q1_7 {
	
	public String toBase (int n, int b) {
		String dStr = "";
		while (n > 0) {
			int newInt = n % b;
			char newChar;
			if (n % b < 10) newChar = (char)(newInt + 48);
			else newChar = (char)(newInt + 55);
			dStr += newChar;
			n /= b;
		}
		return new StringBuffer(dStr).reverse().toString();
	}

	public static void main (String args[]) {
		Input in = new Input();
		int n = in.nextInt();
		int b = in.nextInt();
		Q1_7 q1_7 = new Q1_7();
		System.out.println(q1_7.toBase(n, b));
	}
}





