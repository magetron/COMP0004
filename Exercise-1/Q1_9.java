public class Q1_9 {
	
	private boolean isPalin (long n) {
		long rvsN = 0;
		long orgN = n;
		while (n > 0) {
			rvsN = rvsN * 10 + n % 10;
			n /= 10;
		}
		if (orgN == rvsN) return true;
		else return false;
	}

	public void ioController () {
		Input in = new Input();
		long n = in.nextLong();
		System.out.println(isPalin(n));
	}

	public static void main (String args[]) {
		new Q1_9().ioController();
	}
}
