public class Q1_18 {
	
	private int readInt () {
		Input in = new Input ();
		int tmp = in.nextInt();
		return tmp;
	}

	private String readNum (int digit) {
		switch (digit) {
			case 1 : return "one ";
			case 2 : return "two ";
			case 3 : return "three ";
			case 4 : return "four ";
			case 5 : return "five ";
			case 6 : return "six ";
			case 7 : return "seven ";
			case 8 : return "eight ";
			case 9 : return "nine ";
		}
		return " ";
	}

	private String readNumT (int b, int c) {
		switch (b) {
			case 0 : return readNum(c);
			case 1 : switch (c) {
					case 0 : return "ten ";
					case 1 : return "eleven ";
					case 2 : return "twelve ";
					case 3 : return "thirteen ";
					case 4 : return "fourteen ";
					case 5 : return "fifteen ";
					case 6 : return "sixteen ";
					case 7 : return "seventeen ";
					case 8 : return "eighteen ";
					case 9 : return "ninteen ";
				}
			case 2 : return "twenty " + readNum(c); 
			case 3 : return "thirty " + readNum(c);
			case 4 : return "fourty " + readNum(c);
			case 5 : return "fifty " + readNum(c);
			case 6 : return "sixty " + readNum(c);
			case 7 : return "seventy " + readNum(c);
			case 8 : return "eighty " + readNum(c);
			case 9 : return "ninty " + readNum(c);
		}
		return " ";
	}

	private String readNumH (int a, int b, int c) {
		if (a > 0) 
			if ( (b > 0) || (c > 0) ) return readNum(a) + "hundred and " + readNumT(b, c);
			else return readNum(a) + "hundred ";
		else if ( (b > 0) || (c > 0) ) return readNumT(b,c);
		else return "zero ";
	}

	public void ioController () {
		int n = readInt();
		if ( (n < 0) || (n > 999) ) System.out.println("ERROR : Invalid Input");
		else {
			int a = n / 100;
			int b = n / 10 % 10;
			int c = n % 10;
			System.out.println(readNumH(a, b, c));
		}
	}

	public static void main (String[] args) {
		new Q1_18().ioController();
	}
}


					


