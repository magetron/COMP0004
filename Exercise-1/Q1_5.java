public class Q1_5 {

	public double readDouble () {
		Input in = new Input();
		double tmpDouble = in.nextDouble();
		return tmpDouble;
	}

	public double sqrtOfSum (double a, double b) {
		return Math.sqrt(a + b);
	}

	public static void main (String args[]) {
		Q1_5 q1_5 = new Q1_5();
		System.out.println(q1_5.sqrtOfSum(q1_5.readDouble(), q1_5.readDouble()) );
	}
}

