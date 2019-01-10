public class Q1_17 {

	private boolean isPrime (long n) {
		int j = 2;
		while (j < (int) Math.sqrt(n)) if (n % j++ == 0) return false;
		return true;
	}

	private long getNumber () {
		Input in = new Input();
		long tmp = in.nextLong();
		return tmp;
	}

	public void ioController () {
		System.out.println(isPrime(getNumber()));
	}

	public static void main (String args[]) {
		new Q1_17().ioController();
	}
}

